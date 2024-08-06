package com.app.friendschat.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u001e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017J\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007\u00a8\u0006\u001a"}, d2 = {"Lcom/app/friendschat/ui/home/HomeViewModel;", "Lcom/app/friendschat/ui/base/BaseViewModel;", "()V", "bitmapList", "", "Landroid/graphics/Bitmap;", "getBitmapList", "()Ljava/util/List;", "stickerPack", "Lcom/app/friendschat/data/model/StickerPackInfo;", "uriList", "Landroid/net/Uri;", "getUriList", "addToTelegram", "", "context", "Landroid/content/Context;", "addToWhatsapp", "homeFragment", "Lcom/app/friendschat/ui/home/HomeBepicFragmentRft;", "stickerPackInfo", "downloadImages", "onDownloadSuccessfully", "Lkotlin/Function0;", "loadStickers", "shareImages", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class HomeViewModel extends com.app.friendschat.ui.base.BaseViewModel {
    private com.app.friendschat.data.model.StickerPackInfo stickerPack;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.net.Uri> uriList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.graphics.Bitmap> bitmapList = null;
    
    public HomeViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<android.net.Uri> getUriList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<android.graphics.Bitmap> getBitmapList() {
        return null;
    }
    
    public final void loadStickers(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.StickerPackInfo stickerPack) {
    }
    
    public final void shareImages(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void downloadImages(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDownloadSuccessfully) {
    }
    
    public final void addToTelegram(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void addToWhatsapp(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.home.HomeBepicFragmentRft homeFragment, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.StickerPackInfo stickerPackInfo) {
    }
}