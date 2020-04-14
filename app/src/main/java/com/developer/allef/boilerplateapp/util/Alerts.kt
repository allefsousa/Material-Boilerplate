package com.developer.allef.boilerplateapp.util

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.developer.allef.boilerplateapp.extensions.toLogcat
import com.developer.allef.boilerplateapp.R
import java.util.*


object Alerts {

    fun showDatePicker(context: Context, calendar: Calendar, callback: DatePickerDialog.OnDateSetListener) {
        DatePickerDialog(
                context,
                callback,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    fun showTimePicker(context: Context, calendar: Calendar, callback: TimePickerDialog.OnTimeSetListener) {
        TimePickerDialog(
                context,
                callback,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
        ).show()
    }

    fun showDialogOk(
        context: Context,
        title: String = context.getString(R.string.aviso),
        mensagem: String,
        onOk: (() -> Unit)? = null
    ) {
        if (context is AppCompatActivity && context.isFinishing.not()) {
            val alert = AlertDialog.Builder(context)
            alert.setTitle(title)
            alert.setMessage(mensagem)
            alert.setCancelable(false)
            alert.setPositiveButton(android.R.string.ok) { dialog, _ ->
                dialog.dismiss()
                onOk?.invoke()
            }

            val dialog = alert.create()
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
        }
    }

    fun getDialogSimpleList(
            context: Context,
            options: List<String>,
            callback: DialogInterface.OnClickListener
    ): AlertDialog {
        val finalOptions: Array<String> = options.toTypedArray()
        return AlertDialog.Builder(context)
                .setCancelable(true)
                .setItems(finalOptions, callback)
                .create()
    }

    fun showDialogYesOrNot(context: Context, message: String, callback: () -> Unit) {
        if (context is AppCompatActivity && context.isFinishing.not()) {
            val callbackNo = DialogInterface.OnClickListener { dialog, _ -> dialog.dismiss() }
            val callbackYes = DialogInterface.OnClickListener { dialog, interfac ->
                run {
                    dialog.dismiss()
                    callback.invoke()
                }
            }

            val title = context.getString(R.string.atencao)
            "DIALOG: $title - $message".toLogcat()

            val dialog = showDialogYesOrNot(context, title, message, callbackYes, callbackNo)
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
        }
    }

    fun showDialogYesOrNot(
        context: Context,
        title: String,
        message: String,
        callbackYes: DialogInterface.OnClickListener,
        callbackNo: DialogInterface.OnClickListener
    ): AlertDialog {
        val builder = AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(context.getString(R.string.yes), callbackYes)
                .setNegativeButton(context.getString(R.string.no), callbackNo)

        return builder.create()
    }

    fun showDialogYesOrNot(
            context: Context,
            title: String,
            message: String,
            onYes: () -> Unit,
            onNo: (() -> Unit)? = null
    ): AlertDialog {
        val callbackYes = DialogInterface.OnClickListener { dialog, _ ->
            dialog.dismiss()
            onYes.invoke()
        }

        val callbackNo = DialogInterface.OnClickListener { dialog, _ ->
            dialog.dismiss()
            onNo?.invoke()
        }

        val dialog = showDialogYesOrNot(context, title, message, callbackYes, callbackNo)
        dialog.show()
        return dialog
    }

}