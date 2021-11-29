package com.yasir.tinalahedu.model.identify

import com.google.gson.annotations.SerializedName

data class IdentifyResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val identifyResult: IdentifyData,
    @SerializedName("status")
    val status: Boolean
)