package com.app.friendschat.di

import com.app.friendschat.ui.main.MainBepicActivityRft
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainBepicActivityRft
}