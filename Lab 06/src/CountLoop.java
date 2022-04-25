/**
 * Richard Elliott
 *Lab 6
 *CSMC 255-902
 *02/23/2022
 *This could is a loop that adds the sum of numbers 1,2,3...100 and displays its total to the user
 */
import java.util.Scanner; 
public class CountLoop {
	
	public static void main(String[] args) {
		//prompt user to enter a number
		System.out.println("Please enter a positive whole number");
		Scanner input = new Scanner(System.in); // create a scanner
		// declare three variables to be the sum, numbers, and the users input number
		int userInput = input.nextInt();
		int sum = 0;
		int i = 0;
		// create a while loop to count and add the sum of numbers up to 100
		while (i <= userInput) {
			sum += i;
			i++;
		}
		System.out.println("The sum of this number: " + userInput + " is " + sum);
		int sum1 = 0;
		// create a for loop to count and add the sum of numbers up to 100
		for (int k = 0; k <= userInput; k++) {
			sum1 += k;
		}
		System.out.println("The sum of this number: " + userInput + " is " + sum1);
		int l = 0;
		int sum2 = 0;
		// create a do while loop to count and add the sum of numbers up to 100
		do {
			sum2 += l;
			l++;
		}while(l <= userInput);
			System.out.println("The sum of this number: " + userInput + " is " + sum2);
	}
}
