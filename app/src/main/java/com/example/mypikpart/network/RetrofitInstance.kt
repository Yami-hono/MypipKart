package com.example.mypikpart.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{
        const val baseUrl="https://api.pikpart.com/api/utilities/"


        fun getRetrofitInstance():Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }

}