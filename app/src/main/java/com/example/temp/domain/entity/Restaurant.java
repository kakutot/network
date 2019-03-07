package com.example.temp.domain.entity;

public final class Restaurant {

    private final int id;

    private final String name;

    private final Location location;

    private final double averageCostForTwo;

    private final String currency;

    private final String featuredImage;

    public Restaurant(int id, String name, Location location, double averageCostForTwo, String currency, String featuredImage) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.averageCostForTwo = averageCostForTwo;
        this.currency = currency;
        this.featuredImage = featuredImage;
    }


}
