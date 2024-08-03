package com.app.friendschat.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.app.friendschat.data.AppDataManager
import com.app.friendschat.data.DataManager
import com.app.friendschat.data.api.retrofit.FakerApi
import com.app.friendschat.data.local.IPreferenceHelper
import com.app.friendschat.data.local.PreferenceInfo
import com.app.friendschat.data.local.PreferencesHelper
import com.app.friendschat.data.scheduler.AppSchedulerProvider
import com.app.friendschat.data.scheduler.ISchedulerProvider
import com.app.friendschat.ui.base.ViewModelFactory
import com.app.friendschat.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return "KeyPreference"
    }

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun providePreferenceHelper(preferencesHelper: PreferencesHelper): IPreferenceHelper {
        return preferencesHelper
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideScheduler(): ISchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory {
        return factory
    }

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesFakerAPI(retrofit: Retrofit): FakerApi {
        return retrofit.create(FakerApi::class.java)
    }
}