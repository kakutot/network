package com.example.temp.domain.mvpbase;

import com.example.temp.domain.navigation.Router;

public interface BaseContract {

    interface BaseView<P extends BasePresenter> {

        void onError();

        boolean isActive();

        P getPresenter();

        //TODO delete
        void setPresenter(P presenter);
    }

    interface BasePresenter<V extends BaseView> {

        void attachView(V v);

        void detachView();

        V getView();

        boolean isViewAttached();

        void onError(Throwable throwable);

        Router getRouter();

        void navigateBack();
    }
}