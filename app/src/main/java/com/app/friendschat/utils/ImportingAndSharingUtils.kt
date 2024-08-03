package com.app.friendschat.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.widget.Toast
import com.app.friendschat.R

object ImportingAndSharingUtils {

    fun importToTelegram(context: Context, uriList: List<Uri>) {
        val list: ArrayList<Uri> = ArrayList(uriList)
        val it = list.iterator()
        while (it.hasNext()) {
            context.grantUriPermission(
                "org.telegram.messenger",
                it.next(),
                Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
            )
        }

        val intent = Intent("org.telegram.messenger.CREATE_STICKER_PACK")
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, list)
        intent.putExtra("IMPORTER", context.packageName)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
        intent.type = "image/*"

        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, context.getString(R.string.no_app_found_to_handle_this_action), Toast.LENGTH_SHORT).show()
        }
    }

    fun shareOneImage(context: Context, uri: Uri) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/png"
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
        val chooser = Intent.createChooser(shareIntent, "Share sticker")

        // Grant permission to all apps that can handle the intent
        val resInfoList: List<ResolveInfo> = context.packageManager
            .queryIntentActivities(chooser, PackageManager.MATCH_DEFAULT_ONLY)
        for (resolveInfo in resInfoList) {
            val packageName = resolveInfo.activityInfo.packageName
            context.grantUriPermission(
                packageName,
                uri,
                Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
            )
        }

        if (shareIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(chooser)
        } else {
            Toast.makeText(context, context.getString(R.string.no_app_found_to_handle_the_share_action), Toast.LENGTH_SHORT).show()
        }
    }

    fun shareMultipleImages(context: Context, uriList: List<Uri>) {
        val shareIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND_MULTIPLE
            type = "image/*"
            putParcelableArrayListExtra(Intent.EXTRA_STREAM, ArrayList(uriList))
        }
        try {
            val chooser: Intent = Intent.createChooser(shareIntent, "Share images to..")

            // Grant permission to all apps that can handle the intent
            val resInfoList: List<ResolveInfo> = context.packageManager
                .queryIntentActivities(chooser, PackageManager.MATCH_DEFAULT_ONLY)
            for (resolveInfo in resInfoList) {
                val packageName = resolveInfo.activityInfo.packageName
                for(uri in uriList) {
                    context.grantUriPermission(
                        packageName,
                        uri,
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION
                    )
                }
            }

            context.startActivity(chooser)

        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, context.getString(R.string.no_app_found_to_handle_the_share_action), Toast.LENGTH_SHORT).show()
        }
    }
}