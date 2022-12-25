package com.example.newleaf2o

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.newleaf2o.Data.Response.Data

abstract class BaseActivity<_binding : ViewBinding>(val bindingFactory:(LayoutInflater) ->_binding):
    AppCompatActivity(){

        lateinit var binding: _binding
   // lateinit var progressBar: ProgressBarHandler
    //lateinit var sharePref: SharePref
    lateinit var user: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
        initVM()
        setObserver()
        onClick()

    }
    open fun onClick(){}
    open fun initVM(){}
    open fun setObserver(){}
}