package com.example.temp.data.model;

public class UserRatingModel {

    private final double aggrRating;

    private final String ratingText;

    private final String ratingColor;

    private final int votes;

    public UserRatingModel(double aggrRating, String ratingText, String ratingColor, int votes) {
        this.aggrRating = aggrRating;
        this.ratingText = ratingText;
        this.ratingColor = ratingColor;
        this.votes = votes;
    }

    public double getAggrRating() {
        return aggrRating;
    }

    public String getRatingText() {
        return ratingText;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public int getVotes() {
        return votes;
    }

    public static class Builder {

        private double aggrRating;

        private String ratingText;

        private String ratingColor;

        private int votes;

        public Builder () {

        }

        public UserRatingModel build () {
            return new UserRatingModel(this.aggrRating, this.ratingText, this.ratingColor, this.votes);
        }

        public UserRatingModel.Builder setAggrRating(double aggrRating) {
            this.aggrRating = aggrRating;

            return this;
        }

        public UserRatingModel.Builder setRatingText(String ratingText) {
            this.ratingText = ratingText;

            return this;
        }

        public UserRatingModel.Builder setRatingColor(String ratingColor) {
            this.ratingColor = ratingColor;

            return this;
        }

        public UserRatingModel.Builder setVotes(int votes) {
            this.votes = votes;

            return this;
        }
    }
}
