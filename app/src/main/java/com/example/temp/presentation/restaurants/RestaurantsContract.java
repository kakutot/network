package com.example.temp.presentation.restaurants;

import com.example.temp.domain.entity.Restaurant;
import com.example.temp.domain.mvpbase.BaseContract;

import java.util.List;

public interface RestaurantsContract {

    interface RestaurantsView extends BaseContract.BaseView<RestaurantsPresenter> {

        void renderRestaurants(List<Restaurant> restaurants);

        void showRestaurantsOrderSelectionView();
    }

    interface RestaurantsPresenter extends BaseContract.BasePresenter<RestaurantsView> {

        void orderRestaurantsAsc(String query);

        void orderRestaurantsDesc(String query);

        void restaurantsSearch(String query);

        void navigateToRestaurantDetailsScreen(int restaurantId);
    }
}
