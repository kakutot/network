package com.example.temp.data.network;

import com.example.temp.data.model.CityResponse;
import com.example.temp.data.model.CollectionsResponse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.Single;
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

    String CITIES = "cities";
    String PARAM_QUERY = "q";

    @GET(COLLECTIONS)
    Single<CollectionsResponse> getCollections (@NonNull @Query(PARAM_CITY_ID) Integer cityId,
                                                @Nullable @Query(PARAM_COUNT) Integer count);

    @GET(CITIES)
    Single<CityResponse> getCities(@Nullable @Query(PARAM_QUERY) String query, @Nullable @Query(PARAM_LON) Double lon,
                                         @Nullable @Query(PARAM_LAT) Double lat, @Query(PARAM_COUNT) Integer count);
}
