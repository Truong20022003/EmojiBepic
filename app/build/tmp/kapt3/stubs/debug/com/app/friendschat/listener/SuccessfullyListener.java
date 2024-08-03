package com.app.friendschat.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"Lcom/app/friendschat/listener/SuccessfullyListener;", "Ljava/io/Serializable;", "onSaveSuccessfully", "", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public abstract interface SuccessfullyListener extends java.io.Serializable {
    
    public abstract void onSaveSuccessfully();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
        
        public static void onSaveSuccessfully(@org.jetbrains.annotations.NotNull
        com.app.friendschat.listener.SuccessfullyListener $this) {
        }
    }
}