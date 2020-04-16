package com.developer.allef.boilerplateapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.developer.allef.boilerplateapp.R
import com.developer.allef.boilerplateapp.base.BaseActivity
import com.developer.allef.boilerplateapp.databinding.ActivityMainBinding
import com.developer.allef.boilerplateapp.ui.bottomsheet.BottomSheetActivity


class MainActivity : BaseActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    override val layout: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initView()

        viewBinding.btnNavigate.setOnClickListener {
            startActivity(Intent(this, ButtonActivity::class.java))
        }

        viewBinding.btnBottom.setOnClickListener {
            startActivity(Intent(this, BottomSheetActivity::class.java))
        }
    }


}
