/* Tax Calculation
 * Assignment One, Question Two
 * Asks user for filing status and taxable income total
 * Computes Tax
 * 
 * William Applegate
 * INFO-C210
 */

import java.util.Scanner;

public class TaxComputation {

private static Scanner in = new Scanner(System.in);
	
	/*
	 * main Method
	 * Introduction, calls on methods to get user input, calls on methods to obtain tax information, prints tax
	 */
	public static void main(String[] args) {
		//Introduction
		System.out.println("Tax Calculator");
		System.out.println("Enter the following information...\n");
		
		//Call methods to get user input for filing status and taxable income
		int filingStatus = getFilingStatus();
		int taxableIncome = getTaxableIncome();
		
		
		//Call methods to calculate taxes 
		int[] taxBrackets2009 = getTaxBracket2009(filingStatus);
		final double [] TAX_RATES2009 = {.10, .15, .25, .28, .33, .35}; //initializing array for 2009 tax rates
		double tax = getTax(taxBrackets2009, TAX_RATES2009, taxableIncome);
		
		//Output
		System.out.printf("Income tax is: $%.2f\n", tax);
		in.close();
		System.out.println("Program Complete.");
	}
	
	/*
	 * getFilingStatus Method
	 * asks user to input filing status
	 * checks if valid, then returns int value representing filing status.
	 */
	private static int getFilingStatus() {

		int filingStatus = -1; //Initialize Return Variable
		
		//While loop continues as long as a valid input is still needed from user
		while (filingStatus == -1) {
			
			//print instructions
			System.out.println("| Single | Married Filing Jointly or Qualified Widow(er) | Married Filing Separately | Head of Household |");
			System.out.println("|  (0)   |                       (1)                     |           (2)             |        (3)        |");
			System.out.print("Enter the number that corresponds with your filing status: ");
		
			//Get input if input is type int
			if(in.hasNextInt()) {
				int filingStatusInput = in.nextInt();
			
				//if int input is within range
				if(filingStatusInput > -1 && filingStatusInput < 4) {
					filingStatus = filingStatusInput;
			
				//if int input is out of range
				}else {
					System.err.println("Invalid number entry");
				}
			
			//if no int value was entered
			}else {
				in.nextLine();
				System.err.println("Please enter an integer between 0 and 3");
			}
		}
		return filingStatus; //return statement
	}
	
	/*
	 * getTaxableIncome Method
	 * asks user to input taxable income of type int
	 * Checks if input was valid, then returns int value
	 */
	private static int getTaxableIncome() {

		int taxableIncome = -1; //Initialize Return Variable
		
		//While loop continues as long as filingStatus value stays same
		while (taxableIncome == -1) {
			
			//print instructions
			System.out.print("Enter your total taxable income (no change, no decimal points): ");
		
			//Get input if input is type int
			if(in.hasNextInt()) {
				int taxableIncomeInput = in.nextInt();
			
				//if int input is within range
				if(taxableIncomeInput > -1 && taxableIncomeInput < 999999999) {
					taxableIncome = taxableIncomeInput;
			
				//if int input is out of range
				}else {
					System.err.println("Invalid dollar value entered, out of bounds");
				}
			
			//if no int was entered
			}else {
				System.err.println("Please enter an integer value only\n");
				in.next();
			}
		}
		return taxableIncome; //return statement
	}
	
	
	/*
	 * getTaxBrackets Method
	 * Takes int parameter for filing status
	 * Returns array of max incomes for each tax bracket based on filing status.
	 * 
	 */
	private static int[] getTaxBracket2009(int filingStatus) {
		
		//Switch board chooses which array to initialize and returns it.
		switch (filingStatus) {
		case 0: //Single filing status
			return new int[]{0, 8350, 33950, 82250, 171550, 372950, 999999999};
			
		case 1: //Joint filing status
			return new int[]{0, 16700, 67900, 137050, 208850, 372950, 999999999};
			
		case 2: //Filing Separately
			return new int[]{0, 8350, 33950, 68525, 104425, 186475, 999999999};
			
		case 3: //Head of Household
			return new int[] {0, 11950, 45500, 117450, 190200, 372950, 999999999};
			
		//Error printed if switch board made it this far:
		default:
			System.err.println("Error found while calling method getTaxBracket2009");
			return new int[] {-1};
			
		}
		
	}
	
	/*
	 * getTax Method
	 * calculates tax based on parameters for tax brackets, tax rates and taxable income
	 * returns tax amount
	 */
	public static double getTax(int[] taxBrackets, double[] taxRates, int taxableIncome) {
		double accumulator = 0.0; 
		double tax = -1.0;  
		
		//for loop for the cap of each tax bracket, lowest bracket to highest
		for(int i = 1 ; i < taxBrackets.length ; i++){

			//if taxable income falls within bracket
			if(taxableIncome < taxBrackets[i]) {
				tax = ((taxableIncome - taxBrackets[i-1]) * taxRates[i-1]) + accumulator;
				return tax; 
			
			//if taxable income is higher than current bracket, add taxes owed in current bracket to the accumulator
			}else{
				accumulator += ((taxBrackets[i] - taxBrackets[i-1]) * taxRates[i-1]); 
			}
		}
			System.err.println("Error calculating tax in getTax method");
			return tax; //Return statement for logic error method call
	}	
}