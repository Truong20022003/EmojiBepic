package com.app.friendschat.bottom_sheet

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.View
import android.widget.LinearLayout
import com.app.friendschat.R
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SharingAndAddingStickerPackBepicBottomSheet(
    private val onClickAddToWhatsApp : () -> Unit,
    private val onClickAddToTelegram: () -> Unit,
    private val onClickShare: () -> Unit,
    private val onClickDownload: () -> Unit
) : BottomSheetDialogFragment(){

    private lateinit var llShareBepic: LinearLayout
    private lateinit var llDownloadBepic: LinearLayout
    private lateinit var llAddingToWhatsappBepic: LinearLayout
    private lateinit var llAddingToTelegramBepic: LinearLayout

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val contentView = View.inflate(context, R.layout.layout_sharing_and_adding_sicker_pack_bottom_sheet, null)

        dialog.setContentView(contentView)
        (contentView.parent as View).setBackgroundColor(resources.getColor(android.R.color.transparent))

        llAddingToWhatsappBepic = dialog.findViewById(R.id.ll_adding_to_whatsapp)
        llAddingToTelegramBepic = dialog.findViewById(R.id.ll_adding_to_telegram)
        llShareBepic = dialog.findViewById(R.id.ll_share)
        llDownloadBepic = dialog.findViewById(R.id.ll_download)

        llAddingToWhatsappBepic.tapAndCheckInternet {
            onClickAddToWhatsApp.invoke()
            EventTracking.logEvent(this.requireActivity(), EventTracking.EVENT_NAME_ADD_WHATSAPP_CLICK)
        }

        llAddingToTelegramBepic.tapAndCheckInternet {
            onClickAddToTelegram.invoke()
            EventTracking.logEvent(this.requireActivity(), EventTracking.EVENT_NAME_ADD_TELEGRAM_VIEW)
        }

        llShareBepic.tapAndCheckInternet {
            onClickShare.invoke()
            EventTracking.logEvent(this.requireActivity(), EventTracking.EVENT_NAME_SHARE_CLICK)
        }

        llDownloadBepic.tapAndCheckInternet {
            onClickDownload.invoke()
            EventTracking.logEvent(this.requireActivity(), EventTracking.EVENT_NAME_DOWNLOAD_CLICK)
        }
    }
}