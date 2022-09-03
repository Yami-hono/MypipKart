package com.example.mypikpart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypikpart.network.RetrofitInstance
import com.example.mypikpart.database.*
import com.example.mypikpart.network.NetworkService
import kotlinx.coroutines.launch
import kotlin.Exception

class MainViewModel: ViewModel() {

    private val retrofitInstance: NetworkService =RetrofitInstance.getRetrofitInstance().create(NetworkService::class.java)
    private val surf=ApiRequest(ObjectHash(25.6256436,83.0038971,2316), QueryParamHash("homePageMob"))
    val productBannerList=MutableLiveData<ArrayList<ProductBanner>>()
    val trendingProductList=MutableLiveData<ArrayList<TrendingProduct>>()

    fun getData(){
        viewModelScope.launch {
            try {
                val res=retrofitInstance.getPostList(surf)
                if(res.isSuccessful) {

                    res.body().let {
                        productBannerList.value = it?.responseResult?.result?.data?.product?.productBanner
                        trendingProductList.value=it?.responseResult?.result?.data?.trendingProducts
                    }

                }
            }catch (ex:Exception){

            }
        }


    }
}