package com.example.myproject.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myproject.R
import com.example.myproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initClickListener()

    }

    private fun initClickListener(){
        binding.memoryTestBt.setOnClickListener { startActivity(Intent(this, TestListActivity::class.java)) }
        binding.livedataRVBt.setOnClickListener { startActivity(Intent(this, TestViewModelActivity::class.java)) }
        binding.observablefieldRVBt.setOnClickListener { startActivity(Intent(this, StockListRecyclerviewObservableFieldActivity::class.java)) }

    }

}