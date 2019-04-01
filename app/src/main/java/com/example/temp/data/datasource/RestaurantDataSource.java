package com.example.temp.data.datasource;

import com.example.temp.domain.entity.Restaurant;

import java.util.List;

import io.reactivex.Observable;

public interface RestaurantDataSource {

    Observable<List<Restaurant>> getRestaurantsByCollectionId(int collectionId, int start, int count);

    Observable<List<Restaurant>> getRestaurantsByCollectionIdAsc(int collectionId, int start, int count);

    Observable<List<Restaurant>> getRestaurantsByCollectionIdDesc(int collectionId, int start, int count);

    Observable<Restaurant> getRestaurant(int restaurantId);
}
