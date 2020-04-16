package com.developer.allef.boilerplateapp.ui.bottomsheet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developer.allef.boilerplateapp.R
import com.developer.allef.boilerplateapp.base.BaseActivity
import com.developer.allef.boilerplateapp.databinding.ActivityBottomSheetBinding
import com.developer.allef.boilerplateapp.extensions.onClick

class BottomSheetActivity : BaseActivity() {
    override val layout: Int = R.layout.activity_bottom_sheet
    private lateinit var viewBinding: ActivityBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initView()
        enableHomeAsUpActionBar()

        viewBinding.btnBottom.onClick {
            goTo<BottomSheetInActivity>()
        }

    }




}
