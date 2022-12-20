package com.example.newleaf2o.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.TelephonyManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.newleaf2o.SignUpActivity

fun Context.printTost(massage:String)
{
    Toast.makeText(this,massage,Toast.LENGTH_SHORT).show()
}
