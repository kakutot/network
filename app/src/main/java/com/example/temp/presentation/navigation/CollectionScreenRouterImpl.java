package com.example.temp.presentation.navigation;

import android.support.v7.app.AppCompatActivity;

import com.example.temp.domain.navigation.CollectionsScreenRouter;

public class CollectionScreenRouterImpl extends BaseRouter
        implements CollectionsScreenRouter {

    protected CollectionScreenRouterImpl(AppCompatActivity context) {
        super(context);
    }

    @Override
    public void routeToCollectionsScreen() {

    }

    @Override
    public void routeToRestaurantsScreen(int collectionId) {

    }

    @Override
    public void navigateBack() {

    }
}
