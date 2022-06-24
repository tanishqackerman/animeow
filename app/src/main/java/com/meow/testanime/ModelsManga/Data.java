package com.meow.testanime.ModelsManga;

import java.io.Serializable;

public class Data implements Serializable {
    private int mal_id;
    private String url;
    private Images images;
    private String title;
    private String title_english;
    private String title_japanese;
    private String[] title_synonyms;
    private String type;
    private int chapters;
    private int volumes;
    private String status;
    private boolean publishing;
    private Published published;
    private double score;
    private double scored;
    private int scored_by;
    private int rank;
    private int popularity;
    private int members;
    private int favorites;
    private String synopsis;
    private String background;
    private Author[] authors;
    private Author[] serializations;
    private Author[] genres;
    private String[] explicit_genres; //assumed data type to be String
    private Author[] themes;
    private Author[] demographics;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleEnglish() {
        return title_english;
    }

    public void setTitleEnglish(String title_english) {
        this.title_english = title_english;
    }

    public String getTitleJapanese() {
        return title_japanese;
    }

    public void setTitleJapanese(String title_japanese) {
        this.title_japanese = title_japanese;
    }

    public String[] getTitleSynonyms() {
        return title_synonyms;
    }

    public void setTitleSynonyms(String[] title_synonyms) {
        this.title_synonyms = title_synonyms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getPublishing() {
        return publishing;
    }

    public void setPublishing(boolean publishing) {
        this.publishing = publishing;
    }

    public Published getPublished() {
        return published;
    }

    public void setPublished(Published published) {
        this.published = published;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScored() {
        return scored;
    }

    public void setScored(double scored) {
        this.scored = scored;
    }

    public int getScoredBy() {
        return scored_by;
    }

    public void setScoredBy(int scored_by) {
        this.scored_by = scored_by;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public Author[] getSerializations() {
        return serializations;
    }

    public void setSerializations(Author[] serializations) {
        this.serializations = serializations;
    }

    public Author[] getGenres() {
        return genres;
    }

    public void setGenres(Author[] genres) {
        this.genres = genres;
    }

    public String[] getExplicitGenres() {
        return explicit_genres;
    }

    public void setExplicitGenres(String[] explicit_genres) {
        this.explicit_genres = explicit_genres;
    }

    public Author[] getThemes() {
        return themes;
    }

    public void setThemes(Author[] themes) {
        this.themes = themes;
    }

    public Author[] getDemographics() {
        return demographics;
    }

    public void setDemographics(Author[] demographics) {
        this.demographics = demographics;
    }
}
