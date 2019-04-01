package com.example.temp.presentation.navigation;

import androidx.appcompat.app.AppCompatActivity;

import com.example.temp.R;
import com.example.temp.domain.navigation.CollectionsRouter;
import com.example.temp.presentation.collections.CollectionsFragment;
import com.example.temp.presentation.restaurants.RestaurantsFragment;

public class CollectionScreenRouterImpl extends BaseRouter
        implements CollectionsRouter {

    public CollectionScreenRouterImpl(AppCompatActivity context) {
        super(context);
    }

    @Override
    public void routeToCollectionsScreen() {
        addFragmentToActivity(CollectionsFragment.getInstance(), R.id.contentFL);
    }

    @Override
    public void routeToRestaurantsScreen(int collectionId) {
        addFragmentToActivity(RestaurantsFragment.getInstance(), R.id.contentFL );
    }

    @Override
    public void routeBack() {
        throw new UnsupportedOperationException("Collections screen is app's primary screen");
    }
}
