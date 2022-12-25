package com.example.newleaf2o.db

import android.content.Context
import android.content.SharedPreferences
import com.example.newleaf2o.Data.Response.Data
import com.example.newleaf2o.utils.Constants
import com.example.newleaf2o.utils.Util
import com.google.gson.Gson

class SharePref(context: Context){
    private lateinit var sharedPreferences: SharedPreferences
    private val TAG = "USER_DETAILS"

    init {
        sharedPreferences = context.getSharedPreferences(Util.sharedPrefFile,Context.MODE_PRIVATE)
    }

    fun storeUserDetails(data:Data)
    {
        val editor:SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val json =gson.toJson(data)
        editor.putString(Constants.userDetails,json)
        editor.apply()
    }
}