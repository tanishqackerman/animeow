package com.meow.testanime.DBModels;

import android.view.View;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class AnimeDB implements Serializable {
    private int id;
    private String animename;
    private String imgurl;
    private String animescore;
    private String animeairingperiod;
    private String animeep;
    private String animeage;
    private String learnmore;
    private String animetrailer;
    private String animesypnosis;

    public AnimeDB(int id, String animename, String imgurl, String animescore, String animeairingperiod, String animeep, String animeage, String learnmore, String animetrailer, String animesypnosis) {
        this.id = id;
        this.animename = animename;
        this.imgurl = imgurl;
        this.animescore = animescore;
        this.animeairingperiod = animeairingperiod;
        this.animeep = animeep;
        this.animeage = animeage;
        this.learnmore = learnmore;
        this.animetrailer = animetrailer;
        this.animesypnosis = animesypnosis;
    }

    public AnimeDB(String animename, String imgurl, String animescore, String animeairingperiod, String animeep, String animeage, String learnmore, String animetrailer, String animesypnosis) {
        this.animename = animename;
        this.imgurl = imgurl;
        this.animescore = animescore;
        this.animeairingperiod = animeairingperiod;
        this.animeep = animeep;
        this.animeage = animeage;
        this.learnmore = learnmore;
        this.animetrailer = animetrailer;
        this.animesypnosis = animesypnosis;
    }

    public AnimeDB() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimename() {
        return animename;
    }

    public void setAnimename(String animename) {
        this.animename = animename;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getAnimescore() {
        return animescore;
    }

    public void setAnimescore(String animescore) {
        this.animescore = animescore;
    }

    public String getAnimeairingperiod() {
        return animeairingperiod;
    }

    public void setAnimeairingperiod(String animeairingperiod) {
        this.animeairingperiod = animeairingperiod;
    }

    public String getAnimeep() {
        return animeep;
    }

    public void setAnimeep(String animeep) {
        this.animeep = animeep;
    }

    public String getAnimeage() {
        return animeage;
    }

    public void setAnimeage(String animeage) {
        this.animeage = animeage;
    }

    public String getLearnmore() {
        return learnmore;
    }

    public void setLearnmore(String learnmore) {
        this.learnmore = learnmore;
    }

    public String getAnimetrailer() {
        return animetrailer;
    }

    public void setAnimetrailer(String animetrailer) {
        this.animetrailer = animetrailer;
    }

    public String getAnimesypnosis() {
        return animesypnosis;
    }

    public void setAnimesypnosis(String animesypnosis) {
        this.animesypnosis = animesypnosis;
    }
}
