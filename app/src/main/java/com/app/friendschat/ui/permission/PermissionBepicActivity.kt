package com.app.friendschat.ui.permission

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.app.friendschat.R
import com.app.friendschat.databinding.ActivityPermissionBepicBinding
import com.app.friendschat.ui.base.BaseActivity
import com.app.friendschat.ui.base.BaseFragment
import com.app.friendschat.ui.base.EmptyViewModel
import com.app.friendschat.ui.main.MainBepicActivity
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.EventTracking
import com.app.friendschat.utils.LocalStorageUtils
import com.app.friendschat.utils.PermissionUtils
import com.app.friendschat.utils.widget.tapAndCheckInternet
import kotlin.reflect.KClass

class PermissionBepicActivity : BaseActivity<EmptyViewModel, ActivityPermissionBepicBinding>() {

    private val REQUEST_CODE_STORAGE_PERMISSION_BEPIC = 1001

    override fun initView() {
        EventTracking.logEvent(this, EventTracking.EVENT_NAME_PERMISSION_VIEW)

        binding.switchStoragePermission.setOnCheckedChangeListener { _, p1 ->
            if (p1) {
                binding.switchStoragePermission.thumbTintList =
                    ContextCompat.getColorStateList(this@PermissionBepicActivity, R.color.color_095467)
                binding.switchStoragePermission.trackTintList =
                    ContextCompat.getColorStateList(this@PermissionBepicActivity, R.color.color_80095467)
            } else {
                binding.switchStoragePermission.thumbTintList =
                    ContextCompat.getColorStateList(this@PermissionBepicActivity, R.color.color_095467)
                binding.switchStoragePermission.trackTintList =
                    ContextCompat.getColorStateList(this@PermissionBepicActivity, R.color.color_A9A9A9)
            }
        }

        binding.switchStoragePermission.setOnClickListener {
            if (PermissionUtils.isStoragePermissionGranted(this@PermissionBepicActivity)) {
                binding.switchStoragePermission.isChecked = true
                return@setOnClickListener
            }
            binding.switchStoragePermission.isChecked = false
            PermissionUtils.requestStoragePermission(this@PermissionBepicActivity, REQUEST_CODE_STORAGE_PERMISSION_BEPIC)
        }

        binding.rlNextAds.tapAndCheckInternet {
            showActivity(MainBepicActivity::class.java)
            LocalStorageUtils.writeData(this@PermissionBepicActivity, Constants.KEY_PERMISSION_SCREEN_SHOWED, true)

            EventTracking.logEvent(this, EventTracking.EVENT_NAME_PERMISSION_CONTINUE_CLICK)
        }
    }

    override fun createViewModel(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun switchFragment(fragment: KClass<*>, bundle: Bundle?, addToBackStack: Boolean) {

    }

    override fun bindViewModel() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        binding.switchStoragePermission.isChecked = PermissionUtils.isStoragePermissionGranted(this@PermissionBepicActivity)
    }

    override fun onResume() {
        super.onResume()
        binding.switchStoragePermission.isChecked = PermissionUtils.isStoragePermissionGranted(this@PermissionBepicActivity)
    }

    override fun getContentView(): Int = R.layout.activity_permission_bepic

    override fun onFragmentResumed(fragment: BaseFragment<*, *>) {
    }
}