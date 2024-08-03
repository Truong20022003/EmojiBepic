package com.app.friendschat.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/app/friendschat/utils/ConnectionLiveData;", "Landroidx/lifecycle/LiveData;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "cm", "Landroid/net/ConnectivityManager;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "validNetworks", "", "Landroid/net/Network;", "checkValidNetworks", "", "createNetworkCallback", "onActive", "onInactive", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class ConnectionLiveData extends androidx.lifecycle.LiveData<java.lang.Boolean> {
    private final java.lang.String TAG = "Connect-Manager";
    private android.net.ConnectivityManager.NetworkCallback networkCallback;
    private final android.net.ConnectivityManager cm = null;
    private final java.util.Set<android.net.Network> validNetworks = null;
    
    public ConnectionLiveData(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    private final void checkValidNetworks() {
    }
    
    @java.lang.Override
    protected void onActive() {
    }
    
    @java.lang.Override
    protected void onInactive() {
    }
    
    private final android.net.ConnectivityManager.NetworkCallback createNetworkCallback() {
        return null;
    }
}