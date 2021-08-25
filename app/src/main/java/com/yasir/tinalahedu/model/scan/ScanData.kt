package com.yasir.tinalahedu.model.scan

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ScanData(
    @SerializedName("id_scan")
    val idScan : String,
    @SerializedName("gambar_id")
    val gambarId : String,
    @SerializedName("tokengame_id")
    val tokengameId : String,
    @SerializedName("user_id")
    val userId : String,
    @SerializedName("gambar_scan")
    val gambarScan : String,
    @SerializedName("gambar_scan_url")
    val gambarScanUrl : String,
    @SerializedName("total_skor")
    val totalSkor : String,
    @SerializedName("create_at")
    val createAt : String,
    @SerializedName("update_at")
    val updateAt : String
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
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(idScan)
        writeString(gambarId)
        writeString(tokengameId)
        writeString(userId)
        writeString(gambarScan)
        writeString(gambarScanUrl)
        writeString(totalSkor)
        writeString(createAt)
        writeString(updateAt)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ScanData> = object : Parcelable.Creator<ScanData> {
            override fun createFromParcel(source: Parcel): ScanData = ScanData(source)
            override fun newArray(size: Int): Array<ScanData?> = arrayOfNulls(size)
        }
    }
}
