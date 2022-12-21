package com.example.newleaf2o

import android.content.ClipData
import android.content.ClipData.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newleaf2o.data_class.response.User
import com.example.newleaf2o.databinding.ActivityMainBinding
import com.example.newleaf2o.db.SharePref
import com.example.newleaf2o.util.printTost


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharePref: SharePref
    lateinit var user:User

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val s = SharePref(this)
        user=s.getUserDetails()
        binding.Userame.text=user.name
        onClick()
    }

    private fun onClick() {
        binding.bottomAppBar.setOnItemSelectedListener {
            val sinup =Intent(this,SignUpActivity::class.java)
            val login =Intent(this,LoginActivity::class.java)

           when(it){
               R.id.home->Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
               R.id.cart->{
                   sharePref= SharePref(this)
                   if(sharePref.logout()) printTost("logut")
               }
               R.id.profile->startActivity(login)
               R.id.menu->startActivity(sinup)
           }
        }
    }
}