package com.example.newleaf2o.Data.Response

data class ResultData(
    val IS_UPDATE_NEED: Boolean,
    val area: String,
    val delivery_charge: Any,
    val hno: String,
    val id: String,
    val landmark: String,
    val name: String,
    val pincode: String,
    val society: String,
    val status: String,
    val type: String,
    val uid: String
)