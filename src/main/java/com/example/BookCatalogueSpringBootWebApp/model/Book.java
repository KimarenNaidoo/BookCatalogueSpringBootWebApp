package com.example.BookCatalogueSpringBootWebApp.model;

public class Book {

    private long id;
    private String title;
    private int statusId;
    private int categoryId; 
    private String author; // Text seperated by , for multiple authors
    private int ownershipId;

    // Category
    private final static int SELFIMPROVEMENT_PSYCHOLOGY = 0;
    private final static int SOFTWARE_TECHNOLOGY = 1;
    private final static int ENGINEERING_PHYSICS = 2;
    private final static int FICTION = 3;
    private final static int ART = 4;
    private final static int ROMANCE = 5;
    private final static int HISTORY = 6;
    private final static int MYSTERY_SPY_DETECTIVE = 7;

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


    public String getOwnership() {
        switch (this.ownershipId) {
            case UNOWN:
                return "Unown";

            case LENT:
                return "Lent to...";    

            case BORROWED:
                return "Borrowed from...";

            case OWN:
                return "Own";

            default:
                return "Not available";
        }
    }

    public String getCategory() {
        switch (this.categoryId) {
            case SELFIMPROVEMENT_PSYCHOLOGY:
                return "Self-Improvement/Psychology";

            case SOFTWARE_TECHNOLOGY:
                return "Software Engineering/Technolgy";

            case ENGINEERING_PHYSICS:
                return "Engineering/Physics";

            case FICTION:
                return "Fiction";

            case ART:
                return "Art";

            case ROMANCE:
                return "Romance";

            case HISTORY:
                return "History";

            case MYSTERY_SPY_DETECTIVE:
                return "Mystery/Spy/Detective";
        
            default:
                return "Not available";
        }
    }

    public String displayBookString() {
		return String.format("Book id: %d, title: %s, author: %s, category: %s, status: %d, ownership: %s.", this.getId(), this.getTitle(), this.getAuthor(), this.getCategory(), this.getStatusId(), this.getOwnership());
	}
}