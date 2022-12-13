package com.cicddemo.app

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

open class BaseActivity : AppCompatActivity() {

    var alert: AlertDialog? = null
    var context: Context? = null

    protected fun showDeleteAlert(activity: Activity) {
        context = activity.applicationContext
        val dialogBuilder = MaterialAlertDialogBuilder(activity)
        dialogBuilder.setMessage(getString(R.string.delete_feed_msg))
            .setCancelable(false)
            .setPositiveButton(
                getString(R.string.yes)
            ) { dialog, _ ->
                dialog.cancel()


            }
            .setNegativeButton(
                getString(R.string.text_cancel)
            ) { dialog, _ ->
                dialog.cancel()
            }

        alert = dialogBuilder.create()
        alert!!.setTitle(getString(R.string.delete_feed))
        alert!!.show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("Alert Hide", "Yes its hide " + (alert != null) + " " + (alert!!.context == context))

    }

}