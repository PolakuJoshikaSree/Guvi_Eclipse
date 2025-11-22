package com.chubb.basic;

public class Book {
    private String title;
    private Author author;
    private int edition;

    public Book(String title, Author author, int edition) {
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

    @Override
    public String toString() {
        return title +" - "+ author + "- Edition " + edition;
    }
}
