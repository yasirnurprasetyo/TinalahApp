package com.yasir.tinalahedu.model.identify

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class IdentifyData(
    @SerializedName("id_identify")
    val idIdentify: String,
    @SerializedName("gambar_identify")
    val gambarIdentify: String,
    @SerializedName("gambar_identify_url")
    val gambarIdentifyUrl: String,
    @SerializedName("gambar_id_identify")
    val gambarIdIdentify: String,
    @SerializedName("user_id_identify")
    val userIdIdentify: String,
) : Parcelable {
    constructor(source : Parcel) : this (
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(idIdentify)
        writeString(gambarIdentify)
        writeString(gambarIdentifyUrl)
        writeString(gambarIdIdentify)
        writeString(userIdIdentify)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<IdentifyData> = object : Parcelable.Creator<IdentifyData> {
            override fun createFromParcel(source: Parcel): IdentifyData = IdentifyData(source)
            override fun newArray(size: Int): Array<IdentifyData?> = arrayOfNulls(size)
        }
    }
}
