package com.yasir.tinalahedu.model.identify

import com.google.gson.annotations.SerializedName

class IdentifyDetailResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val identifyResult: List<IdentifyData>,
    @SerializedName("status")
    val status: Boolean
)