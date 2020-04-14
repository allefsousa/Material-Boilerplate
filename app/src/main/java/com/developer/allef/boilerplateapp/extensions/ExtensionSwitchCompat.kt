package com.developer.allef.boilerplateapp.extensions

import androidx.appcompat.widget.SwitchCompat


fun SwitchCompat.inverse() {
    isChecked = isChecked.not()
}