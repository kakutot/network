package com.example.temp.data.model;

import com.example.temp.domain.entity.Location;

public class RestaurantModel {

    private final int id;

    private final String name;

    private final Location location;

    private final double averageCostForTwo;

    private final String currency;

    private final String featuredImage;

    private RestaurantModel(int id, String name, Location location, double averageCostForTwo,
                            String currency, String featuredImage) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.averageCostForTwo = averageCostForTwo;
        this.currency = currency;
        this.featuredImage = featuredImage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public double getAverageCostForTwo() {
        return averageCostForTwo;
    }

    public String getCurrency() {
        return currency;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public static class Builder {

        private int id;

        private String name;

        private Location location;

        private double averageCostForTwo;

        private String currency;

        private String featuredImage;

        public RestaurantModel build () {
            return new RestaurantModel(this.id, this.name, this.location,
                    this.averageCostForTwo, this.currency, this.featuredImage);
        }

        public Builder setId(int id) {
            this.id = id;

            return this;
        }

        public Builder setName(String name) {
            this.name = name;

            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;

            return this;
        }

        public Builder setAverageCostForTwo(double averageCostForTwo) {
            this.averageCostForTwo = averageCostForTwo;

            return this;
        }

        public Builder setCurrency(String currency) {
            this.currency = currency;

            return this;
        }

        public Builder setFeaturedImage(String featuredImage) {
            this.featuredImage = featuredImage;

            return this;
        }
    }
}
