package com.example.temp.data.datasource;

import com.example.temp.data.model.CollectionModel;

import java.util.List;

import io.reactivex.Observable;

public interface CollectionDataSource {

    Observable <List<CollectionModel>> getCollectionsByCityId(int cityId);

    Observable <List<CollectionModel>> getCollectionsByCityId(int cityId, int count);

    Observable <List<CollectionModel>> getCollectionsByCityId(int cityId, double lat, double lon);

    Observable <List<CollectionModel>> getCollectionsByCityId(int cityId, double lat, double lon, int count);
}
