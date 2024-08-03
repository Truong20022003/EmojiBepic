package com.app.friendschat.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u00020\u0006:\u0001`B\u0005\u00a2\u0006\u0002\u0010\u0007J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u000201J\b\u0010<\u001a\u00020:H&J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>H&J\u0018\u0010?\u001a\u00020:2\u000e\u0010@\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030AH\u0016J\u0010\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u000201H&J\b\u0010F\u001a\u000201H\u0002J\u000e\u0010G\u001a\u00020:2\u0006\u0010;\u001a\u000201J\b\u0010H\u001a\u00020:H\u0002J\b\u0010I\u001a\u00020:H&J\u0016\u0010J\u001a\u00020:2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00102\u001a\u000203J\"\u0010K\u001a\u00020:2\u0006\u0010;\u001a\u0002012\u0006\u0010L\u001a\u0002012\b\u0010M\u001a\u0004\u0018\u00010NH\u0014J\u0012\u0010O\u001a\u00020:2\b\u0010P\u001a\u0004\u0018\u00010QH\u0014J\b\u0010R\u001a\u00020:H\u0014J\b\u0010S\u001a\u00020:H\u0014J\u0010\u0010T\u001a\u00020:2\u0006\u0010U\u001a\u00020\u001bH\u0016J\u001e\u0010V\u001a\u00020:2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030>2\b\u0010X\u001a\u0004\u0018\u00010QH\u0016J&\u0010Y\u001a\u00020:2\n\u0010W\u001a\u0006\u0012\u0002\b\u00030>2\u0006\u0010;\u001a\u0002012\b\u0010X\u001a\u0004\u0018\u00010QH\u0016J\b\u0010Z\u001a\u00020:H\u0002J\u0012\u0010[\u001a\u00020:2\b\u0010\\\u001a\u0004\u0018\u00010NH\u0016J\b\u0010]\u001a\u00020:H\u0002J\f\u0010^\u001a\u00020:*\u00020_H\u0002R\u001c\u0010\b\u001a\u00028\u0001X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%R\u001c\u0010\'\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020100X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0002038\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006a"}, d2 = {"Lcom/app/friendschat/ui/base/BaseActivity;", "VM", "Lcom/app/friendschat/ui/base/BaseViewModel;", "DB", "Landroidx/databinding/ViewDataBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/app/friendschat/ui/base/Navigators;", "()V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "dataStore", "Lcom/app/friendschat/utils/DataStorePreferences;", "getDataStore", "()Lcom/app/friendschat/utils/DataStorePreferences;", "setDataStore", "(Lcom/app/friendschat/utils/DataStorePreferences;)V", "factory", "Lcom/app/friendschat/ui/base/ViewModelFactory;", "getFactory", "()Lcom/app/friendschat/ui/base/ViewModelFactory;", "setFactory", "(Lcom/app/friendschat/ui/base/ViewModelFactory;)V", "isBannerLoaded", "", "mDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getMDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "mDisposable$delegate", "Lkotlin/Lazy;", "mProgressDialog", "Lcom/app/friendschat/ui/base/BaseActivity$ProgressDialog;", "getMProgressDialog", "()Lcom/app/friendschat/ui/base/BaseActivity$ProgressDialog;", "mProgressDialog$delegate", "mViewModel", "getMViewModel", "()Lcom/app/friendschat/ui/base/BaseViewModel;", "setMViewModel", "(Lcom/app/friendschat/ui/base/BaseViewModel;)V", "Lcom/app/friendschat/ui/base/BaseViewModel;", "nativeRemoteConfig", "", "requestCodes", "", "", "schedulerProvider", "Lcom/app/friendschat/data/scheduler/ISchedulerProvider;", "getSchedulerProvider", "()Lcom/app/friendschat/data/scheduler/ISchedulerProvider;", "setSchedulerProvider", "(Lcom/app/friendschat/data/scheduler/ISchedulerProvider;)V", "shouldHideNative", "addRequestCodeIfNotExist", "", "requestCode", "bindViewModel", "createViewModel", "Ljava/lang/Class;", "fragmentRequestInject", "fragment", "Lcom/app/friendschat/ui/base/BaseFragment;", "fullScreen", "window", "Landroid/view/Window;", "getContentView", "getStatusBarHeight", "handleReloadAdsByActivityResult", "hideLoading", "initView", "inject", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStart", "onWindowFocusChanged", "hasFocus", "showActivity", "activity", "bundle", "showActivityWithResultCode", "showLoading", "startActivityWithDefaultRequestCode", "intent", "trackingProgress", "addDisposable", "Lio/reactivex/disposables/Disposable;", "ProgressDialog", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public abstract class BaseActivity<VM extends com.app.friendschat.ui.base.BaseViewModel, DB extends androidx.databinding.ViewDataBinding> extends androidx.appcompat.app.AppCompatActivity implements com.app.friendschat.ui.base.Navigators {
    private boolean isBannerLoaded = false;
    private boolean shouldHideNative = false;
    private final java.util.List<java.lang.Integer> requestCodes = null;
    private java.lang.String nativeRemoteConfig;
    @javax.inject.Inject
    public com.app.friendschat.ui.base.ViewModelFactory factory;
    @javax.inject.Inject
    public com.app.friendschat.data.scheduler.ISchedulerProvider schedulerProvider;
    public com.app.friendschat.utils.DataStorePreferences dataStore;
    private final kotlin.Lazy mDisposable$delegate = null;
    public VM mViewModel;
    public DB binding;
    private final kotlin.Lazy mProgressDialog$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.ui.base.ViewModelFactory getFactory() {
        return null;
    }
    
    public final void setFactory(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.ViewModelFactory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.data.scheduler.ISchedulerProvider getSchedulerProvider() {
        return null;
    }
    
    public final void setSchedulerProvider(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.scheduler.ISchedulerProvider p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.utils.DataStorePreferences getDataStore() {
        return null;
    }
    
    public final void setDataStore(@org.jetbrains.annotations.NotNull
    com.app.friendschat.utils.DataStorePreferences p0) {
    }
    
    public final void inject(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.ViewModelFactory factory, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.scheduler.ISchedulerProvider schedulerProvider) {
    }
    
    private final io.reactivex.disposables.CompositeDisposable getMDisposable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.Class<VM> createViewModel();
    
    public abstract int getContentView();
    
    public abstract void initView();
    
    public abstract void bindViewModel();
    
    @org.jetbrains.annotations.NotNull
    public final VM getMViewModel() {
        return null;
    }
    
    public final void setMViewModel(@org.jetbrains.annotations.NotNull
    VM p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final DB getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    DB p0) {
    }
    
    private final com.app.friendschat.ui.base.BaseActivity.ProgressDialog getMProgressDialog() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final int getStatusBarHeight() {
        return 0;
    }
    
    @java.lang.Override
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    private final void trackingProgress() {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
    
    @java.lang.Override
    public void showActivity(@org.jetbrains.annotations.NotNull
    java.lang.Class<?> activity, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle) {
    }
    
    @java.lang.Override
    public void showActivityWithResultCode(@org.jetbrains.annotations.NotNull
    java.lang.Class<?> activity, int requestCode, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle) {
    }
    
    @java.lang.Override
    public void fragmentRequestInject(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.BaseFragment<?, ?> fragment) {
    }
    
    private final void addDisposable(io.reactivex.disposables.Disposable $this$addDisposable) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    public final void addRequestCodeIfNotExist(int requestCode) {
    }
    
    public void startActivityWithDefaultRequestCode(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    public final void handleReloadAdsByActivityResult(int requestCode) {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void fullScreen(android.view.Window window) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/app/friendschat/ui/base/BaseActivity$ProgressDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
    public static final class ProgressDialog extends android.app.Dialog {
        
        public ProgressDialog(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            super(null);
        }
    }
}