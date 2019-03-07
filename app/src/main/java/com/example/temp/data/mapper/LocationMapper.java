package com.example.temp.data.mapper;

import com.example.temp.data.model.LocationModel;
import com.example.temp.domain.entity.Location;

import java.util.LinkedList;
import java.util.List;

public class LocationMapper implements EntityMapper<LocationModel, Location> {

    @Override
    public Location map(LocationModel locationModel) {
        Location.Builder builder = new Location.Builder();

        builder.setAddress(locationModel.getAddress())
                .setCity(locationModel.getCity())
                .setLatitude(locationModel.getLatitude())
                .setLongitude(locationModel.getLongitude())
                .setCountryId(locationModel.getCountryId());

        return builder.build();
    }

    @Override
    public List<Location> mapMany(List<LocationModel> locationModels) {
        List<Location> locations = new LinkedList<>();

        for(LocationModel locationModel : locationModels) {
            locations.add(map(locationModel));
        }

        return locations;
    }

    @Override
    public LocationModel mapBack(Location entity) {
        LocationModel.Builder builder = new LocationModel.Builder();

        builder.setAddress(entity.getAddress())
                .setCity(entity.getCity())
                .setCountryId(entity.getCountryId())
                .setLatitude(entity.getLatitude())
                .setLongitude(entity.getLongitude());

        return builder.build();
    }

    @Override
    public List<LocationModel> mapBackMany(List<Location> locations) {
        List<LocationModel> locationModels = new LinkedList<>();

        for(Location location : locations) {
            locationModels.add(mapBack(location));
        }

        return locationModels;
    }
}
