package com.yasir.tinalahedu.model.history


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.yasir.tinalahedu.model.user.UserData

data class HistoryData(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deskripsi")
    val deskripsi: String,
    @SerializedName("email_user")
    val emailUser: String,
    @SerializedName("gambar")
    val gambar: String,
    @SerializedName("gambar_scan")
    val gambarScan: String,
    @SerializedName("gambar_url")
    val gambarUrl: String,
    @SerializedName("id_gambar")
    val idGambar: String,
    @SerializedName("id_scan")
    val idScan: String,
    @SerializedName("id_user")
    val idUser: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("image_url_user")
    val imageUrlUser: String,
    @SerializedName("image_user")
    val imageUser: String,
    @SerializedName("kategori")
    val kategori: String,
    @SerializedName("nama_gambar")
    val namaGambar: String,
    @SerializedName("name_user")
    val nameUser: String,
    @SerializedName("objek_id")
    val objekId: String,
    @SerializedName("password_user")
    val passwordUser: String,
    @SerializedName("phone_user")
    val phoneUser: String,
    @SerializedName("poin")
    val poin: String,
    @SerializedName("role_user")
    val roleUser: String,
    @SerializedName("token_expired_user")
    val tokenExpiredUser: String,
    @SerializedName("token_user")
    val tokenUser: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest){
        writeString(createdAt)
        writeString(deskripsi)
        writeString(emailUser)
        writeString(gambar)
        writeString(gambarScan)
        writeString(gambarUrl)
        writeString(idGambar)
        writeString(idScan)
        writeString(idUser)
        writeString(imageUrl)
        writeString(imageUrlUser)
        writeString(imageUser)
        writeString(kategori)
        writeString(namaGambar)
        writeString(nameUser)
        writeString(objekId)
        writeString(passwordUser)
        writeString(phoneUser)
        writeString(poin)
        writeString(roleUser)
        writeString(tokenExpiredUser)
        writeString(tokenUser)
        writeString(updatedAt)
        writeString(userId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<HistoryData> = object : Parcelable.Creator<HistoryData> {
            override fun createFromParcel(source: Parcel): HistoryData = HistoryData(source)
            override fun newArray(size: Int): Array<HistoryData?> = arrayOfNulls(size)
        }
    }
}