package com.example.temp.domain.repository;

import com.example.temp.domain.entity.City;

import io.reactivex.Observable;

public interface CityRepository {

    Observable<City> getCity(String cityName);

}
