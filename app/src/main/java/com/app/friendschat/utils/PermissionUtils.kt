package com.app.friendschat.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.app.ActivityCompat
import com.app.friendschat.R
import com.app.friendschat.utils.widget.showDialog

object PermissionUtils {

    private val storagePermissionsToRequest = mutableListOf<String>().apply {
        val readStoragePermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_IMAGES
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

        this.add(readStoragePermission)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            this.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
    }

    fun isStoragePermissionGranted(context: Context): Boolean {
        return storagePermissionsToRequest.all {
            context.checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED
        }
    }

    fun requestStoragePermission(activity: Activity, requestCode: Int = 1000) {
        requestPermissions(activity, storagePermissionsToRequest.toTypedArray(), requestCode)
    }

    private fun requestPermissions(
        activity: Activity,
        permissions: Array<String>,
        requestCode: Int = 1000
    ) {
        val showRationale = permissions.any {
            ActivityCompat.shouldShowRequestPermissionRationale(activity, it)
        }

        if (showRationale) {
            showGotoSettingDialog(activity)
        } else {
            ActivityCompat.requestPermissions(
                activity,
                permissions,
                requestCode
            )
        }
    }

    private fun showGotoSettingDialog(activity: Activity) {
        activity.showDialog(
            title = activity.getString(R.string.Grant_Permission),
            message = activity.getString(R.string.Please_grant_all_permissions),
            textOfPositiveButton = activity.getString(R.string.Go_to_setting),
            positiveButtonFunction = {
                goToSetting(activity)
            }
        )
    }

    private fun goToSetting(activity: Activity) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", activity.packageName, null)
        intent.data = uri
        activity.startActivity(intent)
    }
}