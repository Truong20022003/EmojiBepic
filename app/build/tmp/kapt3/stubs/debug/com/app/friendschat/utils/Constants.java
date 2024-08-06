package com.app.friendschat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00017B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0015X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103\u00a8\u00068"}, d2 = {"Lcom/app/friendschat/utils/Constants;", "", "()V", "ACCESSORIES", "", "AGENT", "BASE_URL", "BEARD", "BROW", "BUNDLE_BUTTON_TEXT_CONTENT_SUCCESS_ACTIVITY", "BUNDLE_EDIT_JSON_EMOJI", "BUNDLE_EDIT_JSON_UNDO_LIST", "BUNDLE_EDIT_POS_EMOJI", "BUNDLE_FROM_ACTIVITY", "BUNDLE_SAVE_ACTION", "BUNDLE_SPLASH", "BUNDLE_SPLASH_NO_INTERNET", "BUNDLE_SUCCESS_ACTION", "BUNDLE_SUGGESTION_STICKER_TITLE", "CACHE", "COUNT_EMOJI", "", "EMPTY", "EYES", "FACE", "GLASS", "HAIR", "HAND", "HAT", "KEY_PERMISSION_SCREEN_SHOWED", "MENU_INDEX_EXPORT_DETAILS", "MENU_INDEX_EXPORT_RESULT", "MENU_INDEX_NEW_MEASUREMENT", "MESSAGE_CAMERA_NOT_AVAILABLE", "MESSAGE_UPDATE_FINAL", "MESSAGE_UPDATE_REALTIME", "MOUTH", "NOSE", "PRIVACY_POLICY", "RANDOM_IDENTIFIER_FOR_ADDING_STICKER_TO_WHATSAPP", "REQUEST_CODE_CAMERA", "REQUEST_CODE_DELETE_STICKER", "REQUEST_CODE_NEW_ACTIVITY", "REQUEST_TIMEOUT", "", "SECURITY", "email", "jsonSticker", "getJsonSticker", "()Ljava/lang/String;", "setJsonSticker", "(Ljava/lang/String;)V", "jsonUndoList", "getJsonUndoList", "setJsonUndoList", "VIEW_STATE", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull
    public static final com.app.friendschat.utils.Constants INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FACE = "face";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EYES = "eyes";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BROW = "brow";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MOUTH = "mouth";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String HAND = "hand";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOSE = "nose";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BEARD = "beard";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String HAT = "hat";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String GLASS = "glass";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACCESSORIES = "accessories";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String HAIR = "hair";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String email = "";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EMPTY = "";
    public static final long REQUEST_TIMEOUT = 30L;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL = "https://demo.dream-space.web.id/walper/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CACHE = "Cache-Control: max-age=0";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String AGENT = "User-Agent: Walper";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SECURITY = "Security: 8V06LupAaMBLtQqyqTxmcN42nn27FlejvaoSM3zXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PRIVACY_POLICY = "https://firebasestorage.googleapis.com/v0/b/bp-v1-v006-emoji.appspot.com/o/Privacy-Policy%20(1).html?alt=media&token=2f59ff92-f16c-46d5-93c1-52da80d38898";
    public static final int REQUEST_CODE_CAMERA = 0;
    public static final int MESSAGE_UPDATE_REALTIME = 1;
    public static final int MESSAGE_UPDATE_FINAL = 2;
    public static final int MESSAGE_CAMERA_NOT_AVAILABLE = 3;
    public static final int MENU_INDEX_NEW_MEASUREMENT = 0;
    public static final int MENU_INDEX_EXPORT_RESULT = 1;
    public static final int MENU_INDEX_EXPORT_DETAILS = 2;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String RANDOM_IDENTIFIER_FOR_ADDING_STICKER_TO_WHATSAPP = "RANDOM_IDENTIFIER_FOR_WHATSAPP_STICKER";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_PERMISSION_SCREEN_SHOWED = "KEY_PERMISSION_SCREEN_SHOWED";
    public static final int REQUEST_CODE_DELETE_STICKER = 1000;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BUNDLE_SUGGESTION_STICKER_TITLE = "BUNDLE_SUGGESTION_STICKER_TITLE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BUNDLE_BUTTON_TEXT_CONTENT_SUCCESS_ACTIVITY = "BUNDLE_BUTTON_TEXT_CONTENT_SUCCESS_ACTIVITY";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BUNDLE_FROM_ACTIVITY = "BUNDLE_FROM_ACTIVITY";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BUNDLE_SAVE_ACTION = "BUNDLE_SAVE_ACTION";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BUNDLE_SUCCESS_ACTION = "BUNDLE_SUCCESS_ACTION";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BUNDLE_EDIT_POS_EMOJI = "BUNDLE_EDIT_POS_EMOJI";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BUNDLE_EDIT_JSON_UNDO_LIST = "BUNDLE_EDIT_JSON_UNDO_LIST";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BUNDLE_EDIT_JSON_EMOJI = "BUNDLE_EDIT_JSON_EMOJI";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BUNDLE_SPLASH_NO_INTERNET = "BUNDLE_SPLASH_NO_INTERNET";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BUNDLE_SPLASH = "BUNDLE_SPLASH";
    public static final int COUNT_EMOJI = 49;
    @org.jetbrains.annotations.NotNull
    private static java.lang.String jsonUndoList = "";
    @org.jetbrains.annotations.NotNull
    private static java.lang.String jsonSticker = "";
    public static final int REQUEST_CODE_NEW_ACTIVITY = 1000;
    
    private Constants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getJsonUndoList() {
        return null;
    }
    
    public final void setJsonUndoList(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getJsonSticker() {
        return null;
    }
    
    public final void setJsonSticker(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/app/friendschat/utils/Constants$VIEW_STATE;", "", "(Ljava/lang/String;I)V", "MEASUREMENT", "SHOW_RESULTS", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
    public static enum VIEW_STATE {
        /*public static final*/ MEASUREMENT /* = new MEASUREMENT() */,
        /*public static final*/ SHOW_RESULTS /* = new SHOW_RESULTS() */;
        
        VIEW_STATE() {
        }
    }
}