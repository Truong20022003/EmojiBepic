package com.app.friendschat.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\bH\u0007J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J*\u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u0004H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/app/friendschat/database/DataConverter;", "", "()V", "fromArrayList", "", "list", "Ljava/util/ArrayList;", "Lcom/app/friendschat/data/model/TagModel;", "Lkotlin/collections/ArrayList;", "fromListString", "", "Lcom/app/friendschat/data/model/StickerModel;", "fromString", "value", "fromStringList", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class DataConverter {
    
    public DataConverter() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.TypeConverter
    public final java.util.ArrayList<com.app.friendschat.data.model.TagModel> fromString(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.TypeConverter
    public final java.lang.String fromArrayList(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.app.friendschat.data.model.TagModel> list) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.util.List<com.app.friendschat.data.model.StickerModel> fromStringList(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String fromListString(@org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.StickerModel> list) {
        return null;
    }
}