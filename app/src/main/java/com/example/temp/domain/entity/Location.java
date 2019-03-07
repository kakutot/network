package com.example.temp.domain.entity;

public final class Location implements Cloneable{

    private final String address;

    private final String city;

    private final double latitude;

    private final double longitude;

    private final double countryId;

    private Location(String address, String city, double latitude, double longitude, double countryId) {
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

    public static class LocationBuilder {
        private String address;

        private String city;

        private double latitude;

        private double longitude;

        private double countryId;

        public Location build () {
            return new Location(this.address, this.city, this.latitude, this.longitude, this.countryId);
        }

        public LocationBuilder setAddress(String address) {
            this.address = address;

            return this;
        }

        public LocationBuilder setCity(String city) {
            this.city = city;

            return this;
        }

        public LocationBuilder setLatitude(double latitude) {
            this.latitude = latitude;

            return this;
        }

        public LocationBuilder setLongitude(double longitude) {
            this.longitude = longitude;

            return this;
        }

        public void setCountry_id(double countryId) {
            this.countryId = countryId;
        }
    }
}
