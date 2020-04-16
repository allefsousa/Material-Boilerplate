package com.developer.allef.boilerplateapp.ui

import android.os.Bundle
import com.developer.allef.boilerplateapp.R
import com.developer.allef.boilerplateapp.base.BaseActivity
import com.developer.allef.boilerplateapp.databinding.ActivityHomeBinding
import com.developer.allef.boilerplateapp.extensions.onClick
import com.developer.allef.boilerplateapp.ui.bottomsheet.BottomSheetActivity
import com.developer.allef.boilerplateapp.ui.buttons.ButtonActivity
import com.developer.allef.boilerplateapp.ui.dialog.DialogActivity


class HomeActivity : BaseActivity() {

    private lateinit var viewBinding: ActivityHomeBinding
    override val layout: Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initView()

        viewBinding.btnNavigate.onClick {
            goTo<ButtonActivity>()
        }

        viewBinding.btnBottom.onClick {
            goTo<BottomSheetActivity>()
        }

        viewBinding.btnDialog.onClick {
            goTo<DialogActivity>()
        }
    }


}
