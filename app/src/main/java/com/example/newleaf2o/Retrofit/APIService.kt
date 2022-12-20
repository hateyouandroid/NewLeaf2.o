package com.example.newleaf2o.Retrofit

import com.example.newleaf2o.Data.Request.*
import com.example.newleaf2o.Data.Response.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {
    @POST("login.php")
    fun userLogin(@Body request: login_request): Call<login_response>

    @POST("register.php")
    fun userRegister(@Body request: register_request): Call<register_response>

    @POST("forgot.php")
    fun userForgot(@Body request: forgotpass_request): Call<forgotpass_response>

    @POST("address.php")
    fun userAddress(@Body request: add_address_request): Call<add_address_response>

    @POST("cat.php")
    fun category(@Body request: category_request): Call<category_response>

}
