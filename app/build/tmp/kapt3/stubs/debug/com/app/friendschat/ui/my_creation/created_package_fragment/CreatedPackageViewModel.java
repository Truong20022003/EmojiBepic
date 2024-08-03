package com.app.friendschat.ui.my_creation.created_package_fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\rJ&\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bJ\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0018J\u001c\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 J\u001e\u0010\"\u001a\u00020\u00122\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030#2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u0012J\u0016\u0010\'\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\t\u00a8\u0006("}, d2 = {"Lcom/app/friendschat/ui/my_creation/created_package_fragment/CreatedPackageViewModel;", "Lcom/app/friendschat/ui/base/BaseViewModel;", "()V", "adapter", "Lcom/app/friendschat/ui/my_creation/created_package_fragment/CreatedPackageAdapter;", "bitmapList", "", "Landroid/graphics/Bitmap;", "getBitmapList", "()Ljava/util/List;", "packageDao", "Lcom/app/friendschat/database/PackageDao;", "packages", "Lcom/app/friendschat/data/model/PackageModel;", "uriList", "Landroid/net/Uri;", "getUriList", "addToTelegram", "", "context", "Landroid/content/Context;", "stickerPack", "addToWhatsapp", "createdPackageFragment", "Lcom/app/friendschat/ui/my_creation/created_package_fragment/CreatedPackageBepicFragmentRft;", "downloadImages", "onDownloaded", "Lkotlin/Function0;", "loadPackagesFromDatabase", "fragment", "loadStickers", "stickers", "", "Lcom/app/friendschat/data/model/StickerModel;", "navigateToStickerPackDetail", "Lcom/app/friendschat/ui/base/BaseFragment;", "packageName", "", "refreshAdapterWithNewList", "shareImages", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class CreatedPackageViewModel extends com.app.friendschat.ui.base.BaseViewModel {
    private com.app.friendschat.database.PackageDao packageDao;
    private java.util.List<com.app.friendschat.data.model.PackageModel> packages;
    private com.app.friendschat.ui.my_creation.created_package_fragment.CreatedPackageAdapter adapter;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.net.Uri> uriList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.graphics.Bitmap> bitmapList = null;
    
    public CreatedPackageViewModel() {
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
    
    public final void loadPackagesFromDatabase(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.my_creation.created_package_fragment.CreatedPackageBepicFragmentRft fragment) {
    }
    
    public final void refreshAdapterWithNewList() {
    }
    
    public final void loadStickers(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.StickerModel> stickers) {
    }
    
    public final void addToTelegram(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.PackageModel stickerPack) {
    }
    
    public final void shareImages(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.PackageModel stickerPack) {
    }
    
    public final void downloadImages(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.PackageModel stickerPack, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDownloaded) {
    }
    
    public final void navigateToStickerPackDetail(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.BaseFragment<?, ?> fragment, @org.jetbrains.annotations.NotNull
    java.lang.String packageName) {
    }
    
    public final void addToWhatsapp(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.my_creation.created_package_fragment.CreatedPackageBepicFragmentRft createdPackageFragment, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.PackageModel stickerPack) {
    }
}