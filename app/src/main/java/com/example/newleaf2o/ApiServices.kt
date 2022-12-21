package com.example.newleaf2o

import retrofit2.http.POST
import retrofit2.http.Query


interface ApiServices {

    @POST("alist.php")
    fun addlist(
        @Query ("Name") name: String,
        @Query ("Home")home: String,
        @Query ("Society")society: String,
        @Query ("Area")area: String,
        @Query ("Landmark")landmark: String,
        @Query ("Pincode")pin_code: String
    )
}