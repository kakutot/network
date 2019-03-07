package com.example.temp.data.repositoryimpl;

import com.example.temp.data.datasource.CollectionDataSource;
import com.example.temp.data.mapper.EntityMapper;
import com.example.temp.data.model.CollectionModel;
import com.example.temp.domain.entity.Collection;
import com.example.temp.domain.repository.CollectionRepository;

import java.util.List;

import io.reactivex.Observable;

public class CollectionRepositoryImpl implements CollectionRepository {

    private EntityMapper<CollectionModel, Collection> entityMapper;
    private CollectionDataSource networkDataSource;

    public CollectionRepositoryImpl(CollectionDataSource networkDataSource, EntityMapper<CollectionModel, Collection> entityMapper ) {
        this.networkDataSource = networkDataSource;
    }

    @Override
    public Observable<List<Collection>> getCollectionsByCityId(int cityId) {
        return networkDataSource
                .getCollectionsByCityId(Integer.valueOf(cityId))
                .map(entityMapper::mapMany);
    }

    @Override
    public Observable<List<Collection>> getCollectionsByCityId(int cityId, int count) {
        return networkDataSource
                .getCollectionsByCityId(cityId, count)
                .map(entityMapper::mapMany);
    }

    @Override
    public Observable<List<Collection>> getCollectionsByCityId(int cityId, double lat, double lon) {
        return networkDataSource
                .getCollectionsByCityId(cityId, lat, lon)
                .map(entityMapper::mapMany);
    }

    @Override
    public Observable<List<Collection>> getCollectionsByCityId(int cityId, double lon, double lat, int count) {
        return networkDataSource
                .getCollectionsByCityId(cityId, lat, lon, count)
                .map(entityMapper::mapMany);
    }

}
