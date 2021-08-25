package com.yasir.tinalahedu.model.scan

import com.google.gson.annotations.SerializedName

data class ScanResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: ScanData,
    @SerializedName("status")
    val status: Boolean
)
