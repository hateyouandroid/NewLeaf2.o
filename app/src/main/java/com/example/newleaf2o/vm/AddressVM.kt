package com.example.newleaf2o.vm

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.data.request.AddAddressRequest
import com.example.newleaf2o.data.response.AddAddressResponse
import com.example.newleaf2o.retrofit.APIClient
import com.example.newleaf2o.retrofit.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressVM: ViewModel() {
    var apiServise: ApiServices = APIClient.getRetrofit().create(ApiServices::class.java)

    val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

    val _isProgress = MutableLiveData<Boolean>()

    val isProgress: LiveData<Boolean>
        get() = _isProgress

    val _addAdressResult = MutableLiveData<AddAddressResponse>()
    val addAddressResponse: LiveData<AddAddressResponse>
        get() = _addAdressResult

    fun addAddress(request: AddAddressRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiServise.addAddress(request)

            call.enqueue(object : Callback<AddAddressResponse> {
                override fun onResponse(
                    call: Call<AddAddressResponse>,
                    response: Response<AddAddressResponse>
                ) {

                    _addAdressResult.postValue(response.body())
                }

                override fun onFailure(call: Call<AddAddressResponse>, t: Throwable) {
                    _msg.postValue(t.message)
                }
            })
        }
    }


}