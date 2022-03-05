package com.example.homework.network

import com.example.homework.constance.ApiConst
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var sRetrofitInstance: Retrofit
    val client by lazy {
        OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    init {
        sRetrofitInstance = Retrofit.Builder()
            .client(client)
            .baseUrl(ApiConst.HOST)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    fun <T> get(clazz: Class<T>): T {
        return sRetrofitInstance.create(clazz)
    }

}
