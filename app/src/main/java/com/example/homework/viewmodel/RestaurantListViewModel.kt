package com.example.homework.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework.entity.Restaurant
import com.example.homework.repository.RestaurantRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RestaurantListViewModel : ViewModel() {
    private val restaurantRepository = RestaurantRepository
    val restaurantResult = MutableLiveData<List<Restaurant?>?>()
    val refresh = MutableLiveData<Boolean>(false)


    /**
     * fetch event trigger then change value of [restaurantResult]
     */
    fun fetchRestaurant(term: String?, location: String?) {
        refresh.value = true
        viewModelScope.launch {
            restaurantRepository.fetchRestaurants(term, location).collect {
                refresh.value = false
                when (it) {
                    is RestaurantRepository.Callback.SuccessFetch -> {
                        restaurantResult.value = it.restaurant
                    }
                    else -> {
                        restaurantResult.value = null
                    }
                }
            }
        }
    }
}