package com.meow.testanime.Models;

import java.io.Serializable;

public class Data implements Serializable {
    private int mal_id;
    private String url;
    private Images images;
    private Trailer trailer;
    private String title;
    private String title_english;
    private String title_japanese;
    private String[] title_synonyms;
    private String type;
    private String source;
    private int episodes;
    private String status;
    private boolean airing;
    private Aired aired;
    private String duration;
    private String rating;
    private double score;
    private int scored_by;
    private int rank;
    private int popularity;
    private int members;
    private int favorites;
    private String synopsis;
    private String background;
    private String season;
    private int year;
    private Broadcast broadcast;
    private Producer[] producers;
    private Producer[] licensors;
    private Producer[] studios;
    private Producer[] genres;
    private String[] explicit_genres; //assumed data type to be string
    private Producer[] themes;
    private Producer[] demographics;

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

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getAiring() {
        return airing;
    }

    public void setAiring(boolean airing) {
        this.airing = airing;
    }

    public Aired getAired() {
        return aired;
    }

    public void setAired(Aired aired) {
        this.aired = aired;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Broadcast getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(Broadcast broadcast) {
        this.broadcast = broadcast;
    }

    public Producer[] getProducers() {
        return producers;
    }

    public void setProducers(Producer[] producers) {
        this.producers = producers;
    }

    public Producer[] getLicensors() {
        return licensors;
    }

    public void setLicensors(Producer[] licensors) {
        this.licensors = licensors;
    }

    public Producer[] getStudios() {
        return studios;
    }

    public void setStudios(Producer[] studios) {
        this.studios = studios;
    }

    public Producer[] getGenres() {
        return genres;
    }

    public void setGenres(Producer[] genres) {
        this.genres = genres;
    }

    public String[] getExplicitGenres() {
        return explicit_genres;
    }

    public void setExplicitGenres(String[] explicit_genres) {
        this.explicit_genres = explicit_genres;
    }

    public Producer[] getThemes() {
        return themes;
    }

    public void setThemes(Producer[] themes) {
        this.themes = themes;
    }

    public Producer[] getDemographics() {
        return demographics;
    }

    public void setDemographics(Producer[] demographics) {
        this.demographics = demographics;
    }
}
