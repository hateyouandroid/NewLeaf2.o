package com.example.newleaf2o.Data.Response

data class category_response(
    val ResponseCode: String,
    val ResponseMsg: String,
    val Result: String,
    val `data`: List<Data>
)