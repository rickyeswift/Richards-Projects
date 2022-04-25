package Labs.Lab7;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Lab7{

    public static void main(String[] args) {
        // variable declarations for part 1
        String title;
        String firstName;
        String lastName;
        Scanner in = new Scanner(System.in);

        // prompt for input for part 1
        System.out.print("Enter a title:");
        title = in.next();
        System.out.print("Enter your first name:");
        firstName = in.next();
        System.out.print("Enter a your last name:");
        lastName = in.next();

        // call the method for part 1
        greeting(title, firstName, lastName);

        // variable declarations for part 2
        int number1;
        int number2;

        // user prompts for part 2
        System.out.print("Enter first number:");
        number1 = in.nextInt();
        System.out.print("Enter second number:");
        number2 = in.nextInt();

        // call the methods max and sumTo inside the println statement
        System.out.println("The largest number is " + max(number1, number2));
        System.out.println("The sum of the numbers is " + sumTo(number1, number2));
    }// end of main method

    /******************** greeting method goes here*********************/
    public static void greeting(String title, String firstName, String lastName){
        System.out.println("");
        System.out.println("Dear " + title + " " + firstName + " " + lastName + ",");
        System.out.println("");
    }




    /***********************end of method*************************/

    /******************** max method goes here*********************/
    public static int max(int number1, int number2){
        int result;
        if(number1 > number2){
            result = number1;
        }
        else{
            result = number2;
        }
        return result;
    }




    /***********************end of method*************************/

    /******************** sumTo method goes here*********************/
    public static int sumTo(int number1, int number2) {
        int result = 0;
        while (true){
            if (number1 < number2){
                result = ((number1 + number2) * (number2 - number1 + 1)) / 2;
            }
            else if(number2 < number1){
                result = ((number2 + number1) * (number1 - number2 + 1)) / 2;
            }
            else if(number1 == number2 || number2 == number1){
                result =  result = ((number1 + number2) * (number2 - number1 + 1)) / 2;
            }
            return result;
        }
    }




    /***********************end of method*************************/
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static class Lab7Test {

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

        @Before
        public void setUpStreams() {
            System.setOut(new PrintStream(outContent));
            System.setErr(new PrintStream(errContent));
        }

        @Test
        public void greetingTest() {
            greeting("Prof.", "Zach", "Whitten");
            String rawOutput = outContent.toString();
            String[] outputLines = rawOutput.split(System.lineSeparator());
            assertEquals("", outputLines[0]);
            assertEquals("Dear Prof. Zach Whitten,", outputLines[1]);
        }

        @Test
        public void max10and2Test() {
            int max = max(10, 2);
            assertEquals(10, max);
        }

        @Test
        public void max2and10Test() {
            int max = max(2, 10);
            assertEquals(10, max);
        }

        @Test
        public void max50and50Test() {
            int max = max(50, 50);
            assertEquals(50, max);
        }

        @Test
        public void maxMinus10andMinus2Test() {
            int max = max(-10, -2);
            assertEquals(-2, max);
        }

        @Test
        public void maxMinus2andMinus10Test() {
            int max = max(-2, -10);
            assertEquals(-2, max);
        }

        @Test
        public void max0and0Test() {
            int max = max(0, 0);
            assertEquals(0, max);
        }

        @Test
        public void sumTo2and10Test() {
            int max = sumTo(2, 10);
            assertEquals(54, max);
        }

        @Test
        public void sumTo10and2Test() {
            int max = sumTo(10, 2);
            assertEquals(54, max);
        }

        @Test
        public void sumTo50and50Test() {
            int max = sumTo(50, 50);
            assertEquals(50, max);
        }

        @Test
        public void sumToMinus10andMinus2Test() {
            int max = sumTo(-10, -2);
            assertEquals(-54, max);
        }

        @Test
        public void sumToMinus2andMinus10Test() {
            int max = sumTo(-2, -10);
            assertEquals(-54, max);
        }

        @Test
        public void sumTo0and0Test() {
            int max = sumTo(0, 0);
            assertEquals(0, max);
        }

        @After
        public void cleanUpStreams() {
            System.setOut(null);
            System.setErr(null);
        }
    }
}
