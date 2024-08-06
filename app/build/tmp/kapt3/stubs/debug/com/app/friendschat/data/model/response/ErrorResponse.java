package com.app.friendschat.data.model.response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/app/friendschat/data/model/response/ErrorResponse;", "", "message", "", "(Ljava/lang/String;)V", "code", "", "(Ljava/lang/String;I)V", "getCode", "()I", "setCode", "(I)V", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "getLocalizedMessage", "Companion", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class ErrorResponse extends java.lang.Throwable {
    @org.jetbrains.annotations.Nullable
    private java.lang.String errorMessage;
    private int code = 0;
    @org.jetbrains.annotations.NotNull
    public static final com.app.friendschat.data.model.response.ErrorResponse.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ERROR = "An error occurred";
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    public final void setErrorMessage(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final int getCode() {
        return 0;
    }
    
    public final void setCode(int p0) {
    }
    
    public ErrorResponse(@org.jetbrains.annotations.Nullable
    java.lang.String message) {
        super(null);
    }
    
    public ErrorResponse(@org.jetbrains.annotations.Nullable
    java.lang.String message, int code) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.String getLocalizedMessage() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/app/friendschat/data/model/response/ErrorResponse$Companion;", "", "()V", "ERROR", "", "defaultError", "Lcom/app/friendschat/data/model/response/ErrorResponse;", "message", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.app.friendschat.data.model.response.ErrorResponse defaultError(@org.jetbrains.annotations.NotNull
        java.lang.String message) {
            return null;
        }
    }
}