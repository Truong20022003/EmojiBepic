package com.app.friendschat.database;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\'J\u0011\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/app/friendschat/database/EmojiDao;", "", "getAllEmoji", "", "Lcom/app/friendschat/data/model/EmojiModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertEmoji", "", "emojiModel", "isEmojiExisted", "", "updateUnLockShowAds", "id", "", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public abstract interface EmojiDao {
    
    @androidx.room.Insert
    public abstract void insertEmoji(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.EmojiModel emojiModel);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM EmojiModel")
    public abstract java.lang.Object getAllEmoji(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.app.friendschat.data.model.EmojiModel>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object isEmojiExisted(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation);
    
    @androidx.room.Query(value = "UPDATE EmojiModel set is_show_ads = 0 WHERE id = :id")
    public abstract void updateUnLockShowAds(int id);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object isEmojiExisted(@org.jetbrains.annotations.NotNull
        com.app.friendschat.database.EmojiDao $this, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super java.lang.Boolean> p1) {
            return null;
        }
    }
}