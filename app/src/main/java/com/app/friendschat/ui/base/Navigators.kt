package com.app.friendschat.ui.base

import android.os.Bundle
import kotlin.reflect.KClass

interface Navigators {
    fun onFragmentResumed(fragment: BaseFragment<*, *>)

    fun switchFragment(fragment: KClass<*>, bundle: Bundle? = null, addToBackStack: Boolean = true)

    fun fragmentRequestInject(fragment: BaseFragment<*, *>)

    fun showActivity(activity: Class<*>, bundle: Bundle? = null)
    fun showActivityWithResultCode(activity: Class<*>, requestCode: Int, bundle: Bundle? = null)
}