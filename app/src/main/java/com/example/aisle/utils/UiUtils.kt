package com.example.aisle.utils

import android.app.Activity
import android.util.Log
import android.widget.Toast
import java.util.concurrent.TimeUnit

object UiUtils {

    private const val TAG = "Aisle => "

    fun Activity.showToast(message: String) {
        this.runOnUiThread {
            Toast.makeText(this@showToast, message, Toast.LENGTH_SHORT).show()
        }
    }

    fun showLogD(message: String) {
        Log.d(TAG, message)
    }

    fun showLogE(message: String?) {
        Log.e(TAG, message ?: "Error")
    }

    fun timeFormat(millis : Long): String {
        return String.format("%02d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(millis) -
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
            TimeUnit.MILLISECONDS.toSeconds(millis) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)))
    }
}