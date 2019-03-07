package com.example.temp.presentation;

import com.example.temp.domain.mvpbase.BaseContract;
import com.example.temp.domain.navigation.Router;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends BaseContract.BaseView, R extends Router>
        implements BaseContract.BasePresenter<V>  {

    private CompositeDisposable compositeDisposable;
    private V view;
    private Router router;

    public BasePresenter(CompositeDisposable compositeDisposable, V view, Router router) {
        this.compositeDisposable = compositeDisposable;
        this.view = view;
        this.router = router;
    }

    private void clearResources() {
        compositeDisposable.clear();
    }

    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        clearResources();
    }

    @Override
    public V getView() {
        return view;
    }


    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void onError(Throwable throwable) {
        view.onError();
    }

    @Override
    public Router getRouter() {
        return router;
    }

}
