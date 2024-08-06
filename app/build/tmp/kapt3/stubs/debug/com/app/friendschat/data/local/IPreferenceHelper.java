package com.app.friendschat.data.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/app/friendschat/data/local/IPreferenceHelper;", "", "jsonUndoList", "", "getJsonUndoList", "()Ljava/lang/String;", "setJsonUndoList", "(Ljava/lang/String;)V", "token", "getToken", "setToken", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public abstract interface IPreferenceHelper {
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getToken();
    
    public abstract void setToken(@org.jetbrains.annotations.NotNull
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.String getJsonUndoList();
    
    public abstract void setJsonUndoList(@org.jetbrains.annotations.Nullable
    java.lang.String p0);
}