package com.app.friendschat.ui.base

import android.content.Context
import android.os.Bundle

interface IFragmentCallback {
    fun getContext(): Context
    fun showLoading()
    fun hideLoading()
    fun showActivity(act: Class<*>, bundle: Bundle? = null)
    fun showActivityWithResultCode(act: Class<*>, requestCode: Int, bundle: Bundle? = null)
}