package com.example.myproject.model

import android.content.Context
import android.content.SharedPreferences
import kotlin.random.Random

class Repository() {
    fun loadData() : ArrayList<StockItem>{
        val itemList = ArrayList<StockItem>()
        for (i in 1..500)
            itemList.add(StockItem("종목" + i.toString(), Random.nextInt(1, 10001), 0))

        return itemList
    }
}



