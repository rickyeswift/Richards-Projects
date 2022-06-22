/*
* CMSC256-Summer2022
* Project 3 TranspositionalList.java
* This code uses the transpose method to mantain a list.
* Richard Elliott Jr
* 06/10/2022
 */
package cmsc256;

import java.util.Arrays;

/**
 * TranspositionalList.java
 * @author Richard Elliott Jr
 * @param <T>
 */
public class TranspositionalList<T> implements ListInterface<T> {

    // Array of list entries; ignore list[0]
    private T[] list;
    private int numberOfEntries;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 3;
    private static final int MAX_CAPACITY = 15;

    /*
     * default constructor
     * list = array;
     * numberOfEntries = 0;
     * initialized = true;
     */
    public TranspositionalList() {
        list = (T[])new Object[DEFAULT_CAPACITY];
        numberOfEntries = 0;
        initialized = true;
    }

    public TranspositionalList(int capacity) {
        checkCapacity(capacity);
        list = (T[])new Object[capacity];
        numberOfEntries = 0;
        initialized = true;
    }

    /*
     *   Doubles the capacity of the array list if it is full.
     *   Precondition: checkInitialization has been called.
     */
    private void ensureCapacity() {
        int capacity = list.length - 1;
        if (numberOfEntries >= capacity) {
            int newCapacity = 2 * capacity;
            // is capacity too big?
            checkCapacity(newCapacity);
            list = Arrays.copyOf(list, newCapacity + 1);
        }
    }

    /*
     * Makes room for a new entry at newPosition.
     * Precondition: 1 <= newPosition <= numberOfEntries + 1;
     * numberOfEntries is list's length before addition;
     * checkInitialization has been called.
     */
    private void makeRoom(int newPosition) {
        assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);

        int newIndex = newPosition;
        int lastIndex = numberOfEntries;

        // Move each entry to next higher index, starting at end of
        // list and continuing until the entry at newIndex is moved
        for (int index = lastIndex; index >= newIndex; index--) {
            list[index + 1] = list[index];
        }
    }

    //Throws an exception if this object is not initialized
    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("TranspositionalList object is not intialized properly.");
        }
    }

    //throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a list " + "whose capacity exceeds " + "allowed maximum.");
        }
    }

    /** Adds a new entry to the end of this list.
     Entries currently in the list are unaffected.
     The list's size is increased by 1.
     @param newEntry  The object to be added as a new entry. */
    @Override
    public void add(T newEntry) {
        checkInitialization();
        ensureCapacity();
        list[++numberOfEntries] = newEntry;
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {
        list = (T[])new Object[size()];
    }


    /** Retrieves the entry at a given position in this list.
     @param givenPosition  An integer that indicates the position of
     the desired entry.
     @return  A reference to the indicated entry.
     @throws  IndexOutOfBoundsException if either
     givenPosition < 1 or givenPosition > size. */
    @Override
    public T getEntry(int givenPosition) {
        checkInitialization();
        if (givenPosition < 1 || givenPosition > size()) {
            throw new IndexOutOfBoundsException();
        }
        return list[givenPosition];
    }

    /**
     * Seed whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list contains anEntry, or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        checkInitialization();
        if (null != anEntry) {
            for (T i : list) {
                if (anEntry.equals(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * Sees whether this list is empty
     *
     * @return True if the list is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        checkInitialization();
        return numberOfEntries == 0;
    }
}
