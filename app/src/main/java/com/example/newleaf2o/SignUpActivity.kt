package com.example.newleaf2o

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newleaf2o.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var db: SQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        db = SQLiteHelper(this)
        binding.btSave.setOnClickListener {
            val userName = binding.etUsername.text.toString()
            val mailId = binding.etMail.text.toString()
            val contactNo = binding.etContact.text.toString()
            val password = binding.etPassword.text.toString()
            if (db.insertData(userName,mailId,contactNo,password))
            {
                Toast.makeText(this, "Record stored", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this, "Record does not stored", Toast.LENGTH_LONG).show()
            }
        }
    }
}

