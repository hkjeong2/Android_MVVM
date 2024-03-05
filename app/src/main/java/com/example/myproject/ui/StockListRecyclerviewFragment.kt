package com.example.myproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.R
import com.example.myproject.adapter.StockItemRVAdapter
import com.example.myproject.databinding.FragmentStockListRecyclerviewBinding
import com.example.myproject.viewmodel.StockItemListViewModel

class StockListRecyclerviewFragment : Fragment() {

    private lateinit var binding : FragmentStockListRecyclerviewBinding
//    private lateinit var stockItemListViewModel : StockItemListViewModel
    private val stockItemListViewModel : StockItemListViewModel by viewModels()
    private lateinit var myAdapter : StockItemRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stock_list_recyclerview, container, false)

//        if (!::stockItemListViewModel.isInitialized)
//            stockItemListViewModel = ViewModelProvider(this)[StockItemListViewModel::class.java]
        binding.viewmodel = stockItemListViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        Log.d("test rv", stockItemListViewModel.toString())

        myAdapter = StockItemRVAdapter(viewLifecycleOwner, stockItemListViewModel.stockList.value!!)
        binding.stockRv.adapter = myAdapter
        binding.stockRv.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("test", "viewcreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onPause() {
        Log.d("test", "puased")
        super.onPause()
    }
    override fun onStop() {
        Log.d("test", "stopped")
        super.onStop()
    }
}