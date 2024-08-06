package com.app.friendschat.popup_menu;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/app/friendschat/popup_menu/PopupMenuCustom;", "", "context", "Landroid/content/Context;", "rLayoutId", "", "onClickListener", "Lcom/app/friendschat/popup_menu/PopupMenuCustom$PopupMenuCustomOnClickListener;", "(Landroid/content/Context;ILcom/app/friendschat/popup_menu/PopupMenuCustom$PopupMenuCustomOnClickListener;)V", "popupView", "Landroid/view/View;", "popupWindow", "Landroid/widget/PopupWindow;", "setAnimationStyle", "", "animationStyle", "show", "anchorView", "showAbove", "showLeft", "PopupMenuCustomOnClickListener", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class PopupMenuCustom {
    private final android.content.Context context = null;
    private final int rLayoutId = 0;
    private final com.app.friendschat.popup_menu.PopupMenuCustom.PopupMenuCustomOnClickListener onClickListener = null;
    private final android.widget.PopupWindow popupWindow = null;
    private final android.view.View popupView = null;
    
    public PopupMenuCustom(@org.jetbrains.annotations.NotNull
    android.content.Context context, int rLayoutId, @org.jetbrains.annotations.NotNull
    com.app.friendschat.popup_menu.PopupMenuCustom.PopupMenuCustomOnClickListener onClickListener) {
        super();
    }
    
    public final void setAnimationStyle(int animationStyle) {
    }
    
    public final void show() {
    }
    
    public final void show(@org.jetbrains.annotations.NotNull
    android.view.View anchorView) {
    }
    
    public final void showLeft(@org.jetbrains.annotations.NotNull
    android.view.View anchorView) {
    }
    
    public final void showAbove(@org.jetbrains.annotations.NotNull
    android.view.View anchorView) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/app/friendschat/popup_menu/PopupMenuCustom$PopupMenuCustomOnClickListener;", "", "onClick", "", "menuItemId", "", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
    public static abstract interface PopupMenuCustomOnClickListener {
        
        public abstract void onClick(int menuItemId);
    }
}