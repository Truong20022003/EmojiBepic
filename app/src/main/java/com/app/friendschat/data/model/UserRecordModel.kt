package com.app.friendschat.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Table_User_Record")
data class UserRecordModel(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "SYSTOLIC") var systolic: Int,
    @ColumnInfo(name = "DIASTOLIC") var diastolic: Int,
    @ColumnInfo(name = "PULSE") var pulse: Int,
    @ColumnInfo(name = "COLOR_INFO") var colorInfo: String,
    @ColumnInfo(name = "KEY_TYPE") var keyType: Int,
    @ColumnInfo(name = "RECORD_YEAR") var recordYear: String,
    @ColumnInfo(name = "RECORD_DATE") var recordDate: String,
    @ColumnInfo(name = "RECORD_TIME") var recordTime: String,
    @ColumnInfo(name = "DATE_CREATED") var dateCreate: Long,
    @ColumnInfo(name = "TYPE_NOTE") var typeNote: String,
    @ColumnInfo(name = "TAG_NOTE") var tagNote: ArrayList<TagModel>,
) : Serializable {
    constructor() : this(0, 0, 0, 0, "", 0, "", "", "", 0, "", arrayListOf())

    constructor(systolic: Int, diastolic: Int, pulse: Int) : this(
        0,
        systolic,
        diastolic,
        pulse,
        "",
        0,
        "",
        "",
        "",
        0,
        "",
        arrayListOf()
    )
}