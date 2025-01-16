package com.example.project;

public class BookStore{
    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    Book[] books = new Book[5];
    User[] users = new User[10];
    int uIndex = 0;
    int bIndex = 0;

    //requires 1 empty constructor
    public BookStore() {}

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users){
        this.users = users;
    }

    public Book[] getBooks(){
        return books;
    }

    public void addUser(User user){
        users[uIndex] = user;
        uIndex ++;
    } 

    public void removeUser(User user){
        for (int i = 0; i < users.length; i++) {
            if (users[i] == user) {
                users[i] = null;
            }
        }
        consolidateUsers();
    }

    public void consolidateUsers(){
        User[] x = new User[users.length];
        int i = 0;
        
        for (User user : users) {
            if (user != null) {
                x[i] = user;
                i++;
            }
        }
        users = x;
    }

    public void addBook(Book book){
        if (bIndex + 1 > books.length) {
            increaseBooks();
        }
        books[bIndex] = book;
        bIndex++;
    }

    public void insertBook(Book book, int index){
        if (bIndex + 1 > books.length) {
            increaseBooks();
        }
        for (int i = bIndex; i > index; i--) {
            books[i] = books[i - 1];
        }
        books[index] = book;
        bIndex++;
    }

    public void removeBook(Book book){
        book.setQuantity(book.getQuantity() - 1);
        if (book.getQuantity() < 1) {
            books[indexOfArray(book)] = null;
            consolidateBooks();
            decreaseBooks();
            bIndex--;
        }
    }
    
    private int indexOfArray(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == book) {
                return i;
            }
        }
        return -1;
    }

    private void increaseBooks() {
        Book[] x = new Book[books.length + 1];
        for (int i = 0; i < x.length; i++) {
            x[i] = books[i];
        }
        books = x;
    }

    private void decreaseBooks() {
        Book[] x = new Book[books.length - 1];
        for (int i = 0; i < x.length; i++) {
            x[i] = books[i];
        }
        books = x;
    }

    private void consolidateBooks(){
        Book[] x = new Book[books.length];
        int i = 0;
        
        for (Book book : books) {
            if (book != null) {
                x[i] = book;
                i++;
            }
        }
        books = x;
    }
}