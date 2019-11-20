package com.devahir.mastery.ui.component

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devahir.mastery.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetInfoDialog : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentParentView = inflater.inflate(R.layout.info_dialog_layout, container, false)
        return fragmentParentView;
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
    }
}