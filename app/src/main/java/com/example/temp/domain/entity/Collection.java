package com.example.temp.domain.entity;

public final class Collection {

    private final int id;

    private final String title;

    private final String imageUrl;

    private final int resCount;

    private Collection(int id, String title, String imageUrl, int resCount) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.resCount = resCount;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getResCount() {
        return resCount;
    }

    public static class Builder {

        private int id;

        private String title;

        private String imageUrl;

        private int resCount;

        public Builder() {
            id = -1;
        }

        public Collection build() {
            return new Collection(this.id, this.title, this.imageUrl, this.resCount);
        }

        public Builder setId(int id) {
            this.id = id;

            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;

            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;

            return this;
        }

        public Builder setResCount(int resCount) {
            this.resCount = resCount;

            return this;
        }
    }
}
