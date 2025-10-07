package com.pluralsight;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Book[] inventory = createInventory();
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

     public void menuOptions(){
        Scanner scanner = new Scanner(System.in);
        String menu = """
                Welcome to your Neighborhood Library Book Manager!
                Please choose a menu option:
                1. List all books
                2. Check out a book
                3. Check in a book
                4. Exit
                """;
        System.out.println(menu);
        int command = scanner.nextInt();
        scanner.nextLine();

     }


}






