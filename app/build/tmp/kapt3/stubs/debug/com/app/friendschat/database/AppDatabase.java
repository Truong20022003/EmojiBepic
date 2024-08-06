package com.app.friendschat.database;

import java.lang.System;

@androidx.room.Database(entities = {com.app.friendschat.data.model.UserRecordModel.class, com.app.friendschat.data.model.TagModel.class, com.app.friendschat.data.model.PackageModel.class, com.app.friendschat.data.model.EmojiModel.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.app.friendschat.database.DataConverter.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/app/friendschat/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "emojiDao", "Lcom/app/friendschat/database/EmojiDao;", "packageNameDao", "Lcom/app/friendschat/database/PackageDao;", "tagDao", "Lcom/app/friendschat/database/TagDao;", "userRecordDao", "Lcom/app/friendschat/database/UserRecordDao;", "Companion", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull
    public static final com.app.friendschat.database.AppDatabase.Companion Companion = null;
    private static com.app.friendschat.database.AppDatabase INSTANCE;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.app.friendschat.database.UserRecordDao userRecordDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.app.friendschat.database.TagDao tagDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.app.friendschat.database.PackageDao packageNameDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.app.friendschat.database.EmojiDao emojiDao();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/app/friendschat/database/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/app/friendschat/database/AppDatabase;", "getInstance", "context", "Landroid/content/Context;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.app.friendschat.database.AppDatabase getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}