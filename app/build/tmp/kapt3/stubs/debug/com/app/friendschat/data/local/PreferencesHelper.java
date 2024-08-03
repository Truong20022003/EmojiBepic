package com.app.friendschat.data.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R(\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/app/friendschat/data/local/PreferencesHelper;", "Lcom/app/friendschat/data/local/IPreferenceHelper;", "context", "Landroid/content/Context;", "prefFileName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "value", "jsonUndoList", "getJsonUndoList", "()Ljava/lang/String;", "setJsonUndoList", "(Ljava/lang/String;)V", "masterKeyAlias", "sharedPreferences", "Landroid/content/SharedPreferences;", "token", "getToken", "setToken", "Companion", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class PreferencesHelper implements com.app.friendschat.data.local.IPreferenceHelper {
    @org.jetbrains.annotations.NotNull
    public static final com.app.friendschat.data.local.PreferencesHelper.Companion Companion = null;
    private static final java.lang.String MASTER_KEY_ALIAS = "Base_ALIAS";
    private static final int KEY_SIZE = 256;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TOKEN_KEY = "token";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String JSON_UNDO_LIST = "json undo list";
    private java.lang.String masterKeyAlias;
    private android.content.SharedPreferences sharedPreferences;
    
    @javax.inject.Inject
    public PreferencesHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String prefFileName) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getToken() {
        return null;
    }
    
    @java.lang.Override
    public void setToken(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.String getJsonUndoList() {
        return null;
    }
    
    @java.lang.Override
    public void setJsonUndoList(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/app/friendschat/data/local/PreferencesHelper$Companion;", "", "()V", "JSON_UNDO_LIST", "", "KEY_SIZE", "", "MASTER_KEY_ALIAS", "TOKEN_KEY", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}