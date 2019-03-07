package com.example.temp.domain.entity;

public final class City {

    private final int id;

    private final String name;

    private final int countryId;

    private final String countryName;

    private City(int id, String name, int countryId, String countryName) {
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

    public static class Builder {
        private int id;

        private String name;

        private int countryId;

        private String countryName;

        public Builder() {
            id = -1;
        }

        public City build() {
            return new City(this.id, this.name, this.countryId, this.countryName);
        }

        public Builder setId(int id) {
            this.id = id;

            return this;
        }

        public Builder setName(String name) {
            this.name = name;

            return this;
        }

        public Builder setCountryId(int countryId) {
            this.countryId = countryId;

            return this;
        }

        public Builder setCountryName(String countryName) {
            this.countryName = countryName;

            return this;
        }
    }
}
