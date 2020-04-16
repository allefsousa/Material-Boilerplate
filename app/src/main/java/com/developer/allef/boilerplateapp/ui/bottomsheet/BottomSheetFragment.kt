package com.developer.allef.boilerplateapp.ui.bottomsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.developer.allef.boilerplateapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A simple [Fragment] subclass.
 */
class BottomSheetFragment : BottomSheetDialogFragment() {
    private var dismissWithAnimation = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_modal_bottom_sheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dismissWithAnimation = arguments?.getBoolean(ARG_DISMISS_WITH_ANIMATION) ?: false
        (requireDialog() as BottomSheetDialog).dismissWithAnimation = dismissWithAnimation
    }

    companion object {
        const val TAG = "ModalBottomSheet"
        private const val ARG_DISMISS_WITH_ANIMATION = "dismiss_with_animation"
        fun newInstance(dismissWithAnimation: Boolean): BottomSheetFragment {
            val modalBottomSheet = BottomSheetFragment()
            modalBottomSheet.arguments = bundleOf(ARG_DISMISS_WITH_ANIMATION to dismissWithAnimation)
            return modalBottomSheet
        }
    }

}
