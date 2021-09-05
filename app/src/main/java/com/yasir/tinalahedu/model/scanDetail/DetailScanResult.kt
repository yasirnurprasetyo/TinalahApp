package com.yasir.tinalahedu.model.scanDetail


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("catatan_tokengame")
    val catatanTokengame: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("created_at_gambar")
    val createdAtGambar: String,
    @SerializedName("created_at_tokengame")
    val createdAtTokengame: String,
    @SerializedName("created_at_user")
    val createdAtUser: String,
    @SerializedName("deskripsi_gambar")
    val deskripsiGambar: String,
    @SerializedName("email_user")
    val emailUser: String,
    @SerializedName("gambar")
    val gambar: String,
    @SerializedName("gambar_id")
    val gambarId: String,
    @SerializedName("gambar_scan")
    val gambarScan: String,
    @SerializedName("gambar_scan_url")
    val gambarScanUrl: String,
    @SerializedName("gambar_url")
    val gambarUrl: String,
    @SerializedName("id_gambar")
    val idGambar: String,
    @SerializedName("id_scan")
    val idScan: String,
    @SerializedName("id_tokengame")
    val idTokengame: String,
    @SerializedName("id_user")
    val idUser: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("image_user")
    val imageUser: String,
    @SerializedName("is_active_tokengame")
    val isActiveTokengame: String,
    @SerializedName("kategori_gambar")
    val kategoriGambar: String,
    @SerializedName("nama_gambar")
    val namaGambar: String,
    @SerializedName("nama_tokengame")
    val namaTokengame: String,
    @SerializedName("name_user")
    val nameUser: String,
    @SerializedName("password_user")
    val passwordUser: String,
    @SerializedName("phone_user")
    val phoneUser: String,
    @SerializedName("role_user")
    val roleUser: String,
    @SerializedName("token_expired_user")
    val tokenExpiredUser: String,
    @SerializedName("token_game")
    val tokenGame: String,
    @SerializedName("token_game_expired")
    val tokenGameExpired: String,
    @SerializedName("token_user")
    val tokenUser: String,
    @SerializedName("tokengame_id")
    val tokengameId: String,
    @SerializedName("total_skor")
    val totalSkor: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("updated_at_gambar")
    val updatedAtGambar: String,
    @SerializedName("updated_at_tokengame")
    val updatedAtTokengame: String,
    @SerializedName("updated_at_user")
    val updatedAtUser: String,
    @SerializedName("user_id")
    val userId: String
)