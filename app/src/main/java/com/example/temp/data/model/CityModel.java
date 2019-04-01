package com.example.temp.data.model;


import com.google.gson.annotations.SerializedName;

public class CityModel{

    private final int id;

    private final String name;

    @SerializedName("country_id")
    private final int countryId;

    @SerializedName("country_name")
    private final String countryName;

    public CityModel(int id, String name, int countryId, String countryName) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public static class CityModelModelBuilder {
        private int id;

        private String name;

        private int countryId;

        private String countryName;

        public CityModelModelBuilder() {
            id = -1;
        }

        public CityModel build() {
            return new CityModel(this.id, this.name, this.countryId, this.countryName);
        }

        public CityModel.CityModelModelBuilder setId(int id) {
            this.id = id;

            return this;
        }

        public CityModel.CityModelModelBuilder setName(String name) {
            this.name = name;

            return this;
        }

        public CityModel.CityModelModelBuilder setCountryId(int countryId) {
            this.countryId = countryId;

            return this;
        }

        public CityModel.CityModelModelBuilder setCountryName(String countryName) {
            this.countryName = countryName;

            return this;
        }
    }
}
