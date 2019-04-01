package com.example.temp.data.repositoryimpl;

import com.example.temp.data.datasource.CityDataSource;
import com.example.temp.data.mapper.EntityMapper;
import com.example.temp.data.model.CityModel;
import com.example.temp.domain.entity.City;
import com.example.temp.domain.repository.CityRepository;

import io.reactivex.Observable;
import io.reactivex.Single;

public class CityRepositoryImpl implements CityRepository {

    private CityDataSource networkCityDataSource;
    private EntityMapper<CityModel, City> mapper;

    public CityRepositoryImpl(CityDataSource networkCityDataSource, EntityMapper<CityModel, City> mapper) {
        this.networkCityDataSource = networkCityDataSource;
        this.mapper = mapper;
    }

    @Override
    public Single<City> getCities(String cityName, int count) {
        return networkCityDataSource.getCity(cityName, count).map(mapper::map);
    }
}
