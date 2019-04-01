package com.example.temp.domain.repository;

import com.example.temp.domain.entity.City;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface CityRepository {

    Single<City> getCities(String cityName, int count);

}
