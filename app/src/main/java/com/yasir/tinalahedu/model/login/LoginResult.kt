package com.yasir.tinalahedu.model.login


import com.google.gson.annotations.SerializedName

data class LoginResult(
    @SerializedName("email_user")
    val emailUser: String,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("image_user")
    val imageUser: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name_user")
    val nameUser: String,
    @SerializedName("phone_user")
    val phoneUser: String,
    @SerializedName("token_expired_user")
    val tokenExpiredUser: String,
    @SerializedName("token_user")
    val tokenUser: String,
    @SerializedName("id_user")
    val idUser: String
)