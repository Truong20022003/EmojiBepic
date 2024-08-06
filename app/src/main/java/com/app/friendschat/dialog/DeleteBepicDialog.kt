package com.app.friendschat.dialog

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.app.friendschat.R
import com.app.friendschat.utils.widget.tapAndCheckInternet

class DeleteBepicDialog(
    activity: Activity,
    private val descriptionBepic: String,
    private val onClickDeleteBepic: () -> Unit,
) : Dialog(activity) {
    private lateinit var rlDeleteBepic: RelativeLayout

    private lateinit var rlQuitBepic: RelativeLayout
    private lateinit var tvDescriptionBepic: TextView
    private lateinit var ivCloseBepic: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.dialog_delete_bepic_rft)

        initViewBepicRft()
        initListenerBepicRft()

        tvDescriptionBepic.text = descriptionBepic
    }


    private fun initListenerBepicRft() {
        ivCloseBepic.tapAndCheckInternet {
            dismiss()
        }

        rlQuitBepic.tapAndCheckInternet {
            dismiss()
        }

        rlDeleteBepic.tapAndCheckInternet {
            onClickDeleteBepic.invoke()
            dismiss()
        }
    }
    private fun initViewBepicRft() {
        ivCloseBepic = findViewById(R.id.iv_close)
        rlQuitBepic = findViewById(R.id.rl_quit)
        rlDeleteBepic = findViewById(R.id.rl_delete)
        tvDescriptionBepic = findViewById(R.id.tv_description)
    }


}