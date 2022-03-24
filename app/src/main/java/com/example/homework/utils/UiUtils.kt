package com.example.homework.utils

import android.content.Context

object UiUtils {
    // convert dp to pixel based on display size
    fun dp2px(context: Context?, dp: Int): Int {
        if (context == null) return 0
        return (context.resources.displayMetrics.density * dp + 0.5f).toInt()
    }
}