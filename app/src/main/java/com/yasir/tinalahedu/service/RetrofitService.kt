package com.yasir.tinalahedu.service

import com.yasir.tinalahedu.model.game.VerifyResponse
import com.yasir.tinalahedu.model.highScore.HighscoreResponse
import com.yasir.tinalahedu.model.history.HistoryResponse
import com.yasir.tinalahedu.model.history.IdentifyHistoryResponse
import com.yasir.tinalahedu.model.identify.IdentifyResponse
import com.yasir.tinalahedu.model.identifyDetail.IdentifyDetailResponse
import com.yasir.tinalahedu.model.login.LoginResponse
import com.yasir.tinalahedu.model.scan.ScanResponse
import com.yasir.tinalahedu.model.scanDetail.DetailScanResponse
import com.yasir.tinalahedu.model.scanDetail.ScanDetailResponse
import com.yasir.tinalahedu.model.user.UserDeleteRespone
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
    @POST("highscore")
    fun verifiyTokenHighScore(@Field("token_game") tokenGame : String) : Deferred<VerifyResponse>

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

    @GET("history/{user_id}")
    fun getHistoryScanByUserLogin(@Path("user_id") userId : String): Deferred<HistoryResponse>

    @GET("identifyhistory/{user_id}")
    fun getHistoryIdentifyByIdUser(@Path("user_id") userId: String): Deferred<IdentifyHistoryResponse>

    @GET("highscore")
    fun getHighScore() : Deferred<HighscoreResponse>

    @GET("highscore/{tokengame_id}")
    fun getHighScoreById(@Path("tokengame_id") tokengameId: String) : Deferred<HighscoreResponse>

    @FormUrlEncoded
    @POST("identify")
    fun identifyObjek(
        @Field("id_identify") idIdentify: String,
        @Field("gambar_identify") gambarIdentify: String,
        @Field("gambar_identify_url") idIdentifyUrl: String,
        @Field("gambar_id_identify") gambarIdIdentify: String,
        @Field("user_id_identify") userIdIdentify: String
    ) : Deferred<IdentifyResponse>

    @GET("scan/{user_id}")
    fun getDetailScanGame(@Path("user_id") userId : String) : Deferred<ScanDetailResponse>

    @GET("scan")
    fun getDetailScanGame() : Deferred<DetailScanResponse>

    @GET("identify/{id_user}")
    fun getDetailIdentify(@Path("id_user") userId : String) : Deferred<IdentifyDetailResponse>

    @DELETE("user/{id_user}")
    fun nonAktifAkun(@Path("id_user") userId: String): Deferred<UserDeleteRespone>
}