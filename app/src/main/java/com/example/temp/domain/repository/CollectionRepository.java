package com.example.temp.domain.repository;


import com.example.temp.domain.entity.Collection;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface CollectionRepository {

    Single<List<Collection>> getCollectionsByCityId(int cityId, int count);
}
