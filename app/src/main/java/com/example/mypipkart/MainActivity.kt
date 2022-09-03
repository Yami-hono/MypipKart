package com.example.mypipkart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypipkart.adapter.ProductBannerListAdapter
import com.example.mypipkart.adapter.TrendingProductListAdapter
import com.example.mypipkart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var productBannerAdapter:ProductBannerListAdapter
    private lateinit var trendingProductAdapter:TrendingProductListAdapter

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        val layoutManager =  GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false)
        binding.trendingProducts.layoutManager = layoutManager

        productBannerAdapter= ProductBannerListAdapter()
        trendingProductAdapter=TrendingProductListAdapter()
        binding.productBanner.adapter=productBannerAdapter
        binding.trendingProducts.adapter=trendingProductAdapter

        viewModel.getData()
        addObserver()
    }

    fun addObserver(){

        viewModel.productBannerList.observe(this){
            if(it.isNotEmpty()){
                productBannerAdapter.setUpdatedList(it)
            }
        }

        viewModel.trendingProductList.observe(this){
            if(it.isNotEmpty()){
                trendingProductAdapter.setUpdatedList(it)
            }
        }

    }
}