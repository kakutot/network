package com.example.temp.data.datasource;

import com.example.temp.data.model.CollectionModel;
import com.example.temp.data.model.CollectionsResponse;
import com.example.temp.data.network.ZomatoApi;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class CollectionNetworkDataSource implements CollectionDataSource {

    private ZomatoApi zomatoApi;

    public CollectionNetworkDataSource(ZomatoApi zomatoApi) {
        this.zomatoApi = zomatoApi;
    }


    @Override
    public Single<List<CollectionModel>> getCollectionsByCityId(int cityId, int count) {
        return zomatoApi.getCollections(cityId, count)
                .map(CollectionsResponse::getCollections);
    }
}
