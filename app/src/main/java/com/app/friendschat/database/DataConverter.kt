package com.app.friendschat.database

import androidx.room.TypeConverter
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.data.model.TagModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DataConverter {
    @TypeConverter
    fun fromString(value: String?): ArrayList<TagModel?>? {
        val listType: Type = object : TypeToken<ArrayList<TagModel?>?>() {}.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    fun fromArrayList(list: ArrayList<TagModel?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringList(value: String): List<StickerModel> {
        val listType = object : TypeToken<List<StickerModel>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListString(list: List<StickerModel>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}