package com.example.newleaf2o.base

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newleaf2o.retrofit.APIClient
import com.example.newleaf2o.retrofit.ApiServise

open class MainVm:ViewModel() {
var apiServise:ApiServise=APIClient.getRetrofit().create(ApiServise::class.java)

    val _msg=MutableLiveData<String>()
    val msg:LiveData<String>
    get()=_msg

    val _isProgress = MutableLiveData<Boolean>()

    val isProgress: LiveData<Boolean>
        get() = _isProgress



}