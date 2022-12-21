package com.example.newleaf2o.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.base.MainVm
import com.example.newleaf2o.data_class.request.LoginRequest
import com.example.newleaf2o.data_class.request.RegisterRequest
import com.example.newleaf2o.data_class.response.LoginResponse
import com.example.newleaf2o.data_class.response.RegisterResponse
import com.example.newleaf2o.reposetry.LoginReposetry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginVm :MainVm(){



    val _registerResult =MutableLiveData<RegisterResponse>()
    val registerResult:LiveData<RegisterResponse>
    get() = _registerResult

    val _loginResult =MutableLiveData<LoginResponse>()
    val loginResult:LiveData<LoginResponse>
        get() = _loginResult


    fun registerUser(request: RegisterRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiServise.registerUser(request)
            call.enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {

                    _registerResult.postValue(response.body())
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    _msg.postValue(t.message)
                }

            })
        }
    }

    fun loginUser(request: LoginRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiServise.loginUser(request)
            call.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {

                    _loginResult.postValue(response.body())
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    _msg.postValue(t.message)
                }

            })
        }
    }

}