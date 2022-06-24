package com.meow.testanime.ModelsCharacter;

import java.io.Serializable;

public class Images implements Serializable {
    private Jpg jpg;
    private Webp webp;

    public Jpg getJpg() {
        return jpg;
    }

    public void setJpg(Jpg jpg) {
        this.jpg = jpg;
    }

    public Webp getWebp() {
        return webp;
    }

    public void setWebp(Webp webp) {
        this.webp = webp;
    }
}
