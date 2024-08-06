package com.app.friendschat.data.scheduler;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/app/friendschat/data/scheduler/AppSchedulerProvider;", "Lcom/app/friendschat/data/scheduler/ISchedulerProvider;", "()V", "computation", "Lio/reactivex/Scheduler;", "getComputation", "()Lio/reactivex/Scheduler;", "io", "getIo", "ui", "getUi", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class AppSchedulerProvider implements com.app.friendschat.data.scheduler.ISchedulerProvider {
    @org.jetbrains.annotations.NotNull
    private final io.reactivex.Scheduler computation = null;
    @org.jetbrains.annotations.NotNull
    private final io.reactivex.Scheduler io = null;
    @org.jetbrains.annotations.NotNull
    private final io.reactivex.Scheduler ui = null;
    
    public AppSchedulerProvider() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public io.reactivex.Scheduler getComputation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public io.reactivex.Scheduler getIo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public io.reactivex.Scheduler getUi() {
        return null;
    }
}