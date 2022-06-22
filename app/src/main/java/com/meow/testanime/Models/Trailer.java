package com.meow.testanime.Models;

import java.io.Serializable;

public class Trailer implements Serializable {
    private String youtube_id;
    private String url;
    private String embed_url;
    private Images2 images;

    public String getYoutubeId() {
        return youtube_id;
    }

    public void setYoutubeId(String youtube_id) {
        this.youtube_id = youtube_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmbedUrl() {
        return embed_url;
    }

    public void setEmbedUrl(String embed_url) {
        this.embed_url = embed_url;
    }

    public Images2 getImages() {
        return images;
    }

    public void setImages(Images2 images) {
        this.images = images;
    }
}
