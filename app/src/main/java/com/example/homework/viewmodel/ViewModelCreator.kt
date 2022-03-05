package com.example.homework.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelCreator {
    companion object {
        fun <T : ViewModel> create(creator: () -> T?) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val model = creator()
                if (model != null && modelClass.isAssignableFrom(model::class.java)) {
                    return model as T
                }
                throw IllegalArgumentException("unknown view model for:" + modelClass.name)
            }
        }
    }
}