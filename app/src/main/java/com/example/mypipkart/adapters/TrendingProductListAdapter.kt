package com.example.mypipkart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypipkart.R import com.example.mypipkart.database.TrendingProduct
import com.example.mypipkart.databinding.LiTrendingProductsBinding

class TrendingProductListAdapter: RecyclerView.Adapter<TrendingProductListAdapter.UserViewHolder>(){

    var data=ArrayList<TrendingProduct>()

    fun setUpdatedList(data:ArrayList<TrendingProduct>){
        this.data= data
        notifyDataSetChanged()
    }

    inner class UserViewHolder(var binding: LiTrendingProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TrendingProduct) {
            with(binding) {
                Glide.with(root.context)
                    .load(item.imageUrl)
                    .circleCrop()
                    .into(productImage)
                discount.text= item.discount.toString()+"% OFF"
                productName.text=item.name
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = DataBindingUtil.inflate<LiTrendingProductsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.li_trending_products,
            parent,
            false
        )
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val searchResult = data.get(position)
        searchResult.let {
            holder.bind(searchResult)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
