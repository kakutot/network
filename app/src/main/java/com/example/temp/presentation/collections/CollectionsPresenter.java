package com.example.temp.presentation.collections;

import com.example.temp.domain.navigation.CollectionsScreenRouter;
import com.example.temp.domain.navigation.Router;
import com.example.temp.presentation.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

public class CollectionsPresenter extends BasePresenter<CollectionsContract.CollectionsView, CollectionsScreenRouter> {

    public CollectionsPresenter(CompositeDisposable compositeDisposable,
                                CollectionsContract.CollectionsView view, Router router) {
        super(compositeDisposable, view, router);
    }
}
