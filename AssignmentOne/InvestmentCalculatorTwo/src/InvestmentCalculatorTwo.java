import java.util.Scanner;


/* Investment Calculator Two
 * Assignment One, Question Four
 * Asks user to input initial investment amount and annual interest rate
 * Outputs investment information including accumulated value
 * every year from first year of investment to year 30.
 * 
 * William Applegate    
 * INFO-C210
 */
public class InvestmentCalculatorTwo {

	private static Scanner in = new Scanner(System.in);
	
	
	/*
	 * main Method
	 * Introduction, gets variables by calling on input methods, then outputs their values.
	 */
	public static void main(String[] args) {
		//Introduction:
		System.out.println("Investment Calculator");
		System.out.println("Enter the following information...\n");
		
		//Obtain values by calling on methods:
		int initialInvestment = inputInvestmentAmount();
		double interestRate = inputInterest();
		double[] futureValueByYear = getValueForNext30Years(initialInvestment, interestRate);
		
		//Output:
		printValuesArray(initialInvestment, interestRate, futureValueByYear);
		
		//End
		System.out.println("Program Complete");
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
					System.err.println("Initial investment " + initialInvestment + " is out of range");
					System.err.println("Initial investment should be between 1 and 999999999");
				}
			
			//If user input is not of type int:
			}else {
				String badInput = in.nextLine();
				System.err.println(badInput + " is an invalid entry");
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
				if(interestRate >= 0.0 && interestRate < 500.0) {
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
		
		interestRate /= 100;   //converts interest rate from percentage to decimal form
		return interestRate;  //return statement
	}
	
	/*
	 * getValueForNext30Years Method
	 * takes initial investment and interest rate parameters
	 * uses for loop to assign values to double array while calling the calcAccumulatedValue method
	 * returns a double array of 30 elements representing values of an investment for first 30 years. 
	 */
	private static double[] getValueForNext30Years(int initialInvestmentInput, double interestRateInput) {
		
		double[] investmentValueByYear = new double[30];  //Create new double array
		
		//for loop to get values by year
		for (int i = 0 ; i < 30 ; i++) {
			int year = i + 1;
			investmentValueByYear[i] = calcAccumulatedValue(initialInvestmentInput, interestRateInput, year);
		}
		
		return investmentValueByYear; //return statement
	}
	
	/*
	 * calcAccumulatedValue Method
	 * Takes three investment parameters 
	 * Uses compound interest formula to calculate accumulated value
	 * Rounds accumulated value to 2 decimal places and returns it
	 */
	private static double calcAccumulatedValue(int initialVal, double interestVal, int numYears) {
		double monthlyInterestRate = interestVal / 12;
		double rawAccumulatedValue = initialVal * (Math.pow((1 + monthlyInterestRate), (numYears * 12)));
		double roundedAccumulatedValue = (Math.floor(rawAccumulatedValue * 100) / 100.00);
		
		return roundedAccumulatedValue;
	}
	
	
	/*
	 * printValuesArray Method
	 * Takes double array as a parameter for years and the associated value
	 * Uses for loop to print array to console
	 */
	private static void printValuesArray(int initialInvestment, double interestRate, double[] values) {
		//Get interest rate from decimal to percentage rate:
		double interestAsPercentage = interestRate * 100;
		
		//Header:
		System.out.println("\n Investment Summary:\n----------------------");
		System.out.println("Initial Investment: $" + initialInvestment);
		System.out.println("Annual Interest Rate: " + interestAsPercentage + "%");
		
		System.out.println("Years\tFuture Value");
		
		//For Loop to print years and their values:
		for (int i = 0 ; i < 30 ; i++) {
			int year = i + 1;
			System.out.printf("%d\t%.2f\n", year, values[i]);
		}
	}

}
