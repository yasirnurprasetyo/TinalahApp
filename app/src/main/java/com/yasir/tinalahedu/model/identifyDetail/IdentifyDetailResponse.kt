package com.yasir.tinalahedu.model.identifyDetail


import com.google.gson.annotations.SerializedName

data class IdentifyDetailResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val identifyDetailData: IdentifyDetailData,
    @SerializedName("status")
    val status: Boolean
)