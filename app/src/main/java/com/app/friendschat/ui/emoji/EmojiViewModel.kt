package com.app.friendschat.ui.emoji

import android.content.Context
import android.graphics.Matrix
import android.graphics.drawable.Drawable
import android.util.Log
import com.app.friendschat.ui.base.BaseViewModel
import com.app.friendschat.utils.custom_sticker.DrawableSticker
import com.app.friendschat.utils.custom_sticker.Sticker
import com.app.friendschat.utils.custom_sticker.TextSticker
import com.app.friendschat.utils.widget.convertPhotoAssetToDrawable
import com.app.friendschat.utils.widget.matrixToString
import com.app.friendschat.utils.widget.stringToMatrix
import org.json.JSONArray
import org.json.JSONObject

class EmojiViewModel : BaseViewModel() {
    //undo list
    private var currentJson: String = ""
    private var undoList: ArrayList<ArrayList<Sticker>> = arrayListOf()

    //emoji
    private var emojiJson: String = ""

    fun getEmojiJson(): String {
        return emojiJson
    }

    fun getUndoList(): ArrayList<ArrayList<Sticker>> {
        return undoList
    }

    fun getCurrentJson(): String {
        return currentJson
    }

    fun convertListOfListToJson(undoList: List<List<Sticker>>) {
        val outerJsonArray: JSONArray = JSONArray()
        for (i in undoList.indices) {
            val innerJsonArray: JSONArray = JSONArray()
            for (j in 0 until undoList[i].size) {
                val jsonObject: JSONObject = JSONObject()
                if (undoList[i][j] is DrawableSticker) {
                    val matrixString = matrixToString(undoList[i][j].matrix)
//                    val drawableTest = drawableToBase64(undoList[i][j].drawable)
                    jsonObject.put("type", 1)
                    jsonObject.put("matrix", matrixString)
                    jsonObject.put("drawablePath", undoList[i][j].drawablePath)
                    jsonObject.put("isFlippedHorizontally", undoList[i][j].isFlippedHorizontally)
                    jsonObject.put("isFlippedVertically", undoList[i][j].isFlippedVertically)
                    jsonObject.put("isHide", undoList[i][j].isHide)
                    jsonObject.put("isLock", undoList[i][j].isLock)
                    jsonObject.put("pagerSelect", undoList[i][j].pagerSelect)
                    jsonObject.put("posSelect", undoList[i][j].posSelect)
                } else if (undoList[i][j] is TextSticker) {
                    //sau update sửa lại put value
                    jsonObject.put("type", 2)
                    jsonObject.put("drawablePath", "no")
                    jsonObject.put("isFlippedHorizontally", "no")
                    jsonObject.put("isFlippedVertically", "no")
                    jsonObject.put("isHide","no")
                    jsonObject.put("isLock", "no")
                    jsonObject.put("pagerSelect", "no")
                    jsonObject.put("posSelect", "no")
                }
                innerJsonArray.put(jsonObject)
            }
            outerJsonArray.put(innerJsonArray)
        }
        currentJson = outerJsonArray.toString()
    }

    fun convertJsonToListOfList(context: Context, json: String) {
        val listUndo: ArrayList<ArrayList<Sticker>> = arrayListOf()
        val jsonArray = JSONArray(json)
        Log.d("jsonlistundo", "-----------------------------------")
        for (i in 0 until jsonArray.length()) {
            val subJsonArray: JSONArray = jsonArray.getJSONArray(i)
            val subList: ArrayList<Sticker> = arrayListOf()
            Log.d("jsonlistundo", "--------")
            for (j in 0 until subJsonArray.length()) {
                val jsonObject: JSONObject = subJsonArray.getJSONObject(j)
                val type: Int = jsonObject.getInt("type")
                if (type == 1) {
                    //DrawableSTicker
                    val drawablePath = jsonObject.getString("drawablePath")
//                    val drawable = base64ToDrawable(jsonObject.getString("drawablePath"))
                    val drawable: Drawable? = convertPhotoAssetToDrawable(context, drawablePath)

                    val matrix: Matrix = stringToMatrix(jsonObject.getString("matrix"))
                    val isFlippedHorizontally: Boolean =
                        jsonObject.getBoolean("isFlippedHorizontally")
                    val isFlippedVertically: Boolean = jsonObject.getBoolean("isFlippedVertically")
                    val isHide: Boolean = jsonObject.getBoolean("isHide")
                    val isLock: Boolean = jsonObject.getBoolean("isLock")
                    val pagerSelect: Int = jsonObject.getInt("pagerSelect")
                    val posSelect: Int = jsonObject.getInt("posSelect")
                    Log.d(
                        "jsonlistundo",
                        "$j. type = $type , matrix = ${matrix.toString()} , posSelect = $posSelect , pagerSelect = $pagerSelect , isLock = $isLock"
                    )

                    val drawableSticker: DrawableSticker = DrawableSticker(drawable, drawablePath)
                    drawableSticker.setMatrix(matrix)
                    drawableSticker.pagerSelect = pagerSelect
                    drawableSticker.posSelect = posSelect
                    drawableSticker.isHide = isHide
                    drawableSticker.isLock = isLock
                    drawableSticker.isFlippedHorizontally = isFlippedHorizontally
                    drawableSticker.isFlippedVertically = isFlippedVertically

                    subList.add(drawableSticker)
                } else {
                    //TextSticker

                }
            }
            listUndo.add(subList)
        }

        undoList.clear()
        undoList.addAll(listUndo)
    }

    fun convertListEmojiToJson(listEmoji: List<Sticker>) {
        val jsonArray: JSONArray = JSONArray()
        for (i in listEmoji.indices) {
            val jsonObject: JSONObject = JSONObject()
            if (listEmoji[i] is DrawableSticker) {
                val matrixString = matrixToString(listEmoji[i].matrix)
//                val drawableTest = drawableToBase64(listEmoji[i].drawable)
                jsonObject.put("type", 1)
                jsonObject.put("matrix", matrixString)
                jsonObject.put("drawablePath", listEmoji[i].drawablePath)
                jsonObject.put("isFlippedHorizontally", listEmoji[i].isFlippedHorizontally)
                jsonObject.put("isFlippedVertically", listEmoji[i].isFlippedVertically)
                jsonObject.put("isHide", listEmoji[i].isHide)
                jsonObject.put("isLock", listEmoji[i].isLock)
                jsonObject.put("pagerSelect", listEmoji[i].pagerSelect)
                jsonObject.put("posSelect", listEmoji[i].posSelect)
            } else if (listEmoji[i] is TextSticker) {
                //sau update sửa lại put value
                jsonObject.put("type", 2)
                jsonObject.put("drawablePath", "no")
                jsonObject.put("isFlippedHorizontally", "no")
                jsonObject.put("isFlippedVertically", "no")
                jsonObject.put("isHide","no")
                jsonObject.put("isLock", "no")
                jsonObject.put("pagerSelect", "no")
                jsonObject.put("posSelect", "no")
            }
            jsonArray.put(jsonObject)
        }
        emojiJson = jsonArray.toString()
    }

}