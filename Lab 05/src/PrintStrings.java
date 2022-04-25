/* This code will prompt the user to pick two words out and will compare the words to each other
 *  and display them in "ABC" order using a series of String commands to execute it.
 * Richard Elliott Jr
 * 02/16/2022
 * CSMC 255-902
 * Lab 05
 */

import java.util.Scanner;

public class PrintStrings {
	public static void main(String[] args) {
		
		//Declare Variables
		String word1;
		String word2;
		
		// Prompt the user to pick two words
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first word: ");
		word1 = input.nextLine();
		
		System.out.println("Enter second word: ");
		word2 = input.nextLine();
		
		// Compare two words chosen
		if (word1.compareToIgnoreCase(word2) < 0) {
			System.out.println("The words in alphabetical order are " + word1 + ", " + word2);
		}
		else {
			System.out.println("The words in alphabetical order are " + word2 + ", " + word1);
		}
		
	}

}
