package com.example.BookCatalogueSpringBootWebApp.model;

public class Book {

    private long id;
    private String title;
    private int statusId;
    private int categoryId; 
    private String author; // Text seperated by , for multiple authors
    private int ownershipId;

    // Ownership
    private final static int UNOWN = 0;
    private final static int LENT = 1;
    private final static int BORROWED = 2;
    private final static int OWN = 3; 

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


    public String getOwnership(int ownership) {

        String ownershipDisplayValue = "";

        switch (ownership) {
            case UNOWN:
                ownershipDisplayValue = "Unown";
                break;

            case LENT:
                ownershipDisplayValue = "Lent to...";
                break;    

            case BORROWED:
                ownershipDisplayValue = "Borrowed from...";
                break;

            case OWN:
                ownershipDisplayValue = "Own";
                break;

            default:
                ownershipDisplayValue = "Unown";
                break;
        }

        return ownershipDisplayValue;
    }



    public String displayBookString()
	{
		return String.format("Book id: %d, title: %s, author: %s, category: %d, status: %d, ownership: %s.", this.getId(), this.getTitle(), this.getAuthor(), this.getCategoryId(), this.getStatusId(), this.getOwnership(this.ownershipId));
	}
}