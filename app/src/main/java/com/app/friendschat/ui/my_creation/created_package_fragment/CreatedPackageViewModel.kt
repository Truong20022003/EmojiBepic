package com.app.friendschat.ui.my_creation.created_package_fragment

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.app.friendschat.R
import com.app.friendschat.data.model.FromActivity
import com.app.friendschat.data.model.PackageModel
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.database.AppDatabase
import com.app.friendschat.database.PackageDao
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.base.BaseViewModel
import com.app.friendschat.ui.sticker_pack_detail.StickerPackDetailBepicActivity
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.FileUtils
import com.app.friendschat.utils.ImportingAndSharingUtils
import com.app.friendschat.utils.PermissionUtils
import com.app.friendschat.utils.custom_view.GridSpacingItemDecoration
import com.app.friendschat.utils.widget.findActivity
import com.app.friendschat.whatsapp.IdGenerator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreatedPackageViewModel: BaseViewModel() {

    private var packageDao: PackageDao? = null

    private lateinit var packages: MutableList<PackageModel>
    private lateinit var adapter: CreatedPackageAdapter

    val uriList = mutableListOf<Uri>()
    val bitmapList = mutableListOf<Bitmap>()

    fun loadPackagesFromDatabase(fragment: CreatedPackageBepicFragment) {
        packageDao = AppDatabase.getInstance(fragment.requireActivity())?.packageNameDao()

        CoroutineScope(Dispatchers.Main).launch {
            packages = withContext(Dispatchers.IO) {
                packageDao?.getAllPackagesWithoutDraft()?.toMutableList() ?: mutableListOf()
            }

            val spanCount = 2
            val spacing = fragment.resources.getDimension(R.dimen._13sdp).toInt()

            fragment.binding.rvCreatedPackage.layoutManager = GridLayoutManager(fragment.requireActivity(), spanCount)
            fragment.binding.rvCreatedPackage.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing))

            adapter = CreatedPackageAdapter(packages, fragment)

            fragment.binding.rvCreatedPackage.adapter = adapter
        }
    }

    fun refreshAdapterWithNewList() {
        packages.clear()
        CoroutineScope(Dispatchers.Main).launch {
            packages.addAll(withContext(Dispatchers.IO) {
                packageDao?.getAllPackagesWithoutDraft()?.toMutableList() ?: mutableListOf()

            })
            GlobalScope.launch(Dispatchers.Main){
                adapter.notifyDataSetChanged()
            }
        }
    }

    fun loadStickers(context: Context, stickers: List<StickerModel>) {

        uriList.clear()
        bitmapList.clear()

        stickers.forEach { sticker ->
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

    fun addToTelegram(context: Context, stickerPack: PackageModel) {

        if (uriList.size != stickerPack.stickers.size) {
            Toast.makeText(context, context.getString(R.string.please_wait_until_all_stickers_are_loaded), Toast.LENGTH_SHORT).show()
            return
        }

        ImportingAndSharingUtils.importToTelegram(context, uriList)
    }

    fun shareImages(context: Context, stickerPack: PackageModel) {

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

    fun downloadImages(context: Context, stickerPack: PackageModel, onDownloaded: () -> Unit = {}) {
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

        onDownloaded.invoke()
        Toast.makeText(context, context.getString(R.string.downloaded_successfully_to_gallery), Toast.LENGTH_SHORT).show()
    }

    fun navigateToStickerPackDetail(fragment: BaseFragment<*, *>, packageName: String) {
        val bundle = Bundle()
        bundle.putString(Constants.BUNDLE_SUGGESTION_STICKER_TITLE, packageName)
        bundle.putSerializable(Constants.BUNDLE_FROM_ACTIVITY, FromActivity.MY_CREATION)
        fragment.showActivityWithResultCode(StickerPackDetailBepicActivity::class.java, Constants.REQUEST_CODE_DELETE_STICKER, bundle)
    }

    fun addToWhatsapp(createdPackageFragment: CreatedPackageBepicFragment, stickerPack: PackageModel) {

        if (uriList.size != stickerPack.stickers.size) {
            Toast.makeText(createdPackageFragment.requireActivity(), createdPackageFragment.requireActivity().getString(R.string.please_wait_until_all_stickers_are_loaded), Toast.LENGTH_SHORT).show()
            return
        }

        if (uriList.size < 3) {
            createdPackageFragment.showErrorDialogBepic()
            return
        }

        val packId = IdGenerator.generatorIdFromPackageModel(createdPackageFragment.requireActivity(), stickerPack)
        val stickerPack = com.app.friendschat.whatsapp.StickerPack(
            packId,
            stickerPack.packageName,
            uriList,
            createdPackageFragment.requireActivity()
        )
        // must add sticker pack to sticker book before adding to whatsapp
        com.app.friendschat.whatsapp.StickerBook.addPackIfNotAlreadyAdded(stickerPack)
        createdPackageFragment.addToWhatsappBepic(stickerPack)
    }
}