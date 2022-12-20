package com.example.newleaf2o

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newleaf2o.Retrofit.APIClient

open class mainVM : ViewModel() {
    var apiService: APIService = APIClient.getRetrofit().create(APIService::class.java)

    val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

}