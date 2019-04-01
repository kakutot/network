package com.example.temp.domain.entity;

import java.util.List;

public final class Location {

    private final String address;

    private final String city;

    private final double latitude;

    private final double longitude;

    private final double countryId;

    private Location(String address, String city, double latitude,
                     double longitude, double countryId) {
        this.address = address;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.countryId = countryId;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getCountryId() {
        return countryId;
    }

    public static class Builder {
        private String address;

        private String city;

        private double latitude;

        private double longitude;

        private double countryId;

        private List<Restaurant> restaurants;

        public Location build () {
            return new Location(this.address, this.city, this.latitude,
                    this.longitude, this.countryId);
        }

        public Builder setAddress(String address) {
            this.address = address;

            return this;
        }

        public Builder setCity(String city) {
            this.city = city;

            return this;
        }

        public Builder setLatitude(double latitude) {
            this.latitude = latitude;

            return this;
        }

        public Builder setLongitude(double longitude) {
            this.longitude = longitude;

            return this;
        }

        public void setCountryId(double countryId) {
            this.countryId = countryId;
        }
    }
}
