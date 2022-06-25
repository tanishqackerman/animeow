package com.meow.testanime.DBModels;

import java.io.Serializable;

public class CharDB implements Serializable {
    private int id;
    private String charname;
    private String imgurl;
    private String learnmore;
    private String charabout;

    public CharDB(int id, String charname, String imgurl, String learnmore, String charabout) {
        this.id = id;
        this.charname = charname;
        this.imgurl = imgurl;
        this.learnmore = learnmore;
        this.charabout = charabout;
    }

    public CharDB(String charname, String imgurl, String learnmore, String charabout) {
        this.charname = charname;
        this.imgurl = imgurl;
        this.learnmore = learnmore;
        this.charabout = charabout;
    }

    public CharDB() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharname() {
        return charname;
    }

    public void setCharname(String charname) {
        this.charname = charname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getLearnmore() {
        return learnmore;
    }

    public void setLearnmore(String learnmore) {
        this.learnmore = learnmore;
    }

    public String getCharabout() {
        return charabout;
    }

    public void setCharabout(String charabout) {
        this.charabout = charabout;
    }
}
