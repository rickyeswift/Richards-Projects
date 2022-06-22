/*
* CMSC256- Summer 2022
* Lab06- Sorting and Searching Lab
* DogNamesLab.java
* This code is used to search the file Dog_Names.csv for dog names and then generate a name to the user.
* Richard Elliott Jr
* 06/14/2022
 */
package cmsc256;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class DogNamesLab {
	private static String promptForFileName() {
		System.out.println("Enter the file name: ");
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		return keyIn.next();
	}

	private static Scanner openFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		while (!file.exists()) {
			file = new File(promptForFileName());
		}
		return new Scanner(file);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Read data file to build data structure
		ArrayList<Dog> doglist = new ArrayList<>();
		
		try {
			// verify file and create file Scanner
			 Scanner fileReader = openFile("Dog_Names.csv");

			//  Discard header line
			 fileReader.nextLine();
			 
			 while(fileReader.hasNextLine()) {
			 	String line = fileReader.nextLine();
			 	int commaIndex = line.indexOf(',');
			 	String name = line.substring(0, commaIndex).trim();
			 	int count = Integer.parseInt(line.substring(commaIndex+1).trim());
			 	doglist.add(new Dog(name, count));
			 }
			 fileReader.close();
		}
		catch(FileNotFoundException noFile){
			System.out.println("There was an error opening or reading from the file.");
			System.exit(0);
		}

		Scanner readInput = new Scanner(System.in);
		String prompt = "\nWhat do you want to do?\n" 
				+ "\t1. Check a dog name\n" + "\t2. See all the dog names\n"
				 + "\t3. Play a game\n" + "\t4. Exit"
				 		+ ".\n"
				+ "Enter the number corresponding to your choice.";
		
		System.out.println(prompt);
		int option = readInput.nextInt();
		
		switch(option) {
		case 1:
			System.out.println("Enter a dog’s name?");
			String name = in.nextLine();
			int nameCount = getCountForDog(doglist, name);
			System.out.println(name + " is registered " + nameCount + " times.");
			break;
		case 2:
			System.out.println(getDogNamesAlphabetically(doglist));
			break;
		case 3:
			playGuessingGame(doglist, in);
			break;
		default: System.out.println("Invalid option.");
		}
		in.close();
	}

	public static int getCountForDog(ArrayList<Dog> dogs, String name) {
		// TODO: 
		// search the list for the Dog named name 
		// display dogs name and the number of registrations for that name
		int count = 0;
		for (int i = 0; i < dogs.size(); i++) {
			if (dogs.get(i).getName().equalsIgnoreCase(name)) {
				count++;
				System.out.println("Name: " + dogs.get(i).getName() + "\t Registration Number:" +
						dogs.get(i).getCount());
			}
		}
		return count;
	}
	
	public static String getDogNamesAlphabetically(ArrayList<Dog> dogs) {
		// TODO Sort the list of Dog by name return
		// Sorting ArrayList in ascending Order
		// using Collection.sort() method
		String strName = "";
		Collections.sort(dogs, Dog.DogNameComprator);
		for (Dog str: dogs) {
			strName = strName + " " + str.getName();
		}
		return strName;
	}

	public static void playGuessingGame(ArrayList<Dog> dogs, Scanner readIn) {
		// TODO: implement the guessing game.
		  // while not done playing
			// pull two random Dogs from the list
			// display the names and prompt player to pick the more popular name
		    // read player input
			// increment total number of guesses
			// check registration counts to determine if player is correct
				// if correct, respond and increment number of correct answers
				// if wrong, respond
			// ask user if they want to quit
				// if yes, display number of correct out of total number of guesses
				// if no, continue
		int min = 0;
		int max = dogs.size();
		int i, j, k = 0;
		int guesses = 0;
		int choice = 0;
		String input;
		do {
			k++;
			i = (int)(Math.random() * (max - min + 1) + min);
			System.out.println(((Dog)dogs.get(i)).getName());
			j = (int)(Math.random() * (max - min + 1) + min);
			System.out.println(((Dog)dogs.get(j)).getName());

			System.out.println("Pick the more popular Dog name: ");
			input = readIn.next();
			int poplari = getCountForDog(dogs, ((Dog)dogs.get(i)).getName());
			int poplarj = getCountForDog(dogs, ((Dog)dogs.get(j)).getName());

			if (poplari == poplarj) {
				System.out.println(((Dog)dogs.get(i)).getName() + " and " + dogs.get(j).getName() + " both are popular");
				guesses++;
				continue;
			}

			if (poplari > poplarj) {
				System.out.println("\nThe " + ((Dog)dogs.get(i)).getName() + "is more popular");
				if (((Dog)dogs.get(i)).getName().equalsIgnoreCase(input)) {
					System.out.println("Your guess is correct");
					guesses++;
				}
				else {
					System.out.println("Your guess is wrong");
				}
			}else {
				System.out.println("\nThe " + dogs.get(j).getName() + "is more popular");
				if (((Dog)dogs.get(j)).getName().equalsIgnoreCase(input)) {
					System.out.println("Your guess is correct");
					guesses++;
				}
				else {
					System.out.println("Your guess is wrong");
				}
			}
			System.out.println("1-> Continue");
			System.out.println("2-> Exit");
			System.out.println("Choice: ");

		}while (choice != 2);
		System.out.println("Your correct guesses is " + guesses + " out of " + k + "");
	}
}
