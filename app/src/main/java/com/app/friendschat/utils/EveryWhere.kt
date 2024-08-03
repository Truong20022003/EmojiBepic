package com.app.friendschat.utils

import android.util.Log
import com.app.friendschat.BuildConfig

inline fun printLog(message: Any?) {
    if (message == null || !BuildConfig.DEBUG) return
    val stackTraceElement = Thread.currentThread().stackTrace[4]
    Log.d(
        "DKS - ${stackTraceElement.fileName} -> ${stackTraceElement.methodName} -> ${stackTraceElement.lineNumber}",
        "#$message"
    )
}

