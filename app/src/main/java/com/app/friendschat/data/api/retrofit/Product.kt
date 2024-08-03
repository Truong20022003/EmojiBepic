package com.app.friendschat.data.api.retrofit

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("status")
    var status: String
)