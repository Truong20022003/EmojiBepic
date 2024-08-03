package com.app.friendschat.whatsapp

import android.content.Context
import com.app.friendschat.data.model.PackageModel
import com.app.friendschat.utils.Constants
import com.app.friendschat.utils.FileUtils
import com.app.friendschat.utils.LocalStorageUtils

object IdGenerator {

    public fun generateIdFromUrl(context: Context, url: String): String {
        val randomIdentifier = LocalStorageUtils.readData(context, Constants.RANDOM_IDENTIFIER_FOR_ADDING_STICKER_TO_WHATSAPP)
        return FileUtils.getFolderNameFromUrl(url).lowercase() + randomIdentifier
    }

    public fun generatorIdFromPackageModel(context: Context, packageModel: PackageModel): String {
        val randomIdentifier = LocalStorageUtils.readData(context, Constants.RANDOM_IDENTIFIER_FOR_ADDING_STICKER_TO_WHATSAPP)
        return packageModel.id.toString() + randomIdentifier
    }
}