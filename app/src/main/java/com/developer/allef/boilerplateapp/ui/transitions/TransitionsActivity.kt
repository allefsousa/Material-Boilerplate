package com.developer.allef.boilerplateapp.ui.transitions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.developer.allef.boilerplateapp.R
import com.developer.allef.boilerplateapp.databinding.ActivityTransitionsBinding
import com.developer.allef.boilerplateapp.extensions.onClick

class TransitionsActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityTransitionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityTransitionsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnCloseDown.onClick {
            finish()
            overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out)
        }
        viewBinding.btnCloseTop.onClick {
            finish()
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }
        viewBinding.btnCloseFade.onClick {
            finish()
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        viewBinding.btnCloseSlideLeft.onClick {
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left)
        }
        viewBinding.btnCloseSlideRigth.onClick {
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right)
        }
        viewBinding.btnCloseRigthLeft.onClick {
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
        viewBinding.btnCloseLeftRigth.onClick {
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }
}
