package com.app.friendschat.ui.sticker_pack_detail

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.app.friendschat.R
import com.app.friendschat.data.model.FromActivity
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.database.PackageDao
import com.app.friendschat.ui.base.BaseViewModel
import com.app.friendschat.utils.FileUtils
import com.app.friendschat.utils.ImportingAndSharingUtils
import com.app.friendschat.utils.PermissionUtils
import com.app.friendschat.utils.widget.findActivity
import com.app.friendschat.whatsapp.IdGenerator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class StickerPackDetailViewModel : BaseViewModel() {

    private var packageDao: PackageDao? = null

    private lateinit var fromActivity: FromActivity
    private lateinit var packageName: String
    private lateinit var adapter: StickerAdapter

    private var _stickers = MutableLiveData<MutableList<StickerModel>>().apply { value = mutableListOf() }

    val stickers: LiveData<MutableList<StickerModel>> = _stickers

    val uriList = mutableListOf<Uri>()
    val bitmapList = mutableListOf<Bitmap>()

    fun setPackageDao(packageDao: PackageDao?) {
        this.packageDao = packageDao
    }

    fun loadStickers(context: Context) {

        bitmapList.clear()
        uriList.clear()

        _stickers.value?.forEach { sticker ->
            Glide.with(context).asBitmap()
                .load(sticker.url)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {

                        // scale to 512x512
                        val scaledBitmap = Bitmap.createScaledBitmap(resource, 512, 512, false)

                        bitmapList.add(scaledBitmap)
                        val imagePath = FileUtils.saveImageToCacheDir(context, scaledBitmap, FileUtils.getFileNameFromUrl(sticker.url))
                        if (imagePath != null) {
                            uriList.add(FileUtils.getUriFromFilePath(context, imagePath))
                        }
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {

                    }
                })
        }
    }

    fun refreshStickersIfNeeded(context: Context) {
        CoroutineScope(Dispatchers.Main).launch {
            val stickers = withContext(Dispatchers.IO) {
                packageDao?.getPackageByName(packageName)?.stickers
            }?.toMutableList()

            stickers?.let {
                if (it.size != _stickers.value?.size) {
                    _stickers.value?.clear()
                    _stickers.value?.addAll(it)
                    loadStickers(context)

                    // notify adapter
                    _stickers.value = _stickers.value
                }
            }
        }
    }

    fun setFromActivity(fromActivity: FromActivity) {
        this.fromActivity = fromActivity
    }

    fun getFromActivity(): FromActivity {
        return fromActivity
    }

    fun setPackageName(packageName: String) {
        this.packageName = packageName
    }

    fun setAdapter(adapter: StickerAdapter) {
        this.adapter = adapter
    }

    fun setStickers(stickers: MutableList<StickerModel>) {
        this._stickers.value = stickers
    }

    fun shareImages(context: Context) {

        // check permission
        if (!PermissionUtils.isStoragePermissionGranted(context)) {
            context.findActivity()?.let {
                PermissionUtils.requestStoragePermission(it)
            }
            return
        }

        if (uriList.size != stickers.value?.size) {
            Toast.makeText(context, context.getString(R.string.please_wait_until_all_stickers_are_loaded), Toast.LENGTH_SHORT).show()
            return
        }

        ImportingAndSharingUtils.shareMultipleImages(context, uriList)
    }

    fun downloadImages(context: Context) {
        if (bitmapList.size != stickers.value?.size) {
            Toast.makeText(context, context.getString(R.string.please_wait_until_all_stickers_are_loaded), Toast.LENGTH_SHORT).show()
            return
        }

        val folderName = FileUtils.getFolderNameFromUrl(stickers.value?.get(0)?.url ?: "Default")

        val size = bitmapList.size
        for (i in 0 until size) {
            val isSuccessful = FileUtils.saveBitmapToGallery(context, bitmapList[i], FileUtils.getFileNameFromUrl(stickers.value?.get(i)?.url ?: "default-name"), folderName)
            if (!isSuccessful) {
                if (i == 0) {
                    Toast.makeText(context, context.getString(R.string.download_failed), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, context.getString(R.string.some_stickers_are_not_downloaded), Toast.LENGTH_SHORT).show()
                }
                return
            }
        }

        Toast.makeText(context, context.getString(R.string.downloaded_successfully_to_gallery), Toast.LENGTH_SHORT).show()
    }

    fun addToTelegram(context: Context) {

        if (uriList.size != stickers.value?.size) {
            Toast.makeText(context, context.getString(R.string.please_wait_until_all_stickers_are_loaded), Toast.LENGTH_SHORT).show()
            return
        }

        ImportingAndSharingUtils.importToTelegram(context, uriList)
    }

    fun deleteImageFromPackage(context: Context, stickerPosition: Int, onDeleteSuccessfully: () -> Unit) {

        if (stickerPosition >= stickers.value!!.size) {
            Toast.makeText(context, context.getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            val packageModel = withContext(Dispatchers.IO) {
                packageDao?.getPackageByName(packageName)
            }

            if (packageModel == null) {
                Toast.makeText(context, context.getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
                return@launch
            }

            stickers.value!!.removeAt(stickerPosition)

            val newPackageModel = packageModel.copy(stickers = stickers.value!!)

            withContext(Dispatchers.IO) {
                packageDao?.updatePackage(newPackageModel)
            }

            onDeleteSuccessfully.invoke()

            // notify adapter
            _stickers.value = stickers.value

            loadStickers(context)
        }
    }

    fun addToWhatsapp(activity: StickerPackDetailBepicActivity) {

        if (uriList.size != stickers.value?.size) {
            Toast.makeText(activity, activity.getString(R.string.please_wait_until_all_stickers_are_loaded), Toast.LENGTH_SHORT).show()
            return
        }

        if (uriList.size < 3) {
            activity.showErrorDialogBepic()
            return
        }

        when (fromActivity) {
            FromActivity.HOME, FromActivity.CREATE_EMOJI -> {
                // suggested sticker pack
                val packId = IdGenerator.generateIdFromUrl(activity, stickers.value!![0].url)
                val stickerPack = com.app.friendschat.whatsapp.StickerPack(
                    packId,
                    packageName,
                    uriList,
                    activity
                )
                // must add sticker pack to sticker book before adding to whatsapp
                com.app.friendschat.whatsapp.StickerBook.addPackIfNotAlreadyAdded(stickerPack)
                activity.addToWhatsappBepic(stickerPack)
            }

            FromActivity.MY_CREATION -> {
                // my creation sticker pack
                CoroutineScope(Dispatchers.Main).launch {
                    val packageModel = withContext(Dispatchers.IO) {
                        packageDao?.getPackageByName(packageName)
                    }
                    packageModel?.let {
                        val packId = IdGenerator.generatorIdFromPackageModel(activity, it)
                        val stickerPack =
                            com.app.friendschat.whatsapp.StickerPack(
                                packId,
                                it.packageName,
                                uriList,
                                activity
                            )
                        // must add sticker pack to sticker book before adding to whatsapp
                        com.app.friendschat.whatsapp.StickerBook.addPackIfNotAlreadyAdded(stickerPack)
                        activity.addToWhatsappBepic(stickerPack)
                    }
                }
            }
        }
    }
}