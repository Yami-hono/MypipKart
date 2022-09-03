package com.example.mypipkart.network

import com.example.mypipkart.database.ApiRequest
import com.example.mypipkart.database.ApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkService {

    @POST("homePageMob/")
    suspend fun getPostList(@Body surf: ApiRequest): Response<ApiResponse>
}