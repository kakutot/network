package com.example.temp.presentation.collections;

import android.util.Log;

import com.example.temp.domain.entity.City;
import com.example.temp.domain.entity.Collection;
import com.example.temp.domain.navigation.CollectionsRouter;
import com.example.temp.domain.navigation.Router;
import com.example.temp.domain.repository.CityRepository;
import com.example.temp.domain.repository.CollectionRepository;
import com.example.temp.presentation.BasePresenter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class CollectionsPresenter
        extends BasePresenter<CollectionsContract.CollectionsView, CollectionsRouter>
        implements CollectionsContract.CollectionsPresenter {

    private PublishSubject<String> cityQuery;
    private CityRepository cityRepository;
    private CollectionRepository collectionRepository;

    public CollectionsPresenter(CollectionRepository collectionRepository, CityRepository cityRepository,
                                CollectionsContract.CollectionsView view, Router router) {
        super(view, router);
        this.cityRepository = cityRepository;
        this.collectionRepository = collectionRepository;
    }

    @Override
    public void collectionsSearch(String cityName) {
       //disposeAll();
        cityQuery.onNext(cityName);
    }

    @Override
    public void collectionsSearchDefault() {

    }

    @Override
    public void navigateToRestaurantsScreen(int collectionId) {

    }

    @Override
    public void attachView(CollectionsContract.CollectionsView view) {
        super.attachView(view);
        cityQuery = PublishSubject.create();
        addDisposable(cityQuery.debounce(3, TimeUnit.SECONDS)
                .filter(val-> !val.isEmpty())
                .flatMapSingle(name -> cityRepository.getCities(name,1))
                .doOnNext(new Consumer<City>() {
                    @Override
                    public void accept(City city) throws Exception {
                        Log.i(getClass().getName(), "City : " + city);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i(getClass().getName(), "Error : " + Log.getStackTraceString(throwable));
                        getView().showLoadingError();
                    }
                })
                .observeOn(Schedulers.io())
                .flatMapSingle(city -> collectionRepository.getCollectionsByCityId(city.getId(),10))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Collection>>() {
                    @Override
                    public void onNext(List<Collection> collections) {
                        for(Collection collection : collections) {
                            Log.i(getClass().getName(), collection.toString());
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i(getClass().getName(), "Error : " + Log.getStackTraceString(e));
                        getView().showLoadingError();
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
                                /*.subscribe(new DisposableObserver<List<Collection>>() {
                                    @Override
                                    public void onNext(List<Collection> collections) {
                                        Log.i(getClass().getName(), "RESULT :" + collections);
                                        getView().renderCollections(collections);
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        e.printStackTrace();
                                        getView().showLoadingError();
                                    }

                                    @Override
                                    public void onComplete() {
                                        Log.i(getClass().getName(), "Done");
                                    }
                                });*/

    }

    @Override
    public void detachView() {
        super.detachView();
        cityQuery = null;
    }

    @Override
    public void navigateBack() {

    }
}
