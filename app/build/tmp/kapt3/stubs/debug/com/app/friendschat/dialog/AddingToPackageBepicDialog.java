package com.app.friendschat.dialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bc\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0002\u0010\u0012J\b\u0010!\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0002J\u0012\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u0010H\u0002J\b\u0010\'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/app/friendschat/dialog/AddingToPackageBepicDialog;", "Landroid/app/Dialog;", "activityBepicRft", "Lcom/app/friendschat/ui/base/BaseActivity;", "fromActivityBepicRft", "Lcom/app/friendschat/data/model/FromActivity;", "stickerBepicRft", "Lcom/app/friendschat/data/model/StickerModel;", "actionBepicRft", "Lcom/app/friendschat/data/model/Action;", "positionInDraftBepicRft", "", "shouldShowDaftPackageBepicRft", "", "onDeleteBepicRft", "Lkotlin/Function0;", "", "onAddToPackageSuccessfullyBepicRft", "(Lcom/app/friendschat/ui/base/BaseActivity;Lcom/app/friendschat/data/model/FromActivity;Lcom/app/friendschat/data/model/StickerModel;Lcom/app/friendschat/data/model/Action;IZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "bitmapBepicRft", "Landroid/graphics/Bitmap;", "imagePathBepicRft", "", "ivCloseBepicRft", "Landroid/widget/ImageView;", "ivDownloadBepicRft", "ivShareBepicRft", "ivTrashBepicRft", "progressBarBepicRft", "Landroid/widget/ProgressBar;", "rlAddToPackageBepicRft", "Landroid/widget/RelativeLayout;", "stickerImageBepicRft", "initViewBepicRft", "loadStickerBepicRft", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupOnClickAddToPackageBepicRft", "setupOnClickCloseButtonBepicRft", "setupOnClickDownloadBepicRft", "setupOnClickShareBepicRft", "setupOnClickTrashBepicRft", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class AddingToPackageBepicDialog extends android.app.Dialog {
    private final com.app.friendschat.ui.base.BaseActivity<?, ?> activityBepicRft = null;
    private final com.app.friendschat.data.model.FromActivity fromActivityBepicRft = null;
    private final com.app.friendschat.data.model.StickerModel stickerBepicRft = null;
    private final com.app.friendschat.data.model.Action actionBepicRft = null;
    private final int positionInDraftBepicRft = 0;
    private final boolean shouldShowDaftPackageBepicRft = false;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteBepicRft = null;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onAddToPackageSuccessfullyBepicRft = null;
    private java.lang.String imagePathBepicRft;
    private android.graphics.Bitmap bitmapBepicRft;
    private android.widget.ImageView ivDownloadBepicRft;
    private android.widget.ImageView ivTrashBepicRft;
    private android.widget.ImageView ivCloseBepicRft;
    private android.widget.ImageView stickerImageBepicRft;
    private android.widget.ProgressBar progressBarBepicRft;
    private android.widget.ImageView ivShareBepicRft;
    private android.widget.RelativeLayout rlAddToPackageBepicRft;
    
    public AddingToPackageBepicDialog(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.BaseActivity<?, ?> activityBepicRft, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.FromActivity fromActivityBepicRft, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.StickerModel stickerBepicRft, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.Action actionBepicRft, int positionInDraftBepicRft, boolean shouldShowDaftPackageBepicRft, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteBepicRft, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddToPackageSuccessfullyBepicRft) {
        super(null);
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupOnClickDownloadBepicRft() {
    }
    
    private final void setupOnClickAddToPackageBepicRft() {
    }
    
    private final void setupOnClickTrashBepicRft() {
    }
    
    private final void loadStickerBepicRft() {
    }
    
    private final void initViewBepicRft() {
    }
    
    private final void setupOnClickShareBepicRft() {
    }
    
    private final void setupOnClickCloseButtonBepicRft() {
    }
}