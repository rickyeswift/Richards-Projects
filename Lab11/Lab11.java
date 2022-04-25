/*
 * Lab11.java
 *
 * This code will initialize the code created in Book.java and BookShelf.java
 * Richard Elliott Jr
 * 04/06/22
 * CMSC 255-902
 */
package Labs.Lab11;

import java.util.ArrayList;

public class Lab11 {

    /** Main Method */
    public static void main(String[] args) {
        // Three variables containing String of book titles and authors
        Book b1 = new Book("Sword of Destiny (The Witcher, 2)", "Andrzej Sapkowski");
        Book b2 = new Book("Von Beck", "Michael Moorcock");
        Book b3 = new Book("A Promised Land", "Barack Obama");

        // Print book info
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());

        // add book titles to the bookshelf
        Bookshelf bs = new Bookshelf();
        bs.addBook(b1);
        bs.addBook(b2);
        bs.addBook(b3);

        //While there is room on the bookshelf print book titles
        ArrayList<Book> books = bs.getBooks();
        System.out.println("BookShelf: ");
        for (Book b : books) {
            System.out.println(b);
        }

        // Make space on the bookshelf
        bs.emptyBookshelf();

        books = bs.getBooks();
        System.out.println("BookShelf: ");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
