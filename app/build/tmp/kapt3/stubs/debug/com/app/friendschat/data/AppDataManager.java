package com.app.friendschat.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/app/friendschat/data/AppDataManager;", "Lcom/app/friendschat/data/DataManager;", "mPreferencesHelper", "Lcom/app/friendschat/data/local/IPreferenceHelper;", "mApiHelper", "Lcom/app/friendschat/data/api/IApiHelper;", "(Lcom/app/friendschat/data/local/IPreferenceHelper;Lcom/app/friendschat/data/api/IApiHelper;)V", "value", "", "jsonUndoList", "getJsonUndoList", "()Ljava/lang/String;", "setJsonUndoList", "(Ljava/lang/String;)V", "token", "getToken", "setToken", "getRepoGit", "Lio/reactivex/Observable;", "Lcom/app/friendschat/data/model/GitResponse;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
@javax.inject.Singleton
public final class AppDataManager implements com.app.friendschat.data.DataManager {
    private final com.app.friendschat.data.local.IPreferenceHelper mPreferencesHelper = null;
    private final com.app.friendschat.data.api.IApiHelper mApiHelper = null;
    
    @javax.inject.Inject
    public AppDataManager(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.local.IPreferenceHelper mPreferencesHelper, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.api.IApiHelper mApiHelper) {
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
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public io.reactivex.Observable<com.app.friendschat.data.model.GitResponse> getRepoGit() {
        return null;
    }
}