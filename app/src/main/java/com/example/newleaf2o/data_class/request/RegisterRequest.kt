package com.example.newleaf2o.data_class.request

data class RegisterRequest(
    val ccode: String,
    val email: String,
    val imei: String,
    val mobile: String,
    val name: String,
    val password: String
)