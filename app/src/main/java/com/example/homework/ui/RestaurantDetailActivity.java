package com.example.homework.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.homework.R;
import com.example.homework.base.BaseActivity;
import com.example.homework.constance.RouteConst;
import com.example.homework.entity.Restaurant;
import com.example.homework.utils.FrescoLoader;
import com.facebook.drawee.view.SimpleDraweeView;

public class RestaurantDetailActivity extends BaseActivity {

    private TextView tv_title;
    private SimpleDraweeView sdv_img;

    @Override
    public int getLayoutResource() {
        return R.layout.activity_restaurant_detail;
    }

    @NonNull
    @Override
    public String setTitle() {
        return "Restarant Detail";
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv_title = findViewById(R.id.tv_title);
        sdv_img = findViewById(R.id.sdv_img);
        bindData(getIntent().getParcelableExtra(RouteConst.PARAMS_RESTAURANT));
    }

    private void bindData(Restaurant restaurant) {
        if (restaurant == null) finish();

        tv_title.setText(restaurant.getName() + "\nLocation:" + restaurant.getLocation().getAddress() + "\nPhone:" + restaurant.getDisplay_phone());
        FrescoLoader.INSTANCE.load(restaurant.getImage_url(), sdv_img);
    }
}
