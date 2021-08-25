package com.yasir.tinalahedu.model.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("result")
    val loginResult: LoginResult,
    @SerializedName("status")
    val status: Boolean
)