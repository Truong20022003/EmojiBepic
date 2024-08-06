package com.app.friendschat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/app/friendschat/App;", "Landroid/app/Application;", "()V", "appDatabase", "Lcom/app/friendschat/database/AppDatabase;", "factory", "Lcom/app/friendschat/ui/base/ViewModelFactory;", "isStartApp", "", "()Z", "setStartApp", "(Z)V", "scheduler", "Lcom/app/friendschat/data/scheduler/ISchedulerProvider;", "onCreate", "", "requestInject", "activity", "Lcom/app/friendschat/ui/base/BaseActivity;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class App extends android.app.Application {
    private boolean isStartApp = false;
    private com.app.friendschat.data.scheduler.ISchedulerProvider scheduler;
    private com.app.friendschat.ui.base.ViewModelFactory factory;
    private com.app.friendschat.database.AppDatabase appDatabase;
    
    public App() {
        super();
    }
    
    public final boolean isStartApp() {
        return false;
    }
    
    public final void setStartApp(boolean p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    public final void requestInject(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.BaseActivity<?, ?> activity) {
    }
}