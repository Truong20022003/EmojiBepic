package com.app.friendschat.utils

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics


object EventTracking {

    const val EVENT_NAME_SPLASH_OPEN = "splash_open"
    const val EVENT_NAME_LANGUAGE_FO_OPEN = "language_fo_open"
    const val EVENT_NAME_LANGUAGE_FO_SAVE_CLICK = "language_fo_save_click"
    const val EVENT_NAME_ONBOARDING1_VIEW = "onboarding1_view"
    const val EVENT_NAME_ONBOARDING2_VIEW = "onboarding2_view"
    const val EVENT_NAME_ONBOARDING3_VIEW = "onboarding3_view"
    const val EVENT_NAME_ONBOARDING3_START_CLICK = "onboarding3_start_click"
    const val EVENT_NAME_PERMISSION_VIEW = "permission_view"
    const val EVENT_NAME_PERMISSION_CONTINUE_CLICK = "permission_continue_click"
    const val EVENT_NAME_NO_INTERNET_VIEW = "no_internet_view"
    const val EVENT_NAME_RATE_SHOW = "rate_show"
    const val EVENT_NAME_RATE_NOT_NOW = "rate_not_now"
    const val EVENT_NAME_RATE_SUBMIT = "rate_submit"
    const val EVENT_NAME_SETTING_VIEW = "setting_view"
    const val EVENT_NAME_SETTING_LANGUAGE_CLICK = "setting_language_click"
    const val EVENT_NAME_SETTING_PRIVACY_POLICY_CLICK = "setting_privacy_policy_click"
    const val EVENT_NAME_SETTING_SHARE_CLICK = "setting_share_click"
    const val EVENT_NAME_HOME_VIEW = "home_view"
    const val EVENT_NAME_HOME_SEARCH_RESULT_VIEW = "home_search_result_view"
    const val EVENT_NAME_HOME_CREATE_CLICK = "home_create_click"
    const val EVENT_NAME_HOME_SUGGESTED_PACKAGE_CLICK = "home_suggested_package_click"
    const val EVENT_NAME_HOME_CREATION_CLICK = "home_creation_click"
    const val EVENT_NAME_HOME_SETTING_CLICK = "home_setting_click"
    const val EVENT_NAME_SUGGESTED_PACKAGE_MORE_CLICK = "suggested_pack_more_click"
    const val EVENT_NAME_SUGGESTED_PACK_VIEW_LIST = "suggested_pack_view_list"
    const val EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM = "suggested_pack_choose_item"
    const val EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM_SHARE = "suggested_pack_choose_item_share"
    const val EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM_DOWNLOAD = "suggested_pack_choose_item_download"
    const val EVENT_NAME_SUGGESTED_PACK_CHOOSE_ITEM_ADD = "suggested_pack_choose_item_add"
    const val EVENT_NAME_CREATE_EMOJI_VIEW = "create_emoji_view"
    const val EVENT_NAME_CREATE_EMOJI_CATEGORY_CHOOSE_ITEM = "create_emoji_category_choose_item"
    const val EVENT_NAME_CREATE_EMOJI_CREATE_CLICK = "create_emoji_create_click"
    const val EVENT_NAME_CREATE_EMOJI_CREATE_SHARE = "create_emoji_create_share"
    const val EVENT_NAME_CREATE_EMOJI_CREATE_DOWNLOAD = "create_emoji_create_download"
    const val EVENT_NAME_CREATE_EMOJI_CREATE_ADD_CLICK = "create_emoji_create_add_click"
    const val EVENT_NAME_CREATE_EMOJI_CREATE_NEW_PACK_CLICK = "create_emoji_create_new_pack_click"
    const val EVENT_NAME_CREATE_EMOJI_CREATE_SAVE_CLICK = "create_emoji_create_save_click"
    const val EVENT_NAME_SUCCESS_VIEW = "success_view"
    const val EVENT_NAME_SUCCESS_MORE_CLICK = "success_more_click"
    const val EVENT_NAME_CREATION_PACKAGE_VIEW = "creation_package_view"
    const val EVENT_NAME_CREATION_PACKAGE_NEW_CLICK = "creation_package_new_click"
    const val EVENT_NAME_CREATION_PACKAGE_MORE_CLICK = "creation_package_more_click"
    const val EVENT_NAME_CREATION_PACKAGE_VIEW_LIST = "creation_package_view_list"
    const val EVENT_NAME_CREATION_PACKAGE_VIEW_LIST_CREATE = "creation_package_view_list_create"
    const val EVENT_NAME_CREATION_PACKAGE_DELETE = "creation_package_delete"
    const val EVENT_NAME_ADD_WHATSAPP_CLICK = "add_whatsapp_click"
    const val EVENT_NAME_ADD_TELEGRAM_VIEW = "add_telegram_click"
    const val EVENT_NAME_SHARE_CLICK = "share_click"
    const val EVENT_NAME_DOWNLOAD_CLICK = "download_click"
    const val EVENT_NAME_CREATION_DRAFT_VIEW = "creation_draft_view"
    const val EVENT_NAME_CREATION_DRAFT_DELETE_CLICK = "creation_draft_delete_click"
    const val EVENT_NAME_CREATION_DRAFT_EDIT_CLICK = "creation_draft_edit_click"
    const val EVENT_NAME_EDIT_EMOJI_VIEW = "edit_emoji_view"
    const val EVENT_NAME_EDIT_EMOJI_DONE_CLICK = "edit_emoji_done_click"
    const val EVENT_NAME_EDIT_EMOJI_SHARE = "edit_emoji_share"
    const val EVENT_NAME_EDIT_EMOJI_DOWNLOAD = "edit_emoji_download"
    const val EVENT_NAME_EDIT_EMOJI_DELETE = "edit_emoji_delete"
    const val EVENT_NAME_EDIT_EMOJI_ADD_CLICK = "edit_emoji_add_click"
    const val EVENT_NAME_EDIT_EMOJI_SAVE_CLICK = "edit_emoji_save_click"

    fun logEvent(context: Context, nameEvent: String) {
        val bundle = Bundle()
        FirebaseAnalytics.getInstance(context).logEvent(nameEvent, bundle)
    }

    fun logEvent(context: Context, nameEvent: String, param: String, value: String) {
        val bundle = Bundle()
        bundle.putString(param, value)
        FirebaseAnalytics.getInstance(context).logEvent(nameEvent, bundle)
    }

    fun logEvent(context: Context, nameEvent: String, param: String, value: Long) {
        val bundle = Bundle()
        bundle.putLong(param, value)
        FirebaseAnalytics.getInstance(context).logEvent(nameEvent, bundle)
    }

}