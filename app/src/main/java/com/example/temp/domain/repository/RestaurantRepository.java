package com.example.temp.domain.repository;

import com.example.temp.domain.entity.Restaurant;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public interface RestaurantRepository {

    Observable<List<Restaurant>> getRestaurantsByCollectionId(@NonNull int collectionId);

    Observable<List<Restaurant>> getRestaurantsByCollectionIdAsc(@NonNull int collectionId);

    Observable<List<Restaurant>> getRestaurantsByCollectionIdDesc(@NonNull int collectionId);

    Observable<Restaurant> getRestaurant(@NonNull int restaurantId);

    Completable saveRestaurant(Restaurant restaurant);

    Completable saveRestaurant(int restaurantId);
}
