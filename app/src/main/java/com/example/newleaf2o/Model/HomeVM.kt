package com.example.newleaf2o.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.Data.Request.add_address_request
import com.example.newleaf2o.Data.Request.category_request
import com.example.newleaf2o.Data.Request.register_request
import com.example.newleaf2o.Data.Response.add_address_response
import com.example.newleaf2o.Data.Response.category_response
import com.example.newleaf2o.Data.Response.register_response
import com.example.newleaf2o.mainVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeVM : mainVM() {
    private val _resgisterUser = MutableLiveData<register_response>()
    val registerUser: LiveData<register_response>
        get() = _resgisterUser

    private val _addressUser = MutableLiveData<add_address_response>()
    val addressUser: LiveData<add_address_response>
        get() = _addressUser

    private val _category = MutableLiveData<category_response>()
    val categoryProduct: LiveData<category_response>
        get() = _category

    //Api call for regsister Api
    fun userRegister(request: register_request) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiService.userRegister(request)
            call.enqueue(object : Callback<register_response> {
                override fun onResponse(
                    call: Call<register_response>,
                    response: Response<register_response>,
                ) {

                    _resgisterUser.postValue(response.body())
                }

                override fun onFailure(call: Call<register_response>, t: Throwable) {
                    _msg.postValue(t.message)
                }

            })
        }
    }

    //Api call for Address Store
    fun userAddress(request: add_address_request) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiService.userAddress(request)
            call.enqueue(object : Callback<add_address_response> {
                override fun onResponse(
                    call: Call<add_address_response>,
                    response: Response<add_address_response>,
                ) {

                    _addressUser.postValue(response.body())
                }

                override fun onFailure(call: Call<add_address_response>, t: Throwable) {
                    _msg.postValue(t.message)
                }

            })
        }
    }

    //Api call for category of product
    fun productCategory(request: category_request) {
        viewModelScope.launch(Dispatchers.IO) {
            val call = apiService.category(request)
            call.enqueue(object : Callback<category_response> {
                override fun onResponse(
                    call: Call<category_response>,
                    response: Response<category_response>,
                ) {

                    _category.postValue(response.body())
                }

                override fun onFailure(call: Call<category_response>, t: Throwable) {
                    _msg.postValue(t.message)
                }

            })
        }
    }

}