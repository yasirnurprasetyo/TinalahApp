package com.yasir.tinalahedu

import com.yasir.tinalahedu.model.login.LoginResponse


interface LoginView {

    fun showLoading()

    fun error(error: Throwable?)

    fun success(response: LoginResponse)

    fun hideLoading()

}