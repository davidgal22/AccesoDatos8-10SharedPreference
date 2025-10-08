package com.example.accesodatos8_10.ui

import android.content.Context

class SharedPreferencesManager (context: Context, fileName: String){
    val sharedPref = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    fun saveString(key:String,value: String){
       with(sharedPref.edit()){
           putString(key,value)
            apply()
       }
    }

    fun getString(key: String): String?{
        return sharedPref.getString(key,"Undefined")
    }
}