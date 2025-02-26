package com.example.BookCatalogueSpringBootWebApp.model;

import java.util.Objects;

public class Book implements Comparable<Book> {

    private long id;
    private String title;
    private int statusId;
    private int categoryId; 
    private String author; // Text seperated by , for multiple authors
    private int ownershipId;

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

    public String getCategory() {
        BookCategory bookCategory = BookCategory.getBookCategory(this.categoryId);
        return bookCategory != null ? bookCategory.getCategoryDisplayValue() : "N/A";
    }

    public String getStatus() {
        BookStatus bookStatus = BookStatus.getBookStatus(this.statusId);
        return bookStatus != null ? bookStatus.getStatusDisplayValue() : "N/A";
    }

    public String getOwnership() {
        BookOwnership bookOwnership = BookOwnership.getBookOwnership(this.ownershipId);
        return bookOwnership != null ? bookOwnership.getOwnershipDisplayValue() : "N/A";
    }

    public String displayBookString() {
		return String.format("<h3>Book Id: %d</h3> <ul><li>Title: %s.</li> <li>Author: %s.</li> <li>Category: %s.</li> <li>Status: %s.</li> <li>Ownership: %s.</li></ul>", this.getId(), this.getTitle(), this.getAuthor(), this.getCategory(), this.getStatus(), this.getOwnership());
	}

    @Override
    public int compareTo(Book o) {
        return 1;// update after implementing ISBN
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title);
    }
}