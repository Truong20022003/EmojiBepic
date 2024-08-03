package com.app.friendschat.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u000bJ\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u000bR\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0002X\u0083D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/app/friendschat/data/api/AppHeader;", "", "()V", "accessToken", "", "contentType", "setToken", "", "token", "toAuthorization", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "toContentType", "Companion", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class AppHeader {
    @org.jetbrains.annotations.NotNull
    public static final com.app.friendschat.data.api.AppHeader.Companion Companion = null;
    private static final java.lang.String auth_prefix = "Bearer ";
    @com.google.gson.annotations.SerializedName(value = "Content-Type")
    @com.google.gson.annotations.Expose
    private final java.lang.String contentType = "application/x-www-form-urlencoded";
    @com.google.gson.annotations.SerializedName(value = "Authorization")
    @com.google.gson.annotations.Expose
    private java.lang.String accessToken = "";
    
    public AppHeader() {
        super();
    }
    
    public final void setToken(@org.jetbrains.annotations.NotNull
    java.lang.String token) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, java.lang.String> toContentType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, java.lang.String> toAuthorization() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/app/friendschat/data/api/AppHeader$Companion;", "", "()V", "auth_prefix", "", "generateAccessToken", "token", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final java.lang.String generateAccessToken(java.lang.String token) {
            return null;
        }
    }
}