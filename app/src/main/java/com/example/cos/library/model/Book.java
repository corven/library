package com.example.cos.library.model;

import com.orm.SugarRecord;

public class Book extends SugarRecord {

    private String name;
    private float rating;
    private int img;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Book() {
    }

    public Book(String name, float rating, int img, String desc) {
        this.name = name;
        this.rating = rating;
        this.img = img;
        this.desc = desc;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", img='" + img + '\'' +
                ", desc='" + desc + '\'' +
                '}' + '\n';
    }
}
