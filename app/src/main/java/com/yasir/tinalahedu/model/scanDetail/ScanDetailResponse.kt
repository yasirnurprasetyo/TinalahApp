package com.yasir.tinalahedu.model.scanDetail


import com.google.gson.annotations.SerializedName

data class ScanDetailResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: Result,
    @SerializedName("status")
    val status: Boolean
)