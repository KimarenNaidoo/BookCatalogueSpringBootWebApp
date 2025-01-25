package com.example.BookCatalogueSpringBootWebApp.model;

public class Book {

    private long id;
    private String title;
    private int statusId;
    private int category; // Enums
    private String author; // Text seperated by , for multiple authors
    private int ownership; // Enums

    public Book(){}

    public Book(long id, String title, int statusId, int category, String author, int ownership) {
        this.id = id; // Make this auto-incrememnt
        this.title = title;
        this.statusId = statusId;
        this.category = category;
        this.author = author;
        this.ownership = ownership;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getOwnership() {
        return ownership;
    }

    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }
}