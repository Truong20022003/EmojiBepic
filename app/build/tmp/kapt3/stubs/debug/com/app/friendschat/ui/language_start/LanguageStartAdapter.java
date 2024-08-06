package com.app.friendschat.ui.language_start;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nH\u0016J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0007J\u0014\u0010&\u001a\u00020\u000b2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R,\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006)"}, d2 = {"Lcom/app/friendschat/ui/language_start/LanguageStartAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/app/friendschat/ui/language_start/LanguageStartAdapter$ViewHolder;", "context", "Landroid/content/Context;", "list", "", "Lcom/app/friendschat/data/model/LanguageModel;", "onClickItem", "Lkotlin/Function2;", "", "", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getOnClickItem", "()Lkotlin/jvm/functions/Function2;", "setOnClickItem", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectLanguage", "code", "", "setSelectedLanguage", "selectedLanguage", "updateData", "newList", "ViewHolder", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class LanguageStartAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.app.friendschat.ui.language_start.LanguageStartAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.app.friendschat.data.model.LanguageModel> list;
    @org.jetbrains.annotations.NotNull
    private kotlin.jvm.functions.Function2<? super com.app.friendschat.data.model.LanguageModel, ? super java.lang.Integer, kotlin.Unit> onClickItem;
    
    public LanguageStartAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.LanguageModel> list, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.app.friendschat.data.model.LanguageModel, ? super java.lang.Integer, kotlin.Unit> onClickItem) {
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
    public final java.util.List<com.app.friendschat.data.model.LanguageModel> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.LanguageModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<com.app.friendschat.data.model.LanguageModel, java.lang.Integer, kotlin.Unit> getOnClickItem() {
        return null;
    }
    
    public final void setOnClickItem(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.app.friendschat.data.model.LanguageModel, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.app.friendschat.ui.language_start.LanguageStartAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.LanguageModel> newList) {
    }
    
    public final void setSelectedLanguage(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.LanguageModel selectedLanguage) {
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.language_start.LanguageStartAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void setSelectLanguage(@org.jetbrains.annotations.NotNull
    java.lang.String code) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/app/friendschat/ui/language_start/LanguageStartAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivAvatar", "Landroid/widget/ImageView;", "getIvAvatar", "()Landroid/widget/ImageView;", "rlBG", "getRlBG", "()Landroid/view/View;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "bind", "", "serverModel", "Lcom/app/friendschat/data/model/LanguageModel;", "context", "Landroid/content/Context;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView ivAvatar = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvTitle = null;
        @org.jetbrains.annotations.NotNull
        private final android.view.View rlBG = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getIvAvatar() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.view.View getRlBG() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.app.friendschat.data.model.LanguageModel serverModel, @org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
    }
}