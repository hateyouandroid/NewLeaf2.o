package com.example.newleaf2o

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.data.request.ForgotRequest
import com.example.newleaf2o.databinding.ActivityForgotBinding
import com.example.newleaf2o.retrofit.ApiServices
import com.example.newleaf2o.vm.ForgotVM

class ForgotActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotBinding
    private lateinit var apiServices: ApiServices
    private lateinit var vm:ForgotVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityForgotBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_forgot)
        vm=ViewModelProvider(this)[ForgotVM::class.java]
        onClick()
        observers()
    }

    private fun observers() {
    vm.forgotResponse.observe(this){
        Toast.makeText(this,it.ResponseMsg,Toast.LENGTH_LONG).show()
    }
    }

    private fun onClick() {
    binding.btSave.setOnClickListener {
        vm.forgotPassword(forgotRequest())
    }
    }
    private fun forgotRequest():ForgotRequest{
        return ForgotRequest(
            "91",
            "2345678988"

        )
    }
}