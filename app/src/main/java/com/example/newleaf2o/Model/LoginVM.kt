package com.example.newleaf2o.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.Data.Request.forgotpass_request
import com.example.newleaf2o.Data.Request.login_request
import com.example.newleaf2o.Data.Response.forgotpass_response
import com.example.newleaf2o.Data.Response.login_response
import com.example.newleaf2o.mainVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginVM:mainVM() {
    private val _loginResult = MutableLiveData<login_response>()
    val loginResult: LiveData<login_response>
        get() = _loginResult

    private val _forgotpass = MutableLiveData<forgotpass_response>()
    val forgotPassword: LiveData<forgotpass_response>
        get() = _forgotpass


    //Api call for login
    fun userLogin(request: login_request) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiService.userLogin(request)
            call.enqueue(object : Callback<login_response> {
                override fun onResponse(
                    call: Call<login_response>,
                    response: Response<login_response>,
                ) {

                    _loginResult.postValue(response.body())
                }

                override fun onFailure(call: Call<login_response>, t: Throwable) {
                    _msg.postValue(t.message)
                }

            })
        }
    }

    //Api call for Forgot Password
    fun userForgot(request: forgotpass_request) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiService.userForgot(request)
            call.enqueue(object : Callback<forgotpass_response> {
                override fun onResponse(
                    call: Call<forgotpass_response>,
                    response: Response<forgotpass_response>,
                ) {

                    _forgotpass.postValue(response.body())
                }

                override fun onFailure(call: Call<forgotpass_response>, t: Throwable) {
                    _msg.postValue(t.message)
                }

            })
        }
    }

}