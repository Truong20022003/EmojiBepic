package com.app.friendschat.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001\u00a2\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001\u00a2\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\u0013H\u0001\u00a2\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\u0016H\u0001\u00a2\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u001bH\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0007\u00a8\u0006!"}, d2 = {"Lcom/app/friendschat/di/AppModule;", "", "()V", "provideContext", "Landroid/content/Context;", "application", "Landroid/app/Application;", "provideContext$Emoji_Maker_v1_0_0_08_06_2024_debug", "provideDataManager", "Lcom/app/friendschat/data/DataManager;", "appDataManager", "Lcom/app/friendschat/data/AppDataManager;", "provideDataManager$Emoji_Maker_v1_0_0_08_06_2024_debug", "providePreferenceHelper", "Lcom/app/friendschat/data/local/IPreferenceHelper;", "preferencesHelper", "Lcom/app/friendschat/data/local/PreferencesHelper;", "providePreferenceHelper$Emoji_Maker_v1_0_0_08_06_2024_debug", "providePreferenceName", "", "providePreferenceName$Emoji_Maker_v1_0_0_08_06_2024_debug", "provideScheduler", "Lcom/app/friendschat/data/scheduler/ISchedulerProvider;", "provideScheduler$Emoji_Maker_v1_0_0_08_06_2024_debug", "providesFakerAPI", "Lcom/app/friendschat/data/api/retrofit/FakerApi;", "retrofit", "Lretrofit2/Retrofit;", "providesRetrofit", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/app/friendschat/ui/base/ViewModelFactory;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
@dagger.Module
public final class AppModule {
    
    public AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @com.app.friendschat.data.local.PreferenceInfo
    @dagger.Provides
    public final java.lang.String providePreferenceName$Emoji_Maker_v1_0_0_08_06_2024_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final android.content.Context provideContext$Emoji_Maker_v1_0_0_08_06_2024_debug(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.app.friendschat.data.local.IPreferenceHelper providePreferenceHelper$Emoji_Maker_v1_0_0_08_06_2024_debug(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.local.PreferencesHelper preferencesHelper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.app.friendschat.data.DataManager provideDataManager$Emoji_Maker_v1_0_0_08_06_2024_debug(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.AppDataManager appDataManager) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.app.friendschat.data.scheduler.ISchedulerProvider provideScheduler$Emoji_Maker_v1_0_0_08_06_2024_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final androidx.lifecycle.ViewModelProvider.Factory viewModelFactory(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.ViewModelFactory factory) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final retrofit2.Retrofit providesRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.app.friendschat.data.api.retrofit.FakerApi providesFakerAPI(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
}