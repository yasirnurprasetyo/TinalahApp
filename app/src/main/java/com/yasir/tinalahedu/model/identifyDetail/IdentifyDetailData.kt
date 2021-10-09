package com.yasir.tinalahedu.model.identifyDetail


import com.google.gson.annotations.SerializedName

data class IdentifyDetailResult(
    @SerializedName("id_identify")
    val idIdentify: String,
    @SerializedName("gambar_id_identify")
    val gambarIdIdentify: String,
    @SerializedName("id_gambar")
    val idGambar: String,
    @SerializedName("nama_gambar")
    val namaGambar: String,
    @SerializedName("gambar")
    val gambar: String,
    @SerializedName("kategori_gambar")
    val kategoriGambar: String,
    @SerializedName("deskripsi_gambar")
    val deskripsiGambar: String,
    @SerializedName("gambar_url")
    val gambarUrl: String,
    @SerializedName("user_id_identify")
    val userIdIdentify: String,
    @SerializedName("id_user")
    val idUser: String,
    @SerializedName("name_user")
    val nameUser: String,
    @SerializedName("email_user")
    val emailUser: String,
    @SerializedName("password_user")
    val passwordUser: String,
    @SerializedName("phone_user")
    val phoneUser: String,
    @SerializedName("image_user")
    val imageUser: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("token_user")
    val tokenUser: String,
    @SerializedName("token_expired_user")
    val tokenExpiredUser: String,
    @SerializedName("role_user")
    val roleUser: String,
    @SerializedName("gambar_identify")
    val gambarIdentify: String,
    @SerializedName("gambar_identify_url")
    val gambarIdentifyUrl: String,
)