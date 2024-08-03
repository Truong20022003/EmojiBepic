package com.app.friendschat.utils.widget

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import com.app.friendschat.ui.no_internet.NoInternetBepicActivity
import com.app.friendschat.utils.CheckInternet

fun Activity.changeStatusBarColor(color: Int, lightStatusBar: Boolean = false) {
    this.window?.statusBarColor = resources.getColor(color, theme)
    if (lightStatusBar)
        this.lightStatusBar()

}

fun Activity.lightStatusBar() {
    val decorView: View? = this.window?.decorView
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val wic = decorView?.windowInsetsController
        wic?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
    } else
        decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}

fun View.tapAndCheckInternet(action: (view: View?) -> Unit) {
    // Khởi tạo biến để theo dõi thời gian của lần click cuối cùng.
    var lastClickTime: Long = 0

    setOnClickListener {
        val currentTime = System.currentTimeMillis()

        if (currentTime - lastClickTime >= 900) {
            lastClickTime = currentTime

            if (!CheckInternet.haveNetworkConnection(context)) {
                context.findActivity()?.let {
                    val intent = Intent(it, NoInternetBepicActivity::class.java)
                    it.startActivity(intent)
                    it.overridePendingTransition(0, 0)
                }
            } else {
                action(this)
            }
        }
    }
}

//fun View.tapAndCheckInternet(action: (view: View?) -> Unit) {
//
//    setOnClickListener(object : TapListener() {
//        override fun onTap(v: View?) {
//                if (!CheckInternet.haveNetworkConnection(context)) {
//                    context.findActivity()?.let {
//                        val intent = Intent(it, NoInternetNewScreenActivity::class.java)
//                        it.startActivity(intent)
//                        it.overridePendingTransition(0, 0)
//                    }
//                    return
//                }
//                action(v)
//            }
//        }
//    })
//}