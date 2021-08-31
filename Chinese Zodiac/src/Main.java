import java.util.Scanner;

/*
 * Finds and outputs Chinese zodiac from year entered by the user.
 * Author: William Applegate
 * INFO-C210
 */
public class Main {
	
	/*
	 * Asks user to input year. If correct, returns the year to Main method
	 */
	private static int getYear() {
		Scanner in = new Scanner(System.in);
		boolean getYearLoop = true;
		int yearInput = 2021;
		
		while (getYearLoop) {
		System.out.println("Enter a year to get Chinese Zodiac: ");
			
			if(in.hasNextInt()) {
				yearInput = in.nextInt();
				if(yearInput > -9999 && yearInput < 9999) {
					getYearLoop = false;
				}else {
					System.err.println("The input " + yearInput + " is out of range!");
				}
			}else {
				String wrongInput = in.nextLine();
				System.err.println(wrongInput + " is not a valid response!");
			}
		}
		
		 return yearInput;
	}
	
	
	/*
	 * returns Chinese zodiac for a given year parameter
	 */
	private static String getZodiacAnimal(int year) {
		year = Math.abs(year);
		int modOfYear = year % 12;
		String animal;
		switch (modOfYear) {
		case 1:
			animal = "monkey";
			break;
		case 2:
			animal = "rooster";
			break;
		case 3:
			animal = "dog";
			break;
		case 4:
			animal = "rat";
			break;
		case 5:
			animal = "ox";
			break;
		case 6:
			animal = "tiger";
			break;
		case 7:
			animal = "rabbit";
			break;
		case 8:
			animal = "dragon";
			break;
		case 9:
			animal = "snake";
			break;
		case 10:
			animal = "horse";
			break;
		case 11:
			animal = "sheep";
			break;
		default:
			System.err.println("Error getting animal!");
			animal = "Error, no animal";
			break;
			
		}
		
		return animal;
	}
	
	
	
	/*
	 * Main method
	 */
	public static void main(String[] args) {
		int year = getYear();
		String animal = getZodiacAnimal(year);
		
		//output
		System.out.println("For the year " + year + ", the Chinese Zodiac is the " + animal + ".");
		
	}
}
