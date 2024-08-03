package com.app.friendschat.dialog

import android.app.Dialog
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.app.friendschat.R
import com.app.friendschat.bottom_sheet.SaveToPackageBepciBottomSheet
import com.app.friendschat.data.model.Action
import com.app.friendschat.data.model.FromActivity
import com.app.friendschat.data.model.StickerModel
import com.app.friendschat.listener.SuccessfullyListener
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.FileUtils
import com.app.friendschat.utils.ImportingAndSharingUtils
import com.app.friendschat.utils.PermissionUtils
import com.app.friendschat.utils.widget.tapAndCheckInternet

class AddingToPackageBepicDialog(
    private val activityBepic: BaseActivity<*, *>,
    private val fromActivityBepic: FromActivity,
    private val stickerBepic: StickerModel,
    private val actionBepic: Action = Action.SAVE_TO_PACKAGE,
    private val positionInDraftBepic: Int = -1,
    private val shouldShowDaftPackageBepic: Boolean = true,
    private val onDeleteBepic: () -> Unit = {},
    private val onAddToPackageSuccessfullyBepic: () -> Unit = {},
) : Dialog(activityBepic) {

    private var imagePathBepic: String? = null
    private var bitmapBepic: Bitmap? = null

    private lateinit var ivDownloadBepic: ImageView
    private lateinit var ivTrashBepic: ImageView
    private lateinit var ivCloseBepic: ImageView
    private lateinit var stickerImageBepic: ImageView
    private lateinit var progressBarBepic: ProgressBar
    private lateinit var ivShareBepic: ImageView
    private lateinit var rlAddToPackageBepic: RelativeLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.dialog_add_sticker_to_package_bepic)

        initViewBepic()

        when (fromActivityBepic) {
            FromActivity.HOME, FromActivity.CREATE_EMOJI -> {
                ivTrashBepic.visibility = View.GONE
            }

            FromActivity.MY_CREATION -> {
                ivTrashBepic.visibility = View.VISIBLE
            }
        }

        loadStickerBepic()
        setupOnClickCloseButtonBepic()
        setupOnClickShareBepic()
        setupOnClickDownloadBepic()
        setupOnClickTrashBepic()
        setupOnClickAddToPackageBepic()
    }

    private fun initViewBepic() {
        stickerImageBepic = findViewById(R.id.iv_sticker)
        progressBarBepic = findViewById(R.id.progress_bar)
        ivShareBepic = findViewById(R.id.iv_share)
        rlAddToPackageBepic = findViewById(R.id.rl_add_to_package)
        ivDownloadBepic = findViewById(R.id.iv_download)
        ivTrashBepic = findViewById(R.id.iv_trash)
        ivCloseBepic = findViewById(R.id.iv_close)
    }

    private fun loadStickerBepic() {
        Glide.with(context).asBitmap().load(stickerBepic.url)
            .listener(object : RequestListener<Bitmap> {
                override fun onResourceReady(
                    resource: Bitmap,
                    model: Any,
                    target: Target<Bitmap>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBarBepic.visibility = View.GONE
                    imagePathBepic = FileUtils.saveImageToCacheDir(context, resource, FileUtils.getFileNameFromUrl(stickerBepic.url))
                    bitmapBepic = resource
                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("CHECK_BUG", e.toString())
                    Toast.makeText(context, "Load sticker failed", Toast.LENGTH_SHORT).show()
                    return false
                }
            })
            .into(stickerImageBepic)
    }

    private fun setupOnClickTrashBepic() {
        ivTrashBepic.tapAndCheckInternet {

            if (fromActivityBepic == FromActivity.MY_CREATION && actionBepic == Action.EDIT_DRAFT) {
                EventTracking.logEvent(activityBepic, EventTracking.EVENT_NAME_EDIT_EMOJI_DELETE)
            }

            val deleteDialog = DeleteBepicDialog(
                activityBepic,
                activityBepic.getString(R.string.this_file_will_be_deleted_on_your_device)
            ) {
                onDeleteBepic.invoke()
                dismiss()
            }
            deleteDialog.show()
        }
    }

    private fun setupOnClickAddToPackageBepic() {
        rlAddToPackageBepic.tapAndCheckInternet {

            when (fromActivityBepic) {
                FromActivity.HOME -> {
                    EventTracking.logEvent(activityBepic, EventTracking.EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM_ADD)
                }
                FromActivity.CREATE_EMOJI -> {
                    if (actionBepic == Action.EDIT_DRAFT) {
                        EventTracking.logEvent(activityBepic, EventTracking.EVENT_NAME_EDIT_EMOJI_ADD_CLICK)
                    } else {
                        EventTracking.logEvent(activityBepic, EventTracking.EVENT_NAME_CREATE_EMOJI_CREATE_ADD_CLICK)
                    }
                }
                else -> {}
            }

            try {
                val saveToPackageBottomSheet = SaveToPackageBepciBottomSheet.newInstance(
                    stickerBepic,
                    fromActivityBepic,
                    actionBepic,
                    positionInDraftBepic,
                    shouldShowDaftPackageBepic)

                saveToPackageBottomSheet.successfullyListenerBepic = object : SuccessfullyListener {
                    override fun onSaveSuccessfully() {
                        // Xử lý sau khi lưu thành công
                        onAddToPackageSuccessfullyBepic()
                        dismiss()
                    }
                }

                saveToPackageBottomSheet.show(
                    activityBepic.supportFragmentManager,
                    saveToPackageBottomSheet.tag
                )
            } catch (e: Exception){

            }
        }
    }

    private fun setupOnClickCloseButtonBepic() {
        ivCloseBepic.tapAndCheckInternet {
            dismiss()
        }
    }

    private fun setupOnClickShareBepic() {
        ivShareBepic.tapAndCheckInternet {

            when (fromActivityBepic) {
                FromActivity.HOME -> {
                    EventTracking.logEvent(activityBepic, EventTracking.EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM_SHARE)
                }
                FromActivity.CREATE_EMOJI -> {
                    if (actionBepic == Action.EDIT_DRAFT) {
                        EventTracking.logEvent(activityBepic, EventTracking.EVENT_NAME_EDIT_EMOJI_SHARE)
                    } else {
                        EventTracking.logEvent(activityBepic, EventTracking.EVENT_NAME_CREATE_EMOJI_CREATE_SHARE)
                    }
                }
                else -> {}
            }

            // prevent user click too fast
            ivShareBepic.isClickable = false
            Handler().postDelayed({
                ivShareBepic.isClickable = true
            }, 1000)

            // check permission
            if (!PermissionUtils.isStoragePermissionGranted(activityBepic)) {
                PermissionUtils.requestStoragePermission(activityBepic)
                return@tapAndCheckInternet
            }

            if (imagePathBepic == null) {
                Toast.makeText(
                    context,
                    context.getString(R.string.please_wait_for_the_sticker_to_load),
                    Toast.LENGTH_SHORT
                ).show()
                return@tapAndCheckInternet
            }

            val uri = FileUtils.getUriFromFilePath(activityBepic, imagePathBepic!!)

            ImportingAndSharingUtils.shareOneImage(activityBepic, uri)
        }
    }

    private fun setupOnClickDownloadBepic() {
        ivDownloadBepic.tapAndCheckInternet {

            when (fromActivityBepic) {
                FromActivity.HOME -> {
                    EventTracking.logEvent(activityBepic, EventTracking.EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM_DOWNLOAD)
                }
                FromActivity.CREATE_EMOJI -> {
                    if (actionBepic == Action.EDIT_DRAFT) {
                        EventTracking.logEvent(activityBepic, EventTracking.EVENT_NAME_EDIT_EMOJI_DOWNLOAD)
                    } else {
                        EventTracking.logEvent(activityBepic, EventTracking.EVENT_NAME_CREATE_EMOJI_CREATE_DOWNLOAD)
                    }
                }
                else -> {}
            }

            ivDownloadBepic.isClickable = false

            if (bitmapBepic == null) {
                Toast.makeText(
                    context,
                    context.getString(R.string.please_wait_for_the_sticker_to_load),
                    Toast.LENGTH_SHORT
                ).show()
                return@tapAndCheckInternet
            }

            val isSuccessful = FileUtils.saveBitmapToGallery(
                context,
                bitmapBepic!!,
                FileUtils.getFileNameFromUrl(stickerBepic.url)
            )

            if (isSuccessful) {
                Toast.makeText(
                    context,
                    context.getString(R.string.downloaded_successfully_to_gallery),
                    Toast.LENGTH_SHORT
                ).show()
                dismiss()
            } else {
                Toast.makeText(
                    context,
                    context.getString(R.string.download_failed),
                    Toast.LENGTH_SHORT
                ).show()
            }

            Handler().postDelayed({
                ivDownloadBepic.isClickable = true
            }, 1000)
        }
    }
}