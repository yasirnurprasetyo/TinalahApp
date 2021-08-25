package com.yasir.tinalahedu.model.history


import com.google.gson.annotations.SerializedName

data class HistoryResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val historyData: List<HistoryData>,
    @SerializedName("status")
    val status: Boolean
)