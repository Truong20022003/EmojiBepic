package com.app.friendschat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/app/friendschat/utils/AssetUtils;", "", "()V", "stickerPacksInfo", "", "Lcom/app/friendschat/data/model/StickerPackInfo;", "getStickerPacksInfo", "()Ljava/util/List;", "setStickerPacksInfo", "(Ljava/util/List;)V", "getStickerPackInfoByTitle", "title", "", "loadStickerPacksInfo", "", "context", "Landroid/content/Context;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class AssetUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.app.friendschat.utils.AssetUtils INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static java.util.List<com.app.friendschat.data.model.StickerPackInfo> stickerPacksInfo;
    
    private AssetUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.app.friendschat.data.model.StickerPackInfo> getStickerPacksInfo() {
        return null;
    }
    
    public final void setStickerPacksInfo(@org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.StickerPackInfo> p0) {
    }
    
    public final boolean loadStickerPacksInfo(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.app.friendschat.data.model.StickerPackInfo getStickerPackInfoByTitle(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
        return null;
    }
}