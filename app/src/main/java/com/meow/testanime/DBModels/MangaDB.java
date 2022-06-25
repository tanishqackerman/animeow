package com.meow.testanime.DBModels;

import java.io.Serializable;

public class MangaDB implements Serializable {
    private int id;
    private String animename;
    private String imgurl;
    private String mangascore;
    private String mangapublishingperiod;
    private String mangach;
    private String mangavol;
    private String learnmore;
    private String mangaabout;

    public MangaDB(int id, String animename, String imgurl, String mangascore, String mangapublishingperiod, String mangach, String mangavol, String learnmore, String mangaabout) {
        this.id = id;
        this.animename = animename;
        this.imgurl = imgurl;
        this.mangascore = mangascore;
        this.mangapublishingperiod = mangapublishingperiod;
        this.mangach = mangach;
        this.mangavol = mangavol;
        this.learnmore = learnmore;
        this.mangaabout = mangaabout;
    }

    public MangaDB(String animename, String imgurl, String mangascore, String mangapublishingperiod, String mangach, String mangavol, String learnmore, String mangaabout) {
        this.id = id;
        this.animename = animename;
        this.imgurl = imgurl;
        this.mangascore = mangascore;
        this.mangapublishingperiod = mangapublishingperiod;
        this.mangach = mangach;
        this.mangavol = mangavol;
        this.learnmore = learnmore;
        this.mangaabout = mangaabout;
    }

    public MangaDB() {

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

    public String getMangascore() {
        return mangascore;
    }

    public void setMangascore(String mangascore) {
        this.mangascore = mangascore;
    }

    public String getMangapublishingperiod() {
        return mangapublishingperiod;
    }

    public void setMangapublishingperiod(String mangapublishingperiod) {
        this.mangapublishingperiod = mangapublishingperiod;
    }

    public String getMangach() {
        return mangach;
    }

    public void setMangach(String mangach) {
        this.mangach = mangach;
    }

    public String getMangavol() {
        return mangavol;
    }

    public void setMangavol(String mangavol) {
        this.mangavol = mangavol;
    }

    public String getLearnmore() {
        return learnmore;
    }

    public void setLearnmore(String learnmore) {
        this.learnmore = learnmore;
    }

    public String getMangaabout() {
        return mangaabout;
    }

    public void setMangaabout(String mangaabout) {
        this.mangaabout = mangaabout;
    }
}
