package com.example.myproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myproject.model.Repository

class StockItemListViewModel : ViewModel() {

    private var _stockList = MutableLiveData<ArrayList<StockItemViewModel>>()
    val stockList : LiveData<ArrayList<StockItemViewModel>> get() = _stockList

    init {
        val loadedStockList = Repository().loadData()
        val list = ArrayList<StockItemViewModel>()
        loadedStockList.forEach{
            val name = it.name
            val price = it.price
            val number = it.number
            val stockItemViewModel = StockItemViewModel()
            stockItemViewModel.setValue(name, price, number)
            list.add(stockItemViewModel)
        }
        _stockList.value = list
    }


}