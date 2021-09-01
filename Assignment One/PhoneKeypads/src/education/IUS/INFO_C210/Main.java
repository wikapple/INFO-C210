package education.IUS.INFO_C210;

import java.util.Scanner;

/*
 * Assignment One Problem Three
 * Calls on recursive phoneKeypadRecursion Method to get letter parameter from user
 * method prints corresponding keypad digit before calling itself again
 * 
 * INFO-C210
 * William Applegate
 */
public class Main {
	//Scanner  
	private static Scanner in = new Scanner(System.in);

	/*
	 * Main method
	 */
	public static void main(String[] args) {
		
		System.out.println("Phone keypad");  //Title printout
		
		phoneKeypadRecursion(); //Calling recursive method
		
		in.close(); //close scanner
		System.out.println("Program ended"); //end of program
	}

	/*
	 * phoneKeypadRecursion Method
	 * Asks user to input letter (char)
	 * prints corresponding keypad integer
	 * method calls itself until stopped
	 */
	public static void phoneKeypadRecursion() {
		//Instructions:
		System.out.println("Enter a letter (or type \"stop\" to end): ");
		
		//get user input
		String userInput = in.nextLine();
		userInput = userInput.toUpperCase();
		
		//if user types stop case insensitive, method will return
		if (userInput.equals("STOP")){
			return;
		}
		
		//char obtained from user input, if user input longer than char, the first index is obtained
		char charInput = userInput.charAt(0);
		//get the ASCII integer of charInput
		int intWrapper = (int)charInput;
		
		int keyPadValue;
		//Checks if input was a letter
		if(intWrapper > 64 && intWrapper <	91) {
			
			//assigns keyPadValue corresponding to mapping standard
			if(intWrapper < 68) {
				keyPadValue = 2;
				
			}else if(intWrapper < 71) {
				keyPadValue = 3;
				
			}else if(intWrapper < 74) {
				keyPadValue = 4;
				
			}else if(intWrapper < 77) {
				keyPadValue = 5;
				
			}else if(intWrapper < 80) {
				keyPadValue = 6;
				
			}else if(intWrapper < 84) {
				keyPadValue = 7;
				
			}else if(intWrapper < 87) {
				keyPadValue = 8;
				
			}else{
				keyPadValue = 9;
				
			}
			//Output corresponding integer
			System.out.println("Keypad value: " + keyPadValue);
			
		//output if letter not found
		}else {
			System.out.println("Error getting keypadValue");
		}
		
		phoneKeypadRecursion(); //Recursion
	}
		
}

