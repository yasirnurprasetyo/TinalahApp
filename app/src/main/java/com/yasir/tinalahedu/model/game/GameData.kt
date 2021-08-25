package com.yasir.tinalahedu.model.game

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class GameData(
    @SerializedName("id_tokengame")
    val idGame: String,
    @SerializedName("nama_tokengame")
    val namaKelompok: String,
    @SerializedName("catatan_tokengame")
    val catatan: String,
    @SerializedName("token_game")
    val tokenGame: String,
    @SerializedName("token_game_expired")
    val tokenGameExpired: String,
    @SerializedName("is_active_tokengame")
    val isActive: String,
    @SerializedName("create_at_tokengame")
    val createAt: String,
    @SerializedName("update_at_tokengame")
    val updateAt: String
) : Parcelable {
    constructor(source: Parcel) : this(
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
        writeString(idGame)
        writeString(namaKelompok)
        writeString(catatan)
        writeString(tokenGame)
        writeString(tokenGameExpired)
        writeString(isActive)
        writeString(createAt)
        writeString(updateAt)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<GameData> = object : Parcelable.Creator<GameData> {
            override fun createFromParcel(source: Parcel): GameData = GameData(source)
            override fun newArray(size: Int): Array<GameData?> = arrayOfNulls(size)
        }
    }
}