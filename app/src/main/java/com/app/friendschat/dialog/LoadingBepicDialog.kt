package com.app.friendschat.dialog

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import com.app.friendschat.R

class LoadingBepicDialog(
    activity: Activity
) : Dialog(activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(false)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.progress_circle)
    }
}