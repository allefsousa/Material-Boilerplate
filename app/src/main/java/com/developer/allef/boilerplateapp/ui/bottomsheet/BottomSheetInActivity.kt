package com.developer.allef.boilerplateapp.ui.bottomsheet

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.developer.allef.boilerplateapp.R
import com.developer.allef.boilerplateapp.extensions.visible
import com.google.android.material.animation.ArgbEvaluatorCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_bottom_sheet_in.*

class BottomSheetInActivity : AppCompatActivity() {
    private lateinit var standardBottomSheetBehavior: BottomSheetBehavior<View>

    private val textColor = Color.parseColor("#FF000000")

    private var modalDismissWithAnimation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet_in)
        setupButtons()
        setupStandardBottomSheet()
    }

    private fun setupButtons() {
        standardBottomSheetButton.setOnClickListener {
            showOrHideBottomSheet()
        }
        modalBottomSheetButton.setOnClickListener {
            showModalBottomSheet()
        }
    }

    private fun setupStandardBottomSheet() {
        standardBottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)
        val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                textView.text = when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> "STATE_EXPANDED"
                    BottomSheetBehavior.STATE_COLLAPSED -> "STATE_COLLAPSED"
                    BottomSheetBehavior.STATE_DRAGGING -> "STATE_DRAGGING"
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> "STATE_HALF_EXPANDED"
                    BottomSheetBehavior.STATE_HIDDEN -> "STATE_HIDDEN"
                    BottomSheetBehavior.STATE_SETTLING -> "STATE_SETTLING"
                    else -> null
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                slideView.visible()
                slideView.alpha = slideOffset
            }
        }
        standardBottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
        standardBottomSheetBehavior.saveFlags = BottomSheetBehavior.SAVE_ALL
        textView.setTextColor(textColor)
    }

    private fun showModalBottomSheet() {
        val modalBottomSheet = BottomSheetFragment.newInstance(modalDismissWithAnimation)
        modalBottomSheet.show(supportFragmentManager, BottomSheetFragment.TAG)
    }

    private fun animateStandardBottomSheetStates() {
        standardBottomSheet.postDelayed({
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }, 1000L)
        standardBottomSheet.postDelayed({
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }, 2000L)
        standardBottomSheet.postDelayed({
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        }, 3000L)
        standardBottomSheet.postDelayed({
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }, 4000L)
        standardBottomSheet.postDelayed({
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }, 5000L)
    }

     private fun showOrHideBottomSheet() {
        if (standardBottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            standardBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
        } else {
            standardBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        }
    }
}
