package com.example.project;

public class Book{
    // provides the 5 attributes of this class
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    // Intializes the atributes of this class
    public Book(String title, String author, int yearPublished, String isbn, int quantity) {
        // I used "this." because I couldn't think of new variables 
        this.title = title; this.author = author; this.yearPublished = yearPublished; this.isbn = isbn; this.quantity = quantity;
    }

    public String getTitle() {
        // returns the title of the Book
        return title;
    }

    public void setTitle(String title) {
        // sets the title of the Book to a new title
        this.title = title;
    }

    public String getAuthor() {
        // returns the author of the Book
        return author;
    }

    public void setAuthor(String author) {
        // sets the author of the Book to a new author
        this.author = author;
    }

    public int getYearPublished() {
        // returns the year the Book was published
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        // Changes the year the Book was published
        this.yearPublished = yearPublished;
    }

    public String getIsbn() {
        // returns the isbn of the Book
        return isbn;
    }

    public void setIsbn(String isbn) {
        // changes to isbn of the Book
        this.isbn = isbn;
    }

    public int getQuantity() {
        // returns the quantity of the Book
        return quantity;
    }

    public void setQuantity(int quantity) {
        // Sets the quantity of the Book to a new amount
        this.quantity = quantity;
    }

    public String bookInfo(){
        // returns the title, author, year published, isbn and quantity of the Book in a formatted string
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity;
    } 
       
}