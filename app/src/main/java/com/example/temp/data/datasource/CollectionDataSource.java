package com.example.temp.data.datasource;

import com.example.temp.data.model.CollectionModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface CollectionDataSource {

    Single<List<CollectionModel>> getCollectionsByCityId(int cityId, int count);
}
