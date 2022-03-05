package com.example.homework.api

import com.example.homework.constance.ApiConst
import com.example.homework.entity.Business
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RestaurantService {
    @Headers("Authorization:Bearer 9X6oR07iESSu-6ClqsV1fqbz_QLSeeCOrTSsBP-DQmzb6ehVEJ45uUvRUB6uMQRn6YOguvnhklvcJrQPsfWpQGUQGtcDOtFrCYiGNzFceUxd70OQPNqYeYRWtRUgYnYx")
    @GET(ApiConst.PATH_RESTAURANT)
    suspend fun fetchRestaurant(
        @Query("term") term: String?,
        @Query("location") location: String?,
        @Query("categories") categories: String = "restaurant",
        @Query("limit") limit: Int = 25
    ): Response<Business?>
}