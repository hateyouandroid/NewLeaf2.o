package com.example.newleaf2o

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.data.request.GetRegisterRequest
import com.example.newleaf2o.databinding.ActivitySignUpBinding
import com.example.newleaf2o.retrofit.ApiServices
import com.example.newleaf2o.vm.SignUpVM

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var db: SQLiteHelper
    private lateinit var vm: SignUpVM
    private lateinit var apiServices: ApiServices
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        vm = ViewModelProvider(this)[SignUpVM::class.java]
        onClick()
        observers()
    }

    private fun observers() {
        vm.getRegisterResponse.observe(this) {
            Toast.makeText(this, it.ResponseMsg, Toast.LENGTH_LONG).show()
        }
    }

    private fun onClick() {
        binding.btSave.setOnClickListener {
            vm.register(getRegisterRequest())
                    }
    }

    private fun getRegisterRequest(): GetRegisterRequest {
        return GetRegisterRequest(

            "13",
            binding.etMail.text.toString().trim(),
            "23",
            binding.etContact.text.toString().trim(),
            binding.etUsername.text.toString().trim(),
            binding.etPassword.text.toString().trim()
        )
    }

}



