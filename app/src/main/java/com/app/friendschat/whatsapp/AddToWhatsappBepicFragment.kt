package com.app.friendschat.whatsapp

import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import com.app.friendschat.BuildConfig
import com.app.friendschat.R
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.base.BaseViewModel

abstract class AddToWhatsappBepicFragment<VM : BaseViewModel, DB : ViewDataBinding>: BaseFragment<VM, DB>() {

    private val ADD_PACK_BEPIC = 200
    private val EXTRA_STICKER_PACK_ID_BEPIC = "sticker_pack_id"
    private val EXTRA_STICKER_PACK_AUTHORITY_BEPIC = "sticker_pack_authority"
    private val EXTRA_STICKER_PACK_NAME_BEPIC = "sticker_pack_name"

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_PACK_BEPIC) {
            if (resultCode == Activity.RESULT_CANCELED && data != null) {
                val validationError = data.getStringExtra("validation_error")
                if (validationError != null) {
                    Log.e("CHECK_BUG", "Validation failed:$validationError")
                }
            } else {
                Log.d("CHECK_BUG", "Add StickerPack to WhatsApp request received $resultCode")
            }
        }
    }

    fun addToWhatsappBepic(stickerPack: com.app.friendschat.whatsapp.StickerPack) {
        if (stickerPack.stickers.size >= 3) {
            addStickerPackToWhatsAppBepic(stickerPack)
        } else {
            showErrorDialogBepic()
        }
    }

    fun showErrorDialogBepic() {
        val alertDialog = AlertDialog.Builder(requireActivity())
            .setNegativeButton(
                "Ok"
            ) { dialogInterface, i -> dialogInterface.dismiss() }.create()
        alertDialog.setTitle(this.getString(R.string.invalid_action))
        alertDialog.setMessage(this.getString(R.string.invalid_action_msg))
        alertDialog.show()
    }

    private fun addStickerPackToWhatsAppBepic(sp: com.app.friendschat.whatsapp.StickerPack) {

        Log.d("CHECK_BUG", "addStickerPackToWhatsApp:stickerPack.identifier ${sp.identifier}")

        val intent = Intent()
        intent.action = "com.whatsapp.intent.action.ENABLE_STICKER_PACK"
        intent.putExtra(EXTRA_STICKER_PACK_ID_BEPIC, sp.identifier)
        intent.putExtra(EXTRA_STICKER_PACK_AUTHORITY_BEPIC, BuildConfig.CONTENT_PROVIDER_AUTHORITY)
        intent.putExtra(EXTRA_STICKER_PACK_NAME_BEPIC, sp.name)
        try {
            startActivityForResult(intent, ADD_PACK_BEPIC)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(requireActivity(), R.string.error_adding_sticker_pack, Toast.LENGTH_LONG).show()
        }
    }

}