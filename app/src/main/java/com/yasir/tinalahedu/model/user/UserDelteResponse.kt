package com.yasir.tinalahedu.model.user

import com.google.gson.annotations.SerializedName

data class UserDeleteRespone(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)