package com.app.friendschat

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import com.app.friendschat.data.scheduler.AppSchedulerProvider
import com.app.friendschat.data.scheduler.ISchedulerProvider
import com.app.friendschat.database.AppDatabase
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.ViewModelFactory
import com.app.friendschat.ui.splash.SplashBepicActivity
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.LocalStorageUtils
import java.util.UUID

class App : Application(){
    var isStartApp = false
    private lateinit var scheduler: ISchedulerProvider
    private lateinit var factory: ViewModelFactory
    private var appDatabase: AppDatabase? = null
    override fun onCreate() {
        super.onCreate()
        scheduler = AppSchedulerProvider()
        appDatabase = AppDatabase.getInstance(this)
        factory = ViewModelFactory(scheduler)

        val randomIdentifier = LocalStorageUtils.readData(
            this,
            Constants.RANDOM_IDENTIFIER_FOR_ADDING_STICKER_TO_WHATSAPP
        )
        if (randomIdentifier == null) {
            val newId = UUID.randomUUID().toString()
            LocalStorageUtils.writeData(
                this,
                Constants.RANDOM_IDENTIFIER_FOR_ADDING_STICKER_TO_WHATSAPP,
                newId
            )
        }

        isStartApp = true
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                if (isStartApp) {
                    if (activity.javaClass.name != SplashBepicActivity::class.java.name) {
                        activity.startActivity(Intent(activity, SplashBepicActivity::class.java))
                        activity.finishAffinity()
                        return
                    }
                }
                isStartApp = false
            }

            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })

    }

    fun requestInject(activity: BaseActivity<*, *>) {
        activity.inject(factory, scheduler)
    }

}