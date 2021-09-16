package com.yasir.tinalahedu.model.scanDetail


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("deskripsi_gambar")
    val deskripsiGambar: String,
    @SerializedName("gambar_id")
    val gambarId: Any,
    @SerializedName("gambar_scan")
    val gambarScan: String,
    @SerializedName("gambar_scan_url")
    val gambarScanUrl: String,
    @SerializedName("id_scan")
    val idScan: String,
    @SerializedName("kategori_gambar")
    val kategoriGambar: String,
    @SerializedName("tokengame_id")
    val tokengameId: String,
    @SerializedName("user_id")
    val userId: String
)