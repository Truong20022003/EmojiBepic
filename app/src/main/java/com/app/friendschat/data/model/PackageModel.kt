package com.app.friendschat.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.app.friendschat.database.DataConverter

@Entity
data class PackageModel(
    @ColumnInfo(name = "package_name")
    val packageName: String,
    @ColumnInfo(name = "sticker_urls")
    @TypeConverters(DataConverter::class)
    val stickers: List<StickerModel> = listOf(),
    @ColumnInfo(name = "is_draft")
    val isDraft: Boolean = false,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)