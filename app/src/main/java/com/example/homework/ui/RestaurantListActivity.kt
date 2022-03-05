package com.example.homework.ui

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R
import com.example.homework.adapter.RestaurantListAdapter
import com.example.homework.base.BaseActivity
import com.example.homework.constance.RouteConst
import com.example.homework.entity.Restaurant
import com.example.homework.holder.IRestaurantBridge
import com.example.homework.utils.UiUtils
import com.example.homework.viewmodel.RestaurantListViewModel
import kotlinx.android.synthetic.main.activity_restaurant_list.*

class RestaurantListActivity : BaseActivity(), IRestaurantBridge {

    private val viewModel: RestaurantListViewModel by viewModels()
    private val adapter by lazy { RestaurantListAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerview()
        observe()
        setListener()
    }

    private fun fetchData() {
        viewModel.fetchRestaurant(tiet_term.text.toString(), tiet_location.text.toString())
    }

    private fun setListener() {
        srl_refresh.setOnRefreshListener { fetchData() }
        btn_search.setOnClickListener { fetchData() }
    }

    private fun setupRecyclerview() {
        rv_content.adapter = adapter
        rv_content.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val gap = UiUtils.dp2px(view.context, 8)
                outRect.left = gap
                outRect.right = gap
                outRect.top = gap
                outRect.bottom = gap
            }
        })
    }

    /**
     * observe the fetch result
     */
    private fun observe() {
        viewModel.restaurantResult.observe(this, Observer { result ->

            if (result == null) {
                Toast.makeText(this, R.string.failed_fetch, Toast.LENGTH_LONG).show()
            } else {
                adapter.setDatas(result)
            }
        })
        viewModel.refresh.observe(this, Observer { srl_refresh.post { srl_refresh.isRefreshing = it } })
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_restaurant_list
    }

    override fun onRestaurantClick(restaurant: Restaurant?) {
        if (restaurant == null) return

        val intent = Intent(this, RestaurantDetailActivity::class.java)
        intent.putExtra(RouteConst.PARAMS_RESTAURANT, restaurant)
        startActivity(intent)
    }

    override fun setTitle(): String {
        return "Restaurant List"
    }
}