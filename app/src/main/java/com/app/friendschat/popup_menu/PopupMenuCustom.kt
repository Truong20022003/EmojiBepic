package com.app.friendschat.popup_menu

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow

class PopupMenuCustom(
    private val context: Context,
    private val rLayoutId: Int,
    private val onClickListener: PopupMenuCustomOnClickListener
) {
    private val popupWindow: PopupWindow
    private val popupView: View
    fun setAnimationStyle(animationStyle: Int) {
        popupWindow.animationStyle = animationStyle
    }

    fun show() {
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
    }

    fun show(anchorView: View) {
        popupWindow.showAsDropDown(anchorView, anchorView.width - popupWindow.width, 0)
    }

    fun showLeft(anchorView: View) {
        popupWindow.showAsDropDown(
            anchorView,
            anchorView.width - popupWindow.width,
            0,
            Gravity.TOP or Gravity.LEFT
        )
    }

    fun showAbove(anchorView: View) {
        val location = IntArray(2)
        anchorView.getLocationOnScreen(location)

        popupWindow.showAtLocation(
            anchorView,
            Gravity.NO_GRAVITY,
            location[0] + anchorView.width,  // Đặt tọa độ x để cách bên phải 0 pixels
            location[1] - popupWindow.height - 50  // Đặt tọa độ y để cách trên 50 pixels
        )
    }

    interface PopupMenuCustomOnClickListener {
        fun onClick(menuItemId: Int)
    }

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        popupView = inflater.inflate(rLayoutId, null)
        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT
        val focusable = true
        popupWindow = PopupWindow(popupView, width, height, focusable)
        popupWindow.elevation = 10f
        val linearLayout = popupView as LinearLayout
        for (i in 0 until linearLayout.childCount) {
            val v: View = linearLayout.getChildAt(i)
            v.setOnClickListener { v1 ->
                onClickListener.onClick(v1.getId())
                popupWindow.dismiss()
            }
        }
    }
}