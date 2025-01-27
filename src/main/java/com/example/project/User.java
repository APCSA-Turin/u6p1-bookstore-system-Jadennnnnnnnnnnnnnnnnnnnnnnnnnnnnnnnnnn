package com.example.project;

public class User{
    // creates 2  variables and an array of Book(s); 3 attributes in total
    private String name; 
    private String Id; 
    private Book[] book = new Book[5];

    // constructer that intializes the name and Id variable
    public User(String name, String Id) {
        this.name = name;
        this.Id = Id;
    }
 
    // returns the name of the User
    public String getName() {
        return name;
    }

    // changes the name of the User
    public void setName(String name) {
        this.name = name;
    }

    // returns the id of the User
    public String getId() {
        return Id;
    }

    // changes the id of the user
    public void setId(String Id) {
        this.Id = Id;
    }

    // returns the User's array of Books
    public Book[] getBooks() {
        return book;
    }

    // changes the User's array of Books
    public void setBooks(Book[] book) {
        this.book = book;
    }

    // returns a formatted string of all of the User's books
    public String bookListInfo() {
        // intializes an empty local string variable
        String string = "";
        // loops through all the books in the "book" array
        for (Book books : book) {
            // checks if the book is null
            if (books != null) {
                // if not, it calls the bookInfo method on the Book object; and adds it to the local string variable
                string += books.bookInfo() + "\n";
            // if it is null, it just adds "empty" to the string
            } else string += "empty\n";
        }
        return string;
    }

    // returns a formatted string that contains the User's name, Id, and all of their books
    public String userInfo(){
        // calls bookListInfo() to add to the string
        return "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo(); 
    }
       
}