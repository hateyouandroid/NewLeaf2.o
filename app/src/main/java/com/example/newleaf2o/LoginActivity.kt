package com.example.newleaf2o

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.Data.Request.login_request
import com.example.newleaf2o.Model.LoginVM
import com.example.newleaf2o.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var vm: LoginVM
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this)[LoginVM::class.java]
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onClick()
        observer()
    }

    private fun observer() {
        vm.loginResult.observe(this)
        {
            Toast.makeText(this,it.ResponseMsg,Toast.LENGTH_LONG).show()
        }
    }

    private fun onClick() {
        binding.btLogin.setOnClickListener {
                vm.userLogin(getLoginResponse())
        }
        binding.tvForgot.setOnClickListener {

        }
    }

    private fun getLoginResponse(): login_request {

        return login_request(
            "111181818283467",
            binding.etEmail.text.toString().trim(),
            binding.etPass.text.toString().trim()
        )
    }
}