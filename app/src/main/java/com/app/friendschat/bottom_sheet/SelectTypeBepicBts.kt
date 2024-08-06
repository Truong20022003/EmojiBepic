package com.app.friendschat.bottom_sheet

import android.annotation.SuppressLint
import android.app.Dialog
import android.view.View
import android.widget.LinearLayout
import com.app.friendschat.R
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SelectTypeBepicBts(
    private val onClickEmoji : () -> Unit,
    private val onClickSticker: () -> Unit
) : BottomSheetDialogFragment(){

    private lateinit var llEmojiBepic: LinearLayout
    private lateinit var llStickerBepic: LinearLayout
    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val contentView = View.inflate(context, R.layout.layout_select_your_type_bottom_sheet_rft, null)

        dialog.setContentView(contentView)
        (contentView.parent as View).setBackgroundColor(resources.getColor(android.R.color.transparent))

        llEmojiBepic = dialog.findViewById(R.id.ll_emoji)
        llStickerBepic = dialog.findViewById(R.id.ll_sticker)

        llEmojiBepic.tapAndCheckInternet {
            onClickEmoji.invoke()
        }

        llStickerBepic.tapAndCheckInternet {
            onClickSticker.invoke()
        }
    }
}