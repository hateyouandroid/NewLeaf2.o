package com.example.newleaf2o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newleaf2o.databinding.ActivityForgotBinding

class ForgotActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityForgotBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_forgot)
        onClick()
    }

    private fun onClick() {
    binding.btSave.setOnClickListener {
        val intent=Intent(this,ForgotActivity::class.java)
        startActivity(intent)
    }

    }
}