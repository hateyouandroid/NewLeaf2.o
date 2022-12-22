package com.example.newleaf2o.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.data.request.LoginResquest
import com.example.newleaf2o.data.response.LoginResponse
import com.example.newleaf2o.retrofit.APIClient
import com.example.newleaf2o.retrofit.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginVM: ViewModel() {
        var apiSerVice: ApiServices = APIClient.getRetrofit().create(ApiServices::class.java)

        val _msg = MutableLiveData<String>()
        val msg: LiveData<String>
            get() = _msg

        val _isProgress = MutableLiveData<Boolean>()
        val isProgress: LiveData<Boolean>
            get() = _isProgress

        val _loginResult= MutableLiveData<LoginResponse>()
        val loginResponse:LiveData<LoginResponse>
        get()=_loginResult

        fun login(request: LoginResquest) {
            viewModelScope.launch(Dispatchers.IO) {
                val call = apiSerVice.login(request)

            }
        }

}