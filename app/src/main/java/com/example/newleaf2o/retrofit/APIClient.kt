package com.example.newleaf2o.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object APIClient {
        private var BASE_URL: String = "https://neworganicleaf.com/web-admin-login/api/"
        private lateinit var retrofit: Retrofit
        var clients = UnsafeOkHttpClient.unsafeOkHttpClient


        private val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        private val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
        }.build()

        fun getRetrofit(): Retrofit {


            val gson = GsonBuilder()
                .setLenient()
                .create()

            retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(clients)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()

            return retrofit
        }
    }
