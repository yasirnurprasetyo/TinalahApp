package com.yasir.tinalahedu.model.user

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class UserData(
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
    @SerializedName("create_at")
    val createAt: String,
    @SerializedName("update_at")
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
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(idUser)
        writeString(nameUser)
        writeString(emailUser)
        writeString(passwordUser)
        writeString(phoneUser)
        writeString(imageUser)
        writeString(imageUrl)
        writeString(tokenUser)
        writeString(tokenExpiredUser)
        writeString(roleUser)
        writeString(createAt)
        writeString(updateAt)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<UserData> = object : Parcelable.Creator<UserData> {
            override fun createFromParcel(source: Parcel): UserData = UserData(source)
            override fun newArray(size: Int): Array<UserData?> = arrayOfNulls(size)
        }
    }
}
