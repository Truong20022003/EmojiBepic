package com.app.friendschat.data.model;

import java.lang.System;

@androidx.room.Entity
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/app/friendschat/data/model/EmojiModel;", "", "path", "", "folderName", "position", "", "iShowAds", "", "id", "(Ljava/lang/String;Ljava/lang/String;IZI)V", "getFolderName", "()Ljava/lang/String;", "getIShowAds", "()Z", "getId", "()I", "getPath", "getPosition", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class EmojiModel {
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "path")
    private final java.lang.String path = null;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "folder_name")
    private final java.lang.String folderName = null;
    @androidx.room.ColumnInfo(name = "position")
    private final int position = 0;
    @androidx.room.ColumnInfo(name = "is_show_ads")
    private final boolean iShowAds = false;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int id = 0;
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.data.model.EmojiModel copy(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String folderName, int position, boolean iShowAds, int id) {
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
    
    public EmojiModel(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    java.lang.String folderName, int position, boolean iShowAds, int id) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFolderName() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getPosition() {
        return 0;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean getIShowAds() {
        return false;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
}