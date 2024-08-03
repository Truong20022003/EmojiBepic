package com.app.friendschat.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002J&\u0010$\u001a\u00020\u001e2\b\b\u0001\u0010%\u001a\u00020\u00112\b\b\u0001\u0010&\u001a\u00020\u00112\b\b\u0001\u0010\'\u001a\u00020\u0011H\u0002J \u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H\u0002J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020-H\u0016J\b\u0010.\u001a\u00020\u0011H\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0002J\b\u00101\u001a\u00020\u001eH\u0016J\"\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0018\u00108\u001a\u00020\u001e2\u000e\u00109\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014H\u0016J-\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u00112\u000e\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070=2\u0006\u0010>\u001a\u00020?H\u0016\u00a2\u0006\u0002\u0010@J\b\u0010A\u001a\u00020\u001eH\u0002J\b\u0010B\u001a\u00020\u001eH\u0002J\b\u0010C\u001a\u00020\u001eH\u0002J&\u0010D\u001a\u00020\u001e2\n\u00109\u001a\u0006\u0012\u0002\b\u00030E2\b\u0010F\u001a\u0004\u0018\u0001072\u0006\u0010G\u001a\u00020HH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/app/friendschat/ui/main/MainBepicActivity;", "Lcom/app/friendschat/ui/base/BaseActivity;", "Lcom/app/friendschat/ui/main/MainViewModel;", "Lcom/app/friendschat/databinding/ActivityMainBepicBinding;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "()V", "TAG", "", "actionEditDraftBepic", "Lcom/app/friendschat/data/model/Action;", "getActionEditDraftBepic", "()Lcom/app/friendschat/data/model/Action;", "setActionEditDraftBepic", "(Lcom/app/friendschat/data/model/Action;)V", "alertDialogBepic", "Landroid/app/AlertDialog;", "colorC9C9C9Bepic", "", "colorCC0C0CBepic", "currentFragmentBepic", "Lcom/app/friendschat/ui/base/BaseFragment;", "drawableMeasureOneBepic", "drawableMeasureTwoBepic", "drawableSettingOneBepic", "drawableSettingTwoBepic", "drawableTrackerOneBepic", "drawableTrackerTwoBepic", "navControllerBepic", "Landroidx/navigation/NavController;", "bindViewModel", "", "changeBackgroundWhenTap", "bg1", "Landroid/graphics/drawable/Drawable;", "bg2", "bg4", "changeImageIconWhenTapBepic", "image1", "image2", "image4", "changeTextColorWhenTapBepic", "color1", "color2", "color4", "createViewModel", "Ljava/lang/Class;", "getContentView", "initView", "navigateFragmentBepic", "onBackPressed", "onDestinationChanged", "controller", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "onFragmentResumed", "fragment", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "showHomeFragmentBepic", "showMyCreationFragmentBepic", "showSettingsFragmentBepic", "switchFragment", "Lkotlin/reflect/KClass;", "bundle", "addToBackStack", "", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class MainBepicActivity extends com.app.friendschat.ui.base.BaseActivity<com.app.friendschat.ui.main.MainViewModel, com.app.friendschat.databinding.ActivityMainBepicBinding> implements androidx.navigation.NavController.OnDestinationChangedListener {
    private com.app.friendschat.ui.base.BaseFragment<?, ?> currentFragmentBepic;
    private final java.lang.String TAG = "MainActivity";
    private androidx.navigation.NavController navControllerBepic;
    private android.app.AlertDialog alertDialogBepic;
    @org.jetbrains.annotations.Nullable
    private com.app.friendschat.data.model.Action actionEditDraftBepic;
    private int colorC9C9C9Bepic = 0;
    private int colorCC0C0CBepic = 0;
    @androidx.annotation.DrawableRes
    private int drawableTrackerTwoBepic = 0;
    @androidx.annotation.DrawableRes
    private int drawableSettingOneBepic = 0;
    @androidx.annotation.DrawableRes
    private int drawableSettingTwoBepic = 0;
    @androidx.annotation.DrawableRes
    private int drawableMeasureOneBepic = 0;
    @androidx.annotation.DrawableRes
    private int drawableMeasureTwoBepic = 0;
    @androidx.annotation.DrawableRes
    private int drawableTrackerOneBepic = 0;
    private java.util.HashMap _$_findViewCache;
    
    public MainBepicActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.app.friendschat.data.model.Action getActionEditDraftBepic() {
        return null;
    }
    
    public final void setActionEditDraftBepic(@org.jetbrains.annotations.Nullable
    com.app.friendschat.data.model.Action p0) {
    }
    
    @java.lang.Override
    public void initView() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.Class<com.app.friendschat.ui.main.MainViewModel> createViewModel() {
        return null;
    }
    
    @java.lang.Override
    public int getContentView() {
        return 0;
    }
    
    @java.lang.Override
    public void bindViewModel() {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    @java.lang.Override
    public void onFragmentResumed(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.BaseFragment<?, ?> fragment) {
    }
    
    @java.lang.Override
    public void onDestinationChanged(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavController controller, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavDestination destination, @org.jetbrains.annotations.Nullable
    android.os.Bundle arguments) {
    }
    
    @java.lang.Override
    public void switchFragment(@org.jetbrains.annotations.NotNull
    kotlin.reflect.KClass<?> fragment, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle, boolean addToBackStack) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    private final void navigateFragmentBepic() {
    }
    
    private final void changeTextColorWhenTapBepic(int color1, int color2, int color4) {
    }
    
    private final void changeBackgroundWhenTap(android.graphics.drawable.Drawable bg1, android.graphics.drawable.Drawable bg2, android.graphics.drawable.Drawable bg4) {
    }
    
    private final void changeImageIconWhenTapBepic(@androidx.annotation.DrawableRes
    int image1, @androidx.annotation.DrawableRes
    int image2, @androidx.annotation.DrawableRes
    int image4) {
    }
    
    private final void showHomeFragmentBepic() {
    }
    
    private final void showMyCreationFragmentBepic() {
    }
    
    private final void showSettingsFragmentBepic() {
    }
}