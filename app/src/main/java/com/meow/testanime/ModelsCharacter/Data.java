package com.meow.testanime.ModelsCharacter;

import java.io.Serializable;

public class Data implements Serializable {
    private int mal_id;
    private String url;
    private Images images;
    private String name;
    private String name_kanji;
    private String[] nicknames;
    private int favorites;
    private String about;

    public int getMalId() {
        return mal_id;
    }

    public void setMalId(int mal_id) {
        this.mal_id = mal_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameKanji() {
        return name_kanji;
    }

    public void setNameKanji(String name_kanji) {
        this.name_kanji = name_kanji;
    }

    public String[] getNicknames() {
        return nicknames;
    }

    public void setNicknames(String[] nicknames) {
        this.nicknames = nicknames;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
