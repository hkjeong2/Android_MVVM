package com.example.myproject.model

import android.content.Context
import android.content.SharedPreferences

class Repository(private val context : Context) {
    private lateinit var pref : SharedPreferences
    fun loadData() : Int{
        pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val num = pref.getInt("number", 0)

        return num
    }

    fun saveData(num : Int){
        pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putInt("number", num)
        editor.apply()
    }
}