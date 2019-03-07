package com.example.temp.data.network;

import com.example.temp.data.model.CollectionModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class ZomatoService implements ZomatoApi{

    private final Retrofit retrofit;
    private ZomatoApi zomatoApi;

    public ZomatoService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Observable<List<CollectionModel>> getCollections(Integer cityId, Double lat, Double lon, Integer count) {
        ifEmptyInitApi();

        return zomatoApi.getCollections(cityId, lat, lon, count);
    }

    private ZomatoApi ifEmptyInitApi() {
        if(zomatoApi == null) {
            retrofit.create(zomatoApi.getClass());
        }

        return zomatoApi;
    }
}
