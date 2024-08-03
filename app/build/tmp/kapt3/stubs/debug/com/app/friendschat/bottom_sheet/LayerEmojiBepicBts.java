package com.app.friendschat.bottom_sheet;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\"\u0010\n\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0018H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/app/friendschat/bottom_sheet/LayerEmojiBepicBts;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "context", "Landroid/content/Context;", "stickerView", "Lcom/app/friendschat/utils/custom_sticker/StickerView;", "listLayer", "Ljava/util/ArrayList;", "Lcom/app/friendschat/utils/custom_sticker/Sticker;", "Lkotlin/collections/ArrayList;", "onClose", "Lkotlin/Function1;", "", "onUndoLayer", "Lkotlin/Function0;", "(Landroid/content/Context;Lcom/app/friendschat/utils/custom_sticker/StickerView;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "itemTouchHelperBepic", "Landroidx/recyclerview/widget/ItemTouchHelper;", "ivDeleteBepic", "Landroid/widget/ImageView;", "ivUndoBepic", "layerEmojiAdapterBepic", "Lcom/app/friendschat/ui/emoji/LayerEmojiAdapter;", "posSelectBepic", "", "rvLayerBepic", "Landroidx/recyclerview/widget/RecyclerView;", "stickerSelectBepic", "initBepic", "dialog", "Landroid/app/Dialog;", "setupDialog", "style", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class LayerEmojiBepicBts extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    private final android.content.Context context = null;
    private final com.app.friendschat.utils.custom_sticker.StickerView stickerView = null;
    private final java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker> listLayer = null;
    private final kotlin.jvm.functions.Function1<java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker>, kotlin.Unit> onClose = null;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onUndoLayer = null;
    private com.app.friendschat.ui.emoji.LayerEmojiAdapter layerEmojiAdapterBepic;
    private androidx.recyclerview.widget.ItemTouchHelper itemTouchHelperBepic;
    private com.app.friendschat.utils.custom_sticker.Sticker stickerSelectBepic;
    private int posSelectBepic = 0;
    private androidx.recyclerview.widget.RecyclerView rvLayerBepic;
    private android.widget.ImageView ivUndoBepic;
    private android.widget.ImageView ivDeleteBepic;
    private java.util.HashMap _$_findViewCache;
    
    public LayerEmojiBepicBts(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.app.friendschat.utils.custom_sticker.StickerView stickerView, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker> listLayer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker>, kotlin.Unit> onClose, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onUndoLayer) {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    @java.lang.Override
    public void setupDialog(@org.jetbrains.annotations.NotNull
    android.app.Dialog dialog, int style) {
    }
    
    private final void initBepic(android.app.Dialog dialog) {
    }
}