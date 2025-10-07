package com.pluralsight;

import java.sql.SQLOutput;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Book[] inventory = createInventory();
        menuOptions(inventory);
    }

    public static Book[] createInventory() {
        Book[] books = new Book[20];

        String[] titles = {
                "To Kill a Mockingbird", "1984", "The Great Gatsby", "Pride and Prejudice",
                "Moby Dick", "The Hobbit", "Brave New World", "Harry Potter and the Sorcerer's Stone",
                "The Catcher in the Rye", "The Lord of the Rings", "Jane Eyre", "Animal Farm",
                "The Chronicles of Narnia", "Wuthering Heights", "Fahrenheit 451", "Dracula",
                "Little Women", "Frankenstein", "War and Peace", "The Odyssey"
        };

        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            book.setId(i + 1);
            book.setTitle(titles[i]);
            book.setIsbn("ISBN-000" + i);
            book.setCheckedOut(false);
            book.setCheckedOutTo("");
            books[i] = book;

        }
        return books;
    }

    public static void menuOptions(Book[] inventory) {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            String menu = """
                    Welcome to your Neighborhood Library Book Manager!
                    Please choose a menu options:
                    1. Show available books
                    2. Show Checked Out Books
                    3. Exit
                    """;
            System.out.println(menu);

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    for (Book book : inventory) {
                        if (!book.isCheckedOut()) {
                            System.out.println(book);
                        }

                    }
                    System.out.print("What is the ID of the book you want to check out? ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    inventory[bookId - 1].checkOut(name);
                    System.out.println("Checkout Complete!");
                    System.out.println("Press enter to return to menu: ");
                    scanner.nextLine();
                    break;

                case 2:
                    for (Book book: inventory) {
                        if (book.isCheckedOut()) {
                            System.out.println(book);
                        }
                    }
                    System.out.print("Press 'C' to check in book \n Press any other character to return to menu: ");
                    String input = scanner.nextLine();

                    if(input.equalsIgnoreCase("C")){

                        System.out.print("What is the ID of the book you are checking in?");
                        int checkInId = scanner.nextInt();
                        scanner.nextLine();
                        inventory[checkInId - 1].checkIn();

                    }
                    break;
                case 3:

                    isRunning = false;
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid. Try again.");
                    break;
            }

        }

    }


}






