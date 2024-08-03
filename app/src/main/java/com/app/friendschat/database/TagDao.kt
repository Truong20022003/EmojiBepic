package com.app.friendschat.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.friendschat.data.model.TagModel

@Dao
interface TagDao {
    @Query("SELECT * FROM Table_Tag ORDER BY id DESC")
    fun getListTag(): MutableList<TagModel>

    @Insert
    fun insertTag(tagModel: TagModel)

    @Query("DELETE FROM Table_Tag WHERE tag =:tag")
    fun deleteTag(tag: String)

    @Query("DELETE FROM Table_Tag")
    fun deleteAll()
}