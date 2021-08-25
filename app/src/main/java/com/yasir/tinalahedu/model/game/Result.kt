package com.yasir.tinalahedu.model.game


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("nama_kelompok")
    val namaKelompok: String
)