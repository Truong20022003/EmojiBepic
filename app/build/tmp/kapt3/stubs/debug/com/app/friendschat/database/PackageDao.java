package com.app.friendschat.database;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0011\u0010\u0014\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u0018\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0019\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ!\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u001eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\'\u0010$\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"Lcom/app/friendschat/database/PackageDao;", "", "deletePackage", "", "packageModel", "Lcom/app/friendschat/data/model/PackageModel;", "(Lcom/app/friendschat/data/model/PackageModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePackageByName", "packageName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteStickerFromDraft", "position", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDrafts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPackages", "getAllPackagesWithoutDraft", "getDraftPackage", "getPackageById", "packageId", "getPackageByName", "insertPackage", "isDraftExisted", "", "isPackageNameExisted", "replaceStickerInDraft", "newSticker", "Lcom/app/friendschat/data/model/StickerModel;", "(ILcom/app/friendschat/data/model/StickerModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveToDraft", "stickerModel", "(Lcom/app/friendschat/data/model/StickerModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackage", "updateStickerList", "stickers", "(ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public abstract interface PackageDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert
    public abstract java.lang.Object insertPackage(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.PackageModel packageName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT COUNT(*) FROM PackageModel WHERE package_name = :packageName")
    public abstract java.lang.Object isPackageNameExisted(@org.jetbrains.annotations.NotNull
    java.lang.String packageName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object isDraftExisted(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updatePackage(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.PackageModel packageModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deletePackage(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.PackageModel packageModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM PackageModel")
    public abstract java.lang.Object getAllPackages(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.app.friendschat.data.model.PackageModel>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllPackagesWithoutDraft(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.app.friendschat.data.model.PackageModel>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM PackageModel WHERE is_draft = 1")
    public abstract java.lang.Object getAllDrafts(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.app.friendschat.data.model.PackageModel>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "UPDATE PackageModel SET sticker_urls = :stickers WHERE id = :packageId")
    public abstract java.lang.Object updateStickerList(int packageId, @org.jetbrains.annotations.NotNull
    java.util.List<com.app.friendschat.data.model.StickerModel> stickers, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM PackageModel WHERE id = :packageId")
    public abstract java.lang.Object getPackageById(int packageId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.app.friendschat.data.model.PackageModel> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPackageByName(@org.jetbrains.annotations.NotNull
    java.lang.String packageName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.app.friendschat.data.model.PackageModel> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deletePackageByName(@org.jetbrains.annotations.NotNull
    java.lang.String packageName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getDraftPackage(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.app.friendschat.data.model.PackageModel> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object saveToDraft(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.StickerModel stickerModel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object replaceStickerInDraft(int position, @org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.StickerModel newSticker, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteStickerFromDraft(int position, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object isDraftExisted(@org.jetbrains.annotations.NotNull
        com.app.friendschat.database.PackageDao $this, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super java.lang.Boolean> p1) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object getAllPackagesWithoutDraft(@org.jetbrains.annotations.NotNull
        com.app.friendschat.database.PackageDao $this, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super java.util.List<com.app.friendschat.data.model.PackageModel>> p1) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object getPackageByName(@org.jetbrains.annotations.NotNull
        com.app.friendschat.database.PackageDao $this, @org.jetbrains.annotations.NotNull
        java.lang.String packageName, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super com.app.friendschat.data.model.PackageModel> p2) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object deletePackageByName(@org.jetbrains.annotations.NotNull
        com.app.friendschat.database.PackageDao $this, @org.jetbrains.annotations.NotNull
        java.lang.String packageName, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object getDraftPackage(@org.jetbrains.annotations.NotNull
        com.app.friendschat.database.PackageDao $this, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super com.app.friendschat.data.model.PackageModel> p1) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object saveToDraft(@org.jetbrains.annotations.NotNull
        com.app.friendschat.database.PackageDao $this, @org.jetbrains.annotations.NotNull
        com.app.friendschat.data.model.StickerModel stickerModel, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object replaceStickerInDraft(@org.jetbrains.annotations.NotNull
        com.app.friendschat.database.PackageDao $this, int position, @org.jetbrains.annotations.NotNull
        com.app.friendschat.data.model.StickerModel newSticker, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object deleteStickerFromDraft(@org.jetbrains.annotations.NotNull
        com.app.friendschat.database.PackageDao $this, int position, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
            return null;
        }
    }
}