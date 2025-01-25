package com.example.BookCatalogueSpringBootWebApp.model;

public class Book {

    private long id;
    private String title;
    private int statusId;
    private int categoryId; // Enums
    private String author; // Text seperated by , for multiple authors
    private int ownershipId; // Enums

    public Book(){}

    public Book(long id, String title, int statusId, int categoryId, String author, int ownershipId) {
        this.id = id; // Make this auto-incrememnt
        this.title = title;
        this.statusId = statusId;
        this.categoryId = categoryId;
        this.author = author;
        this.ownershipId = ownershipId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getOwnershipId() {
        return ownershipId;
    }

    public void setOwnershipId(int ownershipId) {
        this.ownershipId = ownershipId;
    }
}