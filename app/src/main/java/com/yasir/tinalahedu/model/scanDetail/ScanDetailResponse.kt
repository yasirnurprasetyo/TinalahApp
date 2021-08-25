package com.yasir.tinalahedu.model.scanDetail

import com.google.gson.annotations.SerializedName

data class ScanDetailResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<ScanDetailData>,
    @SerializedName("status")
    val status: Boolean
)
