package com.example.temp.data.mapper;

import com.example.tupkalenko.trainee.project.data.model.RestaurantModel;
import com.example.tupkalenko.trainee.project.domain.entity.Restaurant;

import java.util.LinkedList;
import java.util.List;

public class RestaurantMapper implements EntityMapper<RestaurantModel, Restaurant> {

    @Override
    public Restaurant map(RestaurantModel restaurantModel) {
        Restaurant.Builder builder = new Restaurant.Builder();

        builder.setId(restaurantModel.getId())
                .setName(restaurantModel.getName())
                .setCurrency(restaurantModel.getCurrency())
                .setAverageCostForTwo(restaurantModel.getAverageCostForTwo())
                .setFeaturedImage(restaurantModel.getFeaturedImage())
                .setLocation(restaurantModel.getLocation());

        return builder.build();
    }

    @Override
    public List<Restaurant> mapMany(List<RestaurantModel> restaurantModels) {
       List<Restaurant> restaurants = new LinkedList<>();

       for(RestaurantModel model : restaurantModels) {
           restaurants.add(map(model));
       }

       return restaurants;
    }

    @Override
    public RestaurantModel mapBack(Restaurant restaurant) {
        RestaurantModel.Builder builder = new RestaurantModel.Builder();

        builder.setId(restaurant.getId())
                .setAverageCostForTwo(restaurant.getAverageCostForTwo())
                .setCurrency(restaurant.getCurrency())
                .setFeaturedImage(restaurant.getFeaturedImage())
                .setName(restaurant.getName())
                .setAverageCostForTwo(restaurant.getAverageCostForTwo());

        return builder.build();
    }

    @Override
    public List<RestaurantModel> mapBackMany(List<Restaurant> restaurants) {
        List<RestaurantModel> restaurantModels = new LinkedList<>();

        for(Restaurant restaurant : restaurants) {
            restaurantModels.add(mapBack(restaurant));
        }

        return restaurantModels;
    }
}
