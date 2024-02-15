package com.example.myproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myproject.model.Repository

class MainTextViewModel(private val repository: Repository) : ViewModel() {

    private var _num = MutableLiveData<Int>()
    val num : LiveData<Int> get() = _num

    init{
        _num.value = repository.loadData()
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

    fun clickSaveNum(){
        saveNum()
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

    private fun saveNum(){
        repository.saveData(_num.value!!)
    }

}