package com.app.friendschat.database;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\'\u00a8\u0006\f"}, d2 = {"Lcom/app/friendschat/database/TagDao;", "", "deleteAll", "", "deleteTag", "tag", "", "getListTag", "", "Lcom/app/friendschat/data/model/TagModel;", "insertTag", "tagModel", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public abstract interface TagDao {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Table_Tag ORDER BY id DESC")
    public abstract java.util.List<com.app.friendschat.data.model.TagModel> getListTag();
    
    @androidx.room.Insert
    public abstract void insertTag(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.TagModel tagModel);
    
    @androidx.room.Query(value = "DELETE FROM Table_Tag WHERE tag =:tag")
    public abstract void deleteTag(@org.jetbrains.annotations.NotNull
    java.lang.String tag);
    
    @androidx.room.Query(value = "DELETE FROM Table_Tag")
    public abstract void deleteAll();
}