package com.example.project;

public class BookStore{
    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    Book[] books;
    User[] users = new User[10];

    //requires 1 empty constructor
    public BookStore() {}

    public User[] getUsers() {
        return users;
    }

    // public setUsers(){}

    // public  getBooks(){}

    // public void addUser(User user){} 

    // public void removeUser(User user){}

    // public void consolidateUsers(){}

    // public void addBook(Book book){}

    // public void insertBook(Book book, int index){}

    // public void removeBook(Book book){}
       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}