package com.app.friendschat.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.friendschat.data.model.EmojiModel
import com.app.friendschat.data.model.PackageModel
import com.app.friendschat.data.model.TagModel
import com.app.friendschat.data.model.UserRecordModel

@TypeConverters(DataConverter::class)
@Database(entities = [UserRecordModel::class, TagModel::class, PackageModel::class, EmojiModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userRecordDao(): UserRecordDao
    abstract fun tagDao(): TagDao
    abstract fun packageNameDao(): PackageDao
    abstract fun emojiDao(): EmojiDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "AppDatabase"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}