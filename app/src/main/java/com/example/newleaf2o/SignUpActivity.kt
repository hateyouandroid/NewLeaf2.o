package com.example.newleaf2o


import android.Manifest.permission.READ_PHONE_STATE
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.example.newleaf2o.Exceptions.*
import com.example.newleaf2o.data_class.request.RegisterRequest
import com.example.newleaf2o.databinding.ActivitySignUpBinding
import com.example.newleaf2o.util.*
import com.example.newleaf2o.vm.LoginVm


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var vm:LoginVm
    private val REQUEST_CODE = 101
    private lateinit var imei: String
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
            getIMEI(),
            binding.etContact.text.toString().trim(),
            binding.etUsername.text.toString().trim(),
            binding.etPassword.text.toString().trim()
        )
    }

    private fun getIMEI(): String {
        val telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager


        // in the below line, we are checking for permissions
        if (ActivityCompat.checkSelfPermission(this,READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // if permissions are not provided we are requesting for permissions.
            ActivityCompat.requestPermissions(this, arrayOf(READ_PHONE_STATE), REQUEST_CODE)
        }

        // in the below line, we are setting our imei to our text view.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            imei = telephonyManager.imei
        }
       return imei
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_CODE) {
            // in the below line, we are checking if permission is granted.
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // if permissions are granted we are displaying below toast message.
                Toast.makeText(this, "Permission granted.", Toast.LENGTH_SHORT).show()
            } else {
                // in the below line, we are displaying toast message if permissions are not granted.
                Toast.makeText(this, "Permission denied.", Toast.LENGTH_SHORT).show()
            }
        }}

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