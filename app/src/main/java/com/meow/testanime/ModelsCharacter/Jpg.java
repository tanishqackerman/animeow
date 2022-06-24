package com.meow.testanime.ModelsCharacter;

import java.io.Serializable;

public class Jpg implements Serializable {
    private String image_url;

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }
}
