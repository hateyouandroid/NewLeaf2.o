package com.example.newleaf2o.data_class.response

data class LoginResponse(
    val ResponseCode: String,
    val ResponseMsg: String,
    val Result: String,
    val d_charge: Any,
    val user: User
)

data class User(
    val ccode: String="",
    val email: String="",
    val id: String="",
    val imei: String="",
    val mobile: String="",
    val name: String="",
    val password: String="",
    val pin: String="",
    val rdate: String="",
    val status: String=""
)