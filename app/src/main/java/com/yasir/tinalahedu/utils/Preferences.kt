package com.yasir.tinalahedu

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.yasir.tinalahedu.model.login.LoginResult

object Preferences {
    fun getToken(context: Context): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString("token", "")
    }
    fun saveToken(context: Context, token: String): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor = prefs.edit()
        prefsEditor.putString("token", token)
        prefsEditor.apply()
        return true
    }

    fun saveUsername(token: String, context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor = prefs.edit()
        prefsEditor.putString("username", token)
        prefsEditor.apply()
        return true
    }

    fun getUsername(context: Context): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString("username", "")
    }

    fun savePassword(token: String, context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor = prefs.edit()
        prefsEditor.putString("password", token)
        prefsEditor.apply()
        return true
    }

    fun getPassword(context: Context): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString("password", "")
    }

    fun saveTokenGameNull(tokengame: String, context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val prefsEditor = prefs.edit()
        prefsEditor.putString("tokengame", tokengame)
        prefsEditor.apply()
        return true
    }

    fun getTokenGame(context: Context): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString("tokengame", "")
    }
}