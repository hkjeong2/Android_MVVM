package com.example.myproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StockItemViewModel : ViewModel(){

    private var _name = MutableLiveData<String>()
    val name : LiveData<String> get() = _name

    private var _price = MutableLiveData<Int>()
    val price : LiveData<Int> get() = _price

    private var _number = MutableLiveData<Int>()
    val number : LiveData<Int> get() = _number

    fun setValue(name : String, price : Int, number : Int){
        _name.value = name
        _price.value = price
        _number.value = number
    }

    fun clickPlus(){
        plusNumber()
    }

    fun clickMinus(){
        minusNumber()
    }

    private fun plusNumber(){
        _number.value = _number.value!! + 1
    }

    private fun minusNumber(){
        _number.value = _number.value!! - 1
    }

}