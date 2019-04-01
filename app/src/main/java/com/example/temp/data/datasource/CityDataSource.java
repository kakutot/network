package com.example.temp.data.datasource;

import com.example.temp.data.model.CityModel;
import com.example.temp.data.model.CityResponse;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface CityDataSource {

    Single<CityModel> getCity(String cityName, int count);

    Single<CityModel> getCity(double lat, double lon, int count);
}
