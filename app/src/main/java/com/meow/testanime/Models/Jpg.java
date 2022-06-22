package com.meow.testanime.Models;

import java.io.Serializable;

public class Jpg implements Serializable {
    private String image_url;
    private String small_image_url;
    private String large_image_url;

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public String getSmallImageUrl() {
        return small_image_url;
    }

    public void setSmallImageUrl(String small_image_url) {
        this.small_image_url = small_image_url;
    }

    public String getLargeImageUrl() {
        return large_image_url;
    }

    public void setLargeImageUrl(String large_image_url) {
        this.large_image_url = large_image_url;
    }
}
