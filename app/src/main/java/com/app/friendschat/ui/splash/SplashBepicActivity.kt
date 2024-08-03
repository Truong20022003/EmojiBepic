package com.app.friendschat.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import com.app.friendschat.R
import com.app.friendschat.databinding.ActivitySplashBepicBinding
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.language_start.LanguageStartBepicActivity
import com.app.friendschat.ui.no_internet.NoInternetBepicActivity
import com.app.friendschat.utils.CheckInternet
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import kotlin.reflect.KClass

class SplashBepicActivity : BaseActivity<SplashViewModel, ActivitySplashBepicBinding>() {

    override fun createViewModel(): Class<SplashViewModel> = SplashViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_splash_bepic

    override fun initView() {
        if (!isTaskRoot
            && intent.hasCategory(Intent.CATEGORY_LAUNCHER)
            && intent.action != null && intent.action.equals(Intent.ACTION_MAIN)
        ) {
            finish()
            return
        }
        EventTracking.logEvent(this, EventTracking.EVENT_NAME_SPLASH_OPEN)


        countDownTimer.start()
    }

    private val countDownTimer: CountDownTimer = object : CountDownTimer(2500, 5) {
        override fun onTick(millisUntilFinished: Long) {
            val progressValue = ((2500 - millisUntilFinished) * 100 / 2500).toInt()
            binding.tvLoading.text = "$progressValue%"
           binding.pb.progress = progressValue
        }

        override fun onFinish() {
            navigateToNextScreenBepic()
        }
    }

    override fun bindViewModel() {
    }


    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {
    }

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {

    }

    override fun onBackPressed() {
    }

    private fun navigateToNextScreenBepic() {
        if (!CheckInternet.haveNetworkConnection(this)) {
            val intent = Intent(this, NoInternetBepicActivity::class.java)
            intent.putExtra(Constants.BUNDLE_SPLASH_NO_INTERNET, Constants.BUNDLE_SPLASH)
            startActivity(intent)
            finish()
            overridePendingTransition(0, 0)
        } else {
            val  intent = Intent(this@SplashBepicActivity, LanguageStartBepicActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}