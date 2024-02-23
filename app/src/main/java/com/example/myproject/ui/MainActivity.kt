package com.example.myproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myproject.R
import com.example.myproject.databinding.ActivityMainBinding
import com.example.myproject.model.User
import com.example.myproject.viewmodel.UserVM

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val vm = ViewModelProvider(this).get(UserVM::class.java) // 영역 내에서 객체 반환 or 생성
        binding.lifecycleOwner = this //--> activity 가 결합된 live data 를 observing
        binding.viewmodel = vm

        binding.bt.setOnClickListener {
            vm.userLiveData.value = User("test2", "test2")
        }


    }


}