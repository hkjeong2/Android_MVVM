package com.example.myproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myproject.R
import com.example.myproject.model.StockItem

class StockItemLVAdapter(val context : Context, val items : ArrayList<StockItem>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int) = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.stockitem_item, null)

        val title = view.findViewById<TextView>(R.id.title_tv)
        val price = view.findViewById<TextView>(R.id.price_tv)
        val number = view.findViewById<TextView>(R.id.number_tv)

        val item = items[position]
        title.text = item.name
        price.text = item.price.toString()
        number.text = item.number.toString()

        return view
    }
}