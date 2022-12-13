package com.cicddemo.app

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast


fun Context.showDialog(
    title: String,
    description: String,
    titleOfPositiveButton: String? = null,
    titleOfNegativeButton: String? = null,
    positiveButtonFunction: (() -> Unit)? = { },
    negativeButtonFunction: (() -> Unit)? = { }
): Dialog {
    val dialog = Dialog(this, R.style.Theme_Dialog)
    dialog.window?.requestFeature(Window.FEATURE_NO_TITLE) // if you have blue line on top of your dialog, you need use this code
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.dialog_custom_layout)
    val dialogTitle = dialog.findViewById(R.id.tvTitle) as TextView
    val dialogDescription = dialog.findViewById(R.id.tvDescription) as TextView
    val dialogPositiveButton = dialog.findViewById(R.id.tvPositiveButton) as TextView
    val dialogNegativeButton = dialog.findViewById(R.id.tvNegativeButton) as TextView
    dialogTitle.text = title
    dialogDescription.text = description
    titleOfPositiveButton?.let { dialogPositiveButton.text = it } ?: dialogPositiveButton.makeGone()
    titleOfNegativeButton?.let { dialogNegativeButton.text = it } ?: dialogNegativeButton.makeGone()
    dialogPositiveButton.setOnClickListener {
        positiveButtonFunction?.invoke()
        dialog.dismiss()
    }
    dialogNegativeButton.setOnClickListener {
        negativeButtonFunction?.invoke()
        dialog.dismiss()
    }

    return dialog
}

fun Context.makeToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}

fun TextView.makeGone() {
    this.visibility = View.GONE
}