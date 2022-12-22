package com.example.newleaf2o.data.request

data class GetRegisterRequest(
    val ccode: String,
    val email: String,
    val imei: String,
    val mobile: String,
    val name: String,
    val password: String
)