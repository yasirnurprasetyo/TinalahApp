package com.yasir.tinalahedu.presenter

import android.util.Base64
import com.yasir.tinalahedu.LoginView
import com.yasir.tinalahedu.service.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginPresenter(private val view: LoginView) {
    fun login(username: String, password: String) {
        view.showLoading()
        val auth = "$username:$password"
        val credential = "Basic " + Base64.encodeToString(auth.toByteArray(), Base64.NO_WRAP)
        val api = RetrofitFactory.createLogin()
        val request = api.login(credential)
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = request.await()
                view.success(response)
            } catch (e: Exception) {
                view.error(e)
            }
            view.hideLoading()
        }
    }
}