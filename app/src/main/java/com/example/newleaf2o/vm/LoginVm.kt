package com.example.newleaf2o.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.base.MainVm
import com.example.newleaf2o.data_class.request.RegisterRequest
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
}