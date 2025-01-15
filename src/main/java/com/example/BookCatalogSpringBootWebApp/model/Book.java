package com.example.BookCatalogSpringBootWebApp.model;

public class Book {

    private long id;
    private String title;
    private int category; //Enums
    private String author;
    private int ownership; // Enums

    public Book (long id, String title, int category, String author, int ownership) {
        this.id = id; // Make this auto-incrememnt
        this.title = title;
        this.category = category;
        this.author = author;
        this.ownership = ownership;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory(){
        return category;
    }

    public void setCategory(int category){
        this.category = category;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public int getOwnership(){
        return ownership;
    }

    public void setOwnership(int ownership){
        this.ownership = ownership;
    }
}