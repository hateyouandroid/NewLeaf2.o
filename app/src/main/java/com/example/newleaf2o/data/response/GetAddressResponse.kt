package com.example.newleaf2o.data.response

import android.security.identity.ResultData

data class GetAddressResponse(
    val ResponseCode: String,
    val ResponseMsg: String,
    val Result: String,
    val ResultData: List<ResultData>
)