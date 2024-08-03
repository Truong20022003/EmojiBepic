package com.app.friendschat.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/app/friendschat/di/AppComponent;", "Ldagger/android/AndroidInjector;", "Lcom/app/friendschat/App;", "Builder", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
@dagger.Component(modules = {dagger.android.support.AndroidSupportInjectionModule.class, com.app.friendschat.di.ActivityBuilder.class, com.app.friendschat.di.AppModule.class})
@javax.inject.Singleton
public abstract interface AppComponent extends dagger.android.AndroidInjector<com.app.friendschat.App> {
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/app/friendschat/di/AppComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lcom/app/friendschat/di/AppComponent;", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
    @dagger.Component.Builder
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull
        @dagger.BindsInstance
        public abstract com.app.friendschat.di.AppComponent.Builder application(@org.jetbrains.annotations.NotNull
        android.app.Application application);
        
        @org.jetbrains.annotations.NotNull
        public abstract com.app.friendschat.di.AppComponent build();
    }
}