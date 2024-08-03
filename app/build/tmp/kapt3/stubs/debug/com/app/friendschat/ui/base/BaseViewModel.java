package com.app.friendschat.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020!J\b\u00102\u001a\u000201H\u0014J\u0006\u00103\u001a\u000201J\n\u00104\u001a\u000201*\u000205R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R!\u0010&\u001a\b\u0012\u0004\u0012\u00020(0\'8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001a\u0010-\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b\u00a8\u00066"}, d2 = {"Lcom/app/friendschat/ui/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "computation", "Lio/reactivex/Scheduler;", "getComputation", "()Lio/reactivex/Scheduler;", "setComputation", "(Lio/reactivex/Scheduler;)V", "fragmentCallback", "Lcom/app/friendschat/ui/base/IFragmentCallback;", "getFragmentCallback", "()Lcom/app/friendschat/ui/base/IFragmentCallback;", "setFragmentCallback", "(Lcom/app/friendschat/ui/base/IFragmentCallback;)V", "io", "getIo", "setIo", "mDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "navigation", "Lcom/app/friendschat/ui/base/Navigators;", "getNavigation", "()Lcom/app/friendschat/ui/base/Navigators;", "setNavigation", "(Lcom/app/friendschat/ui/base/Navigators;)V", "progressBar", "Lcom/app/friendschat/utils/RxProgressBar;", "getProgressBar", "()Lcom/app/friendschat/utils/RxProgressBar;", "setProgressBar", "(Lcom/app/friendschat/utils/RxProgressBar;)V", "scheduler", "Lcom/app/friendschat/data/scheduler/ISchedulerProvider;", "getScheduler", "()Lcom/app/friendschat/data/scheduler/ISchedulerProvider;", "setScheduler", "(Lcom/app/friendschat/data/scheduler/ISchedulerProvider;)V", "trackingError", "Lio/reactivex/subjects/PublishSubject;", "Lcom/app/friendschat/data/model/response/ErrorResponse;", "getTrackingError", "()Lio/reactivex/subjects/PublishSubject;", "trackingError$delegate", "Lkotlin/Lazy;", "ui", "getUi", "setUi", "initData", "", "onCleared", "onDestroyView", "addDisposable", "Lio/reactivex/disposables/Disposable;", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public class BaseViewModel extends androidx.lifecycle.ViewModel {
    public com.app.friendschat.ui.base.IFragmentCallback fragmentCallback;
    public com.app.friendschat.ui.base.Navigators navigation;
    public com.app.friendschat.data.scheduler.ISchedulerProvider scheduler;
    private final io.reactivex.disposables.CompositeDisposable mDisposable = null;
    public io.reactivex.Scheduler io;
    public io.reactivex.Scheduler ui;
    public io.reactivex.Scheduler computation;
    public com.app.friendschat.utils.RxProgressBar progressBar;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy trackingError$delegate = null;
    
    public BaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.ui.base.IFragmentCallback getFragmentCallback() {
        return null;
    }
    
    public final void setFragmentCallback(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.IFragmentCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.ui.base.Navigators getNavigation() {
        return null;
    }
    
    public final void setNavigation(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.Navigators p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.data.scheduler.ISchedulerProvider getScheduler() {
        return null;
    }
    
    public final void setScheduler(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.scheduler.ISchedulerProvider p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.Scheduler getIo() {
        return null;
    }
    
    public final void setIo(@org.jetbrains.annotations.NotNull
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.Scheduler getUi() {
        return null;
    }
    
    public final void setUi(@org.jetbrains.annotations.NotNull
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.Scheduler getComputation() {
        return null;
    }
    
    public final void setComputation(@org.jetbrains.annotations.NotNull
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.utils.RxProgressBar getProgressBar() {
        return null;
    }
    
    public final void setProgressBar(@org.jetbrains.annotations.NotNull
    com.app.friendschat.utils.RxProgressBar p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final io.reactivex.subjects.PublishSubject<com.app.friendschat.data.model.response.ErrorResponse> getTrackingError() {
        return null;
    }
    
    public final void initData(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.scheduler.ISchedulerProvider scheduler) {
    }
    
    public final void addDisposable(@org.jetbrains.annotations.NotNull
    io.reactivex.disposables.Disposable $this$addDisposable) {
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
    
    public final void onDestroyView() {
    }
}