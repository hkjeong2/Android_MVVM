package com.example.myproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.myproject.model.NumberData
import com.example.myproject.model.User

class UserVM : ViewModel() {

    val userLiveData = MutableLiveData<User>(User("hk", "J"))
    val userName: LiveData<String> = userLiveData.map {
            user -> "${user.firstName} ${user.lastName}"
    }
}