package com.meow.testanime.ModelsCharacter;

import java.io.Serializable;
import java.util.List;

public class CharAPIResponse implements Serializable {
    Pagination PaginationObject;
    List<Data> data;

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

    // Setter Methods

    public void setPagination(Pagination paginationObject) {
        this.PaginationObject = paginationObject;
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

class Webp implements Serializable {
    private String image_url;
    private String small_image_url;

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
}