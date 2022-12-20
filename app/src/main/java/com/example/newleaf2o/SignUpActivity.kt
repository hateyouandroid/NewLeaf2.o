package com.example.newleaf2o

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.Exceptions.*
import com.example.newleaf2o.data_class.request.RegisterRequest
import com.example.newleaf2o.databinding.ActivitySignUpBinding
import com.example.newleaf2o.util.*
import com.example.newleaf2o.vm.LoginVm

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var vm:LoginVm
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        vm=ViewModelProvider(this)[LoginVm::class.java]
        onClick()
        observer()
    }

    private fun observer() {
        vm.registerResult.observe(this){
            printTost(it.ResponseMsg)
        }
    }


    private fun onClick() {
        binding.btSave.setOnClickListener {
            if(isValidate())
                vm.registerUser(getRegisterUserRequest())

        }
    }
    private fun getRegisterUserRequest(): RegisterRequest {
        return RegisterRequest(
            "93",
            binding.etMail.text.toString().trim(),
            "111181818283467",
            binding.etContact.text.toString().trim(),
            binding.etUsername.text.toString().trim(),
            binding.etPassword.text.toString().trim()
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
            return binding.etUsername.validationError(e.message.toString())
        }
        catch (e:ValidateEmail){
            return binding.etMail.validationError(e.message.toString())
        }
        catch (e:ValidateMobile){
            return binding.etContact.validationError(e.message.toString())
        }
        catch (e:ValidatePassword){
            return binding.etPassword.validationError(e.message.toString())
        }
        catch (e:ValidateConformPassword){
           return binding.etConformpass.validationError(e.message.toString())
        }
        return true
    }
}