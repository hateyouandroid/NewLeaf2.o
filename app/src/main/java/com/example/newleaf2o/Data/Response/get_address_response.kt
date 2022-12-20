package com.example.newleaf2o.Data.Response

data class get_address_response(
    val ResponseCode: String,
    val ResponseMsg: String,
    val Result: String,
    val ResultData: List<ResultData>
)