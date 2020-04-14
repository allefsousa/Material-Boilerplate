package com.developer.allef.boilerplateapp.extensions

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt



fun Drawable.changeDrawableColor(color: String?) {
    color?.let { colorFilter = PorterDuffColorFilter(Color.parseColor(it), PorterDuff.Mode.SRC_IN) }
}

fun Drawable.changeDrawableColor(@ColorInt color: Int): Int {
    colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
    return color
}