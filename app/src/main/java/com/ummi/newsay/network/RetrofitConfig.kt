package com.ummi.newsay.network

import com.google.gson.GsonBuilder
import com.ummi.newsay.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//fungsi rebuild adalah mengaktifkan service project kalian
object RetrofitConfig {
    //
    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(interceptor).retryOnConnectionFailure(true)
        .connectTimeout(30, TimeUnit.SECONDS).build()
    val gson = GsonBuilder().setLenient().create()
    val retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(client).addConverterFactory(
            GsonConverterFactory.create(
                gson
            )
        )

}