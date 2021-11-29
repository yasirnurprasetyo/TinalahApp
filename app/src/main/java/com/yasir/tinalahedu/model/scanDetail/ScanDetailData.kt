package com.yasir.tinalahedu.model.scanDetail


import com.google.gson.annotations.SerializedName

data class ScanDetailData(
    @SerializedName("deskripsi_gambar")
    val deskripsiGambarScan: String,
    @SerializedName("gambar_id")
    val gambarIdScan: Any,
    @SerializedName("gambar_scan")
    val gambarScanScan: String,
    @SerializedName("gambar_scan_url")
    val gambarScanUrlScan: String,
    @SerializedName("id_scan")
    val idScanScan : String,
    @SerializedName("kategori_gambar")
    val kategoriGambarScan : String,
    @SerializedName("tokengame_id")
    val tokengameIdScan : String,
    @SerializedName("user_id")
    val userIdScan : String,
    @SerializedName("nama_gambar")
    val namaGambarScan : String,
    @SerializedName("gambar_url")
    val gambarUrl : String
)