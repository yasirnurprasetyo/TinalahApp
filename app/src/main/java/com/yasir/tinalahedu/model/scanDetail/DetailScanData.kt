package com.yasir.tinalahedu.model.scanDetail


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.yasir.tinalahedu.model.history.HistoryData

data class DetailScanData(
    @SerializedName("id_scan")
    val idScan: String,
    @SerializedName("gambar_id")
    val gambarId: String,
    @SerializedName("tokengame_id")
    val tokengameId: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("gambar_scan")
    val gambarScan: String,
    @SerializedName("gambar_scan_url")
    val gambarScanUrl: String,
    @SerializedName("total_skor")
    val totalSkor: String,
//    @SerializedName("create_at")
//    val createAt: String,
//    @SerializedName("update_at")
//    val updateAt: String,
    @SerializedName("id_user")
    val idUser: String,
    @SerializedName("name_user")
    val nameUser: String,
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
//    @SerializedName("create_at_user")
//    val createAtUser: String,
//    @SerializedName("update_at_user")
//    val updateAtUser: String,
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
//    @SerializedName("create_at_gambar")
//    val createAtGambar: String,
//    @SerializedName("update_at_gambar")
//    val updateAtGambar: String,
    @SerializedName("id_tokengame")
    val idTokengame: String,
    @SerializedName("nama_tokengame")
    val namaTokengame: String,
    @SerializedName("catatan_tokengame")
    val catatanTokengame: String,
    @SerializedName("token_game")
    val tokenGame: String,
    @SerializedName("token_game_expired")
    val tokenGameExpired: String,
    @SerializedName("is_active_tokengame")
    val isActiveTokengame: String,
//    @SerializedName("create_at_tokengame")
//    val createAtTokengame: String,
//    @SerializedName("update_at_tokengame")
//    val updateAtTokengame: String,
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
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
//        source.readString(),
//        source.readString(),
//        source.readString(),
//        source.readString(),
//        source.readString(),
//        source.readString(),
//        source.readString(),
//        source.readString(),
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest){
        writeString(idScan)
        writeString(gambarId)
        writeString(tokengameId)
        writeString(userId)
        writeString(gambarScan)
        writeString(gambarScanUrl)
        writeString(totalSkor)
//        writeString(createAt)
//        writeString(updateAt)
        writeString(idUser)
        writeString(nameUser)
        writeString(passwordUser)
        writeString(phoneUser)
        writeString(imageUser)
        writeString(imageUrl)
        writeString(tokenUser)
        writeString(tokenExpiredUser)
        writeString(roleUser)
//        writeString(createAtUser)
//        writeString(updateAtUser)
        writeString(idGambar)
        writeString(namaGambar)
        writeString(kategoriGambar)
        writeString(deskripsiGambar)
        writeString(gambar)
        writeString(gambarUrl)
//        writeString(createAtGambar)
//        writeString(updateAtGambar)
        writeString(idTokengame)
        writeString(namaTokengame)
        writeString(catatanTokengame)
        writeString(tokenGame)
        writeString(tokenGameExpired)
        writeString(isActiveTokengame)
//        writeString(createAtTokengame)
//        writeString(updateAtTokengame)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<DetailScanData> = object : Parcelable.Creator<DetailScanData> {
            override fun createFromParcel(source: Parcel): DetailScanData = DetailScanData(source)
            override fun newArray(size: Int): Array<DetailScanData?> = arrayOfNulls(size)
        }
    }
}