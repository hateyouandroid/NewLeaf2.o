package com.example.newleaf2o
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newleaf2o.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding
        private lateinit var db: SQLiteHelper
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            onClick()

    }

    fun onClick() {
        binding.test.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)

            startActivity(intent)

        }
    }
}


