package com.app.friendschat.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J(\u0010\u000b\u001a\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000e\u001a\u00020\u0005H&\u00a8\u0006\u000f"}, d2 = {"Lcom/app/friendschat/ui/base/IFragmentCallback;", "", "getContext", "Landroid/content/Context;", "hideLoading", "", "showActivity", "act", "Ljava/lang/Class;", "bundle", "Landroid/os/Bundle;", "showActivityWithResultCode", "requestCode", "", "showLoading", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public abstract interface IFragmentCallback {
    
    @org.jetbrains.annotations.NotNull
    public abstract android.content.Context getContext();
    
    public abstract void showLoading();
    
    public abstract void hideLoading();
    
    public abstract void showActivity(@org.jetbrains.annotations.NotNull
    java.lang.Class<?> act, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle);
    
    public abstract void showActivityWithResultCode(@org.jetbrains.annotations.NotNull
    java.lang.Class<?> act, int requestCode, @org.jetbrains.annotations.Nullable
    android.os.Bundle bundle);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
    }
}