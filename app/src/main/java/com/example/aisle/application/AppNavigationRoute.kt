package com.example.aisle.application

import android.content.Context
import android.content.Intent
import com.example.aisle.auth.presentation.activity.LoginViaPhoneActivity
import com.example.aisle.auth.presentation.activity.OtpVerificationActivity
import com.example.aisle.notes.presentation.activity.NotesActivity
import com.example.aisle.utils.Constants

object AppNavigationRoute {

    fun openOtpVerificationActivity(context: Context, phone: String) {
        context.startActivity(Intent(context, OtpVerificationActivity::class.java).apply {
            putExtra(Constants.PHONE_NUMBER, phone)
        })
    }

    fun openLoginViaPhoneActivity(context: Context) {
        context.startActivity(Intent(context, LoginViaPhoneActivity::class.java))
    }

    fun openNotesActivityAndKillOthers(context: Context) {
        val intent = Intent(context, NotesActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
    }
}