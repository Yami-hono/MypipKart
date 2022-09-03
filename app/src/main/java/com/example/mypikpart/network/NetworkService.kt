package com.example.mypikpart.network

import com.example.mypikpart.database.ApiRequest
import com.example.mypikpart.database.ApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkService {

    @POST("homePageMob/")
    suspend fun getPostList(@Body surf: ApiRequest): Response<ApiResponse>
}