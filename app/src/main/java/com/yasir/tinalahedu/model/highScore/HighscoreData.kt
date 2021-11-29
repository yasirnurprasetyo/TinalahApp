package com.yasir.tinalahedu.model.highScore

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class HighscoreData(
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("total_skor")
    val totalSkor: String,
    @SerializedName("name_user")
    val nameUser: String,
    @SerializedName("nama_tokengame")
    val namaTokengame: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest){
        writeString(userId)
        writeString(totalSkor)
        writeString(nameUser)
        writeString(namaTokengame)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<HighscoreData> = object : Parcelable.Creator<HighscoreData> {
            override fun createFromParcel(source: Parcel): HighscoreData = HighscoreData(source)
            override fun newArray(size: Int): Array<HighscoreData?> = arrayOfNulls(size)
        }
    }
}
