package com.example.newleaf2o

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newleaf2o.Exceptions.*
import com.example.newleaf2o.databinding.ActivitySignUpBinding
import com.example.newleaf2o.util.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onClick()
    }

    private fun onClick() {
        binding.btSave.setOnClickListener {
            if(isValidate())
            printTost("Valid")
        }
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