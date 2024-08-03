package com.app.friendschat.dialog

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.app.friendschat.R
import com.app.friendschat.utils.widget.tapAndCheckInternet

class UnlockItemBepicDialog(
    activity:Activity,
    private val onCloseBepic: () -> Unit = {},
    private val onWatchVideoBepic: () -> Unit
) : Dialog(activity) {

    private lateinit var ivCloseBepic: ImageView
    private lateinit var llWatchVideoBepic: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.dialog_unlock_items_bepic)

        initViewBepic()

        ivCloseBepic.tapAndCheckInternet {
            onCloseBepic.invoke()
            dismiss()
        }

        llWatchVideoBepic.tapAndCheckInternet {
            onWatchVideoBepic.invoke()
            dismiss()
        }

    }

    private fun initViewBepic(){
        ivCloseBepic = findViewById(R.id.iv_close)
        llWatchVideoBepic = findViewById(R.id.ll_watch_video)
    }

}