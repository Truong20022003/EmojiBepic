package com.app.friendschat.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H&J \u0010\u0007\u001a\u00020\u00032\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&J(\u0010\f\u001a\u00020\u00032\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&J*\u0010\u000f\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00102\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lcom/app/friendschat/ui/base/Navigators;", "", "fragmentRequestInject", "", "fragment", "Lcom/app/friendschat/ui/base/BaseFragment;", "onFragmentResumed", "showActivity", "activity", "Ljava/lang/Class;", "bundle", "Landroid/os/Bundle;", "showActivityWithResultCode", "requestCode", "", "switchFragment", "Lkotlin/reflect/KClass;", "addToBackStack", "", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public abstract interface Navigators {
    
    public abstract void onFragmentResumed(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.BaseFragment<?, ?> fragment);
    
    public abstract void switchFragment(@org.jetbrains.annotations.NotNull
    kotlin.reflect.KClass<?> fragment, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle, boolean addToBackStack);
    
    public abstract void fragmentRequestInject(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.BaseFragment<?, ?> fragment);
    
    public abstract void showActivity(@org.jetbrains.annotations.NotNull
    java.lang.Class<?> activity, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle);
    
    public abstract void showActivityWithResultCode(@org.jetbrains.annotations.NotNull
    java.lang.Class<?> activity, int requestCode, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
    }
}