package com.yasir.tinalahedu.model.game


import com.google.gson.annotations.SerializedName

data class VerifyResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: GameData,
    @SerializedName("status")
    val status: Boolean
)