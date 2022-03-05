package com.example.homework.utils

import com.facebook.drawee.view.SimpleDraweeView

object FrescoLoader {
    fun load(url: String?, view: SimpleDraweeView?) {
        if (view == null || url.isNullOrBlank()) return
        view.setImageURI(url)
    }
}