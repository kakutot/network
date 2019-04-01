package com.example.temp.presentation.restaurantdetails;

import com.example.temp.domain.entity.Restaurant;
import com.example.temp.domain.mvpbase.BaseContract;
import com.example.temp.presentation.restaurants.RestaurantsContract;

public interface RestaurantDetailsContract {

    interface RestaurantDetailsView extends BaseContract.BaseView {

        void showSavingError();

        void showSavingSuccess();

        void renderRestaurant(Restaurant restaurant);
    }

    interface RestaurantsPresenter extends BaseContract.BasePresenter<RestaurantsContract.RestaurantsView> {

        void saveRestaurant(Restaurant restaurant);
    }
}
