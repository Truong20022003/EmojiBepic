package com.app.friendschat.utils.widget

import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Base64
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.friendschat.data.model.IconModel
import com.app.friendschat.utils.printLog
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class ListLiveData<T> : MutableLiveData<MutableList<T>>()

fun <T> LiveData<T>.hasValue(): Boolean {
    return value?.let {
        true
    } ?: kotlin.run {
        false
    }
}


fun <T> Flow<T>.trackingProgress(progressBar: PublishSubject<Boolean>): Flow<T> {
    return this.onStart {
        printLog("onStart")
        progressBar.onNext(true)
    }.onCompletion {
        printLog("onCompletion")
        progressBar.onNext(false)
    }
}

fun <T> CoroutineScope.executeAsync(
    onPreExecute: suspend () -> Unit,
    doInBackground: suspend () -> T,
    onPostExecute: (T) -> Unit
) = launch {
    onPreExecute()
    val result = withContext(Dispatchers.IO) {
        doInBackground()
    }
    onPostExecute(result)
}

fun getListIconFromAssetFolder(context: Context, folderName: String): MutableList<IconModel> {
    val imagePaths: MutableList<IconModel> = ArrayList()
    val assetManager: AssetManager = context.getAssets()
    try {
        // Danh sách tất cả tệp trong thư mục
        val files = assetManager.list(folderName)

        // Lọc ra các tệp ảnh (có thể cần chỉnh sửa phần kiểm tra phần mở rộng tệp)
        if (files != null) {
            for (i in files.indices) {
                if (files[i].endsWith(".png") || files[i].endsWith(".jpg") || files[i].endsWith(".jpeg")) {
                    //                imagePaths.add("$folderName/$file")
                    imagePaths.add(
                        IconModel(
                            i,
                            "file:///android_asset/$folderName/${files[i]}",
                            false,
                            true,
                            i
                        )
                    )
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return imagePaths
}

suspend fun addDataIconToDataBase(
    context: Context,
    folderName: String,
    action: (pos: Int, folderName: String, nameIcon: String) -> Unit
) {
    val assetManager: AssetManager = context.assets
    try {
        // Danh sách tất cả tệp trong thư mục
        val files = assetManager.list(folderName)

        // Lọc ra các tệp ảnh (có thể cần chỉnh sửa phần kiểm tra phần mở rộng tệp)
        if (files != null) {
            for (i in files.indices) {
                if (files[i].endsWith(".png") || files[i].endsWith(".jpg") || files[i].endsWith(".jpeg")) {
                    //                imagePaths.add("$folderName/$file")
                    withContext(Dispatchers.Default) {
                        action.invoke(i, folderName, files[i])
                    }
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

fun convertPhotoAssetToDrawable(context: Context, path: String): Drawable? {
    var drawable: Drawable? = null
    try {
        // Remove the "file:///android_asset/" prefix
        val assetPath: String = path.replace("file:///android_asset/", "")

        // Open an InputStream to the asset file
        val stream: InputStream = context.assets.open(assetPath)

        // Convert the InputStream to a Drawable
        val bitmap = BitmapFactory.decodeStream(stream)
        drawable = BitmapDrawable(context.resources, bitmap)
    } catch (e: IOException) {
        e.printStackTrace()
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return drawable
}

fun drawableToBase64(drawable: Drawable): String? {
    if (drawable is BitmapDrawable) {
        val outputStream = ByteArrayOutputStream()
        drawable.bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        val bitmapData = outputStream.toByteArray()
        return Base64.encodeToString(bitmapData, Base64.DEFAULT)
    }
    return null
}

fun base64ToDrawable(base64String: String): Drawable? {
    if (!base64String.isNullOrEmpty()) {
        try {
            // Giải mã chuỗi Base64 thành mảng byte
            val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)

            // Tạo đối tượng Bitmap từ mảng byte
            val bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)

            // Tạo Drawable từ Bitmap
            return BitmapDrawable(Resources.getSystem(), bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    return null
}

//
fun drawableToHex(drawable: Drawable?): String? {
    if (drawable == null || drawable !is BitmapDrawable) {
        return null
    }

    val bitmap = drawable.bitmap
    val byteArray = bitmap.toByteArray()
    return byteArray.joinToString("") { String.format("%02X", it) }
}

fun Bitmap.toByteArray(): ByteArray {
    val stream = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.PNG, 100, stream)
    return stream.toByteArray()
}

fun hexToDrawable(context: Context, hexString: String?): Drawable? {
    if (hexString == null) return null

    // Chuyển chuỗi hex thành mảng byte
    val byteArray = hexToBytes(hexString)

    // Chuyển mảng byte thành Bitmap
    val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)

    // Tạo Drawable từ Bitmap
    return BitmapDrawable(context.resources, bitmap)
}

private fun hexToBytes(hexString: String): ByteArray {
    val len = hexString.length
    val data = ByteArray(len / 2)
    var i = 0
    while (i < len) {
        data[i / 2] = ((Character.digit(hexString[i], 16) shl 4)
                + Character.digit(hexString[i + 1], 16)).toByte()
        i += 2
    }
    return data
}
//

fun getCurrentTimeAsString(): String {
    val dateFormat = SimpleDateFormat("dd_MM_yyyy_HH_mm_ss", Locale.getDefault())
    val currentTime = System.currentTimeMillis()
    val currentDate = Date(currentTime)
    return dateFormat.format(currentDate)
}

fun getNameUndoListCurrentTimeAsString(): String {
    val dateFormat = SimpleDateFormat("dd_MM_yyyy_HH_mm_ss", Locale.getDefault())
    val currentTime = System.currentTimeMillis()
    val currentDate = Date(currentTime)
    return "json_undo_list_${dateFormat.format(currentDate)}"
}

fun getNameEmojiCurrentTimeAsString(): String {
    val dateFormat = SimpleDateFormat("dd_MM_yyyy_HH_mm_ss", Locale.getDefault())
    val currentTime = System.currentTimeMillis()
    val currentDate = Date(currentTime)
    return "json_emoji_${dateFormat.format(currentDate)}"
}

fun matrixToString(matrix: Matrix): String? {
    val matrixValues = FloatArray(9)
    matrix.getValues(matrixValues)

    // Chuyển đổi mảng giá trị ma trận thành chuỗi
    val stringBuilder = StringBuilder()
    for (i in 0..8) {
        stringBuilder.append(matrixValues[i])
        if (i < 8) {
            stringBuilder.append(",") // Thêm dấu phẩy giữa các giá trị
        }
    }
    return stringBuilder.toString()
}

fun stringToMatrix(matrixString: String): Matrix {
    val matrix = Matrix()
    val values = matrixString.split(",".toRegex()).dropLastWhile { it.isEmpty() }
        .toTypedArray()

    // Chuyển đổi chuỗi thành mảng float
    val matrixValues = FloatArray(9)
    for (i in 0..8) {
        matrixValues[i] = values[i].toFloat()
    }

    // Đặt giá trị cho Matrix
    matrix.setValues(matrixValues)
    return matrix
}

fun scalePhotoBitmap(bitmapSticker: Bitmap): Bitmap {
    val originalWidth = bitmapSticker.width
    val originalHeight = bitmapSticker.height

    val targetWidth = 512
    val targetHeight = 512

    val scaleFactorWidth = targetWidth.toFloat() / originalWidth
    val scaleFactorHeight = targetHeight.toFloat() / originalHeight

    // Chọn tỷ lệ co giãn thấp nhất để giữ cho ảnh không bị méo
    val scaleFactor = minOf(scaleFactorWidth, scaleFactorHeight)

    return Bitmap.createScaledBitmap(
        bitmapSticker,
        (originalWidth * scaleFactor).toInt(),
        (originalHeight * scaleFactor).toInt(),
        true
    )
}
