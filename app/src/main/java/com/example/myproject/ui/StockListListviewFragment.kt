package com.example.myproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.myproject.adapter.StockItemLVAdapter
import com.example.myproject.databinding.FragmentStockListListviewFragmentBinding
import com.example.myproject.model.ListView_Item
import com.example.myproject.model.Repository
import com.example.myproject.model.StockItem


class StockListListviewFragment : Fragment() {

    private lateinit var binding : FragmentStockListListviewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStockListListviewFragmentBinding.inflate(inflater)
        val listView = binding.stockLv

        val itemList: ArrayList<StockItem> = Repository().loadData()

        listView.adapter = StockItemLVAdapter(requireContext(), itemList)

        return binding.root

    }


}