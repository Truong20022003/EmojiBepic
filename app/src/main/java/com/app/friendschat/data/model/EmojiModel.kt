package com.app.friendschat.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmojiModel(
    @ColumnInfo(name = "path")
    val path: String,
    @ColumnInfo(name = "folder_name")
    val folderName: String,
    @ColumnInfo(name = "position")
    val position: Int,
    @ColumnInfo(name = "is_show_ads")
    val iShowAds:Boolean = true,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
//isShowAds: mặc đinh set true, show tất cả ads cảu icon, dựa theo logic chọn icon đặt làm vị trí show ads ể dùng
//position: dùng để lấy vị trí của icon theo từng folder, ví dụ face chạy từ 0 đến 10, eyes cũng chạy lại từ 0 đến 10