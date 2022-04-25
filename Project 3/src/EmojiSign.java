/*
 * Project 3 EmojiSign
 * 
 * This code will let the user create an emoji sign factoring in the volume and surface area
 * it will calculate the price of the emoji sign based on it's size and the amount of words
 * used on the sign as well
 * 
 * Richard Elliott
 * 02/20/2022
 * CSMC 255-902
 */
import java.util.Scanner;

public class EmojiSign {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double r = 0; // r will be assigned to the radius the user inputs
		// create a do/while loop to have the program run again if the user wants to continue
		String s5 = "yes";
		String newSign = "n";
		do {
		// prompt user to enter a radius
			System.out.println("Enter the radius: ");
		
			r = input.nextDouble();
			input.nextLine();
			final double SURFACE_AREA = 4 * (Math.PI) * (Math.pow(r, 2)); // formula for surface area
			final double VOLUME = 1.33333333333333333 * (Math.PI) * (Math.pow(r, 3)); // formula for volume 
		
			double costOfSurface = 2.75 * SURFACE_AREA; // cost of surface area
			double costOfVolume = 3.45 * VOLUME; // cost of volume
		
			System.out.println("Enter the string you would like on your sign: ");
			String display = input.nextLine();
			String newDisplay = display.replace(" ", "");
			double costOfDisplay = 4.50 * newDisplay.length(); // multiply the length of the message by 4.50
		
			// prompt user to enter a emoji sign to use
			System.out.println("Which emoji would you like on your sign: ");
			String emoji = input.nextLine();
			// create string variables for the emojis the user will choose
			String s1 = "Cool";
			String s2 = "Wink";
			String s3 = "4 eyes";
			String s4 = "Smile";
			
		
			// create an if/else statement determine the pricing of the emoji choosen
			if (emoji.equals(s1) || emoji.equals(s3)) {
				double costOfEmoji = 500;
				double totalCost1 = costOfEmoji + costOfDisplay + costOfSurface + costOfVolume;
				System.out.printf("Your sign with " + '"' + display + '"' + " will cost $%,.2f%n", totalCost1);
			}
			else if (emoji.equals(s2) || emoji.equals(s4)) {
				double costOfEmoji = 450;
				double totalCost2 = costOfEmoji + costOfDisplay + costOfSurface + costOfVolume;
				System.out.printf("Your sign with " + '"' + display + '"' + " will cost $%,.2f%n", totalCost2);
			}
			else System.out.println("incorrect input");
			System.out.println("Would you like to create another sign? Enter yes to continue.");
			newSign = input.nextLine().trim();
			newSign.toLowerCase();
		}while (newSign.equals(s5));
	}
}