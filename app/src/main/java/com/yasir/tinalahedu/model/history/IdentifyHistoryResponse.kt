package com.yasir.tinalahedu.model.history


import com.google.gson.annotations.SerializedName

data class IdentifyHistoryResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<Result>,
    @SerializedName("status")
    val status: Boolean
)