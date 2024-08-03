package com.app.friendschat.data

import com.app.friendschat.data.api.IApiHelper
import com.app.friendschat.data.local.IPreferenceHelper

interface DataManager : IPreferenceHelper, IApiHelper {
}