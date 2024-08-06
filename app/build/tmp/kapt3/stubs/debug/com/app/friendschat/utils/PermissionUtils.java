package com.app.friendschat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ-\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002\u00a2\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/app/friendschat/utils/PermissionUtils;", "", "()V", "storagePermissionsToRequest", "", "", "goToSetting", "", "activity", "Landroid/app/Activity;", "isStoragePermissionGranted", "", "context", "Landroid/content/Context;", "requestPermissions", "permissions", "", "requestCode", "", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "requestStoragePermission", "showGotoSettingDialog", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class PermissionUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.app.friendschat.utils.PermissionUtils INSTANCE = null;
    private static final java.util.List<java.lang.String> storagePermissionsToRequest = null;
    
    private PermissionUtils() {
        super();
    }
    
    public final boolean isStoragePermissionGranted(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    public final void requestStoragePermission(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, int requestCode) {
    }
    
    private final void requestPermissions(android.app.Activity activity, java.lang.String[] permissions, int requestCode) {
    }
    
    private final void showGotoSettingDialog(android.app.Activity activity) {
    }
    
    private final void goToSetting(android.app.Activity activity) {
    }
}