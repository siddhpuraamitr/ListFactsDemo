package com.siddhpuraamitr.androiddemo.service

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://dl.dropboxusercontent.com/"
    var logging = HttpLoggingInterceptor()

    val factService: GetFactService
        get() {
            if (retrofit == null) {
                logging.level = HttpLoggingInterceptor.Level.BASIC

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(GetFactService::class.java)
        }
}
