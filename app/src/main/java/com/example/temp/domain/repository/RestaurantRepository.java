package com.example.temp.domain.repository;

import com.example.temp.domain.entity.Restaurant;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface RestaurantRepository {

    Observable<List<Restaurant>> getRestaurantsByCollectionId(int collectionId, int start, int count);

    Observable<List<Restaurant>> getRestaurantsByCollectionIdAsc(int collectionId, int start, int count);

    Observable<List<Restaurant>> getRestaurantsByCollectionIdDesc(int collectionId, int start, int count);

    Observable<Restaurant> getRestaurant(int restaurantId);

    Completable saveRestaurant(Restaurant restaurant);

    Completable saveRestaurant(int restaurantId);

    Completable removeRestaurant(int restaurantId);
}
