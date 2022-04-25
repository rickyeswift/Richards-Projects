/*
*BookShelf.java
*
* This code will be the model of a bookshelf holding all the books entered
* Richard Elliott Jr
* 04/06/22
* CMSC 255-902
 */
package Labs.Lab11;

import java.util.ArrayList;
public class Bookshelf {
    // Create a variable that will determine how many books can be held
    private int size;
    // Create an array that stores data from Book.java
    private ArrayList<Book> books;
    private Book b;

    /**
     * This method initializes a ArrayList and sets size to 2
     * */
    public Bookshelf() {
        // Create a variable assigned to the Array
        books = new ArrayList<>();
        // Assign 2 to the variable size
        size = 2;
    }

    /**
     * This method receives a single parameter for size and initializes the ArrayList
     * */
    public Bookshelf(int size) {
        // Initialize ArrayList
        books = new ArrayList<>();
        this.size = size;
    }

    /**
     * Getters
     * */
    public int getSize() {
        return size;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * This method is to set book parameters for all the books allowed on the array list
     * */
    public void addBook(Book b) {
        books.add(b);
    }

    /** This method
     * removes the first book on the bookshelf
     * */
    public Book removeBook() {
        Book b = books.get(0);
        if (b != null) {
            books.remove(0);
        }
        return b;
    }

    /**
     * This method removes all the books from the shelf
     * */
    public void emptyBookshelf() {
        books = new ArrayList<>();
    }
}
