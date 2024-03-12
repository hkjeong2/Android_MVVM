package com.example.myproject.binding

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.Utils.setAdapter
import com.example.myproject.viewmodel.ViewModel

@BindingAdapter(value = ["rv_itemList"])
fun bindItemList(
    view : RecyclerView,
    itemList : ObservableArrayList<ViewModel>?){

    setAdapter(view, itemList)
}

