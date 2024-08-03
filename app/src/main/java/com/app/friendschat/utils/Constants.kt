package com.app.friendschat.utils

object Constants {
    const val FACE = "face"
    const val EYES = "eyes"
    const val BROW = "brow"
    const val MOUTH = "mouth"
    const val HAND = "hand"
    const val NOSE = "nose"
    const val BEARD = "beard"
    const val HAT = "hat"
    const val GLASS = "glass"
    const val ACCESSORIES = "accessories"
    const val HAIR = "hair"

    const val email = ""
    const val EMPTY = ""
    const val REQUEST_TIMEOUT = 30L
    const val BASE_URL = "https://demo.dream-space.web.id/walper/"
    const val CACHE = "Cache-Control: max-age=0"
    const val AGENT = "User-Agent: Walper"
    const val SECURITY =
        "Security: " + "8V06LupAaMBLtQqyqTxmcN42nn27FlejvaoSM3zXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"

    const val PRIVACY_POLICY =
        "https://firebasestorage.googleapis.com/v0/b/bp-v1-v006-emoji.appspot.com/o/Privacy-Policy%20(1).html?alt=media&token=2f59ff92-f16c-46d5-93c1-52da80d38898"

    const val REQUEST_CODE_CAMERA = 0
    const val MESSAGE_UPDATE_REALTIME = 1
    const val MESSAGE_UPDATE_FINAL = 2
    const val MESSAGE_CAMERA_NOT_AVAILABLE = 3

    const val MENU_INDEX_NEW_MEASUREMENT = 0
    const val MENU_INDEX_EXPORT_RESULT = 1
    const val MENU_INDEX_EXPORT_DETAILS = 2

    enum class VIEW_STATE {
        MEASUREMENT, SHOW_RESULTS
    }

    const val RANDOM_IDENTIFIER_FOR_ADDING_STICKER_TO_WHATSAPP = "RANDOM_IDENTIFIER_FOR_WHATSAPP_STICKER"
    const val KEY_PERMISSION_SCREEN_SHOWED = "KEY_PERMISSION_SCREEN_SHOWED"

    const val REQUEST_CODE_DELETE_STICKER = 1000

    const val BUNDLE_SUGGESTION_STICKER_TITLE = "BUNDLE_SUGGESTION_STICKER_TITLE"
    const val BUNDLE_BUTTON_TEXT_CONTENT_SUCCESS_ACTIVITY = "BUNDLE_BUTTON_TEXT_CONTENT_SUCCESS_ACTIVITY"
    const val BUNDLE_FROM_ACTIVITY = "BUNDLE_FROM_ACTIVITY"
    const val BUNDLE_SAVE_ACTION = "BUNDLE_SAVE_ACTION"
    const val BUNDLE_SUCCESS_ACTION = "BUNDLE_SUCCESS_ACTION"


    const val BUNDLE_EDIT_POS_EMOJI = "BUNDLE_EDIT_POS_EMOJI"
    const val BUNDLE_EDIT_JSON_UNDO_LIST = "BUNDLE_EDIT_JSON_UNDO_LIST"
    const val BUNDLE_EDIT_JSON_EMOJI = "BUNDLE_EDIT_JSON_EMOJI"

    const val BUNDLE_SPLASH_NO_INTERNET = "BUNDLE_SPLASH_NO_INTERNET"
    const val BUNDLE_SPLASH = "BUNDLE_SPLASH"

    const val COUNT_EMOJI = 49 //giới hạn 50 item: do list chạy từ 0-49

    var jsonUndoList = ""
    var jsonSticker = ""

    const val REQUEST_CODE_NEW_ACTIVITY = 1000

}