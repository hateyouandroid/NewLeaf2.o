package com.example.newleaf2o

import android.content.ClipData
import android.content.ClipData.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newleaf2o.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
          onClick()


    }

    private fun onClick() {
        binding.bottomAppBar.setOnItemSelectedListener {
           when(it){
               R.id.home->Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
               R.id.cart->Toast.makeText(this,"Cart",Toast.LENGTH_SHORT).show()
               R.id.profile->Toast.makeText(this,"Profile",Toast.LENGTH_SHORT).show()
               R.id.menu->Toast.makeText(this,"Menu",Toast.LENGTH_SHORT).show()



           }
        }
    }
}