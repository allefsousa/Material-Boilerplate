package com.developer.allef.boilerplateapp.extensions

import android.os.Handler
import br.com.redcode.base.utils.Constants

inline fun delay(crossinline code: () -> Unit) = delay(Constants.ONE_SECOND_IN_MILLISECONDS, code)

inline fun delay(time: Long, crossinline code: () -> Unit) {
    try {
        Handler().postDelayed({ code() }, time)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}