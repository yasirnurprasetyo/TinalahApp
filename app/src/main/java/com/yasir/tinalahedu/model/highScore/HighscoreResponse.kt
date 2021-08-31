package com.yasir.tinalahedu.model.highScore


import com.google.gson.annotations.SerializedName

data class HighscoreResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<Result>,
    @SerializedName("status")
    val status: Boolean
)