package bankmanagementsystem;
import java.util.Scanner;

public class UserInput {
	static private Scanner in = new Scanner(System.in);
	
	private UserInput() {
		
	}
	public static void divder() {

		in.nextLine();
	}
	public static boolean yesOrNoQuestion(String instructions) {
		System.out.println(instructions);
		String answer;
		boolean questionLoop = true;
		do {
		System.out.println("(Enter y or n): ");
		answer = in.nextLine();
		
		answer = answer.toUpperCase();
		
		if(answer.equals("Y")||answer.equals("YES")){
			return true;
		}else if(answer.equals("N") || answer.equals("NO")) {
			return false;
		}else {
			System.out.println("Invalid entry");
		}
		
		}while(questionLoop);
		return false;
	}
	
	public static String enterName(String instructions) {
		String name;
		boolean nameLoop = true;
		
		do {
			System.out.println(instructions);
			
			in.nextLine();
			name = in.nextLine();
				nameLoop = false;
		}while(nameLoop);
		
		return name;
	}
	
	public static int enterNumber(String instructions, int min, int max) {
		int response;
		boolean numberLoop = true;
		System.out.println(instructions);
		do {
			if(in.hasNextInt()) {
				response = in.nextInt();
				if(response <= max && response >= min) {
					numberLoop = false;
					return response;
				}else {
					System.out.println("Input of " + response + "out of range");
				}
			}else {
				System.out.println("" + in.next() + "is not an integer");
			}
		}while(numberLoop);
	
	return -1;
	}
}