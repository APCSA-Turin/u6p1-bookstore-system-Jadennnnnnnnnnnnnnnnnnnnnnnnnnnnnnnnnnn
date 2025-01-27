package com.example.project;

public class BookStore{
    // creates two arrays of Books and Users, with a max of 5 and 10 respectively 
    Book[] books = new Book[5];
    User[] users = new User[10];
    // creates two private varibles for add books and users to a certian index in their arrays
    int uIndex = 0;
    int bIndex = 0;

    // empty constructor 
    public BookStore() {}

    // returns the users array
    public User[] getUsers() {
        return users;
    }

    // sets the users array to a new array
    public void setUsers(User[] users){
        this.users = users;
    }

    // returns the books array
    public Book[] getBooks(){
        return books;
    }

    // adds a user to the users array
    public void addUser(User user){
        // uses uIndex for the user
        users[uIndex] = user;
        // increases uIndex by one, to not reset user
        uIndex ++;
    } 

    // removes a certain user from the user array
    public void removeUser(User user){
        // loops through the users array
        for (int i = 0; i < users.length; i++) {
            // searches for the user to be removed, then sets it to null
            if (users[i] == user) {
                users[i] = null;
            }
        }
        // calls the consolidateUsers() method
        consolidateUsers();
    }

    // moves all users to the left and all nulls to the right of the user array
    public void consolidateUsers(){
        // initializes a new list of users
        User[] x = new User[users.length];
        // initializes an integer i as 0
        int i = 0;
        
        // loops through the users array
        for (User user : users) {
            // if the variable isn't null, it copies it to the new list at index i, which starts at 0
            if (user != null) {
                x[i] = user;
                // increases i if this occurs
                i++;
            }
        }
        // sets users to the newly consolidated list
        users = x;
    }

    // adds a book to the books array
    public void addBook(Book book){
        // Checks if the current index of the books array will be greater than the length of the array
        if (bIndex + 1 > books.length) {
            // calls the increaseBooks() method if so
            increaseBooks();
        }
        // sets the current index of the book array to the book parameter
        books[bIndex] = book;
        // increases the current index of the book array by 1
        bIndex++;
    }

    // adds a book to the books array at a certain index
    public void insertBook(Book book, int index){
        // Checks if the current index of the books array will be greater than the length of the array
        if (bIndex + 1 > books.length) {
            // calls the increaseBooks() method if so
            increaseBooks();
        }
        // moves everything from the bIndex one to the right
        for (int i = bIndex; i > index; i--) {
            books[i] = books[i - 1];
        }
        // sets the index of the book array at index 'parameter index' to the book parameter
        books[index] = book;
        // increases the current index of the book array by 1
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

    // increases the length of the books array by 1
    private void increaseBooks() {
        // intializes a new array
        Book[] x = new Book[books.length + 1];
        // copies all book in books into the new array
        for (int i = 0; i < x.length; i++) {
            x[i] = books[i];
        }
        // sets books to the new array created
        books = x;
    }

    // decreases the length of the books array by 1
    private void decreaseBooks() {
        // intializes a new array
        Book[] x = new Book[books.length - 1];
        // coppies all book in books into the new array
        for (int i = 0; i < x.length; i++) {
            x[i] = books[i];
        }
        // sets books to the new array created
        books = x;
    }

    // moves all books to the left and all nulls to the right of the book array
    private void consolidateBooks(){
        // initializes a new list of books
        Book[] x = new Book[books.length];
        // initializes an integer i as 0
        int i = 0;
        
        // loops through the books array
        for (Book book : books) {
            // if the variable isn't null, it copies it to the new list at index i, which starts at 0
            if (book != null) {
                // increases i if this occurs
                x[i] = book;
                i++;
            }
        }
        // sets books to the new array created
        books = x;
    }
}