package com.example.newleaf2o.Data.Request

data class register_request(
    val ccode: String,
    val email: String,
    val imei: String,
    val mobile: String,
    val name: String,
    val password: String
)