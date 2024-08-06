package com.app.friendschat.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u0018\u0012\u0014\u0012\u00120\u0005R\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00000\u0004:\u0001(B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007J%\u0010\u0019\u001a\u00120\u0005R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001a\u001a\u00028\u0000H$\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\nH\u0016J\u001c\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010!\u001a\u00020\u00172\u0016\u0010\"\u001a\u00120\u0005R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010#\u001a\u00020\nH\u0016J(\u0010$\u001a\u00120\u0005R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\nH\u0016R\u0014\u0010\t\u001a\u00020\n8eX\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006)"}, d2 = {"Lcom/app/friendschat/ui/base/BaseAdapter;", "DB", "Landroidx/databinding/ViewDataBinding;", "M", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/app/friendschat/ui/base/BaseAdapter$BaseVH;", "listData", "", "(Ljava/util/List;)V", "layoutRes", "", "getLayoutRes", "()I", "getListData", "()Ljava/util/List;", "setListData", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "addList", "", "newList", "createVH", "binding", "(Landroidx/databinding/ViewDataBinding;)Lcom/app/friendschat/ui/base/BaseAdapter$BaseVH;", "getItemCount", "insertList", "fromIdx", "insertedList", "onAttachedToRecyclerView", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BaseVH", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public abstract class BaseAdapter<DB extends androidx.databinding.ViewDataBinding, M extends java.lang.Object> extends androidx.recyclerview.widget.RecyclerView.Adapter<com.app.friendschat.ui.base.BaseAdapter<DB, M>.BaseVH> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<M> listData;
    protected androidx.recyclerview.widget.RecyclerView recyclerView;
    
    public BaseAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<M> listData) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<M> getListData() {
        return null;
    }
    
    public final void setListData(@org.jetbrains.annotations.NotNull
    java.util.List<M> p0) {
    }
    
    @androidx.annotation.LayoutRes
    protected abstract int getLayoutRes();
    
    @org.jetbrains.annotations.NotNull
    protected abstract com.app.friendschat.ui.base.BaseAdapter<DB, M>.BaseVH createVH(@org.jetbrains.annotations.NotNull
    DB binding);
    
    @org.jetbrains.annotations.NotNull
    protected final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    protected final void setRecyclerView(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @java.lang.Override
    public void onAttachedToRecyclerView(@org.jetbrains.annotations.NotNull
    androidx.recyclerview.widget.RecyclerView recyclerView) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.app.friendschat.ui.base.BaseAdapter<DB, M>.BaseVH onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.base.BaseAdapter<DB, M>.BaseVH holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void addList(@org.jetbrains.annotations.NotNull
    java.util.List<M> newList) {
    }
    
    public final void insertList(int fromIdx, @org.jetbrains.annotations.NotNull
    java.util.List<M> insertedList) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u00a6\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\fR\u0010\u0010\u0002\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/app/friendschat/ui/base/BaseAdapter$BaseVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "(Lcom/app/friendschat/ui/base/BaseAdapter;Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "bind", "", "data", "(Ljava/lang/Object;)V", "onItemClickListener", "position", "", "(ILjava/lang/Object;)V", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
    public abstract class BaseVH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final DB binding = null;
        
        public BaseVH(@org.jetbrains.annotations.NotNull
        DB binding) {
            super(null);
        }
        
        public void onItemClickListener(int position, M data) {
        }
        
        public void bind(M data) {
        }
    }
}