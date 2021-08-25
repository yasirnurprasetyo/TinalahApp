package com.yasir.tinalahedu.service

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.yasir.tinalahedu.Preferences
import com.yasir.tinalahedu.utils.ApiConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory {
//    const val BASE_URL = ApiConfig.apiFiskom +"/TinalahWebService/api/v1/"
    const val BASE_URL = ApiConfig.apiWifiPribadi +"/tinalahAPI/api/v1/"
    fun createLogin(): RetrofitService {
        //Inisiasi builder
        val builder = OkHttpClient().newBuilder()
        builder.connectTimeout(15, TimeUnit.SECONDS)
        builder.connectTimeout(15, TimeUnit.SECONDS)
        //Create Logging to watch Log
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.HEADERS
        logging.level = HttpLoggingInterceptor.Level.BODY
        //Adding interceptor
        builder.addInterceptor(logging)
        //Create Client
        val client = builder.build()
        //Setting Retrofit
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        return retrofit.create(RetrofitService::class.java)
    }

    fun create(context: Context): RetrofitService {
        val token = Preferences.getToken(context)
        val builder = OkHttpClient().newBuilder()
        builder.connectTimeout(15, TimeUnit.SECONDS)
        //builder.connectTimeout(15, TimeUnit.SECONDS)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.HEADERS
        logging.level = HttpLoggingInterceptor.Level.BODY

        builder.addInterceptor(logging)
        val addInterceptor = builder.addInterceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("token", token.toString()).build()
            chain.proceed(request)
        }

        val client = builder.build()
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        return retrofit.create(RetrofitService::class.java)
    }
}