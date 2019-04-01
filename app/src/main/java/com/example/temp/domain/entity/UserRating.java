package com.example.temp.domain.entity;

public final class UserRating {

    private final double aggrRating;

    private final String ratingText;

    private final String ratingColor;

    private final int votes;

    private UserRating(double aggrRating, String ratingText, String ratingColor, int votes) {
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

        public UserRating build () {
            return new UserRating(this.aggrRating, this.ratingText, this.ratingColor, this.votes);
        }

        public Builder setAggrRating(double aggrRating) {
            this.aggrRating = aggrRating;

            return this;
        }

        public Builder setRatingText(String ratingText) {
            this.ratingText = ratingText;

            return this;
        }

        public Builder setRatingColor(String ratingColor) {
            this.ratingColor = ratingColor;

            return this;
        }

        public Builder setVotes(int votes) {
            this.votes = votes;

            return this;
        }
    }
}
