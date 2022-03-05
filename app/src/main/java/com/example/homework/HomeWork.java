package com.example.homework;

import android.app.Application;

import com.example.homework.network.RetrofitClient;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;

public class HomeWork extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this, OkHttpImagePipelineConfigFactory
                .newBuilder(this, RetrofitClient.INSTANCE.getClient()) // other setters
                .build());
    }
}
