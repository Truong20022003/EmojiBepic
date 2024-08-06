package com.app.friendschat.whatsapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0006\u0010\u0018\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/app/friendschat/whatsapp/AddToWhatsappBepicActivity;", "VM", "Lcom/app/friendschat/ui/base/BaseViewModel;", "DB", "Landroidx/databinding/ViewDataBinding;", "Lcom/app/friendschat/ui/base/BaseActivity;", "()V", "ADD_PACK_BEPIC", "", "EXTRA_STICKER_PACK_AUTHORITY_BEPIC", "", "EXTRA_STICKER_PACK_ID_BEPIC", "EXTRA_STICKER_PACK_NAME_BEPIC", "addStickerPackToWhatsAppBepic", "", "sp", "Lcom/app/friendschat/whatsapp/StickerPack;", "addToWhatsappBepic", "stickerPack", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showErrorDialogBepic", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public abstract class AddToWhatsappBepicActivity<VM extends com.app.friendschat.ui.base.BaseViewModel, DB extends androidx.databinding.ViewDataBinding> extends com.app.friendschat.ui.base.BaseActivity<VM, DB> {
    private final int ADD_PACK_BEPIC = 200;
    private final java.lang.String EXTRA_STICKER_PACK_NAME_BEPIC = "sticker_pack_name";
    private final java.lang.String EXTRA_STICKER_PACK_ID_BEPIC = "sticker_pack_id";
    private final java.lang.String EXTRA_STICKER_PACK_AUTHORITY_BEPIC = "sticker_pack_authority";
    private java.util.HashMap _$_findViewCache;
    
    public AddToWhatsappBepicActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    public final void addToWhatsappBepic(@org.jetbrains.annotations.NotNull
    com.app.friendschat.whatsapp.StickerPack stickerPack) {
    }
    
    public final void showErrorDialogBepic() {
    }
    
    private final void addStickerPackToWhatsAppBepic(com.app.friendschat.whatsapp.StickerPack sp) {
    }
}