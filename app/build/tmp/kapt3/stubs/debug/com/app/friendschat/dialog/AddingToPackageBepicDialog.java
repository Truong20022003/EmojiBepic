package com.app.friendschat.dialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bc\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0002\u0010\u0012J\b\u0010!\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0002J\u0012\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u0010H\u0002J\b\u0010\'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/app/friendschat/dialog/AddingToPackageBepicDialog;", "Landroid/app/Dialog;", "activityBepic", "Lcom/app/friendschat/ui/base/BaseActivity;", "fromActivityBepic", "Lcom/app/friendschat/data/model/FromActivity;", "stickerBepic", "Lcom/app/friendschat/data/model/StickerModel;", "actionBepic", "Lcom/app/friendschat/data/model/Action;", "positionInDraftBepic", "", "shouldShowDaftPackageBepic", "", "onDeleteBepic", "Lkotlin/Function0;", "", "onAddToPackageSuccessfullyBepic", "(Lcom/app/friendschat/ui/base/BaseActivity;Lcom/app/friendschat/data/model/FromActivity;Lcom/app/friendschat/data/model/StickerModel;Lcom/app/friendschat/data/model/Action;IZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "bitmapBepic", "Landroid/graphics/Bitmap;", "imagePathBepic", "", "ivCloseBepic", "Landroid/widget/ImageView;", "ivDownloadBepic", "ivShareBepic", "ivTrashBepic", "progressBarBepic", "Landroid/widget/ProgressBar;", "rlAddToPackageBepic", "Landroid/widget/RelativeLayout;", "stickerImageBepic", "initViewBepic", "loadStickerBepic", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupOnClickAddToPackageBepic", "setupOnClickCloseButtonBepic", "setupOnClickDownloadBepic", "setupOnClickShareBepic", "setupOnClickTrashBepic", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class AddingToPackageBepicDialog extends android.app.Dialog {
    private final com.app.friendschat.ui.base.BaseActivity<?, ?> activityBepic = null;
    private final com.app.friendschat.data.model.FromActivity fromActivityBepic = null;
    private final com.app.friendschat.data.model.StickerModel stickerBepic = null;
    private final com.app.friendschat.data.model.Action actionBepic = null;
    private final int positionInDraftBepic = 0;
    private final boolean shouldShowDaftPackageBepic = false;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteBepic = null;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onAddToPackageSuccessfullyBepic = null;
    private java.lang.String imagePathBepic;
    private android.graphics.Bitmap bitmapBepic;
    private android.widget.ImageView ivDownloadBepic;
    private android.widget.ImageView ivTrashBepic;
    private android.widget.ImageView ivCloseBepic;
    private android.widget.ImageView stickerImageBepic;
    private android.widget.ProgressBar progressBarBepic;
    private android.widget.ImageView ivShareBepic;
    private android.widget.RelativeLayout rlAddToPackageBepic;
    
    public AddingToPackageBepicDialog(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.BaseActivity<?, ?> activityBepic, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.FromActivity fromActivityBepic, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.StickerModel stickerBepic, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.Action actionBepic, int positionInDraftBepic, boolean shouldShowDaftPackageBepic, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteBepic, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddToPackageSuccessfullyBepic) {
        super(null);
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViewBepic() {
    }
    
    private final void loadStickerBepic() {
    }
    
    private final void setupOnClickTrashBepic() {
    }
    
    private final void setupOnClickAddToPackageBepic() {
    }
    
    private final void setupOnClickCloseButtonBepic() {
    }
    
    private final void setupOnClickShareBepic() {
    }
    
    private final void setupOnClickDownloadBepic() {
    }
}