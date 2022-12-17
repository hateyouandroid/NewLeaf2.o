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