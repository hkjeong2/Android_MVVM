package com.example.myproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myproject.model.NumberData

class MainTextViewModel : ViewModel() {

    private var _num = MutableLiveData<Int>()
    val num : LiveData<Int> get() = _num

    init{
        val numberData = NumberData()
        _num.value = numberData.number
    }

    fun clickResetNum(){
        resetNum()
    }

    fun clickAddNum(){
        addNum()
    }

    fun clickMinusNum(){
        minusNum()
    }

    private fun resetNum() {
        _num.value = 0
    }

    private fun addNum(){
        if (_num.value!! < 10){
            _num.value = _num.value!! + 1
        }
    }

    private fun minusNum(){
        if (_num.value!! > 0){
            _num.value = _num.value!! - 1
        }
    }

}