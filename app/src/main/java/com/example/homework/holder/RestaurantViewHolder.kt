package com.example.homework.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.entity.Restaurant
import com.example.homework.utils.FrescoLoader
import kotlinx.android.synthetic.main.item_restaurant_list.view.*

class RestaurantViewHolder(view: View, private val ibridge: IRestaurantBridge? = null) : RecyclerView.ViewHolder(view) {

    var data: Restaurant? = null

    init {
        itemView.setOnClickListener { ibridge?.onRestaurantClick(restaurant = data) }
    }

    /**
     * bind data from adapter
     */
    fun bindData(restaurant: Restaurant?) {
        data = restaurant
        FrescoLoader.load(restaurant?.image_url, itemView.sdv_logo)
        itemView.tv_title.text = restaurant?.name ?: ""
    }
}

interface IRestaurantBridge {
    fun onRestaurantClick(restaurant: Restaurant?)
}