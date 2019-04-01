package com.example.temp.data.datasource;

import com.example.temp.data.model.CityModel;
import com.example.temp.data.model.CityResponse;
import com.example.temp.data.network.ZomatoApi;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class CityNetworkDataSource implements CityDataSource{

    private ZomatoApi zomatoApi;

    public CityNetworkDataSource(ZomatoApi zomatoApi) {
        this.zomatoApi = zomatoApi;
    }

    @Override
    public Single<CityModel> getCity(String cityName, int count) {
        return zomatoApi.getCities(cityName, null, null, count)
                .map(cityResponse -> cityResponse.getCities().get(0));
    }

    @Override
    public Single<CityModel> getCity(double lat, double lon, int count) {
        return zomatoApi.getCities(null, null, null, count)
                .map(cityResponse -> cityResponse.getCities().get(0));
    }
}
