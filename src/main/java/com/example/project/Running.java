package com.example.project;
import java.util.Scanner;

public class Running {
    private BookStore store = new BookStore();

    public Running() {}

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        System.out.println("*************************Welcome to Bookstore X*************************");
        System.out.println("*******************Select From The Following Options:*******************");
        System.out.println("************************************************************************");
        System.out.println("------------------------------------------------------------------------");

        while (!quit) {
            System.out.println("0. Exit Application");
            System.out.println("1. Add New Book");
            System.out.println("2. Update Quantity of a Book");
            System.out.println("3. Search a Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Register Student");
            System.out.println("6. Show All Registered Students");
            System.out.println("7. Check Out Book");
            System.out.println("8. Check In Book");
            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    quit = true;
                    break;
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
                default: System.out.println("Invalid Choice");
            }
        }
        scanner.close();
    }

    private void addNewBook(Scanner scanner) {
        System.out.print("Enter Title of Book: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        System.out.print("Enter Year Published: ");
        int yearPublished = scanner.nextInt();
        System.out.print("Enter Serial Number of Books: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Quantity of Books: ");
        int quantity = scanner.nextInt();

        Book book = new Book(title, author, yearPublished, isbn, quantity);
        store.addBook(book);
    }

    private void updateQuantity(Scanner scanner) {
        System.out.println("Enter Serial Number of Book: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter quantity to add: ");
        int quantity = scanner.nextInt();

        for (Book book : store.getBooks()) {
            if (book.getIsbn().equals(isbn) && book != null) {
                book.setQuantity(book.getQuantity() + quantity);
            } else System.out.println("Book not found");
        }
    }

    private void searchBook(Scanner scanner) {
        System.out.println("Enter Title of Book: ");
        String title = scanner.nextLine();

        for (Book book : store.getBooks()) {
            if (book.getTitle().equals(title) && book != null) {
                System.out.println("Book Found at index " + store.indexOfArray(book));
                System.out.println("Book Info: \n" + book.bookInfo());
            } else System.out.println("Book not found");
        }
    }

    private void printBooks() {
        for (Book book : store.getBooks()) {
            if (book != null) {
                System.out.println(book.bookInfo());
            }
        }
    }

    private void registerStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        IdGenerate.generateID();

        User user = new User(name, IdGenerate.getCurrentId());
        store.addUser(user);
    }

    private void printStudents() {
        for (User user : store.getUsers()) {
            if (user != null) {
                System.out.println(user.userInfo());
            }
        }
    }

    private void checkOutBook(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Serial Number of Book: ");
        String isbn = scanner.nextLine();
        User student = findStudent(studentId);

        for (Book book : store.getBooks()) {
            if (book.getIsbn().equals(isbn) && book != null) {
                store.removeBook(book);
                for (int i = 0; i < student.getBooks().length; i++) {
                    if (student.getBooks()[i] == null) {
                        student.getBooks()[i] = book;
                    }
                }
            }
        }
    }

    private void checkInBook(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Serial Number of Book: ");
        String isbn = scanner.nextLine();
        User student = findStudent(studentId);

        for (int i = 0; i < student.getBooks().length; i++) {
            Book book = student.getBooks()[i];
            if (book != null && book.getIsbn().equals(isbn)) {
                student.getBooks()[i] = null;
                book.setQuantity(book.getQuantity() + 1);
            }
        }
    }

    private User findStudent(String Id) {
        for (User user : store.getUsers()) {
            if (user.getId().equals(Id)) {
                return user;
            }
        }
        return null;
    }
}