/*
 * Richard Elliott
 * CSMC 255-902
 * Project 2 NumberPlay
 * This code is seeing what 6 digit numbers sums are divisible by 11
 * I will have the user choose between 1 and 2
 * 1 will have the user enter a 6 digit number 
 * 2 will have a random 6 digit number choosen for the user
 * The 6 digit of either number will have each digit summed up for a total
 * That total will be modulated by 11 to see if its divisible by 11
 * The code will output to the user whether their 6 digit number is divisible by 11 or not
 */

import java.util.Scanner;

public class NumberPlay{
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		// prompt the user to choose between 1 and 2
		System.out.println("Would you like to randomly generate a number (1) or enter it yourself (2)?");
		int choice = input.nextInt();
		// use an IF/ELSE statement to assign different outputs for 1 and 2 
		if (choice == 2) {
			System.out.println("Please enter a 6 digit number");
			int number = input.nextInt();
				int sum = 0;
				int userPick = number;
				while (userPick != 0) {
				// these lines of code finds the sum between each digit
					int lastdigit = userPick % 10; 
					sum += lastdigit;
					userPick /= 10;
				 }
					// make sure the number inputted by the user is over 6 digits and divisible by 11
					if (number < 100000 || number > 999999){
							System.out.println("Incorrect input");
						}
						else if ((sum % 11 == 0) && (number > 100000 || number < 999999)) {
							System.out.println(number + " is divisible by 11");
						}
						else if ((sum % 11 != 0) && (number > 100000 || number < 999999)) {
							System.out.println(number + " is not divisible by 11");
						}
		}		
		// generate a random number if the users choice is 1
		else if (choice == 1) {
			// a random 6 digit number will be choosen 
			double ranNum = Math.floor(100000 + Math.random() * 999999); 
			// use typecasting to change ranNum into an integer 
			int randomChoice = (int)ranNum;
			int number2 = randomChoice;
			int sum2 = 0;
			int userPick2 = number2;
			while (userPick2 != 0) {
				int lastdigit = userPick2 % 10;
				sum2 += lastdigit;
				userPick2 /= 10;
			}
			System.out.println("Sum of digits " + number2 + " is " + sum2);
			if (sum2 % 11 == 0) {
				System.out.println("The sum of " + number2 + " is divisible by 11");
			}
			else if (sum2 % 11 != 0) { 
				System.out.println("Sum of digits " + number2 + " is not divisible by 11");
			}
		// this else statement is for if the user chooses a number either than 1 or 2
		else System.out.println("Incorrect input");
		}
	}
}
