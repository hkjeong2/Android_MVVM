package com.example.myproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myproject.model.Repository

class MainTextViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainTextViewModel::class.java)) {
            MainTextViewModel(repository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}