package com.app.friendschat.ui.emoji_edit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0014\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013J\u001a\u0010\u0014\u001a\u00020\f2\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00130\u0013J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ,\u0010\u0018\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b`\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R4\u0010\n\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/app/friendschat/ui/emoji_edit/EditEmojiViewModel;", "Lcom/app/friendschat/ui/base/BaseViewModel;", "()V", "emojiJson", "", "emojiList", "Ljava/util/ArrayList;", "Lcom/app/friendschat/utils/custom_sticker/Sticker;", "Lkotlin/collections/ArrayList;", "jsonUndoList", "undoList", "convertJsonToList", "", "context", "Landroid/content/Context;", "json", "convertJsonToListOfList", "convertListEmojiToJson", "listEmoji", "", "convertListOfListToJson", "getEmojiJson", "getJsonUndoList", "getListStickers", "getListUndo", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class EditEmojiViewModel extends com.app.friendschat.ui.base.BaseViewModel {
    private java.util.ArrayList<java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker>> undoList;
    private java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker> emojiList;
    private java.lang.String emojiJson = "";
    private java.lang.String jsonUndoList = "";
    
    public EditEmojiViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getJsonUndoList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmojiJson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker> getListStickers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.util.ArrayList<com.app.friendschat.utils.custom_sticker.Sticker>> getListUndo() {
        return null;
    }
    
    public final void convertJsonToListOfList(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String json) {
    }
    
    public final void convertJsonToList(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String json) {
    }
    
    public final void convertListEmojiToJson(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.app.friendschat.utils.custom_sticker.Sticker> listEmoji) {
    }
    
    public final void convertListOfListToJson(@org.jetbrains.annotations.NotNull
    java.util.List<? extends java.util.List<? extends com.app.friendschat.utils.custom_sticker.Sticker>> undoList) {
    }
}