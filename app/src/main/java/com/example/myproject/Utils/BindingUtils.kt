package com.example.myproject.Utils

import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.adapter.StockItemOFRVAdapter
import com.example.myproject.viewmodel.ViewModel

fun setAdapter(
    view : RecyclerView,
    itemList : ObservableArrayList<ViewModel>
){
    view.adapter = StockItemOFRVAdapter(itemList)
    view.layoutManager = LinearLayoutManager(view.context)
}