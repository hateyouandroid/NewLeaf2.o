package com.example.newleaf2o.base

import com.example.newleaf2o.retrofit.APIClient
import com.example.newleaf2o.retrofit.ApiServise

open class BaseReposetry {
    var apiServise: ApiServise = APIClient.getRetrofit().create(ApiServise::class.java)
}