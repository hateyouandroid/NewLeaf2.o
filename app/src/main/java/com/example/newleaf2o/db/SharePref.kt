package com.example.newleaf2o.db

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.newleaf2o.data_class.response.User
import com.example.newleaf2o.util.Constants
import com.example.newleaf2o.util.Utill
import com.google.gson.Gson

class SharePref(context: Context) {

        private var sharedPreferences: SharedPreferences
        private  val TAG="USER_DETAILS"

        init {
            sharedPreferences = context.getSharedPreferences(Utill.SHARED_PREF_FILE, Context.MODE_PRIVATE)

        }

        fun storeUserDetails(data: User) {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            val gson = Gson()
            val json = gson.toJson(data)
            editor.putString(Constants.USER_DETAILS, json)
            editor.apply()


        }

        fun getUserDetails(): User {
            val gson = Gson()
            val json: String = sharedPreferences.getString(Constants.USER_DETAILS, "").toString()
            Log.d(TAG, json)
            if (json.isBlank()) {
                return User()
            }
            return gson.fromJson(json,User::class.java)
        }

        fun logout():Boolean {
            val editor=sharedPreferences.edit()
            editor.clear()
            editor.apply()
            return true
        }


    }
