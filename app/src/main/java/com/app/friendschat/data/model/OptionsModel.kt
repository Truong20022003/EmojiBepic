package com.app.friendschat.data.model

data class OptionsModel(
    var id: Int,
    var photoOptionsUnSelect: Int,
    var photoOptionsSelect: Int,
    var nameEvent: String,
    var nameOptions: String,
    var listIcon: MutableList<IconModel>,
    var isSelectPage: Boolean
)
//nameEvent: dùng để put tên mà không dịch lên firebase