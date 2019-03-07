package com.example.temp.data.datasource;

import com.example.temp.data.model.CollectionModel;
import com.example.temp.data.network.ZomatoApi;

import java.util.List;

import io.reactivex.Observable;

public class CollectionNetworkDataSource implements CollectionDataSource {

    private ZomatoApi zomatoApi;

    public CollectionNetworkDataSource(ZomatoApi zomatoApi) {
        this.zomatoApi = zomatoApi;
    }

    @Override
    public Observable<List<CollectionModel>> getCollectionsByCityId(int cityId) {
        return zomatoApi
                .getCollections(new Integer(cityId), null, null, null);
    }

    @Override
    public Observable<List<CollectionModel>> getCollectionsByCityId(int cityId, int count) {
        return zomatoApi
                .getCollections(new Integer(cityId), null, null, count);
    }

    @Override
    public Observable<List<CollectionModel>> getCollectionsByCityId(double lat, double lon) {
        return zomatoApi
                .getCollections(null, Double.valueOf(lon),  Double.valueOf(lat), null);
    }

    @Override
    public Observable<List<CollectionModel>> getCollectionsByCityId(double lat, double lon, int count) {
        return zomatoApi
                .getCollections(null, Double.valueOf(lon),  Double.valueOf(lat), count);
    }
}
