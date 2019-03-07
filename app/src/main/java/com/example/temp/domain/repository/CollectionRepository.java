package com.example.temp.domain.repository;


import com.example.temp.domain.entity.Collection;

import java.util.List;

import io.reactivex.Observable;

public interface CollectionRepository {

    Observable<List<Collection>> getCollectionsByCityId(int cityId);

    Observable<List<Collection>> getCollectionsByCityId(int cityId, int count);

    Observable<List<Collection>> getCollectionsByCityId(int cityId, double lon, double lat);

    Observable<List<Collection>> getCollectionsByCityId(int cityId, double lon, double lat, int count);
}
