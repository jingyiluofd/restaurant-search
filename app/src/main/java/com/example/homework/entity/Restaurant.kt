package com.example.homework.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.lang.StringBuilder

@Parcelize
data class Business(
    val businesses: List<Restaurant>?
) : Parcelable

@Parcelize
data class Restaurant(
    val display_phone: String?,
    val image_url: String?,
    val location: Location?,
    val name: String?
) : Parcelable

@Parcelize
data class Location(
    val display_address: List<String>?
) : Parcelable {
    fun getAddress(): String {
        if (display_address.isNullOrEmpty()) return ""
        val sb = StringBuilder()
        display_address.forEach {
            sb.append(it)
        }
        return sb.toString()
    }
}