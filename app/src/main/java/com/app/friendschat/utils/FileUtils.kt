package com.app.friendschat.utils

import android.content.ContentValues
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException


object FileUtils {

    fun removeStickerFromCacheDir(context: Context, nameFile: String) {
        val cw = ContextWrapper(context)
        // path to /data/data/yourapp/cache
        val directory: File = cw.cacheDir
        // Create imageDir
        val file = File(directory, "$nameFile.png")

        if (file.exists()) {
            file.delete()
        }
    }

    fun saveStickerToCacheDir(context: Context, bitmapImage: Bitmap, nameFile: String): String? {
        val cw = ContextWrapper(context)
        // path to /data/data/yourapp/cache
        val directory: File = cw.cacheDir
        // Create imageDir
        val file = File(directory, "$nameFile.png")
//        val file = File(directory, "$nameFile${System.currentTimeMillis()}.png")

        if (file.exists()) {
            return file.absolutePath
        }

        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(file)
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        } finally {
            try {
                fos?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return file.absolutePath
    }

    fun saveImageToCacheDir(context: Context, bitmapImage: Bitmap, fileName: String): String? {
        val cw = ContextWrapper(context)
        // path to /data/data/yourapp/cache
        val directory: File = cw.cacheDir
        // Create imageDir
        val file = File(directory, "$fileName${System.currentTimeMillis()}.png")

        if (file.exists()) {
            return file.absolutePath
        }

        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(file)
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        } finally {
            try {
                fos?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return file.absolutePath
    }

    fun saveBitmapToGallery(context: Context, bitmapImage: Bitmap, fileName: String, folderName: String? = null): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val resolver = context.contentResolver
            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
                if (folderName != null) {
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DCIM + File.separator + folderName)
                } else {
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DCIM)
                }
            }

            val contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            val imageUri = resolver.insert(contentUri, contentValues)

            imageUri?.let {
                try {
                    val outputStream = resolver.openOutputStream(it)
                    outputStream?.let { it1 ->
                        bitmapImage.compress(Bitmap.CompressFormat.PNG, 100,
                            it1
                        )
                    }
                    outputStream?.close()
                    return true
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        } else {
            val galleryDir = if (folderName != null) {
                File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), folderName)
            } else {
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
            }

            galleryDir.mkdirs()

            val imageFile = File(galleryDir, fileName)

            try {
                val outputStream = FileOutputStream(imageFile)
                bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                outputStream.close()
                // Notify media scanner about the new file
                MediaScannerConnection.scanFile(context, arrayOf(imageFile.absolutePath), null, null)
                return true
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return false
    }

    //save json to txt
    fun saveStringToTxtCache(context: Context, data: String, fileName: String): String? {
        val cw = ContextWrapper(context)
        val directory: File = cw.cacheDir
        val file = File(directory, "$fileName.txt")

        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(file)
            fos.write(data.toByteArray()) // Chuyển chuỗi thành mảng byte và ghi vào tệp tin
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        } finally {
            try {
                fos?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return file.absolutePath
    }
    fun readStringTxtFromCache(context: Context, filePath: String): String? {
        val file = File(filePath)

        if (!file.exists()) {
            // Tệp tin không tồn tại
            return null
        }

        var fis: FileInputStream? = null
        try {
            fis = FileInputStream(file)
            val length = fis.available()
            val buffer = ByteArray(length)
            fis.read(buffer)
            return String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        } finally {
            try {
                fis?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun updateStringTxtToCache(context: Context, filePath: String, appendString: String): String? {
        //val currentContent = readStringTxtFromCache(context, filePath)

//        if (currentContent != null) {
//            val newContent = currentContent + appendString

            var fos: FileOutputStream? = null
            try {
                fos = FileOutputStream(filePath, false) // Mở tệp tin để ghi đè nội dung
                fos.write(appendString.toByteArray())
            } catch (e: IOException) {
                e.printStackTrace()
                return null
            } finally {
                try {
                    fos?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            return filePath
//        } else {
//            // Đọc tệp tin không thành công
//            return null
//        }
    }


    //end

    fun getFileNameFromUrl(url: String): String {
        return url.substring(url.lastIndexOf('/') + 1)
    }

    fun getFolderNameFromUrl(url: String): String {
        return url.substringBeforeLast('/').substringAfterLast('/')
    }

    fun getUriFromFilePath(context: Context, filePath: String): Uri {
        val file = File(filePath)
        return FileProvider.getUriForFile(context, context.packageName + ".provider", file)
    }
}