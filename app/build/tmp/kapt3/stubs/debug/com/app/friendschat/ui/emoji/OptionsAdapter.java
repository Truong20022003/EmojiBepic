package com.app.friendschat.ui.emoji;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\u0010\fJ \u0010\u001c\u001a\u00120\u001dR\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u001e\u001a\u00020\u0002H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\n8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/app/friendschat/ui/emoji/OptionsAdapter;", "Lcom/app/friendschat/ui/base/BaseAdapter;", "Lcom/app/friendschat/databinding/ItemOptionsBinding;", "Lcom/app/friendschat/data/model/OptionsModel;", "context", "Landroid/content/Context;", "listOptions", "", "onClickItem", "Lkotlin/Function2;", "", "", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "layoutRes", "getLayoutRes", "()I", "getListOptions", "()Ljava/util/List;", "setListOptions", "(Ljava/util/List;)V", "getOnClickItem", "()Lkotlin/jvm/functions/Function2;", "setOnClickItem", "(Lkotlin/jvm/functions/Function2;)V", "createVH", "Lcom/app/friendschat/ui/base/BaseAdapter$BaseVH;", "binding", "OptionsViewModel", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class OptionsAdapter extends com.app.friendschat.ui.base.BaseAdapter<com.app.friendschat.databinding.ItemOptionsBinding, com.app.friendschat.data.model.OptionsModel> {
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.app.friendschat.data.model.OptionsModel> listOptions;
    @org.jetbrains.annotations.NotNull
    private kotlin.jvm.functions.Function2<? super com.app.friendschat.data.model.OptionsModel, ? super java.lang.Integer, kotlin.Unit> onClickItem;
    
    public OptionsAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.OptionsModel> listOptions, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.app.friendschat.data.model.OptionsModel, ? super java.lang.Integer, kotlin.Unit> onClickItem) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.app.friendschat.data.model.OptionsModel> getListOptions() {
        return null;
    }
    
    public final void setListOptions(@org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.OptionsModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<com.app.friendschat.data.model.OptionsModel, java.lang.Integer, kotlin.Unit> getOnClickItem() {
        return null;
    }
    
    public final void setOnClickItem(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.app.friendschat.data.model.OptionsModel, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @java.lang.Override
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    protected com.app.friendschat.ui.base.BaseAdapter<com.app.friendschat.databinding.ItemOptionsBinding, com.app.friendschat.data.model.OptionsModel>.BaseVH createVH(@org.jetbrains.annotations.NotNull
    com.app.friendschat.databinding.ItemOptionsBinding binding) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00120\u0001R\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/app/friendschat/ui/emoji/OptionsAdapter$OptionsViewModel;", "Lcom/app/friendschat/ui/base/BaseAdapter$BaseVH;", "Lcom/app/friendschat/ui/base/BaseAdapter;", "Lcom/app/friendschat/databinding/ItemOptionsBinding;", "Lcom/app/friendschat/data/model/OptionsModel;", "binding", "(Lcom/app/friendschat/ui/emoji/OptionsAdapter;Lcom/app/friendschat/databinding/ItemOptionsBinding;)V", "getBinding", "()Lcom/app/friendschat/databinding/ItemOptionsBinding;", "bind", "", "data", "onItemClickListener", "position", "", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
    public final class OptionsViewModel extends com.app.friendschat.ui.base.BaseAdapter<com.app.friendschat.databinding.ItemOptionsBinding, com.app.friendschat.data.model.OptionsModel>.BaseVH {
        @org.jetbrains.annotations.NotNull
        private final com.app.friendschat.databinding.ItemOptionsBinding binding = null;
        
        public OptionsViewModel(@org.jetbrains.annotations.NotNull
        com.app.friendschat.databinding.ItemOptionsBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.app.friendschat.databinding.ItemOptionsBinding getBinding() {
            return null;
        }
        
        @java.lang.Override
        public void onItemClickListener(int position, @org.jetbrains.annotations.NotNull
        com.app.friendschat.data.model.OptionsModel data) {
        }
        
        @java.lang.Override
        public void bind(@org.jetbrains.annotations.NotNull
        com.app.friendschat.data.model.OptionsModel data) {
        }
    }
}