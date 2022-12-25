package com.example.newleaf2o.Activity

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.BaseActivity
import com.example.newleaf2o.Data.Request.forgotpass_request
import com.example.newleaf2o.Model.LoginVM
import com.example.newleaf2o.databinding.ActivityForgetBinding

class ForgetActivity : BaseActivity<ActivityForgetBinding>(ActivityForgetBinding::inflate) {

    lateinit var vm: LoginVM

    override fun initVM() {
        super.initVM()
        vm = ViewModelProvider(this)[LoginVM::class.java]
    }

    override fun onClick() {
        binding.forgetOtp.setOnClickListener {
            vm.userForgot(getforgetResponse())
            Toast.makeText(this, "click", Toast.LENGTH_LONG).show()
        }
    }

    private fun getforgetResponse(): forgotpass_request {
        return forgotpass_request("91", binding.mobileNo.text.toString().trim())
    }
}