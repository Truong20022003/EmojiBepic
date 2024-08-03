package com.app.friendschat.dialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0012\u0010#\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010\'\u001a\u00020\u0006H\u0002J\b\u0010(\u001a\u00020\u0006H\u0002J\b\u0010)\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020\u0006H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/app/friendschat/dialog/AddingToPackageBepicDialog;", "Landroid/app/Dialog;", "shouldShowDaftPackageBepic", "", "onDeleteBepic", "Lkotlin/Function0;", "", "stickerBepic", "Lcom/app/friendschat/data/model/StickerModel;", "actionBepic", "Lcom/app/friendschat/data/model/Action;", "positionInDraftBepic", "", "onAddToPackageSuccessfullyBepic", "activityBepic", "Lcom/app/friendschat/ui/base/BaseActivity;", "fromActivityBepic", "Lcom/app/friendschat/data/model/FromActivity;", "(ZLkotlin/jvm/functions/Function0;Lcom/app/friendschat/data/model/StickerModel;Lcom/app/friendschat/data/model/Action;ILkotlin/jvm/functions/Function0;Lcom/app/friendschat/ui/base/BaseActivity;Lcom/app/friendschat/data/model/FromActivity;)V", "bitmapBepic", "Landroid/graphics/Bitmap;", "imagePathBepic", "", "ivCloseBepic", "Landroid/widget/ImageView;", "ivDownloadBepic", "ivShareBepic", "ivTrashBepic", "progressBarBepic", "Landroid/widget/ProgressBar;", "rlAddToPackageBepic", "Landroid/widget/RelativeLayout;", "stickerImageBepic", "initViewBepicRft", "loadStickerBepicRft", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupOnClickAddToPackageBepicRft", "setupOnClickCloseButtonBepicRft", "setupOnClickDownloadBepicRft", "setupOnClickShareBepicRft", "setupOnClickTrashBepicRft", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class AddingToPackageBepicDialog extends android.app.Dialog {
    private final boolean shouldShowDaftPackageBepic = false;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteBepic = null;
    private final com.app.friendschat.data.model.StickerModel stickerBepic = null;
    private final com.app.friendschat.data.model.Action actionBepic = null;
    private final int positionInDraftBepic = 0;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onAddToPackageSuccessfullyBepic = null;
    private final com.app.friendschat.ui.base.BaseActivity<?, ?> activityBepic = null;
    private final com.app.friendschat.data.model.FromActivity fromActivityBepic = null;
    private android.widget.ImageView ivDownloadBepic;
    private android.widget.ImageView ivTrashBepic;
    private android.widget.ImageView ivCloseBepic;
    private java.lang.String imagePathBepic;
    private android.graphics.Bitmap bitmapBepic;
    private android.widget.ImageView stickerImageBepic;
    private android.widget.ProgressBar progressBarBepic;
    private android.widget.ImageView ivShareBepic;
    private android.widget.RelativeLayout rlAddToPackageBepic;
    
    public AddingToPackageBepicDialog(boolean shouldShowDaftPackageBepic, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteBepic, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.StickerModel stickerBepic, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.Action actionBepic, int positionInDraftBepic, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddToPackageSuccessfullyBepic, @org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.BaseActivity<?, ?> activityBepic, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.FromActivity fromActivityBepic) {
        super(null);
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupOnClickDownloadBepicRft() {
    }
    
    private final void setupOnClickShareBepicRft() {
    }
    
    private final void setupOnClickCloseButtonBepicRft() {
    }
    
    private final void setupOnClickAddToPackageBepicRft() {
    }
    
    private final void loadStickerBepicRft() {
    }
    
    private final void setupOnClickTrashBepicRft() {
    }
    
    private final void initViewBepicRft() {
    }
}