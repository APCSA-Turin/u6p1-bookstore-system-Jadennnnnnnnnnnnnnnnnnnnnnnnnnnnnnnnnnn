package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    private String name; 
    private String Id; 
    private Book[] book = new Book[5];

    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String name, String Id) {
        this.name = name;
        this.Id = Id;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Book[] getBooks() {
        return book;
    }

    public void setBooks(Book[] book) {
        this.book = book;
    }

    public String bookListInfo() {
        String string = "";
        for (Book books : book) {
            if (books != null) {
                string += books.bookInfo() + "\n";
            } else string += "empty\n";
        }
        return string;
    }

    public String userInfo(){
        return "Name: " + name + "\nId: " + Id + "\nBooks: \n" + bookListInfo(); 
    }
       
}