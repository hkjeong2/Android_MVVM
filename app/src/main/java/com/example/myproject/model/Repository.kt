package com.example.myproject.model

import android.content.Context
import android.content.SharedPreferences

class Repository() {
    fun loadData() : ArrayList<StockItem>{
        val items = arrayListOf(
            StockItem("삼성전자", 70000, 10),
            StockItem("LG전자", 20000, 10),
            StockItem("현대자동차", 220000, 10),
        )
        return items
    }
}



