package com.app.friendschat.utils.widget;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001an\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052K\u0010\u0006\u001aG\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u001a\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0005\u001a\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005\u001a\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u000f\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u001a\u0006\u0010\u0016\u001a\u00020\u0005\u001a\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0006\u0010\u001a\u001a\u00020\u0005\u001a\u0006\u0010\u001b\u001a\u00020\u0005\u001a\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002\u001a\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u001a\u0010\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\"\u001a\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$\u001a\u000e\u0010&\u001a\u00020\"2\u0006\u0010\'\u001a\u00020\u0005\u001ah\u0010(\u001a\u00020)\"\u0004\b\u0000\u0010**\u00020+2\u001c\u0010,\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010.\u0012\u0006\u0012\u0004\u0018\u00010/0-2\u001c\u00100\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0.\u0012\u0006\u0012\u0004\u0018\u00010/0-2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00010-\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102\u001a\u0016\u00103\u001a\u000204\"\u0004\b\u0000\u0010**\b\u0012\u0004\u0012\u0002H*05\u001a\n\u00106\u001a\u00020\u001d*\u00020$\u001a*\u00107\u001a\b\u0012\u0004\u0012\u0002H*08\"\u0004\b\u0000\u0010**\b\u0012\u0004\u0012\u0002H*082\f\u00109\u001a\b\u0012\u0004\u0012\u0002040:\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006;"}, d2 = {"addDataIconToDataBase", "", "context", "Landroid/content/Context;", "folderName", "", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "pos", "nameIcon", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base64ToDrawable", "Landroid/graphics/drawable/Drawable;", "base64String", "convertPhotoAssetToDrawable", "path", "drawableToBase64", "drawable", "drawableToHex", "getCurrentTimeAsString", "getListIconFromAssetFolder", "", "Lcom/app/friendschat/data/model/IconModel;", "getNameEmojiCurrentTimeAsString", "getNameUndoListCurrentTimeAsString", "hexToBytes", "", "hexString", "hexToDrawable", "matrixToString", "matrix", "Landroid/graphics/Matrix;", "scalePhotoBitmap", "Landroid/graphics/Bitmap;", "bitmapSticker", "stringToMatrix", "matrixString", "executeAsync", "Lkotlinx/coroutines/Job;", "T", "Lkotlinx/coroutines/CoroutineScope;", "onPreExecute", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "doInBackground", "onPostExecute", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "hasValue", "", "Landroidx/lifecycle/LiveData;", "toByteArray", "trackingProgress", "Lkotlinx/coroutines/flow/Flow;", "progressBar", "Lio/reactivex/subjects/PublishSubject;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class DataExKt {
    
    public static final <T extends java.lang.Object>boolean hasValue(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LiveData<T> $this$hasValue) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Object>kotlinx.coroutines.flow.Flow<T> trackingProgress(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<? extends T> $this$trackingProgress, @org.jetbrains.annotations.NotNull
    io.reactivex.subjects.PublishSubject<java.lang.Boolean> progressBar) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Object>kotlinx.coroutines.Job executeAsync(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope $this$executeAsync, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> onPreExecute, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> doInBackground, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> onPostExecute) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<com.app.friendschat.data.model.IconModel> getListIconFromAssetFolder(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String folderName) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object addDataIconToDataBase(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String folderName, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.String, ? super java.lang.String, kotlin.Unit> action, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final android.graphics.drawable.Drawable convertPhotoAssetToDrawable(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String path) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final java.lang.String drawableToBase64(@org.jetbrains.annotations.NotNull
    android.graphics.drawable.Drawable drawable) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final android.graphics.drawable.Drawable base64ToDrawable(@org.jetbrains.annotations.NotNull
    java.lang.String base64String) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final java.lang.String drawableToHex(@org.jetbrains.annotations.Nullable
    android.graphics.drawable.Drawable drawable) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final byte[] toByteArray(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap $this$toByteArray) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final android.graphics.drawable.Drawable hexToDrawable(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String hexString) {
        return null;
    }
    
    private static final byte[] hexToBytes(java.lang.String hexString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getCurrentTimeAsString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getNameUndoListCurrentTimeAsString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getNameEmojiCurrentTimeAsString() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final java.lang.String matrixToString(@org.jetbrains.annotations.NotNull
    android.graphics.Matrix matrix) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Matrix stringToMatrix(@org.jetbrains.annotations.NotNull
    java.lang.String matrixString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Bitmap scalePhotoBitmap(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap bitmapSticker) {
        return null;
    }
}