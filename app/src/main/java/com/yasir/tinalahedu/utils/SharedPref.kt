package com.yasir.tinalahedu.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.yasir.tinalahedu.model.game.GameData
import com.yasir.tinalahedu.model.login.LoginResult

class SharedPref(activity: Activity) {
    val login = "login"
    val nama = "nama"
    val phone = "phone"
    val email = "email"
    val id = "id_user"
    val tokenId = "id_token"

    val user = "user"
    val token = "token"

    val mypref = "MAIN_PRF"
    val mypref2 = "MAIN_PRF2"
    val sp : SharedPreferences

    init {
        sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status: Boolean){
        sp.edit().putBoolean(login, status).apply()
    }

    fun getStatusLogin(): Boolean{
        return sp.getBoolean(login, false)
    }

    fun setUser(value: LoginResult) {
        val data: String = Gson().toJson(value, LoginResult::class.java)
        sp.edit().putString(user, data).apply()
    }

    fun getUser(): LoginResult? {
        val data:String = sp.getString(user, null) ?: return null
        return Gson().fromJson<LoginResult>(data, LoginResult::class.java)
    }

    fun setToken(value : GameData){
        val data : String = Gson().toJson(value, GameData::class.java)
        sp.edit().putString(token, data).apply()
    }
    fun setTokenNull(token : String){
        sp.edit().putString(token, "").apply()
    }

    fun getToken(): GameData? {
        val data : String = sp.getString(token, null) ?: return null
        return  Gson().fromJson<GameData>(data, GameData::class.java)
    }
}