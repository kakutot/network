package com.example.temp.data.model;


import com.google.gson.annotations.SerializedName;

public class CollectionModel {

    @SerializedName("collection_id")
    private final int id;

    @SerializedName("res_count")
    private final int resCount;

    private final String title;

    @SerializedName("image_url")
    private final String imageUrl;

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
