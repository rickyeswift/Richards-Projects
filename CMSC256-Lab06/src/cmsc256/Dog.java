/*
* CMSC256- SUMMER 2022
* Lab06- Sorting and Searching
* Dog.java
* This code serves as an object for Dog creating a variable for dogName
* and count to be used in the DogNamesLab generator.
* Richard Eliiott Jr
* 06/14/2022
 */
package cmsc256;

import java.util.Comparator;

//class dog
//implements comparable to do the sorting
public class Dog {
    private String dogName;
    private int count;

    private static int num = 8000;


    //constructor which takes the name and count
    public Dog(String name, int count) {
        this.dogName = name;
        this.count = count;
        num++;

    }

    public String getName() {

        return dogName;
    }

    public int getCount() {

        return count;
    }

    //overrides compareTo from Comparable interface to do the sorting
    @Override
    public String toString() {
        return "Dog{" + "Registration Number: " + count + "\tName: " + dogName + '}';
    }

    public static Comparator<Dog> DogNameComprator = new Comparator<Dog>() {
        @Override
        public int compare(Dog d1, Dog d2) {
            String Name1 = d1.getName().toUpperCase();
            String Name2 = d2.getName().toUpperCase();

            // ascending order
            return Name1.compareTo(Name2);

            // descending order
        }
    };
}