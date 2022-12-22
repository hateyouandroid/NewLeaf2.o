package com.example.newleaf2o.retrofit

import com.example.newleaf2o.data.ForgotResponse
import com.example.newleaf2o.data.GetRegisterResponse
import com.example.newleaf2o.data.request.*
import com.example.newleaf2o.data.response.AddAddressResponse
import com.example.newleaf2o.data.response.GetAddressResponse
import com.example.newleaf2o.data.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiServices {

    @POST("alist.php")
    fun getAddress( @Body request:GetAddressRequest):Call<GetAddressResponse>

    @POST("address.php")
    fun addAddress(@Body request:AddAddressRequest):Call<AddAddressResponse>

    @POST("forgot.php")
    fun forgotPassword(@Body request: ForgotRequest):Call<ForgotResponse>

    @POST("register.php")
    fun register(@Body request: GetRegisterRequest):Call<GetRegisterResponse>

    @POST("login.php")
    fun login(@Body request:LoginResquest):Call<LoginResponse>
}
