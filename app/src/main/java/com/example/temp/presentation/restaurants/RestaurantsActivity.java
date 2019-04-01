package com.example.temp.presentation.restaurants;

import android.os.Bundle;
import android.util.Log;

import com.example.temp.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        Log.i(this.getClass().getName(), "onCreate");
        getIntent().getExtras().getString("TEST");
    }
}
