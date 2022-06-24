package com.meow.testanime.ModelsManga;

import java.io.Serializable;

public class Images implements Serializable {
    private Jpg jpg;
    private Jpg webp;

    public Jpg getJpg() {
        return jpg;
    }

    public void setJpg(Jpg jpg) {
        this.jpg = jpg;
    }

    public Jpg getWebp() {
        return webp;
    }

    public void setWebp(Jpg webp) {
        this.webp = webp;
    }
}
