package com.yasir.tinalahedu.model.history


import com.google.gson.annotations.SerializedName

data class IdentifyHistoryResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val identifyHistoryData: List<IdentifyHistoryData>,
    @SerializedName("status")
    val status: Boolean
)