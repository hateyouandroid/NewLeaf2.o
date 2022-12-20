package com.example.newleaf2o

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.Data.Request.register_request
import com.example.newleaf2o.Model.HomeVM
import com.example.newleaf2o.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    //private lateinit var db:SQLiteHelper
    private lateinit var vm: HomeVM
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[HomeVM::class.java]
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
           if(isValidate())vm.userRegister(getRegisterUserRequest())
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

    private fun isValidate(): Boolean{
        try {
            binding.etUsername.nameValidate()
            binding.etMail.emailValidate()
            binding.etContact.mobileValidate()
            binding.etPassword.passwordValidate()
            binding.etConformpass.confPasswordValidate(binding.etPassword)
        }
        catch (e:ValidateName){
            binding.etUsername.requestFocus()
            binding.etUsername.error=e.message
            return false
        }
        catch (e:ValidateEmail){
            binding.etMail.requestFocus()
            binding.etMail.error=e.message
            return false
        }
        catch (e:ValidateMobile){
            binding.etContact.requestFocus()
            binding.etContact.error=e.message
            return false
        }
        catch (e:ValidatePassword){
            binding.etPassword.requestFocus()
            binding.etPassword.error=e.message
            return false

        }
        catch (e:ValidateConformPassword){
            binding.etConformpass.requestFocus()
            binding.etConformpass.error=e.message
            return false
        }
        return true
    }



}