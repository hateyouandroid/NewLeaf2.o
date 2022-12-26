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
        validation()
    }

    private fun validation() :Boolean {
        val name = binding.etUsername.text.toString()
        val mail = binding.etMail.text.toString()
        val mobile = binding.etContact.text.toString()
        val password = binding.etPassword.text.toString()
        val conform = binding.etConformpass.text.toString()
        if (name.trim().isEmpty())
        {
            binding.etUsername.error="Enter Name"
            binding.etUsername.requestFocus()
            return false
        }
        else if (mail.trim().isEmpty()){
            binding.etMail.error="Enter valid mail id"
            binding.etMail.requestFocus()
            return false
        }
        else if(mobile.trim().isEmpty()){
            binding.etContact.error="Enter Valid Mobile No"
            binding.etContact.requestFocus()
            return false
        }
        else if(mobile.length!=10){
            binding.etContact.error="Please Enter 10 digit no"
            binding.etContact.requestFocus()
            return false
        }
        else if (password.trim().isEmpty()){
            binding.etPassword.error="Enter Password"
            binding.etPassword.requestFocus()
            return false
        }
        else if (conform.trim().isEmpty()){
            binding.etConformpass.error="Enter Conform password"
            binding.etConformpass.requestFocus()
            return false
        }
        else if (password!=conform){
            binding.etConformpass.error="Password do not match"
            binding.etConformpass.requestFocus()
            return false
        }
        return true
    }

    private fun observers() {
        vm.getRegisterResponse.observe(this) {
            Toast.makeText(this, it.ResponseMsg, Toast.LENGTH_LONG).show()
        }
    }

    private fun onClick() {
        binding.btSave.setOnClickListener {
            vm.register(getRegisterRequest())
            if (validation()){

                val name=binding.etUsername.text.toString()
                val mail = binding.etMail.text.toString()
                val mobile = binding.etContact.text.toString()
                val password = binding.etPassword.text.toString()
                val conform = binding.etConformpass.text.toString()

                if (db.insertData(name,mail,mobile,password,conform))
                {
                    Toast.makeText(this, "Registration Successfully", Toast.LENGTH_SHORT).show()
                    val intent=Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                }
        }
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



