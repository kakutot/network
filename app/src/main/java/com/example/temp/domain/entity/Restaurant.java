package com.example.temp.domain.entity;

public final class Restaurant {

    private final int id;

    private final String name;

    private final Location location;

    private final double averageCostForTwo;

    private final String currency;

    private final String featuredImage;

    private final UserRating userRating;

    public Restaurant(int id, String name, Location location, double averageCostForTwo,
                      String currency, String featuredImage, UserRating userRating) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.averageCostForTwo = averageCostForTwo;
        this.currency = currency;
        this.featuredImage = featuredImage;
        this.userRating = userRating;
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

    public UserRating getUserRating() {
        return userRating;
    }

    public static class Builder {

        private int id;

        private String name;

        private Location location;

        private double averageCostForTwo;

        private String currency;

        private String featuredImage;

        private UserRating userRating;

        public Builder () {

        }

        public Restaurant build() {
            return new Restaurant(this.id, this.name, this.location, this.averageCostForTwo,
                    this.currency, this.featuredImage, this.userRating);
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

        public Builder setUserRating(UserRating userRating) {
            this.userRating = userRating;

            return this;
        }
    }
}
