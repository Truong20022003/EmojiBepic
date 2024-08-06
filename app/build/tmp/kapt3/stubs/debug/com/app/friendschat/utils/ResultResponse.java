package com.app.friendschat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0016*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002\u0016\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0004J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0000\"\b\b\u0001\u0010\f*\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\f0\u000eJ.\u0010\u000f\u001a\u00028\u00002!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00028\u00000\u000e\u00a2\u0006\u0002\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/app/friendschat/utils/ResultResponse;", "T", "", "value", "(Ljava/lang/Object;)V", "isFailure", "", "()Z", "isSuccess", "getValue", "()Ljava/lang/Object;", "map", "U", "f", "Lkotlin/Function1;", "materialize", "onFailure", "", "Lkotlin/ParameterName;", "name", "error", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "Failure", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class ResultResponse<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object value = null;
    @org.jetbrains.annotations.NotNull
    public static final com.app.friendschat.utils.ResultResponse.Companion Companion = null;
    private final boolean isSuccess = false;
    private final boolean isFailure = false;
    
    private ResultResponse(java.lang.Object value) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getValue() {
        return null;
    }
    
    public final boolean isSuccess() {
        return false;
    }
    
    public final boolean isFailure() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public final T materialize(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, ? extends T> onFailure) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public final <U extends java.lang.Object>com.app.friendschat.utils.ResultResponse<U> map(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super T, ? extends U> f) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/app/friendschat/utils/ResultResponse$Failure;", "", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
    public static final class Failure {
        @org.jetbrains.annotations.NotNull
        private final java.lang.Throwable error = null;
        
        public Failure(@org.jetbrains.annotations.NotNull
        java.lang.Throwable error) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.Throwable getError() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007J#\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012\u0006\u0010\t\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/app/friendschat/utils/ResultResponse$Companion;", "", "()V", "failure", "Lcom/app/friendschat/utils/ResultResponse;", "T", "error", "", "success", "value", "(Ljava/lang/Object;)Lcom/app/friendschat/utils/ResultResponse;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final <T extends java.lang.Object>com.app.friendschat.utils.ResultResponse<T> success(@org.jetbrains.annotations.NotNull
        T value) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final <T extends java.lang.Object>com.app.friendschat.utils.ResultResponse<T> failure(@org.jetbrains.annotations.NotNull
        java.lang.Throwable error) {
            return null;
        }
    }
}