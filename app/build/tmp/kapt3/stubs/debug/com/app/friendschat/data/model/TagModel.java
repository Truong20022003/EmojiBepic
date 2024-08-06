package com.app.friendschat.data.model;

import java.lang.System;

@androidx.room.Entity(tableName = "Table_Tag")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ$\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\tH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004\u00a8\u0006\u001e"}, d2 = {"Lcom/app/friendschat/data/model/TagModel;", "Ljava/io/Serializable;", "tag", "", "(Ljava/lang/String;)V", "isSelect", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "id", "", "getId", "()I", "setId", "(I)V", "()Ljava/lang/Boolean;", "setSelect", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTag", "()Ljava/lang/String;", "setTag", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/app/friendschat/data/model/TagModel;", "equals", "other", "", "hashCode", "toString", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class TagModel implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "TAG")
    private java.lang.String tag;
    @org.jetbrains.annotations.Nullable
    @androidx.room.Ignore
    private java.lang.Boolean isSelect;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.data.model.TagModel copy(@org.jetbrains.annotations.NotNull
    java.lang.String tag, @org.jetbrains.annotations.Nullable
    java.lang.Boolean isSelect) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public TagModel(@org.jetbrains.annotations.NotNull
    java.lang.String tag, @org.jetbrains.annotations.Nullable
    java.lang.Boolean isSelect) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTag() {
        return null;
    }
    
    public final void setTag(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean isSelect() {
        return null;
    }
    
    public final void setSelect(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    public TagModel(@org.jetbrains.annotations.NotNull
    java.lang.String tag) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
}