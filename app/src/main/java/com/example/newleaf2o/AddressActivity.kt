package com.example.newleaf2o

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.data.request.AddAddressRequest
import com.example.newleaf2o.data.response.AddAddressResponse
import com.example.newleaf2o.databinding.ActivityAddressBinding
import com.example.newleaf2o.retrofit.APIClient
import com.example.newleaf2o.retrofit.ApiServices
import com.example.newleaf2o.vm.AddressVM
import retrofit2.*

class AddressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddressBinding
    private lateinit var apiServices: ApiServices
    private lateinit var vm:AddressVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm=ViewModelProvider(this)[AddressVM::class.java]
        onClick()
        obeserver()
    }

    private fun obeserver() {
    vm.addAddressResponse.observe(this){
        Toast.makeText(this,it.ResponseMsg,Toast.LENGTH_LONG).show()
    }
    }

    private fun onClick() {
        binding.btSave.setOnClickListener {
            vm.addAddress(getAddAddressResquest())
        }
    }

    private fun getAddAddressResquest(): AddAddressRequest {
        return AddAddressRequest(
            "0",
            binding.etArea.text.toString().trim(),
            binding.etHomeNo.text.toString().trim(),
            "123345575675678",
            binding.etLandmark.text.toString().trim(),
            "5678432345",
            binding.etUsername.text.toString().trim(),
            "126634",
            binding.etPincode.text.toString().trim(),
            binding.etSociety.text.toString().trim(),
            "home",
            "35"
        )
    }
           }



