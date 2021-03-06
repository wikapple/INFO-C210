import java.util.Scanner;

/* Phone Keypad
 * Assignment One Problem Three
 * Calls on recursive phoneKeypadRecursion Method to get letter parameter from user
 * method prints corresponding keypad digit before calling itself again
 * 
 * William Applegate
 * INFO-C210
 */
public class PhoneKeypads {
	//Scanner  
	private static Scanner in = new Scanner(System.in);

	/*
	 * Main method
	 */
	public static void main(String[] args) {
		
		System.out.println("Phone keypad");  //Title printout
		
		phoneKeypadRecursion(); //Calling recursive method in order to print corresponding keypad values according to user input
		
		in.close(); //close scanner
		System.out.println("Program complete."); //end of program
	}

	/*
	 * phoneKeypadRecursion Method
	 * Asks user to input letter (char)
	 * prints corresponding keypad integer
	 * method calls itself until stopped
	 */
	public static void phoneKeypadRecursion() {
		//Instructions:
		System.out.print("Enter a letter (or type 'stop' to end): ");
		
		//get user input
		String userInput = in.nextLine();
		userInput = userInput.toUpperCase();
		
		//if user types stop, method will return
		if (userInput.equals("STOP")||userInput.equals("")){
			return;
		}
		
		//char obtained from user input, if user input longer than char, the first element is obtained
		char charInput = userInput.charAt(0);
		
		int letterValue = charInput - 'A';
		int keyPadValue = -1;
		
		//Checks for valid entry, then assigns keyPadValue.
		if(letterValue > -1 && letterValue < 26) {
			
			if(letterValue < 18) {
				keyPadValue = (letterValue / 3) + 2;
				
			}else if(letterValue < 19) {
				keyPadValue = 7;
				
			}else if(letterValue < 22) {
				keyPadValue = 8;
				
			}else {
				keyPadValue = 9;
			}
		
		}else {
			System.out.println("Invalid entry");
		}
		
		//if keyPadValue was assigned a new value, print it to console
		if(keyPadValue != -1) {
		System.out.println("Corresponding keypad digit = " + keyPadValue);
		}
		
		System.out.println("--------------------");
		phoneKeypadRecursion(); //Recursion
	}
		
}