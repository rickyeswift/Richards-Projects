/**
 * Richard Elliott
 * CSMC 255-902
 * Lab 06
 * This code will display a right triangle and an equilateral triangle by using a nestedloop 
 */
public class NestedLoopTriangle {
	public static void main(String[] args) {
		rightTriangle();
		System.out.println(); // print out the code inside rightTriangle()
		equilateralTriangle();
		System.out.println(); // print out code inside equilateralTriangle()
	}

	public static void rightTriangle() {
		int tri= 11;
		for (int i = 1; i <= tri; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*"); // to fill out the form of the right triangle with asterisks
			}
			System.out.println();
		}
	}
	public static void equilateralTriangle() {
		int iso = 11;
		for(int r = 1; r <= iso; r++) {
			for(int sp = r; sp <= iso; sp++) {	
				System.out.print(" "); //to form space
			}
			for(int sp = 1; sp <= r; sp++) {
				System.out.print("* "); // to fill with asterisks 
			}
			System.out.println(""); // to print the form of the triangle
		}

	}

}
