package com.yasir.tinalahedu.model.scanDetail


import com.google.gson.annotations.SerializedName

data class DetailScanResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<Result>,
    @SerializedName("status")
    val status: Boolean
)