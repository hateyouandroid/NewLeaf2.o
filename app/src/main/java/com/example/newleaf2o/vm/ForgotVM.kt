package com.example.newleaf2o.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.data.ForgotResponse
import com.example.newleaf2o.data.request.ForgotRequest
import com.example.newleaf2o.retrofit.APIClient
import com.example.newleaf2o.retrofit.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotVM: ViewModel() {
    var apiSerVice: ApiServices = APIClient.getRetrofit().create(ApiServices::class.java)

    val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

    val _isProgress = MutableLiveData<Boolean>()
    val isProgress: LiveData<Boolean>
        get() = _isProgress

    val _forgotResult = MutableLiveData<ForgotResponse>()
    val forgotResponse: LiveData<ForgotResponse>
        get() = _forgotResult

       fun forgotPassword(request: ForgotRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiSerVice.forgotPassword(request)

            call.enqueue(object : Callback<ForgotResponse> {
                override fun onResponse(
                    call: Call<ForgotResponse>,
                    response: Response<ForgotResponse>
                ) {
                    _forgotResult.postValue(response.body())
                }

                override fun onFailure(call: Call<ForgotResponse>, t: Throwable) {
                    _msg.postValue(t.message)
                }
            })
        }
    }
}