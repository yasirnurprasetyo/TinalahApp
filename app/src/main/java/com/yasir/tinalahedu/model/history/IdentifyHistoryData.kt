package com.yasir.tinalahedu.model.history


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("created_at_gambar")
    val createdAtGambar: String,
    @SerializedName("created_at_identify")
    val createdAtIdentify: String,
    @SerializedName("created_at_user")
    val createdAtUser: String,
    @SerializedName("deskripsi_gambar")
    val deskripsiGambar: String,
    @SerializedName("email_user")
    val emailUser: String,
    @SerializedName("gambar")
    val gambar: String,
    @SerializedName("gambar_id_identify")
    val gambarIdIdentify: String,
    @SerializedName("gambar_identify")
    val gambarIdentify: String,
    @SerializedName("gambar_identify_url")
    val gambarIdentifyUrl: String,
    @SerializedName("gambar_url")
    val gambarUrl: String,
    @SerializedName("id_gambar")
    val idGambar: String,
    @SerializedName("id_identify")
    val idIdentify: String,
    @SerializedName("id_user")
    val idUser: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("image_user")
    val imageUser: String,
    @SerializedName("kategori_gambar")
    val kategoriGambar: String,
    @SerializedName("nama_gambar")
    val namaGambar: String,
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
    @SerializedName("token_user")
    val tokenUser: String,
    @SerializedName("updated_at_gambar")
    val updatedAtGambar: String,
    @SerializedName("updated_at_identify")
    val updatedAtIdentify: String,
    @SerializedName("updated_at_user")
    val updatedAtUser: String,
    @SerializedName("user_id_identify")
    val userIdIdentify: String
)