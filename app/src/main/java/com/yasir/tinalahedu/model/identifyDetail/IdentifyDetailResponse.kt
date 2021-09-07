package com.yasir.tinalahedu.model.identifyDetail


import com.google.gson.annotations.SerializedName

data class IdentifyDetailResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<Result>,
    @SerializedName("status")
    val status: Boolean
)