package com.app.friendschat.ui.emoji;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0014\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J\u001a\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u0011J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J,\u0010\u0015\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0007j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t`\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R4\u0010\u0006\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0007j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/app/friendschat/ui/emoji/EmojiViewModel;", "Lcom/app/friendschat/ui/base/BaseViewModel;", "()V", "currentJson", "", "emojiJson", "undoList", "Ljava/util/ArrayList;", "Lcom/app/friendschat/utils/custom_sticker/Sticker;", "Lkotlin/collections/ArrayList;", "convertJsonToListOfList", "", "context", "Landroid/content/Context;", "json", "convertListEmojiToJson", "listEmoji", "", "convertListOfListToJson", "getCurrentJson", "getEmojiJson", "getUndoList", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class EmojiViewModel extends com.app.friendschat.ui.base.BaseViewModel {
    private java.lang.String currentJson = "";
    private java.util.ArrayList<java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker>> undoList;
    private java.lang.String emojiJson = "";
    
    public EmojiViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmojiJson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker>> getUndoList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentJson() {
        return null;
    }
    
    public final void convertListOfListToJson(@org.jetbrains.annotations.NotNull
    java.util.List<? extends java.util.List<? extends com.app.friendschat.utils.custom_sticker.Sticker>> undoList) {
    }
    
    public final void convertJsonToListOfList(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String json) {
    }
    
    public final void convertListEmojiToJson(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.app.friendschat.utils.custom_sticker.Sticker> listEmoji) {
    }
}