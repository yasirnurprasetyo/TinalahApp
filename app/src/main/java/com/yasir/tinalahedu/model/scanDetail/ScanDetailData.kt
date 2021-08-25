package com.yasir.tinalahedu.model.scanDetail

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ScanDetailData(
    @SerializedName("id_scan")
    val idScan : String,
    @SerializedName("gambar_scan")
    val gambarScan : String,
    @SerializedName("poin")
    val poin : String,
    @SerializedName("image_url")
    val imageUrl : String,
    @SerializedName("objek_id")
    val objekId : String,
    @SerializedName("id_gambar")
    val idGambar : String,
    @SerializedName("nama_gambar")
    val namaGambar : String,
    @SerializedName("kategori")
    val kategori : String,
    @SerializedName("deskripsi")
    val deskripsi : String,
    @SerializedName("gambar")
    val gambar : String,
    @SerializedName("gambar_url")
    val gambarUrl : String
) : Parcelable {
    constructor(source: Parcel) : this (
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

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(idScan)
        writeString(gambarScan)
        writeString(poin)
        writeString(imageUrl)
        writeString(objekId)
        writeString(idGambar)
        writeString(namaGambar)
        writeString(kategori)
        writeString(deskripsi)
        writeString(gambar)
        writeString(gambarUrl)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ScanDetailData> = object : Parcelable.Creator<ScanDetailData> {
            override fun createFromParcel(source: Parcel): ScanDetailData = ScanDetailData(source)
            override fun newArray(size: Int): Array<ScanDetailData?> = arrayOfNulls(size)
        }
    }
}
