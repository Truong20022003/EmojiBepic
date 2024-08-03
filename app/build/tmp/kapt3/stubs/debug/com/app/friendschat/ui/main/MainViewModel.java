package com.app.friendschat.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/app/friendschat/ui/main/MainViewModel;", "Lcom/app/friendschat/ui/base/BaseViewModel;", "()V", "emojiDao", "Lcom/app/friendschat/database/EmojiDao;", "listRepo", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/app/friendschat/data/model/RepoModel;", "getListRepo", "()Landroidx/lifecycle/MutableLiveData;", "packageDao", "Lcom/app/friendschat/database/PackageDao;", "addDataIconModel", "", "activity", "Lcom/app/friendschat/ui/main/MainBepicActivity;", "(Lcom/app/friendschat/ui/main/MainBepicActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDraftPackageIfNotExist", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class MainViewModel extends com.app.friendschat.ui.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.app.friendschat.data.model.RepoModel>> listRepo = null;
    private com.app.friendschat.database.PackageDao packageDao;
    private com.app.friendschat.database.EmojiDao emojiDao;
    
    public MainViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.app.friendschat.data.model.RepoModel>> getListRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createDraftPackageIfNotExist(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.main.MainBepicActivity activity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addDataIconModel(@org.jetbrains.annotations.NotNull
    com.app.friendschat.ui.main.MainBepicActivity activity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}