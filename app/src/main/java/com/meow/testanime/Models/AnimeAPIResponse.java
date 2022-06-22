package com.meow.testanime.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimeAPIResponse implements Serializable {
    Pagination PaginationObject;
    List<Data> data;

    // Getter Methods

    public Pagination getPagination() {
        return PaginationObject;
    }

    // Setter Methods

    public void setPagination(Pagination paginationObject) {
        this.PaginationObject = paginationObject;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
class Pagination implements Serializable {
    private float last_visible_page;
    private boolean has_next_page;
    private float current_page;
    Items ItemsObject;


    // Getter Methods

    public float getLast_visible_page() {
        return last_visible_page;
    }

    public boolean getHas_next_page() {
        return has_next_page;
    }

    public float getCurrent_page() {
        return current_page;
    }

    public Items getItems() {
        return ItemsObject;
    }

    // Setter Methods

    public void setLast_visible_page(float last_visible_page) {
        this.last_visible_page = last_visible_page;
    }

    public void setHas_next_page(boolean has_next_page) {
        this.has_next_page = has_next_page;
    }

    public void setCurrent_page(float current_page) {
        this.current_page = current_page;
    }

    public void setItems(Items itemsObject) {
        this.ItemsObject = itemsObject;
    }
}
class Items implements Serializable {
    private float count;
    private float total;
    private float per_page;


    // Getter Methods

    public float getCount() {
        return count;
    }

    public float getTotal() {
        return total;
    }

    public float getPer_page() {
        return per_page;
    }

    // Setter Methods

    public void setCount(float count) {
        this.count = count;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setPer_page(float per_page) {
        this.per_page = per_page;
    }
}

class Broadcast implements Serializable {
    private String day;
    private String time;
    private String timezone;
    private String string;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}

class From implements Serializable {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

class Images2 implements Serializable {
    private String image_url;
    private String small_image_url;
    private String medium_image_url;
    private String large_image_url;
    private String maximum_image_url;

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public String getSmallImageUrl() {
        return small_image_url;
    }

    public void setSmallImageUrl(String small_image_url) {
        this.small_image_url = small_image_url;
    }

    public String getMediumImageUrl() {
        return medium_image_url;
    }

    public void setMediumImageUrl(String medium_image_url) {
        this.medium_image_url = medium_image_url;
    }

    public String getLargeImageUrl() {
        return large_image_url;
    }

    public void setLargeImageUrl(String large_image_url) {
        this.large_image_url = large_image_url;
    }

    public String getMaximumImageUrl() {
        return maximum_image_url;
    }

    public void setMaximumImageUrl(String maximum_image_url) {
        this.maximum_image_url = maximum_image_url;
    }
}

class Producer implements Serializable {
    private int mal_id;
    private String type;
    private String name;
    private String url;

    public int getMalId() {
        return mal_id;
    }

    public void setMalId(int mal_id) {
        this.mal_id = mal_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

class Prop implements Serializable {
    private From from;
    private From to;

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public From getTo() {
        return to;
    }

    public void setTo(From to) {
        this.to = to;
    }
}

class RootObject implements Serializable {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

