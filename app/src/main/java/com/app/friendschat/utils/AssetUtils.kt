package com.app.friendschat.utils

import android.content.Context
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.data.model.StickerPackInfo
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.nio.charset.StandardCharsets

object AssetUtils {

    var stickerPacksInfo = mutableListOf<StickerPackInfo>()

    fun loadStickerPacksInfo(context: Context): Boolean {
        if (stickerPacksInfo.isNotEmpty()) {
            return true
        }

        val json = try {
            val `is` = context.assets.open("suggestion_stickers.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, StandardCharsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return false
        }

        try {
            val jsonArr = JSONArray(json)
            for (i in 0 until jsonArr.length()) {
                val jsonObj = jsonArr.getJSONObject(i)

                val title = jsonObj.getString("title")
                val icon = jsonObj.getString("icon")

                val stickersJson = jsonObj.getJSONArray("stickers")

                val stickerUrls = mutableListOf<String>()
                for (j in 0 until stickersJson.length()) {
                    stickerUrls.add(stickersJson.getString(j))
                }

                val stickerPackInfo = StickerPackInfo(
                    title,
                    icon,
                    stickerUrls.map { StickerModel(it) }
                )

                stickerPacksInfo.add(stickerPackInfo)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
            return false
        }


        return true
    }

    fun getStickerPackInfoByTitle(title: String): StickerPackInfo? {
        for (stickerPackInfo in stickerPacksInfo) {
            if (stickerPackInfo.title == title) {
                return stickerPackInfo
            }
        }
        return null
    }
}