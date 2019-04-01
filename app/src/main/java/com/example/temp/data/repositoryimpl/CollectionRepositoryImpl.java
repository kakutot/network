package com.example.temp.data.repositoryimpl;

import com.example.temp.data.datasource.CollectionDataSource;
import com.example.temp.data.mapper.EntityMapper;
import com.example.temp.data.model.CollectionModel;
import com.example.temp.domain.entity.Collection;
import com.example.temp.domain.repository.CollectionRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class CollectionRepositoryImpl implements CollectionRepository {

    private EntityMapper<CollectionModel, Collection> entityMapper;
    private CollectionDataSource networkDataSource;

    public CollectionRepositoryImpl(CollectionDataSource networkDataSource, EntityMapper<CollectionModel, Collection> entityMapper ) {
        this.networkDataSource = networkDataSource;
        this.entityMapper = entityMapper;
    }


    @Override
    public Single<List<Collection>> getCollectionsByCityId(int cityId, int count) {
        return networkDataSource
                .getCollectionsByCityId(cityId, count)
                .map(entityMapper::mapMany);
    }
}
