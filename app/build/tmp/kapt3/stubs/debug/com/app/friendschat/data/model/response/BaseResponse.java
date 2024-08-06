package com.app.friendschat.data.model.response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/app/friendschat/data/model/response/BaseResponse;", "T", "", "()V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "error", "Lcom/app/friendschat/data/model/response/ErrorResponse;", "getError", "()Lcom/app/friendschat/data/model/response/ErrorResponse;", "setError", "(Lcom/app/friendschat/data/model/response/ErrorResponse;)V", "isSuccess", "", "()Z", "status", "", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public class BaseResponse<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "success")
    private java.lang.Integer status;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "data")
    private T data;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "errors")
    private com.app.friendschat.data.model.response.ErrorResponse error;
    
    public BaseResponse() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final T getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable
    T p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.app.friendschat.data.model.response.ErrorResponse getError() {
        return null;
    }
    
    public final void setError(@org.jetbrains.annotations.Nullable
    com.app.friendschat.data.model.response.ErrorResponse p0) {
    }
    
    public final boolean isSuccess() {
        return false;
    }
}