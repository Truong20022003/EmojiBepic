package com.app.friendschat.bottom_sheet;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J&\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0004H\u0002J\u0011\u0010!\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/app/friendschat/bottom_sheet/NewPackageBepicBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "onCreateSuccessfully", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "edtPackageNameBepic", "Landroid/widget/EditText;", "packageDaoBepic", "Lcom/app/friendschat/database/PackageDao;", "rlCancelBepic", "Landroid/widget/RelativeLayout;", "rlSaveBepic", "checkPackageNameExisted", "", "packageName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectToDatabaseBepic", "initViewBepic", "view", "Landroid/view/View;", "insertPackageName", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "setupListenersBepic", "validatePackageName", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Emoji_Maker_v1.0.0_08.03.2024_debug"})
public final class NewPackageBepicBottomSheet extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onCreateSuccessfully = null;
    private android.widget.RelativeLayout rlCancelBepic;
    private android.widget.RelativeLayout rlSaveBepic;
    private android.widget.EditText edtPackageNameBepic;
    private com.app.friendschat.database.PackageDao packageDaoBepic;
    private java.util.HashMap _$_findViewCache;
    
    public NewPackageBepicBottomSheet() {
        super();
    }
    
    public NewPackageBepicBottomSheet(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onCreateSuccessfully) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    private final void setupListenersBepic() {
    }
    
    private final void connectToDatabaseBepic() {
    }
    
    private final void initViewBepic(android.view.View view) {
    }
    
    private final java.lang.Object validatePackageName(kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    private final java.lang.Object insertPackageName(java.lang.String packageName, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object checkPackageNameExisted(java.lang.String packageName, kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}