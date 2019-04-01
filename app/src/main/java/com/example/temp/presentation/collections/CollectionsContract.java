package com.example.temp.presentation.collections;

import com.example.temp.domain.entity.Collection;
import com.example.temp.domain.mvpbase.BaseContract;
import com.example.temp.presentation.base.LoadingView;

import java.util.List;

public interface CollectionsContract {

    interface CollectionsView extends BaseContract.BaseView<CollectionsPresenter>, LoadingView {

        void renderCollections(List<Collection> collections);
    }

    interface CollectionsPresenter extends BaseContract.BasePresenter<CollectionsView> {

        void collectionsSearch(String cityName);

        void collectionsSearchDefault();

        void navigateToRestaurantsScreen(int collectionId);
    }
}
