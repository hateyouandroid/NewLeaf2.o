package com.example.newleaf2o

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.data_class.request.LoginRequest
import com.example.newleaf2o.databinding.ActivityLoginBinding
import com.example.newleaf2o.db.SharePref
import com.example.newleaf2o.util.printTost
import com.example.newleaf2o.vm.LoginVm

class LoginActivity : AppCompatActivity() {
  private lateinit var binding: ActivityLoginBinding
  private lateinit var vm: LoginVm
  lateinit var sharePref: SharePref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm=ViewModelProvider(this)[LoginVm::class.java]
        sharePref= SharePref(this)

        onClick()
        observer()
    }
    private fun onClick() {
        binding.btLogin.setOnClickListener {
            vm.loginUser(getLoginRequest())
        }
    }

    private fun getLoginRequest(): LoginRequest {
   return LoginRequest(
       "283784738273827",
       binding.etEmail.text.toString().trim(),
       binding.etPass.text.toString().trim()
   )
    }


    private fun observer() {
        vm.loginResult.observe(this){
            try {

                if(it.Result=="true"){  printTost(it.ResponseMsg)
                    with(sharePref) { storeUserDetails(it.user)
                      }
                }
                else printTost(it.ResponseMsg)

            }catch (e:Exception){
                printTost(e.message.toString())
            }
        }
    }

}