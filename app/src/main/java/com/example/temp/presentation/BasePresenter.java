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

    public BasePresenter(V view, Router router) {
        this.view = view;
        this.router = router;
    }

    private void clearResources() {
        if(compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    protected void addDisposable(Disposable disposable) {
        initAndGetCD().add(disposable);
    }

    protected void disposeAll() {
        if(compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    private CompositeDisposable initAndGetCD() {
        if(compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        return compositeDisposable;
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
