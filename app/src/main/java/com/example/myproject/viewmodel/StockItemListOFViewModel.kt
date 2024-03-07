package com.example.myproject.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myproject.model.Repository
import com.example.myproject.model.StockItem

class StockItemListOFViewModel : ViewModel {

    private val stockList = ObservableArrayList<ViewModel>()
    val stockListField : ObservableField<ObservableArrayList<ViewModel>> = ObservableField(stockList)

    init{
        val list : ArrayList<ViewModel> = arrayListOf()

        Repository().loadData().forEach{
            list.add(StockItemOFViewModel(it))
        }
        stockList.addAll(list)
    }



}