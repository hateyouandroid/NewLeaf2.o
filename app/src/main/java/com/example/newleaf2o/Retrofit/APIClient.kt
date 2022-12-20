package com.example.newleaf2o.Retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    private var BASE_URL: String = "https://neworganicleaf.com/web-admin-login/api/"

    private lateinit var retrofit: Retrofit

    fun getRetrofit(): Retrofit {


        val gson = GsonBuilder()
            .setLenient()
            .create()

        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

        return retrofit
    }
}