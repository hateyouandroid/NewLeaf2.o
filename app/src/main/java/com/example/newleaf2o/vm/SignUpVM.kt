package com.example.newleaf2o.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.data.GetRegisterResponse
import com.example.newleaf2o.data.request.GetRegisterRequest
import com.example.newleaf2o.data.response.AddAddressResponse
import com.example.newleaf2o.retrofit.APIClient
import com.example.newleaf2o.retrofit.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpVM:ViewModel() {
    var apiSerVice: ApiServices = APIClient.getRetrofit().create(ApiServices::class.java)

    val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

    val _isProgress = MutableLiveData<Boolean>()
    val isProgress: LiveData<Boolean>
        get() = _isProgress

    val _addAdressResult = MutableLiveData<AddAddressResponse>()
    val addAddressResponse: LiveData<AddAddressResponse>
        get() = _addAdressResult

    val _registerRequest = MutableLiveData<GetRegisterResponse>()
    val getRegisterResponse: LiveData<GetRegisterResponse>
        get() = _registerRequest


    fun register(request: GetRegisterRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiSerVice.register(request)

            call.enqueue(object : Callback<GetRegisterResponse> {
                override fun onResponse(
                    call: Call<GetRegisterResponse>,
                    response: Response<GetRegisterResponse>
                ) {
                    _registerRequest.postValue(response.body())
                }

                override fun onFailure(call: Call<GetRegisterResponse>, t: Throwable) {
                    _msg.postValue(t.message)
                }
            })
        }
}
}