package com.developer.allef.boilerplateapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Spinnable(
    val id: String,
    val description: String
) : Parcelable  {
    override fun toString() = description
}
