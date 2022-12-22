package com.example.newleaf2o

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.newleaf2o.Data.Request.forgotpass_request
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
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (vibrator.hasVibrator()) { // Vibrator availability checking
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE)) // New vibrate method for API Level 26 or higher
                } else {
                    vibrator.vibrate(50) // Vibrate method for below API Level 26
                }
            }

        }
        binding.tvForgot.setOnClickListener {
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                val intent = Intent(this,ForgetActivity::class.java)
                startActivity(intent)
            if (vibrator.hasVibrator()) { // Vibrator availability checking
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE)) // New vibrate method for API Level 26 or higher
                } else {
                    vibrator.vibrate(50) // Vibrate method for below API Level 26
                }
            }


        }
        binding.tvSign.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (vibrator.hasVibrator()) { // Vibrator availability checking
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE)) // New vibrate method for API Level 26 or higher
                } else {
                    vibrator.vibrate(50) // Vibrate method for below API Level 26
                }
            }

        }
    }

    private fun getForgetResponse(): forgotpass_request {
        return forgotpass_request(
            "91",""
        )

    }

    private fun getLoginResponse(): login_request {

        return login_request(
            "111181818283467",
            binding.etEmail.text.toString().trim(),
            binding.etPass.text.toString().trim()
        )
    }
}