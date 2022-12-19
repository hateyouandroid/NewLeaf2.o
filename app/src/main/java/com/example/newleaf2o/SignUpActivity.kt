package com.example.newleaf2o

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newleaf2o.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var db:SQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onClick()
    }

    private fun onClick() {
        if (isVaildate())
        {
            db = SQLiteHelper(this)
            binding.btSave.setOnClickListener {
              //  val name =binding.etUsername.text.toString()
                //val mailId = binding.etMail.text.toString()
                //val contact = binding.etContact.text.toString()
                //val password = binding.etPassword.text.toString()
                if(db.insertData(binding.etUsername.text.toString(),binding.etMail.text.toString(),binding.etContact.text.toString(),binding.etPassword.text.toString()))
                    Toast.makeText(this,"Record is stored",Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this,"Recod not stored",Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun isVaildate(): Boolean {

        try {
            binding.etUsername.nameVaild(binding.etUsername,"Please Enter the name")
            binding.etMail.mailVaild(binding.etMail,"Please Enter the MailId")
        }
        catch (e:VaildateName)
        {
            binding.etUsername.setText("")
            binding.etUsername.requestFocus()
            binding.etUsername.setError(e.message)
        }
        catch (e:VaildateMail)
        {
            binding.etMail.setText("")
            binding.etMail.requestFocus()
            binding.etMail.setError(e.message)
        }
        return true
    }

}