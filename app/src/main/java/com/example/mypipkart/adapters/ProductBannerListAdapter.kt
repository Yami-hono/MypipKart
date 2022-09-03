package com.example.mypipkart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypipkart.R
import com.example.mypipkart.database.ProductBanner
import com.example.mypipkart.databinding.LiProductBannerBinding

class ProductBannerListAdapter: RecyclerView.Adapter<ProductBannerListAdapter.UserViewHolder>(){
    var data=ArrayList<ProductBanner>()

    fun setUpdatedList(data:ArrayList<ProductBanner>){
        this.data= data
        notifyDataSetChanged()
    }

    inner class UserViewHolder(var binding: LiProductBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductBanner) {
            with(binding) {
                Glide.with(root.context)
                    .load(item.imageUrl)
                    .fitCenter()
                    .into(productBannerImage)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = DataBindingUtil.inflate<LiProductBannerBinding>(
            LayoutInflater.from(parent.context),
            R.layout.li_product_banner,
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
