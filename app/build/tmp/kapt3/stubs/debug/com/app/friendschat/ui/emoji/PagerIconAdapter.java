package com.app.friendschat.ui.emoji;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B[\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t\u0012\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0018\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0016J\u000e\u0010\'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u000bJ\u000e\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R2\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR2\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001c\u00a8\u0006+"}, d2 = {"Lcom/app/friendschat/ui/emoji/PagerIconAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/app/friendschat/ui/emoji/PagerIconAdapter$ViewHolder;", "context", "Landroid/content/Context;", "listPager", "", "Lcom/app/friendschat/data/model/OptionsModel;", "onClickItem", "Lkotlin/Function3;", "Lcom/app/friendschat/data/model/IconModel;", "", "", "onShowAdsReward", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "iconAdapter", "Lcom/app/friendschat/ui/emoji/IconAdapter;", "getListPager", "()Ljava/util/List;", "setListPager", "(Ljava/util/List;)V", "getOnClickItem", "()Lkotlin/jvm/functions/Function3;", "setOnClickItem", "(Lkotlin/jvm/functions/Function3;)V", "getOnShowAdsReward", "setOnShowAdsReward", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateNotifyDeleteIcon", "pos", "updateNotifyMoveIcon", "ViewHolder", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class PagerIconAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.app.friendschat.ui.emoji.PagerIconAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.app.friendschat.data.model.OptionsModel> listPager;
    @org.jetbrains.annotations.NotNull
    private kotlin.jvm.functions.Function3<? super com.app.friendschat.data.model.IconModel, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onClickItem;
    @org.jetbrains.annotations.NotNull
    private kotlin.jvm.functions.Function3<? super com.app.friendschat.data.model.IconModel, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onShowAdsReward;
    private com.app.friendschat.ui.emoji.IconAdapter iconAdapter;
    
    public PagerIconAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.OptionsModel> listPager, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super com.app.friendschat.data.model.IconModel, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onClickItem, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super com.app.friendschat.data.model.IconModel, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onShowAdsReward) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.app.friendschat.data.model.OptionsModel> getListPager() {
        return null;
    }
    
    public final void setListPager(@org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.OptionsModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function3<com.app.friendschat.data.model.IconModel, java.lang.Integer, java.lang.Integer, kotlin.Unit> getOnClickItem() {
        return null;
    }
    
    public final void setOnClickItem(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super com.app.friendschat.data.model.IconModel, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function3<com.app.friendschat.data.model.IconModel, java.lang.Integer, java.lang.Integer, kotlin.Unit> getOnShowAdsReward() {
        return null;
    }
    
    public final void setOnShowAdsReward(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super com.app.friendschat.data.model.IconModel, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.app.friendschat.ui.emoji.PagerIconAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.emoji.PagerIconAdapter.ViewHolder holder, int position) {
    }
    
    public final void updateNotifyMoveIcon(int pos) {
    }
    
    public final void updateNotifyDeleteIcon(int pos) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/app/friendschat/ui/emoji/PagerIconAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "rvIcon", "Landroidx/recyclerview/widget/RecyclerView;", "getRvIcon", "()Landroidx/recyclerview/widget/RecyclerView;", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final androidx.recyclerview.widget.RecyclerView rvIcon = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.recyclerview.widget.RecyclerView getRvIcon() {
            return null;
        }
    }
}