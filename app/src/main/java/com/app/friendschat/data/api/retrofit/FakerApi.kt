package com.app.friendschat.data.api.retrofit

import com.app.friendschat.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FakerApi {
    @Headers(
        Constants.CACHE,
        Constants.AGENT,
        Constants.SECURITY
    )
    @GET("services/getWallpaperDetails")
    suspend fun getProducts(
        @Query("id") id: Long,
        @Query("device") device_id: String,
        @Query("view") view: Int
    ): Response<Product>
}