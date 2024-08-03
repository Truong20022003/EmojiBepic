package com.app.friendschat.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "MyDataStorePreferences")
class DataStorePreferences(context: Context) {

    companion object {
        val JSON_UNDO_LIST = stringPreferencesKey("json_undo_list_sticker")
    }

    // Lưu trữ dữ liệu
    suspend fun setJsonUndoListSticker(json: String, context: Context) {
        withContext(Dispatchers.IO) {
            context.dataStore.edit { preferences ->
                preferences[JSON_UNDO_LIST] = json
            }
        }
    }

    // Đọc dữ liệu
    val jsonUndoListSticker: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[JSON_UNDO_LIST] ?: ""
    }

}