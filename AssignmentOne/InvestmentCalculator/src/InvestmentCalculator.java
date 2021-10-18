import java.util.Scanner;


/* Investment Calculator
 * Assignment One, Question One
 * Asks user to input initial investment amount, annual interest rate and number of years
 * Outputs investment information including accumulated value
 * 
 * William Applegate    
 * INFO-C210
 */
public class InvestmentCalculator {

	/*
	 * Scanner object created as class instance variable
	 * I intended to create and close a scanner within each method
	 * but calling '.close()' completely closed 'System.in' causing a run-time error when the next input was requested
	 */
	private static Scanner in = new Scanner(System.in);
	
	
	/*
	 * main Method
	 * Introduction, gets variables by calling on input methods, then outputs their values.
	 */
	public static void main(String[] args) {
		//Greeting:
		System.out.println("Investment Calculator");
		System.out.println("Enter the following information...\n");
		
		//Obtain values by calling on methods:
		int initialInvestment = inputInvestmentAmount();
		double interestRate = inputInterest();
		int years = inputYears();
		double accumulatedValue = calcAccumulatedValue(initialInvestment, interestRate, years);
		
		//Output:
		System.out.println("\n Investment Summary:\n--------------------------");
		System.out.println("Initial Investment: $" + initialInvestment);
		System.out.println("Annual Interest Rate: " + interestRate + "%");
		System.out.println("Investment length: " + years + " years");
		System.out.println("---------------------------");
		System.out.printf("Accumulated Value: $%.2f", accumulatedValue);
		
		in.close();

	}
	
	/* inputInvestmentAmount Method
	 * Gets initial investment input from user
	 * Checks if input valid, then returns input.
	 */
	private static int inputInvestmentAmount() {

		int initialInvestment = -1; 	//Initialize return variable
		boolean investmentInputLoop = true; 		//boolean set for while loop
		
		//while loop stops if user makes valid entry
		while(investmentInputLoop) {
			System.out.print("Enter the initial investment amount: ");
		
			//if user enters an integer:
			if(in.hasNextInt()) {
				initialInvestment = in.nextInt();
				
				//if integer input is within range:
				if(initialInvestment > 0 && initialInvestment < 1000000000) {
					investmentInputLoop = false; //Break loop
				
				//If integer input is out of range:
				}else {
					System.err.print("Initial investment " + initialInvestment + " is out of range\t");
					System.err.println("Initial investment should be between 1 and 999999999");
				}
			
			//If user input is not of type int:
			}else {
				String badInput = in.nextLine();
				System.err.print(badInput + " is an invalid entry\t");
				System.err.println("Please enter an initial investment of type integer");
			}
		}
		return initialInvestment; //return statement
	}
	
	/* inputInterest method
	 * Gets interest rate from user
	 * Checks if valid, then returns the given interest rate
	 */
	private static double inputInterest() {

		double interestRate = -0.1;			//Variable initialized
		boolean interestInputLoop = true;    //boolean initialized for while loop
		
		while (interestInputLoop) {
			System.out.print("Enter the annual interest rate as a precentage: ");
			
			if(in.hasNextDouble()) {
				interestRate = in.nextDouble();
				
				//if user input is valid:
				if(interestRate >= 0.0 && interestRate < 500.1) {
					interestInputLoop = false; 	//break while loop
				
				//Else if user input double is too far out of range
				}else {
					System.err.println("Your entry (" + interestRate + "), was out of range");
					System.err.println("Please enter an interest rate between 0.0% and 500.0%");
				}
				
			//Else if user input is not a double:
			}else {
				String badInput = in.nextLine();
				System.err.println(badInput + " is an invalid entry");
				System.err.println("Please enter an interest rate of type double (0.0% to 500.0%");
			}
		}
		
		return interestRate;  //return statement
	}
	
	/*
	 * inputYears method
	 * Gets number of years from user
	 * Checks if valid, then returns given years
	 */
	private static int inputYears() {

		int yearsInput = -1;
		boolean yearInputLoop = true;
		
		while (yearInputLoop) {
			System.out.print("Enter the length of the investment in years: ");
			
			if(in.hasNextInt()) {
				yearsInput = in.nextInt();
				
				//if user input is valid:
				if(yearsInput > 0 && yearsInput < 1000) {
					yearInputLoop = false;
					
				//Else if user input double is too far out of range
				}else {
					System.err.println("Your entry " + yearsInput + " was invalid");
					System.err.println("Please enter an integer for years between 1 and 999");
				}
				
			//Else if user input is not a double:
			}else {
				String badYearInput = in.nextLine();
				System.err.println(badYearInput + " is not a valid entry");
				System.err.println("Please enter an integer for the number of years");
			}
		}

		return yearsInput; //return statement
	}
	
	
	/*
	 * calcAccumulatedValue Method
	 * Takes three investment parameters 
	 * Uses compound interest formula to calculate accumulated value
	 * Rounds accumulated value to 2 decimal places and returns it
	 */
	private static double calcAccumulatedValue(int initialVal, double interestVal, int numYears) {
		interestVal /= 100;   //converts interest rate from percentage to decimal form
		double monthlyInterestRate = interestVal / 12;
		double rawAccumulatedValue = initialVal * (Math.pow((1 + monthlyInterestRate), (numYears * 12)));
		
		double roundedAccumulatedValue = (Math.round(rawAccumulatedValue * 100) / 100.00);
		
		return roundedAccumulatedValue;
	}

}
