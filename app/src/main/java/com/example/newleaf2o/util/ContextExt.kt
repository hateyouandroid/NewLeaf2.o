package com.example.newleaf2o.util

import android.content.Context
import android.widget.Toast

fun Context.printTost(massage:String)
{
    Toast.makeText(this,massage,Toast.LENGTH_SHORT).show()
}