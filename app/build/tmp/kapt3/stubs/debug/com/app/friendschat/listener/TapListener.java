package com.app.friendschat.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/app/friendschat/listener/TapListener;", "Landroid/view/View$OnClickListener;", "()V", "lastClickMillis", "", "now", "onClick", "", "v", "Landroid/view/View;", "onTap", "Companion", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public abstract class TapListener implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull
    public static final com.app.friendschat.listener.TapListener.Companion Companion = null;
    private static final long DEBOUNCE = 50L;
    private long lastClickMillis = 0L;
    private long now = 0L;
    
    public TapListener() {
        super();
    }
    
    @java.lang.Override
    public void onClick(@org.jetbrains.annotations.Nullable
    android.view.View v) {
    }
    
    public abstract void onTap(@org.jetbrains.annotations.Nullable
    android.view.View v);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/app/friendschat/listener/TapListener$Companion;", "", "()V", "DEBOUNCE", "", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}