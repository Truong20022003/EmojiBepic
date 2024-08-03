package com.app.friendschat.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.friendschat.data.model.EmojiModel

@Dao
interface EmojiDao {
    @Insert
    fun insertEmoji(emojiModel: EmojiModel)

    @Query("SELECT * FROM EmojiModel")
    suspend fun getAllEmoji(): List<EmojiModel>

    suspend fun isEmojiExisted(): Boolean{
        return getAllEmoji().isNotEmpty()
    }
    @Query("UPDATE EmojiModel set is_show_ads = 0 WHERE id = :id")
    fun updateUnLockShowAds(id: Int)

}