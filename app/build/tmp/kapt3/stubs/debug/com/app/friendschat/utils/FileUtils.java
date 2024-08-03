package com.app.friendschat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0004J*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004J \u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J \u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0004J \u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J \u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004\u00a8\u0006\u001c"}, d2 = {"Lcom/app/friendschat/utils/FileUtils;", "", "()V", "getFileNameFromUrl", "", "url", "getFolderNameFromUrl", "getUriFromFilePath", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "filePath", "readStringTxtFromCache", "removeStickerFromCacheDir", "", "nameFile", "saveBitmapToGallery", "", "bitmapImage", "Landroid/graphics/Bitmap;", "fileName", "folderName", "saveImageToCacheDir", "saveStickerToCacheDir", "saveStringToTxtCache", "data", "updateStringTxtToCache", "appendString", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class FileUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.app.friendschat.utils.FileUtils INSTANCE = null;
    
    private FileUtils() {
        super();
    }
    
    public final void removeStickerFromCacheDir(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String nameFile) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String saveStickerToCacheDir(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmapImage, @org.jetbrains.annotations.NotNull
    java.lang.String nameFile) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String saveImageToCacheDir(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmapImage, @org.jetbrains.annotations.NotNull
    java.lang.String fileName) {
        return null;
    }
    
    public final boolean saveBitmapToGallery(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmapImage, @org.jetbrains.annotations.NotNull
    java.lang.String fileName, @org.jetbrains.annotations.Nullable
    java.lang.String folderName) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String saveStringToTxtCache(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String data, @org.jetbrains.annotations.NotNull
    java.lang.String fileName) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String readStringTxtFromCache(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String filePath) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String updateStringTxtToCache(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String filePath, @org.jetbrains.annotations.NotNull
    java.lang.String appendString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFileNameFromUrl(@org.jetbrains.annotations.NotNull
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFolderNameFromUrl(@org.jetbrains.annotations.NotNull
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.net.Uri getUriFromFilePath(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String filePath) {
        return null;
    }
}