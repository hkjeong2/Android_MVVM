package com.example.myproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject.R
import com.example.myproject.adapter.StockItemRVAdapter
import com.example.myproject.databinding.FragmentTestViewmodel3Binding
import com.example.myproject.viewmodel.StockItemListViewModel

class TestViewModel3Fragment : Fragment() {

    private lateinit var binding : FragmentTestViewmodel3Binding
    private lateinit var myAdapter : StockItemRVAdapter
    private val stockItemListViewModel by activityViewModels<StockItemListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test_viewmodel_3, container, false)

        // ViewModelProvider 로 만든 객체가 프래그먼트간 동일한지 여부 확인
        Log.d("test 3", stockItemListViewModel.toString())

        binding.viewmodel = stockItemListViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        myAdapter = StockItemRVAdapter(viewLifecycleOwner, stockItemListViewModel.stockList.value!!)
        binding.stockRv.adapter = myAdapter
        binding.stockRv.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

}