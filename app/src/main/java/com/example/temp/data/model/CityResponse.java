package com.example.temp.data.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityResponse {

    @SerializedName("location_suggestions")
    private List<CityModel> cities;

    public List<CityModel> getCities() {
        return cities;
    }
}
