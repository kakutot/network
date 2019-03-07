package com.example.temp.data.model;


public final class CollectionModel {

    private final int id;

    private final String title;

    private final String imageUrl;

    private final int resCount;

    public CollectionModel(int id, String title, String imageUrl, int resCount) {
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

    public static class CollectionModelBuilder {

        private int id;

        private String title;

        private String imageUrl;

        private int resCount;

        public CollectionModelBuilder() {
            id = -1;
        }

        public CollectionModel build() {
            return new CollectionModel(this.id, this.title, this.imageUrl, this.resCount);
        }

        public CollectionModelBuilder  setId(int id) {
            this.id = id;

            return this;
        }

        public CollectionModelBuilder setTitle(String title) {
            this.title = title;

            return this;
        }

        public CollectionModelBuilder  setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;

            return this;
        }

        public CollectionModelBuilder setResCount(int resCount) {
            this.resCount = resCount;

            return this;
        }
    }

}
