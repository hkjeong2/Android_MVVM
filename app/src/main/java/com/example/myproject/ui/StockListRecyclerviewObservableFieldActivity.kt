package com.example.myproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myproject.R
import com.example.myproject.databinding.ActivityStockListRecyclerviewObservableFieldBinding
import com.example.myproject.viewmodel.StockItemListOFViewModel

class StockListRecyclerviewObservableFieldActivity : AppCompatActivity() {

    private lateinit var binding : ActivityStockListRecyclerviewObservableFieldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_stock_list_recyclerview_observable_field)

        binding.stockListVM = StockItemListOFViewModel()

        setContentView(binding.root)
    }

}