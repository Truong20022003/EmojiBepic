package com.app.friendschat.ui.sticker_pack_detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 J$\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0%J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\'\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010,\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010-\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010.\u001a\u00020\u001b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010/\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\f\u00a8\u00060"}, d2 = {"Lcom/app/friendschat/ui/sticker_pack_detail/StickerPackDetailViewModel;", "Lcom/app/friendschat/ui/base/BaseViewModel;", "()V", "_stickers", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/app/friendschat/data/model/StickerModel;", "adapter", "Lcom/app/friendschat/ui/sticker_pack_detail/StickerAdapter;", "bitmapList", "Landroid/graphics/Bitmap;", "getBitmapList", "()Ljava/util/List;", "fromActivity", "Lcom/app/friendschat/data/model/FromActivity;", "packageDao", "Lcom/app/friendschat/database/PackageDao;", "packageName", "", "stickers", "Landroidx/lifecycle/LiveData;", "getStickers", "()Landroidx/lifecycle/LiveData;", "uriList", "Landroid/net/Uri;", "getUriList", "addToTelegram", "", "context", "Landroid/content/Context;", "addToWhatsapp", "activity", "Lcom/app/friendschat/ui/sticker_pack_detail/StickerPackDetailBepicActivityRft;", "deleteImageFromPackage", "stickerPosition", "", "onDeleteSuccessfully", "Lkotlin/Function0;", "downloadImages", "getFromActivity", "loadStickers", "refreshStickersIfNeeded", "setAdapter", "setFromActivity", "setPackageDao", "setPackageName", "setStickers", "shareImages", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class StickerPackDetailViewModel extends com.app.friendschat.ui.base.BaseViewModel {
    private com.app.friendschat.database.PackageDao packageDao;
    private com.app.friendschat.data.model.FromActivity fromActivity;
    private java.lang.String packageName;
    private com.app.friendschat.ui.sticker_pack_detail.StickerAdapter adapter;
    private androidx.lifecycle.MutableLiveData<java.util.List<com.app.friendschat.data.model.StickerModel>> _stickers;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.app.friendschat.data.model.StickerModel>> stickers = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.net.Uri> uriList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.graphics.Bitmap> bitmapList = null;
    
    public StickerPackDetailViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.app.friendschat.data.model.StickerModel>> getStickers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<android.net.Uri> getUriList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<android.graphics.Bitmap> getBitmapList() {
        return null;
    }
    
    public final void setPackageDao(@org.jetbrains.annotations.Nullable
    com.app.friendschat.database.PackageDao packageDao) {
    }
    
    public final void loadStickers(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void refreshStickersIfNeeded(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void setFromActivity(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.FromActivity fromActivity) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.data.model.FromActivity getFromActivity() {
        return null;
    }
    
    public final void setPackageName(@org.jetbrains.annotations.NotNull
    java.lang.String packageName) {
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.sticker_pack_detail.StickerAdapter adapter) {
    }
    
    public final void setStickers(@org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.StickerModel> stickers) {
    }
    
    public final void shareImages(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void downloadImages(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void addToTelegram(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void deleteImageFromPackage(@org.jetbrains.annotations.NotNull
    android.content.Context context, int stickerPosition, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteSuccessfully) {
    }
    
    public final void addToWhatsapp(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.sticker_pack_detail.StickerPackDetailBepicActivityRft activity) {
    }
}