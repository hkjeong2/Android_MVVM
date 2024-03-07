package com.example.myproject.viewmodel

import androidx.databinding.ObservableField
import com.example.myproject.R
import com.example.myproject.model.StockItem

class StockItemOFViewModel(model : StockItem) : ViewModel {

    val stockName = ObservableField<String>("")
    val stockPrice = ObservableField<Int>(0)
    val stockNumber = ObservableField<Int>(0)

    fun clickMinus(){
        stockNumber.set(stockNumber.get()!! - 1)
    }

    fun clickPlus(){
        stockNumber.set(stockNumber.get()!! + 1)
    }

    init {
        stockName.set(model.name)
        stockPrice.set(model.price)
        stockNumber.set(model.number)
    }
//
//    fun getView() = R.layout.stockitem_item
}

