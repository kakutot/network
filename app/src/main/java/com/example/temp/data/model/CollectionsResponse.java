package com.example.temp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionsResponse {

    @SerializedName("collections")
    private List<CollectionModel> collections;

    public List<CollectionModel> getCollections() {
        return collections;
    }
}
