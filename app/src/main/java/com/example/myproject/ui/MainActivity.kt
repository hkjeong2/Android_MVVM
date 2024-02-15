package com.example.myproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myproject.R
import com.example.myproject.databinding.ActivityMainBinding
import com.example.myproject.viewmodel.MainTextViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mainTextViewModel: MainTextViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainTextViewModel = ViewModelProvider(this).get(MainTextViewModel::class.java) // 영역 내에서 객체 반환 or 생성
        binding.lifecycleOwner = this //--> activity 가 결합된 live data 를 observing
        binding.viewmodel = mainTextViewModel


    }


}