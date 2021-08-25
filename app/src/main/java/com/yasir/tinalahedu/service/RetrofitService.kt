package com.yasir.tinalahedu.service

import com.yasir.tinalahedu.model.game.VerifyResponse
import com.yasir.tinalahedu.model.history.HistoryResponse
import com.yasir.tinalahedu.model.login.LoginResponse
import com.yasir.tinalahedu.model.scan.ScanResponse
import com.yasir.tinalahedu.model.scanDetail.ScanDetailResponse
import com.yasir.tinalahedu.model.user.UserRespone
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface RetrofitService {
    @POST("login")
    fun login(@Header("Authorization") credential: String): Deferred<LoginResponse>

    @FormUrlEncoded
    @POST("user")
    fun register(
        @Field("name_user") nameUser : String,
        @Field("email_user") emailUser : String,
        @Field("password_user") passwordUser : String,
        @Field("phone_user") phoneUser : String,
        @Field("image_user") imageUser : String
    ): Deferred<UserRespone>

    @FormUrlEncoded
    @POST("verify")
    fun verifiyToken(@Field("token_game") tokenGame : String) : Deferred<VerifyResponse>

    @FormUrlEncoded
    @POST("scan")
    fun scanObjek(
        @Field("id_scan") idScan : String,
        @Field("gambar_id") gambarId : String,
        @Field("tokengame_id") tokengameId: String,
        @Field("user_id") userId: String,
        @Field("gambar_scan") gambarScan: String,
        @Field("gambar_scan_url") gambarScanUrl : String,
        @Field("total_skor") totalSkor : String,
        @Field("crate_at") createAt: String,
        @Field("update_at") updateAt: String,
    ) : Deferred<ScanResponse>

    @GET("history")
    fun getHistoryScanByUserLogin(): Deferred<HistoryResponse>
}