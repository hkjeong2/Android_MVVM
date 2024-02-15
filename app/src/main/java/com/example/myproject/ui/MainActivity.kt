package com.example.myproject.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myproject.R
import com.example.myproject.databinding.ActivityMainBinding
import com.example.myproject.model.Repository
import com.example.myproject.viewmodel.MainTextViewModel
import com.example.myproject.viewmodel.MainTextViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mainTextViewModel: MainTextViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("log", "start")
        super.onCreate(savedInstanceState)

        Log.d("log", "start")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainTextViewModel = ViewModelProvider(this, MainTextViewModelFactory(Repository(this)))
            .get(MainTextViewModel::class.java)// 영역 내에서 객체 반환 or 생성

        binding.lifecycleOwner = this //--> activity 가 결합된 live data 를 observing
        binding.viewmodel = mainTextViewModel


    }


}