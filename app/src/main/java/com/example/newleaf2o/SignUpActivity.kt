package com.example.newleaf2o

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.Data.Request.register_request
import com.example.newleaf2o.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    //private lateinit var db:SQLiteHelper
    private lateinit var vm: mainVM
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[mainVM::class.java]
        setContentView(binding.root)
        onClick()
        observer()
    }

    private fun observer() {
        vm.registerUser.observe(this)
        {
            Toast.makeText(this, it.ResponseMsg.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun onClick() {
        binding.btSave.setOnClickListener {
            vm.userRegister(getRegisterUserRequest())
        }
    }


    private fun getRegisterUserRequest(): register_request {

        return register_request(
            "92",
            binding.etMail.text.toString().trim(),
            "111181818283467",
            binding.etContact.text.toString().trim(),
            binding.etUsername.text.toString().trim(),
            binding.etPassword.text.toString().trim(),
        )
    }


    private fun isVaildate(): Boolean {

        try {
            binding.etUsername.nameVaild(binding.etUsername, "Please Enter the name")
            binding.etMail.mailVaild(binding.etMail, "Please Enter the MailId")
        } catch (e: VaildateName) {
            binding.etUsername.setText("")
            binding.etUsername.requestFocus()
            binding.etUsername.setError(e.message)
        } catch (e: VaildateMail) {
            binding.etMail.setText("")
            binding.etMail.requestFocus()
            binding.etMail.setError(e.message)
        }
        return true
    }

}