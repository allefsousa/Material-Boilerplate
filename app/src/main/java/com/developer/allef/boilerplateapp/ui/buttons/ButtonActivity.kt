package com.developer.allef.boilerplateapp.ui.buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developer.allef.boilerplateapp.R
import com.developer.allef.boilerplateapp.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


    }
}
