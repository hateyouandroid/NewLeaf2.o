package com.example.newleaf2o

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.Data.Request.forgotpass_request
import com.example.newleaf2o.Data.Request.login_request
import com.example.newleaf2o.Data.Request.register_request
import com.example.newleaf2o.Data.Response.forgotpass_response
import com.example.newleaf2o.Data.Response.login_response
import com.example.newleaf2o.Data.Response.register_response
import com.example.newleaf2o.Retrofit.APIClient
import com.example.newleaf2o.Retrofit.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class mainVM : ViewModel() {
    var apiService: APIService = APIClient.getRetrofit().create(APIService::class.java)

    val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

}