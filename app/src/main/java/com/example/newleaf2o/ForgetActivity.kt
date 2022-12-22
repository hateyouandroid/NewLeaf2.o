package com.example.newleaf2o

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.Data.Request.forgotpass_request
import com.example.newleaf2o.Model.LoginVM
import com.example.newleaf2o.databinding.ActivityForgetBinding

class ForgetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgetBinding
    lateinit var vm:LoginVM
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityForgetBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this)[LoginVM::class.java]
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onClick()
    }

    private fun onClick() {
        binding.forgetOtp.setOnClickListener {
            vm.userForgot(getforgetResponse())
            Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
        }
    }

    private fun getforgetResponse(): forgotpass_request {
        return forgotpass_request(
            "91",binding.mobileNo.text.toString().trim()
        )
    }
}