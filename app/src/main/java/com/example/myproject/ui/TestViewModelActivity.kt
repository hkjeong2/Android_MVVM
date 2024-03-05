package com.example.myproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myproject.R
import com.example.myproject.databinding.ActivityTestViewmodelBinding
import com.google.android.material.tabs.TabLayout

class TestViewModelActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTestViewmodelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_viewmodel)

        setTabLayout()
    }

    private fun setTabLayout() {
        val testViewModel1Fragment = TestViewModel1Fragment()
        val testViewModel2Fragment = TestViewModel2Fragment()
        val testViewModel3Fragment = TestViewModel3Fragment()
        val testViewModel4Fragment = TestViewModel4Fragment()

        supportFragmentManager.beginTransaction().apply{
            add(binding.tabLayoutContainer.id, testViewModel1Fragment)
            commit()
        }

        binding.mainTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when (tab?.position) {
                    0 -> transaction.replace(binding.tabLayoutContainer.id, testViewModel1Fragment)
                    1 -> transaction.replace(binding.tabLayoutContainer.id, testViewModel2Fragment)
                    2 -> transaction.replace(binding.tabLayoutContainer.id, testViewModel3Fragment)
                    3 -> transaction.replace(binding.tabLayoutContainer.id, testViewModel4Fragment)
                }
                transaction.commit()
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

}