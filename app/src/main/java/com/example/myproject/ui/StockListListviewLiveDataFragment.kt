package com.example.myproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myproject.R
import com.example.myproject.adapter.StockItemLVAdapter
import com.example.myproject.databinding.FragmentStockListListviewFragmentBinding
import com.example.myproject.model.Repository
import com.example.myproject.model.StockItem


class StockListListviewLiveDataFragment : Fragment() {

    private lateinit var binding : FragmentStockListListviewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stock_list_listview_fragment, container, false)

        val itemList: ArrayList<StockItem> = Repository().loadData()

        binding.stockLv.adapter = StockItemLVAdapter(requireContext(), itemList)

        return binding.root

    }


}