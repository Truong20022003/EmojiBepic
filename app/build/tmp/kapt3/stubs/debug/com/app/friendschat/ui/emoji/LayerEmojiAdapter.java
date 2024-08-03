package com.app.friendschat.ui.emoji;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fBG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\rJ\u0016\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rJ\u001e\u0010\u001d\u001a\u00020\u000e2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/app/friendschat/ui/emoji/LayerEmojiAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/app/friendschat/ui/emoji/LayerEmojiAdapter$LayerViewHolder;", "context", "Landroid/content/Context;", "stickerView", "Lcom/app/friendschat/utils/custom_sticker/StickerView;", "listLayer", "Ljava/util/ArrayList;", "Lcom/app/friendschat/utils/custom_sticker/Sticker;", "Lkotlin/collections/ArrayList;", "onClickLayer", "Lkotlin/Function2;", "", "", "(Landroid/content/Context;Lcom/app/friendschat/utils/custom_sticker/StickerView;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function2;)V", "selectItemPosition", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemDismiss", "onItemMove", "fromPosition", "toPosition", "setListData", "newListSTicker", "LayerViewHolder", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class LayerEmojiAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.app.friendschat.ui.emoji.LayerEmojiAdapter.LayerViewHolder> {
    private android.content.Context context;
    private final com.app.friendschat.utils.custom_sticker.StickerView stickerView = null;
    private java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker> listLayer;
    private kotlin.jvm.functions.Function2<? super com.app.friendschat.utils.custom_sticker.Sticker, ? super java.lang.Integer, kotlin.Unit> onClickLayer;
    private int selectItemPosition = androidx.recyclerview.widget.RecyclerView.NO_POSITION;
    
    public LayerEmojiAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.app.friendschat.utils.custom_sticker.StickerView stickerView, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker> listLayer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.app.friendschat.utils.custom_sticker.Sticker, ? super java.lang.Integer, kotlin.Unit> onClickLayer) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.app.friendschat.ui.emoji.LayerEmojiAdapter.LayerViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.emoji.LayerEmojiAdapter.LayerViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void onItemMove(int fromPosition, int toPosition) {
    }
    
    public final void onItemDismiss(int position) {
    }
    
    public final void setListData(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker> newListSTicker) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/app/friendschat/ui/emoji/LayerEmojiAdapter$LayerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivLayer", "Landroid/widget/ImageView;", "getIvLayer", "()Landroid/widget/ImageView;", "ivShowLayer", "getIvShowLayer", "ivSwap", "getIvSwap", "pbLoading", "Landroid/widget/ProgressBar;", "getPbLoading", "()Landroid/widget/ProgressBar;", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
    public static final class LayerViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView ivShowLayer = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView ivLayer = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ProgressBar pbLoading = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvName = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView ivSwap = null;
        
        public LayerViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getIvShowLayer() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getIvLayer() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ProgressBar getPbLoading() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getIvSwap() {
            return null;
        }
    }
}