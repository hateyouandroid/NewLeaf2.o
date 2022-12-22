package com.example.newleaf2o


import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.data.request.LoginResquest
import com.example.newleaf2o.databinding.ActivityLoginBinding
import com.example.newleaf2o.retrofit.ApiServices
import com.example.newleaf2o.vm.LoginVM


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var vm:LoginVM
    private lateinit var apiServices: ApiServices
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(this)[LoginVM::class.java]
        val sharedPref = getSharedPreferences("shaPref", MODE_PRIVATE)
        val editor =sharedPref.edit()

        onClick()
        observers()


//SharedPreference
        binding.apply {
            btLogin.setOnClickListener {
                val mail = etEmail.text.toString()
                val password = etPass.text.toString()

                editor.apply {
                    putString("Mail", mail)
                    putString("Password", password)
                    apply()

                }

            }
            /*
            btLogin.setOnClickListener {

                val sign = sharedPref.getString("Sign",null)
                val forgot = sharedPref.getString("Forgot",null)

                tvSign.text = sign
                tvForp.text= forgot

        }*/
        }
    }

    private fun observers() {
    vm.loginResponse.observe(this){
        Toast.makeText(this,it.ResponseMsg,Toast.LENGTH_LONG).show()
    }
   }

    private fun onClick() {
    binding.btLogin.setOnClickListener{
        vm.login(loginRequest())
    }
    }
      private fun loginRequest(): LoginResquest{
        return LoginResquest(
            "123456765432189",
            "8833356789",
            binding.etPass.text.toString().trim()

        )
    }
}