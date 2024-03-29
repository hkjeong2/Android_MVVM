package com.example.myproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myproject.R
import com.example.myproject.databinding.ActivityTestListBinding
import com.google.android.material.tabs.TabLayout

class TestListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTestListBinding
//    private lateinit var stockItemListViewModel : StockItemListViewModel
//    private lateinit var myAdapter : StockItemRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_list)

        setTabLayout()

//        stockItemListViewModel = ViewModelProvider(this)[StockItemListViewModel::class.java]
//        binding.viewmodel = stockItemListViewModel
//        binding.lifecycleOwner = this

//        myAdapter = StockItemRVAdapter(this, stockItemListViewModel.stockList.value!!)
//        binding.stockRv.adapter = myAdapter
//        binding.stockRv.layoutManager = LinearLayoutManager(this)


    }

    private fun setTabLayout() {
        val stockListRecyclerviewLiveDataFragment = StockListRecyclerviewLiveDataFragment()
        val stockListListviewLiveDataFragment = StockListListviewLiveDataFragment()

        supportFragmentManager.beginTransaction().apply{
            add(binding.tabLayoutContainer.id, stockListRecyclerviewLiveDataFragment)
            commit()
        }

        binding.mainTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.position) {
                    0 -> transaction.replace(binding.tabLayoutContainer.id, stockListRecyclerviewLiveDataFragment)
                    1 -> transaction.replace(binding.tabLayoutContainer.id, stockListListviewLiveDataFragment)
                }
                transaction.commit()
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

}