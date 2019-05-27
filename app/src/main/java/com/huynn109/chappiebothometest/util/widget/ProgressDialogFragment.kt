package com.huynn109.chappiebothometest.util.widget

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.huynn109.chappiebothometest.R

/**
 * Created by huynn109 on 2019-05-12.
 */

class ProgressDialogFragment : DialogFragment() {
    companion object {
        fun newInstance(): ProgressDialogFragment {
            return ProgressDialogFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return inflater.inflate(R.layout.dialog_progress, container, false)
    }
}