package com.example.newleaf2o.retrofit

import com.example.newleaf2o.data_class.request.RegisterRequest
import com.example.newleaf2o.data_class.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServise {
    @POST("register.php")
    fun registerUser(@Body request: RegisterRequest):Call<RegisterResponse>

}