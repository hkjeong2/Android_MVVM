package com.example.myproject.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.databinding.StockitemItemBinding
import com.example.myproject.viewmodel.StockItemViewModel

class StockItemRVAdapter(private val owner : LifecycleOwner, private val stockList: ArrayList<StockItemViewModel>) : RecyclerView.Adapter<StockItemRVAdapter.MyViewHolder>() {

    class MyViewHolder(private val owner : LifecycleOwner, private val binding : StockitemItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(stock : StockItemViewModel){
            binding.stock = stock
            binding.lifecycleOwner = owner

            stock.name.observe(owner, Observer{
                binding.titleTv.text = it
            })

            stock.price.observe(owner, Observer{
                binding.priceTv.text = it.toString()
            })

            stock.number.observe(owner, Observer{
                binding.numberTv.text = it.toString()
            })
        }
    }

    override fun getItemCount(): Int = stockList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = StockitemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(owner, binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(stockList[position])
    }

}