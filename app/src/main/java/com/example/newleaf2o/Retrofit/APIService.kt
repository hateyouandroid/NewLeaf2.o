package com.example.newleaf2o.Retrofit

import com.example.newleaf2o.Data.Request.login_request
import com.example.newleaf2o.Data.Request.register_request
import com.example.newleaf2o.Data.Response.login_response
import com.example.newleaf2o.Data.Response.register_response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {
    @POST("login.php")
    fun userLogin(@Body request: login_request): Call<login_response>

    @POST("register.php")
    fun userRegister(@Body request: register_request): Call<register_response>

}
