
import java.util.Scanner;


/*
 * Checks whether an int user input is divisible by 2 and 3,
 * whether the number is divisible by 2 or 3
 * or whether a number is divisible by 2 or 3, but not both
 * Author: William Applegate
 * Info-C210
 */
public class Main {

	
	/*
	 * Asks user for int input, returns int once one is recieved
	 */
	private static int getInt() {
		Scanner in = new Scanner(System.in);
		boolean intLoop = false;
		int userNumber = -1;
		
		while(!intLoop) {
			System.out.println("Enter an integer: ");
			if(in.hasNextInt()) {
				userNumber = in.nextInt();
				intLoop = true;
			}else {
				String wrongInput = in.nextLine();
				System.err.println(wrongInput + " is not a valid response!");
			}
		}
		return userNumber;
	}
	
	
	/*
	 * Takes int parameter
	 * Calls on two boolean methods to check if int parameter is divisible by 2 or 3
	 * Prints various outputs depending on whether divisible
	 */
	private static void isNumberDivisible(int number) {
		boolean divisibleBy2 = divisibleBy2(number);
		boolean divisibleBy3 = divisibleBy3(number);
		
		if(divisibleBy2 && divisibleBy3) {
			System.out.println("Entered number is divisible by both 2 and 3");
		}else if(divisibleBy2 && !divisibleBy3) {
			System.out.println("Entered number is divisible by 2");
		}else if(divisibleBy3) {
			System.out.println("Entered number is divisible by 3");
		}else if (!divisibleBy2 && !divisibleBy3) {
			System.out.println("Entered number is not divisible by 2 or 3");
		}else {
			System.err.println("Error found in isNumberDivisible method");
		}
	}
	
	/*
	 * Checks if int parameter is divisible by 2
	 * returns boolean value
	 */
	private static boolean divisibleBy2(int number) {
		if(number % 2 == 0) {
		return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Checked if int parameter is divisible by 3
	 * returns boolean value
	 */
	private static boolean divisibleBy3(int number) {
		if(number % 3 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/*
	 * Main Method
	 */
	public static void main(String[] args) {
		int number = getInt();
		System.out.println("Your number is " + number);
		
		isNumberDivisible(number);
		
		System.out.println("Program Completed");
	}
}
