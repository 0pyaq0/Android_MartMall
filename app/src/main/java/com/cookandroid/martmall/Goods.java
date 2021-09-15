package com.cookandroid.martmall;

public class Goods {
    private int image_id;
    private String title;
    private int price;

    public Goods(int image_id, String title, int price) {
        this.image_id = image_id;
        this.title = title;
        this.price = price;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
