package com.meow.testanime.ModelsManga;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MangaAPIResponse implements Serializable {
    Pagination PaginationObject;
    List<Data> data;
    Links LinksObject;
    Meta MetaObject;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }


    // Getter Methods

    public Pagination getPagination() {
        return PaginationObject;
    }

    public Links getLinks() {
        return LinksObject;
    }

    public Meta getMeta() {
        return MetaObject;
    }

    // Setter Methods

    public void setPagination(Pagination paginationObject) {
        this.PaginationObject = paginationObject;
    }

    public void setLinks(Links linksObject) {
        this.LinksObject = linksObject;
    }

    public void setMeta(Meta metaObject) {
        this.MetaObject = metaObject;
    }
}

class Pagination implements Serializable{
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

class Author implements Serializable {
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

class Links implements Serializable {
    private String first;
    private String last;
    private String prev;
    private String next;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}

class Links2 implements Serializable {
    private String url;
    private String label;
    private boolean active;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

class Meta implements Serializable {
    private int current_page;
    private int from;
    private int last_page;
    private Links2[] links;
    private String path;
    private int per_page;
    private int to;
    private int total;

    public int getCurrentPage() {
        return current_page;
    }

    public void setCurrentPage(int current_page) {
        this.current_page = current_page;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getLastPage() {
        return last_page;
    }

    public void setLastPage(int last_page) {
        this.last_page = last_page;
    }

    public Links2[] getLinks() {
        return links;
    }

    public void setLinks(Links2[] links) {
        this.links = links;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPerPage() {
        return per_page;
    }

    public void setPerPage(int per_page) {
        this.per_page = per_page;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
    private Links links;
    private Meta meta;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}