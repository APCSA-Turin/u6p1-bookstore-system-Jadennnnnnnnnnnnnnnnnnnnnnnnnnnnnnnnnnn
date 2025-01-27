package com.example.project;
import java.util.Scanner;

public class Running {
    // initializes the BookStore variable store
    private BookStore store = new BookStore();

    // empty constructer
    public Running() {}

    public void run() {
        // Scanner to check for user input
        Scanner scanner = new Scanner(System.in);
        // Used for the while loop
        boolean quit = false;

        // Used as the header for the system
        System.out.println("*************************Welcome to Bookstore X*************************");
        System.out.println("*******************Select From The Following Options:*******************");
        System.out.println("************************************************************************");
        System.out.println("------------------------------------------------------------------------");

        // a while loop is used to continously run the system
        while (!quit) {
            // prints user options
            System.out.println("0. Exit Application");
            System.out.println("1. Add New Book");
            System.out.println("2. Update Quantity of a Book");
            System.out.println("3. Search a Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Register Student");
            System.out.println("6. Show All Registered Students");
            System.out.println("7. Check Out Book");
            System.out.println("8. Check In Book");
            System.out.println("------------------------------------------------------------------------");
            // reads the user's choice
            int option = scanner.nextInt();
            scanner.nextLine();

            // uses a switch statement rather than if-else statements based on user's choice
            switch (option) {
                // If user chooses 0, it sets quit to true, ending the while loop
                case 0:
                    quit = true;
                    break;
                // Created private methods for the rest of the cases
                case 1:
                    addNewBook(scanner);
                    break;
                case 2:
                    updateQuantity(scanner);
                    break;
                case 3:
                    searchBook(scanner);
                    break;
                case 4:
                    printBooks();
                    break;
                case 5:
                    registerStudent(scanner);
                    break;
                case 6:
                    printStudents();
                    break;
                case 7:
                    checkOutBook(scanner);
                    break;
                case 8: 
                    checkInBook(scanner);
                    break;
                // if the user didn't input 0-8; it prints this
                default: System.out.println("Invalid Choice");
            }
            System.out.println("------------------------------------------------------------------------");
        }
        scanner.close();
    }

    // adds a new book into the store's books array
    private void addNewBook(Scanner scanner) {
        // user input become the parameters of the Book instance
        System.out.print("Enter Title of Book: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        System.out.print("Enter Year Published: ");
        int yearPublished = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Serial Number of Books: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Quantity of Books: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        // creates a Book and calls the addBook() function from BookStore
        Book book = new Book(title, author, yearPublished, isbn, quantity);
        store.addBook(book);
    }

    // adds to the quantity attribute of a book
    private void updateQuantity(Scanner scanner) {
        // asks which book and how much to add
        System.out.println("Enter Serial Number of Book: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter quantity to add: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        // loops through the books[] attribute of the store variable
        for (Book book : store.getBooks()) {
            // checks if the isbn the user entered is the same as the book in the books array
            if (book != null && book.getIsbn().equals(isbn)) {
                // if so, the quantity increases, by calling Book's setQuantity()
                book.setQuantity(book.getQuantity() + quantity);
            } else System.out.println("Book not found");
        }
    }

    // searches for a specific book and prints it's index and information
    private void searchBook(Scanner scanner) {
        // asks the user the title of the book
        System.out.println("Enter Title of Book: ");
        String title = scanner.nextLine();

        // loops through the books[] attribute of the store variable
        for (Book book : store.getBooks()) {
            // checks if the title the user entered is the same as the book's in the books array
            if (book != null && book.getTitle().equals(title)) {
                // if so, calls BookStore's indexOfArray() and Book's bookInfo()
                System.out.println("Book Found at index " + store.indexOfArray(book));
                System.out.println("Book Info: \n" + book.bookInfo());
            }
        }
    }

    // prints all the info of all the books
    private void printBooks() {
        // loops through the books[] attribute of the store variable
        for (Book book : store.getBooks()) {
            // checks if the value is null
            if (book != null) {
                // if not, it prints the info of the book
                System.out.println(book.bookInfo());
            }
        }
    }

    // add a student in the store's users array
    private void registerStudent(Scanner scanner) {
        // asks user for the student's name
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        // calls IdGenerateID
        IdGenerate.generateID();

        // uses the above for the User's parameters
        User user = new User(name, IdGenerate.getCurrentId());
        // calls the addUser() method
        store.addUser(user);
    }

    // prints the info of the student
    private void printStudents() {
        // loops through the store's users array
        for (User user : store.getUsers()) {
            // checks if the user isn't null before printing the student's info
            if (user != null) {
                System.out.println(user.userInfo());
            }
        }
    }

    //removes a copy of a book and adds it to a student
    private void checkOutBook(Scanner scanner) {
        // asks user to input the student who is checking out a book, and what book they're checking out
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Serial Number of Book: ");
        String isbn = scanner.nextLine();
        // calls findStudent
        User student = findStudent(studentId);

        // loops through the books[] attribute of the store variable
        for (Book book : store.getBooks()) {
            // checks if the isbn the user entered is the same as the book in the books array
            if (book != null && book.getIsbn().equals(isbn)) {
                // if so, one copy of the book is removed
                store.removeBook(book);
                // That copy is added to the Books[] attribute of the student
                for (int i = 0; i < student.getBooks().length; i++) {
                    if (student.getBooks()[i] == null) {
                        student.getBooks()[i] = book;
                        // break prevents the same book from being copied over and over
                        break;
                    }
                }
            }
        }
    }

    // adds a copy of a book and removes it from a student
    private void checkInBook(Scanner scanner) {
        // asks user to input the student who is checking in a book, and what book they're checking in
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Serial Number of Book: ");
        String isbn = scanner.nextLine();
        // calls findStudent
        User student = findStudent(studentId);

        // loops through all the books of the student in order to find the book being checked in
        for (int i = 0; i < student.getBooks().length; i++) {
            Book book = student.getBooks()[i];
            // checks if the isbn the user entered is the same as the book the student has
            if (book != null && book.getIsbn().equals(isbn)) {
                // sets that book to null and increases the quantity in the store by one.
                student.getBooks()[i] = null;
                book.setQuantity(book.getQuantity() + 1);
            }
        }
    }

    // returns the student based on their ID
    private User findStudent(String Id) {
        // loops through the store's users the find a user who's id matches the parameter
        for (User user : store.getUsers()) {
            // calls the User's getId()
            if (user.getId().equals(Id)) {
                return user;
            }
        }
        return null;
    }
}