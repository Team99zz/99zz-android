package com.team.ggzz

import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface
import org.json.JSONObject

class WebViewInterface (private val context:Context){

    @JavascriptInterface
    open fun setStatusBarColor(colorName: String) {
        val color = mapOf("blue" to context.getColor(R.color.main_blue), "gray" to context.getColor(R.color.sub_gray))
        Log.d("로그", colorName)
        val activity = context as MainActivity
        activity.window.statusBarColor = color[colorName]!!
    }
}