package com.app.friendschat.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Table_Tag")
data class TagModel(
    @ColumnInfo(name = "TAG") var tag: String,
    @Ignore
    var isSelect: Boolean? = false
) : Serializable {
    constructor(tag: String) : this(tag, false)

    @PrimaryKey(autoGenerate = true)
    var id = 0
}