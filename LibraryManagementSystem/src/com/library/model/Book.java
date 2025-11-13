package com.library.model;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return id + " | " + title + " by " + author + (isAvailable ? " (Available)" : " (Borrowed)");
    }
}
