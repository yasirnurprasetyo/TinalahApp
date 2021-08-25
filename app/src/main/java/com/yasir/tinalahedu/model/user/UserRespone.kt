package com.yasir.tinalahedu.model.user

import com.google.gson.annotations.SerializedName

data class UserRespone(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: UserData,
    @SerializedName("status")
    val status: String
)
