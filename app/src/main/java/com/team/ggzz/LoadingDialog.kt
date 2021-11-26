package com.team.ggzz

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater

class LoadingDialog {
    var dialog: Dialog? = null

    fun show(context: Context):Dialog {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.loading_spinner, null)
        dialog = Dialog(context, R.style.LoadingSpinnerDialog)
        dialog!!.setContentView(view)
        dialog!!.setCancelable(false)
        dialog!!.show()
        return dialog as Dialog
    }
}