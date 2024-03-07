package com.example.myproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.databinding.StockitemItemObservableFieldBinding
import com.example.myproject.viewmodel.ViewModel
import androidx.databinding.library.baseAdapters.BR

class StockItemOFRVAdapter(private val observableViewModels : ObservableArrayList<ViewModel>) : RecyclerView.Adapter<StockItemOFRVAdapter.BaseViewHolder>() {

    class BaseViewHolder(val binding : StockitemItemObservableFieldBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(vm : ViewModel){
            binding.setVariable(BR.stockItemVM, vm)
            binding.executePendingBindings()
        }
        fun unbind(){
            binding.setVariable(BR.stockItemVM, null)
            binding.executePendingBindings()
            binding.unbind()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = StockitemItemObservableFieldBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BaseViewHolder(binding)
    }

    override fun getItemCount(): Int = observableViewModels.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(observableViewModels[position])
    }

    override fun onViewRecycled(holder: BaseViewHolder) {
        holder.unbind()

        super.onViewRecycled(holder)
    }

}