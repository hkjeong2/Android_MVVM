package com.example.myproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myproject.R
import com.example.myproject.databinding.ActivityStockListRecyclerviewObservableFieldBinding
import com.example.myproject.viewmodel.StockItemListOFViewModel
import androidx.databinding.library.baseAdapters.BR
import com.example.myproject.viewmodel.StockItemOFViewModel

class StockListRecyclerviewObservableFieldActivity : AppCompatActivity() {

    private lateinit var binding : ActivityStockListRecyclerviewObservableFieldBinding
    private lateinit var viewModel : StockItemListOFViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_stock_list_recyclerview_observable_field)

        viewModel = StockItemListOFViewModel()

        binding.setVariable(BR.stockListVM, viewModel)
        binding.executePendingBindings()

        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()

        binding.setVariable(BR.stockListVM, null)
        binding.executePendingBindings()
    }

}