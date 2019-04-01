package com.example.temp.data.network;

import com.example.temp.data.model.CityModel;
import com.example.temp.data.model.CityResponse;
import com.example.temp.data.model.CollectionModel;
import com.example.temp.data.model.CollectionsResponse;

import java.util.List;

import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class ZomatoService implements ZomatoApi{

    private final Retrofit retrofit;
    private ZomatoApi zomatoApi;

    public ZomatoService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    private ZomatoApi ifEmptyInitApi() {
        if(zomatoApi == null) {
           zomatoApi = retrofit.create(ZomatoApi.class);
        }

        return zomatoApi;
    }

    @Override
    public Single<CollectionsResponse> getCollections(@Nullable Integer cityId, @Nullable Integer count) {
        ifEmptyInitApi();

        return zomatoApi.getCollections(cityId, count);
    }

    @Override
    public Single<CityResponse> getCities(String query, @Nullable Double lon, @Nullable Double lat, Integer count) {
        ifEmptyInitApi();

        return zomatoApi.getCities(query, lon, lat, count);
    }
}