package com.yasir.tinalahedu.model.scanDetail


import com.google.gson.annotations.SerializedName

data class DetailScanResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
//    val detailScanData: List<DetailScanData>,
    val detailScanResult: DetailScanData,
    @SerializedName("status")
    val status: Boolean
)