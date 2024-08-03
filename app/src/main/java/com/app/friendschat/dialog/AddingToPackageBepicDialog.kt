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
import com.app.friendschat.bottom_sheet.SaveToPackageBepciBts
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
    private val activityBepicRft: BaseActivity<*, *>,
    private val fromActivityBepicRft: FromActivity,
    private val stickerBepicRft: StickerModel,
    private val actionBepicRft: Action = Action.SAVE_TO_PACKAGE,
    private val positionInDraftBepicRft: Int = -1,
    private val shouldShowDaftPackageBepicRft: Boolean = true,
    private val onDeleteBepicRft: () -> Unit = {},
    private val onAddToPackageSuccessfullyBepicRft: () -> Unit = {},
) : Dialog(activityBepicRft) {

    private var imagePathBepicRft: String? = null
    private var bitmapBepicRft: Bitmap? = null

    private lateinit var ivDownloadBepicRft: ImageView
    private lateinit var ivTrashBepicRft: ImageView
    private lateinit var ivCloseBepicRft: ImageView
    private lateinit var stickerImageBepicRft: ImageView
    private lateinit var progressBarBepicRft: ProgressBar
    private lateinit var ivShareBepicRft: ImageView
    private lateinit var rlAddToPackageBepicRft: RelativeLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.dialog_add_sticker_to_package_bepic_rft)

        initViewBepicRft()

        when (fromActivityBepicRft) {
            FromActivity.HOME, FromActivity.CREATE_EMOJI -> {
                ivTrashBepicRft.visibility = View.GONE
            }

            FromActivity.MY_CREATION -> {
                ivTrashBepicRft.visibility = View.VISIBLE
            }
        }

        loadStickerBepicRft()
        setupOnClickCloseButtonBepicRft()
        setupOnClickShareBepicRft()
        setupOnClickDownloadBepicRft()
        setupOnClickTrashBepicRft()
        setupOnClickAddToPackageBepicRft()
    }


    private fun setupOnClickDownloadBepicRft() {
        ivDownloadBepicRft.tapAndCheckInternet {

            when (fromActivityBepicRft) {
                FromActivity.HOME -> {
                    EventTracking.logEvent(activityBepicRft, EventTracking.EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM_DOWNLOAD)
                }
                FromActivity.CREATE_EMOJI -> {
                    if (actionBepicRft == Action.EDIT_DRAFT) {
                        EventTracking.logEvent(activityBepicRft, EventTracking.EVENT_NAME_EDIT_EMOJI_DOWNLOAD)
                    } else {
                        EventTracking.logEvent(activityBepicRft, EventTracking.EVENT_NAME_CREATE_EMOJI_CREATE_DOWNLOAD)
                    }
                }
                else -> {}
            }

            ivDownloadBepicRft.isClickable = false

            if (bitmapBepicRft == null) {
                Toast.makeText(
                    context,
                    context.getString(R.string.please_wait_for_the_sticker_to_load),
                    Toast.LENGTH_SHORT
                ).show()
                return@tapAndCheckInternet
            }

            val isSuccessful = FileUtils.saveBitmapToGallery(
                context,
                bitmapBepicRft!!,
                FileUtils.getFileNameFromUrl(stickerBepicRft.url)
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
                ivDownloadBepicRft.isClickable = true
            }, 1000)
        }
    }

    private fun setupOnClickAddToPackageBepicRft() {
        rlAddToPackageBepicRft.tapAndCheckInternet {

            when (fromActivityBepicRft) {
                FromActivity.HOME -> {
                    EventTracking.logEvent(activityBepicRft, EventTracking.EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM_ADD)
                }
                FromActivity.CREATE_EMOJI -> {
                    if (actionBepicRft == Action.EDIT_DRAFT) {
                        EventTracking.logEvent(activityBepicRft, EventTracking.EVENT_NAME_EDIT_EMOJI_ADD_CLICK)
                    } else {
                        EventTracking.logEvent(activityBepicRft, EventTracking.EVENT_NAME_CREATE_EMOJI_CREATE_ADD_CLICK)
                    }
                }
                else -> {}
            }

            try {
                val saveToPackageBottomSheet = SaveToPackageBepciBts.newInstance(
                    stickerBepicRft,
                    fromActivityBepicRft,
                    actionBepicRft,
                    positionInDraftBepicRft,
                    shouldShowDaftPackageBepicRft)

                saveToPackageBottomSheet.successfullyListenerBepic = object : SuccessfullyListener {
                    override fun onSaveSuccessfully() {
                        // Xử lý sau khi lưu thành công
                        onAddToPackageSuccessfullyBepicRft()
                        dismiss()
                    }
                }

                saveToPackageBottomSheet.show(
                    activityBepicRft.supportFragmentManager,
                    saveToPackageBottomSheet.tag
                )
            } catch (e: Exception){

            }
        }
    }
    private fun setupOnClickTrashBepicRft() {
        ivTrashBepicRft.tapAndCheckInternet {

            if (fromActivityBepicRft == FromActivity.MY_CREATION && actionBepicRft == Action.EDIT_DRAFT) {
                EventTracking.logEvent(activityBepicRft, EventTracking.EVENT_NAME_EDIT_EMOJI_DELETE)
            }

            val deleteDialog = DeleteBepicDialog(
                activityBepicRft,
                activityBepicRft.getString(R.string.this_file_will_be_deleted_on_your_device)
            ) {
                onDeleteBepicRft.invoke()
                dismiss()
            }
            deleteDialog.show()
        }
    }
    private fun loadStickerBepicRft() {
        Glide.with(context).asBitmap().load(stickerBepicRft.url)
            .listener(object : RequestListener<Bitmap> {
                override fun onResourceReady(
                    resource: Bitmap,
                    model: Any,
                    target: Target<Bitmap>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBarBepicRft.visibility = View.GONE
                    imagePathBepicRft = FileUtils.saveImageToCacheDir(context, resource, FileUtils.getFileNameFromUrl(stickerBepicRft.url))
                    bitmapBepicRft = resource
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
            .into(stickerImageBepicRft)
    }

    private fun initViewBepicRft() {
        stickerImageBepicRft = findViewById(R.id.iv_sticker)
        progressBarBepicRft = findViewById(R.id.progress_bar)
        ivShareBepicRft = findViewById(R.id.iv_share)
        rlAddToPackageBepicRft = findViewById(R.id.rl_add_to_package)
        ivDownloadBepicRft = findViewById(R.id.iv_download)
        ivTrashBepicRft = findViewById(R.id.iv_trash)
        ivCloseBepicRft = findViewById(R.id.iv_close)
    }
    private fun setupOnClickShareBepicRft() {
        ivShareBepicRft.tapAndCheckInternet {

            when (fromActivityBepicRft) {
                FromActivity.HOME -> {
                    EventTracking.logEvent(activityBepicRft, EventTracking.EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM_SHARE)
                }
                FromActivity.CREATE_EMOJI -> {
                    if (actionBepicRft == Action.EDIT_DRAFT) {
                        EventTracking.logEvent(activityBepicRft, EventTracking.EVENT_NAME_EDIT_EMOJI_SHARE)
                    } else {
                        EventTracking.logEvent(activityBepicRft, EventTracking.EVENT_NAME_CREATE_EMOJI_CREATE_SHARE)
                    }
                }
                else -> {}
            }

            // prevent user click too fast
            ivShareBepicRft.isClickable = false
            Handler().postDelayed({
                ivShareBepicRft.isClickable = true
            }, 1000)

            // check permission
            if (!PermissionUtils.isStoragePermissionGranted(activityBepicRft)) {
                PermissionUtils.requestStoragePermission(activityBepicRft)
                return@tapAndCheckInternet
            }

            if (imagePathBepicRft == null) {
                Toast.makeText(
                    context,
                    context.getString(R.string.please_wait_for_the_sticker_to_load),
                    Toast.LENGTH_SHORT
                ).show()
                return@tapAndCheckInternet
            }

            val uri = FileUtils.getUriFromFilePath(activityBepicRft, imagePathBepicRft!!)

            ImportingAndSharingUtils.shareOneImage(activityBepicRft, uri)
        }
    }
    private fun setupOnClickCloseButtonBepicRft() {
        ivCloseBepicRft.tapAndCheckInternet {
            dismiss()
        }
    }


}