package com.example.myproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.R
import com.example.myproject.adapter.StockItemRVAdapter
import com.example.myproject.databinding.ActivityMainBinding
import com.example.myproject.viewmodel.StockItemListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var stockItemListViewModel : StockItemListViewModel
    private lateinit var myAdapter : StockItemRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        stockItemListViewModel = ViewModelProvider(this)[StockItemListViewModel::class.java]
        binding.viewmodel = stockItemListViewModel
//        binding.lifecycleOwner = this

        myAdapter = StockItemRVAdapter(this, stockItemListViewModel.stockList.value!!)
        binding.stockRv.adapter = myAdapter
        binding.stockRv.layoutManager = LinearLayoutManager(this)




    }


}