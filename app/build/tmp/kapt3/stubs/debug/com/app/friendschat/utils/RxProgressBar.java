package com.app.friendschat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u000e\u001a\u00020\fJ\u0018\u0010\u000f\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0011H\u0014J \u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0001\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0001R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/app/friendschat/utils/RxProgressBar;", "Lio/reactivex/Observable;", "", "schedulerProvider", "Lcom/app/friendschat/data/scheduler/ISchedulerProvider;", "(Lcom/app/friendschat/data/scheduler/ISchedulerProvider;)V", "loading", "variable", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "decrement", "", "increment", "reset", "subscribeActual", "observer", "Lio/reactivex/Observer;", "trackActivity", "T", "source", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class RxProgressBar extends io.reactivex.Observable<java.lang.Boolean> {
    private final io.reactivex.subjects.BehaviorSubject<java.lang.Integer> variable = null;
    private io.reactivex.Observable<java.lang.Boolean> loading;
    
    public RxProgressBar(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.scheduler.ISchedulerProvider schedulerProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final <T extends java.lang.Object>io.reactivex.Observable<T> trackActivity(@org.jetbrains.annotations.NotNull
    io.reactivex.Observable<T> source) {
        return null;
    }
    
    @java.lang.Override
    protected void subscribeActual(@org.jetbrains.annotations.NotNull
    io.reactivex.Observer<? super java.lang.Boolean> observer) {
    }
    
    private final void increment() {
    }
    
    private final void decrement() {
    }
    
    public final void reset() {
    }
}