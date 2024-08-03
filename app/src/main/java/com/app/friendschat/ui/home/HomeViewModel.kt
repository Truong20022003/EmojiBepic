package com.app.friendschat.ui.home

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.app.friendschat.R
import com.app.friendschat.data.model.StickerPackInfo
import com.app.friendschat.ui.base.BaseViewModel
import com.app.friendschat.utils.FileUtils
import com.app.friendschat.utils.ImportingAndSharingUtils
import com.app.friendschat.utils.PermissionUtils
import com.app.friendschat.utils.widget.findActivity
import com.app.friendschat.whatsapp.IdGenerator


class HomeViewModel : BaseViewModel() {

    private lateinit var stickerPack: StickerPackInfo

    val uriList = mutableListOf<Uri>()
    val bitmapList = mutableListOf<Bitmap>()

    fun loadStickers(context: Context, stickerPack: StickerPackInfo) {

        uriList.clear()
        bitmapList.clear()
        this.stickerPack = stickerPack

        stickerPack.stickers.forEach { sticker ->
            Glide.with(context).asBitmap()
                .load(sticker.url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
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

    fun shareImages(context: Context) {

        // check permission
        if (!PermissionUtils.isStoragePermissionGranted(context)) {
            context.findActivity()?.let {
                PermissionUtils.requestStoragePermission(it)
            }
            return
        }

        if (uriList.size != stickerPack.stickers.size) {
            Toast.makeText(context, context.getString(R.string.please_wait_until_all_stickers_are_loaded), Toast.LENGTH_SHORT).show()
            return
        }

        ImportingAndSharingUtils.shareMultipleImages(context, uriList)
    }

    fun downloadImages(context: Context, onDownloadSuccessfully: () -> Unit = {}) {
        if (bitmapList.size != stickerPack.stickers.size) {
            Toast.makeText(context, context.getString(R.string.please_wait_until_all_stickers_are_loaded), Toast.LENGTH_SHORT).show()
            return
        }

        val folderName = FileUtils.getFolderNameFromUrl(stickerPack.stickers[0].url)

        val size = bitmapList.size
        for (i in 0 until size) {
            val isSuccessful = FileUtils.saveBitmapToGallery(context, bitmapList[i], FileUtils.getFileNameFromUrl(stickerPack.stickers[i].url), folderName)
            if (!isSuccessful) {
                if (i == 0) {
                    Toast.makeText(context, context.getString(R.string.download_failed), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, context.getString(R.string.some_stickers_are_not_downloaded), Toast.LENGTH_SHORT).show()
                }
                return
            }
        }

        onDownloadSuccessfully.invoke()
        Toast.makeText(context, context.getString(R.string.downloaded_successfully_to_gallery), Toast.LENGTH_SHORT).show()
    }

    fun addToTelegram(context: Context) {

        if (uriList.size != stickerPack.stickers.size) {
            Toast.makeText(context, context.getString(R.string.please_wait_until_all_stickers_are_loaded), Toast.LENGTH_SHORT).show()
            return
        }

        ImportingAndSharingUtils.importToTelegram(context, uriList)
    }

    fun addToWhatsapp(homeFragment: HomeBepicFragment, stickerPackInfo: StickerPackInfo) {

        if (uriList.size != stickerPack.stickers.size) {
            Toast.makeText(homeFragment.requireActivity(), homeFragment.requireActivity().getString(R.string.please_wait_until_all_stickers_are_loaded), Toast.LENGTH_SHORT).show()
            return
        }

        if (uriList.size < 3) {
            homeFragment.showErrorDialogBepic()
            return
        }

        // generate identifier for sticker pack based on sticker pack name and a random string
        val packId = IdGenerator.generateIdFromUrl(homeFragment.requireActivity(), stickerPack.stickers[0].url)

        val stickerPack = com.app.friendschat.whatsapp.StickerPack(
            packId,
            stickerPackInfo.title,
            uriList,
            homeFragment.requireActivity()
        )

        // must add sticker pack to sticker book before adding to whatsapp
        com.app.friendschat.whatsapp.StickerBook.addPackIfNotAlreadyAdded(stickerPack)

        homeFragment.addToWhatsappBepic(stickerPack)
    }
}