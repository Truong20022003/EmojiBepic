package com.app.friendschat.bottom_sheet

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.app.friendschat.R
import com.app.friendschat.ui.emoji.LayerEmojiAdapter
import com.app.friendschat.ui.emoji.MyItemTouchHelperCallback
import com.app.friendschat.utils.custom_sticker.Sticker
import com.app.friendschat.utils.custom_sticker.StickerView
import com.app.friendschat.utils.widget.tapAndCheckInternet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LayerEmojiBepicBottomSheet(
    private val context: Context,
    private val stickerView: StickerView,
    private val listLayer: ArrayList<Sticker>,
    private val onClose: (ArrayList<Sticker>) -> Unit,
    private val onUndoLayer: () -> Unit
) : BottomSheetDialogFragment() {

    private lateinit var layerEmojiAdapterBepic: LayerEmojiAdapter
    private var itemTouchHelperBepic: ItemTouchHelper? = null
    private var stickerSelectBepic: Sticker? = null
    private var posSelectBepic: Int = 0

    private lateinit var rvLayerBepic: RecyclerView
    private lateinit var ivUndoBepic: ImageView
    private lateinit var ivDeleteBepic: ImageView

    @SuppressLint("RestrictedApi")

    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)

        val contentView = View.inflate(context, R.layout.layout_layer_emoji_bottom_sheet, null)

        dialog.setContentView(contentView)
        (contentView.parent as View).setBackgroundColor(resources.getColor(android.R.color.transparent))

        initBepic(dialog)

        Log.d("listStickerBottomSheet", "setupDialog: $listLayer")
        layerEmojiAdapterBepic = LayerEmojiAdapter(
            context,
            stickerView,
            listLayer,
            onClickLayer = { model, pos ->
                stickerView.selectStickerCurrent(model)
                ivDeleteBepic.visibility = View.VISIBLE
                stickerSelectBepic = model
                posSelectBepic = pos
            }
        )

        rvLayerBepic.adapter = layerEmojiAdapterBepic

        //swap
        itemTouchHelperBepic = ItemTouchHelper(MyItemTouchHelperCallback(layerEmojiAdapterBepic))
        itemTouchHelperBepic?.attachToRecyclerView(rvLayerBepic)

        ivDeleteBepic.tapAndCheckInternet {
            if (stickerSelectBepic != null) {
                stickerView.remove(stickerSelectBepic)
                layerEmojiAdapterBepic.notifyItemRemoved(posSelectBepic)
                ivDeleteBepic.visibility = View.GONE
            }
        }

        ivUndoBepic.tapAndCheckInternet {
            onUndoLayer.invoke()
            ivDeleteBepic.visibility = View.GONE
            stickerView.undo()
            layerEmojiAdapterBepic.setListData(stickerView.stickers as ArrayList<Sticker>)

        }

    }

    private fun initBepic(dialog: Dialog){

        ivUndoBepic = dialog.findViewById(R.id.iv_undo)
        ivDeleteBepic = dialog.findViewById(R.id.iv_delete)
        rvLayerBepic = dialog.findViewById(R.id.rv_layer)
    }
}