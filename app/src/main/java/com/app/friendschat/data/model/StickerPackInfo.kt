package com.app.friendschat.data.model

data class StickerPackInfo(
    val title: String,
    val iconUrl: String,
    val stickers: List<StickerModel>,
)