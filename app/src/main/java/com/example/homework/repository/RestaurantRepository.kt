package com.example.homework.repository

import com.example.homework.api.RestaurantService
import com.example.homework.entity.Restaurant
import com.example.homework.network.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object RestaurantRepository {

    /**
     * fetch all of the restaurant
     *
     * @return list of [Restaurant]
     */
    sealed class Callback {

        object ErrorFetch : Callback()

        data class SuccessFetch(
            val restaurant: List<Restaurant?>?
        ) : Callback()
    }

    fun fetchRestaurants(term: String?, location: String?): Flow<Callback> {
        return flow {
            val response = RetrofitClient.get(RestaurantService::class.java).fetchRestaurant(term, location)
            val data = response.body()
            val restaurants = data?.businesses
            if (response.isSuccessful && !(restaurants.isNullOrEmpty())) {
                emit(Callback.SuccessFetch(restaurants))
            } else {
                emit(Callback.ErrorFetch)
            }
        }
    }
}