package com.example.newleaf2o.Data.Response

data class login_response(
    val ResponseCode: String,
    val ResponseMsg: String,
    val Result: String,
    val d_charge: Any,
    val user: User
)