package com.app.friendschat.data.api.retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/app/friendschat/data/api/retrofit/FakerApi;", "", "getProducts", "Lretrofit2/Response;", "Lcom/app/friendschat/data/api/retrofit/Product;", "id", "", "device_id", "", "view", "", "(JLjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public abstract interface FakerApi {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "services/getWallpaperDetails")
    @retrofit2.http.Headers(value = {"Cache-Control: max-age=0", "User-Agent: Walper", "Security: 8V06LupAaMBLtQqyqTxmcN42nn27FlejvaoSM3zXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"})
    public abstract java.lang.Object getProducts(@retrofit2.http.Query(value = "id")
    long id, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "device")
    java.lang.String device_id, @retrofit2.http.Query(value = "view")
    int view, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.app.friendschat.data.api.retrofit.Product>> continuation);
}