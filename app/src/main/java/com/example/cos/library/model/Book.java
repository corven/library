package com.example.cos.library.model;

import com.orm.SugarRecord;

import java.util.Comparator;

public class Book extends SugarRecord {

    private String name;
    private float rating;
    private int img;
    private String desc;
    private String title;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book() {
    }

    public Book(String name, float rating, int img, String desc, String title) {
        this.name = name;
        this.rating = rating;
        this.img = img;
        this.desc = desc;
        this.title = title;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", img='" + img + '\'' +
                ", desc='" + desc + '\'' +
                ", title='" + desc + '\'' +
                '}' + '\n';
    }

    public static Comparator<Book> compSortTitle = new Comparator<Book>() {
        @Override
        public int compare(Book lhs, Book rhs) {
            return lhs.name.compareTo(rhs.name);
        }
    };
    public static Comparator<Book> compSortRating = new Comparator<Book>() {
        @Override
        public int compare(Book lhs, Book rhs) {
            return String.valueOf(rhs.rating).compareTo(String.valueOf(lhs.rating));
        }
    };
}
