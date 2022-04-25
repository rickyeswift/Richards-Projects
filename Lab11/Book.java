/*
*Book.java
*
* This code will act as a book on a bookshelf gathering the title and author of the book and outputting the data
*
* Richard Elliott Jr
*04/06/22
* CMSC 255-902
 */
package Labs.Lab11;

import java.util.ArrayList;

public class Book {
    // Create private Strings title and author
    private String title;
    private String author;

    /** Create a constructor that sets title to "Test" and author to null */
    public Book() {
        super();
        this.title = "Test";
        this.author = null;
    }

    /** Create a parameterized constructor that will receive the title and author for these fields */
    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    /** Create getters and setters */
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /** toString() method that will return a string with the books information */
    @Override
    public String toString() {
        return "\"" + title + "\"" + " by " + author;
    }
}
