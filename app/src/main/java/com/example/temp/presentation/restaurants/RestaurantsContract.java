package com.example.temp.presentation.restaurants;

import com.example.temp.domain.mvpbase.BaseContract;

public interface RestaurantsContract {

    interface RestaurantsView extends BaseContract.BaseView {

        void renderRestaurants();
    }

    interface RestaurantsPresenter extends BaseContract.BasePresenter<RestaurantsView> {

        void restaurantsSearch(String query);
    }
}
