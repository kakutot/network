package com.example.temp.data.network;

import com.example.temp.data.model.CollectionModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ZomatoApi {

    String BASE_URL = "https://developers.zomato.com/api/v2.1/";

    String API_KEY = "531465a0826b509aef8133185948a1f9";

    String COLLECTIONS = "collections";
    String PARAM_CITY_ID = "city_id";
    String PARAM_LON = "lon";
    String PARAM_LAT = "lat";
    String PARAM_COUNT = "count";


    @GET(COLLECTIONS)
    Observable<List<CollectionModel>> getCollections (@Query(PARAM_CITY_ID) Integer cityId,
                                                      @Query(PARAM_LON) Double lon,
                                                      @Query(PARAM_LAT) Double lat,
                                                      @Query(PARAM_COUNT) Integer count);
}
