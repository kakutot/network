package com.example.temp.data.mapper;

import com.example.temp.data.model.CityModel;
import com.example.temp.domain.entity.City;

import java.util.LinkedList;
import java.util.List;

public class CityMapper implements EntityMapper<CityModel, City> {

    @Override
    public City map(CityModel cityModel) {
        City.Builder builder = new City.Builder();

        builder.setId(cityModel.getId())
                .setCountryId(cityModel.getCountryId())
                .setCountryName(cityModel.getCountryName())
                .setName(cityModel.getName());

        return builder.build();
    }

    @Override
    public List<City> mapMany(List<CityModel> models) {
        List<City> collections = new LinkedList<>();

        for(CityModel cityModel : models) {
            collections.add(map(cityModel));
        }

        return collections;
    }

    @Override
    public CityModel mapBack(City entity) {
        CityModel.CityModelModelBuilder builder = new CityModel.CityModelModelBuilder();

        builder.setId(entity.getId())
                .setName(entity.getName())
                .setCountryName(entity.getCountryName())
                .setCountryId(entity.getCountryId());

        return builder.build();
    }

    @Override
    public List<CityModel> mapBackMany(List<City> cities) {
        List<CityModel> models = new LinkedList<>();

        for(City city : cities) {
            models.add(mapBack(city));
        }

        return models;
    }
}
