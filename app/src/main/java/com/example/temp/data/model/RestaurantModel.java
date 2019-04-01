package com.example.temp.data.model;

public class RestaurantModel {

    private final int id;

    private final String name;

    private final LocationModel location;

    private final double averageCostForTwo;

    private final String currency;

    private final String featuredImage;

    private final UserRatingModel userRatingModel;

    private RestaurantModel(int id, String name, LocationModel location, double averageCostForTwo,
                            String currency, String featuredImage, UserRatingModel userRatingModel) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.averageCostForTwo = averageCostForTwo;
        this.currency = currency;
        this.featuredImage = featuredImage;
        this.userRatingModel = userRatingModel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocationModel getLocation() {
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

    public UserRatingModel getUserRatingModel() {
        return userRatingModel;
    }

    public static class Builder {

        private int id;

        private String name;

        private LocationModel location;

        private double averageCostForTwo;

        private String currency;

        private String featuredImage;

        private UserRatingModel userRatingModel;

        public RestaurantModel build () {
            return new RestaurantModel(this.id, this.name, this.location,
                    this.averageCostForTwo, this.currency, this.featuredImage, this.userRatingModel);
        }

        public Builder setId(int id) {
            this.id = id;

            return this;
        }

        public Builder setName(String name) {
            this.name = name;

            return this;
        }

        public Builder setLocation(LocationModel location) {
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

        public Builder setUserRatingModel(UserRatingModel userRatingModel) {
            this.userRatingModel = userRatingModel;

            return this;
        }
    }
}
