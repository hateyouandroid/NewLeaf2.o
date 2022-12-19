package com.example.newleaf2o

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.Data.Request.login_request
import com.example.newleaf2o.Data.Request.register_request
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

    private val _loginResult = MutableLiveData<login_response>()
    val loginResult: LiveData<login_response>
        get() = _loginResult

    private val _resgisterUser = MutableLiveData<register_response>()
    val registerUser: LiveData<register_response>
        get() = _resgisterUser

    fun userLogin(request: login_request) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiService.userLogin(request)
            call.enqueue(object : Callback<login_response> {
                override fun onResponse(
                    call: Call<login_response>,
                    response: Response<login_response>
                ) {

                    _loginResult.postValue(response.body())
                }

                override fun onFailure(call: Call<login_response>, t: Throwable) {
                    _msg.postValue(t.message)
                }

            })
        }
    }
//Api call for regsister Api
    fun userRegister(request: register_request) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiService.userRegister(request)
            call.enqueue(object : Callback<register_response> {
                override fun onResponse(
                    call: Call<register_response>,
                    response: Response<register_response>
                ) {

                    _resgisterUser.postValue(response.body())
                }

                override fun onFailure(call: Call<register_response>, t: Throwable) {
                    _msg.postValue(t.message)
                }

            })
        }
    }


}