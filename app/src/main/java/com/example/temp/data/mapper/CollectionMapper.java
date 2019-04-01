package com.example.temp.data.mapper;

import com.example.temp.data.model.CollectionModel;
import com.example.temp.domain.entity.Collection;

import java.util.LinkedList;
import java.util.List;

public class CollectionMapper implements EntityMapper<CollectionModel, Collection> {

    @Override
    public Collection map(CollectionModel collectionModel) {
        Collection.Builder builder = new Collection.Builder();

        builder.setId(collectionModel.getId())
                .setImageUrl(collectionModel.getImageUrl())
                .setTitle(collectionModel.getTitle())
                .setResCount(collectionModel.getResCount());

        return builder.build();
    }

    @Override
    public List<Collection> mapMany(List<CollectionModel> models) {
        List<Collection> collections = new LinkedList<>();

        for(CollectionModel collectionModel : models) {
            collections.add(map(collectionModel));
        }

        return collections;
    }

    @Override
    public CollectionModel mapBack(Collection entity) {
        CollectionModel.CollectionModelBuilder builder = new CollectionModel.CollectionModelBuilder();

        builder.setId(entity.getId())
                .setImageUrl(entity.getImageUrl())
                .setResCount(entity.getResCount())
                .setTitle(entity.getTitle());

        return builder.build();
    }

    @Override
    public List<CollectionModel> mapBackMany(List<Collection> collections) {
        List<CollectionModel> collectionModels = new LinkedList<>();

        for(Collection collection : collections) {
            collectionModels.add(mapBack(collection));
        }

        return collectionModels;
    }
}
