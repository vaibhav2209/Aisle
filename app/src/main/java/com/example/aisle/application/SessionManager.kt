package com.example.aisle.application

import android.content.Context
import javax.inject.Inject

class SessionManager @Inject constructor(
    private val context: Context
) {

    companion object {
        const val SESSION_PREFERENCE = "SESSION_PREFERENCE"
        const val ACCESS_TOKEN = "ACCESS_TOKEN"
    }

    private val sharedPref = context.getSharedPreferences(SESSION_PREFERENCE, Context.MODE_PRIVATE)

    fun putString(key: String, value: String) {
        with(sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(key: String): String {
        return sharedPref.getString(key, "") ?: return ""
    }
}