package com.app.friendschat.data.model

import java.io.Serializable

data class StickerModel(
    val url: String,
    val jsonUndoList: String? = null,
    val jsonSticker: String? = null,
    val numberOfLayers: Int = 0
): Serializable