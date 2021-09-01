package education.IUS.INFO_C210;

/*
 * Assignment One Question Two
 * Asks user for filing status and taxable income total
 * Computes Tax
 * 
 * William Applegate
 * INFO-C210
 */

import java.util.Scanner;

public class Main {

private static Scanner in = new Scanner(System.in);
	
	/*
	 * main Method
	 * Introduction, calls on methods to get user input, calls on methods to obtain tax information, prints tax
	 */
	public static void main(String[] args) {
		//Greeting
		System.out.println("Tax Calculator");
		System.out.println("Enter the following information...\n");
		
		//Call methods to get filing status and taxable income
		int filingStatus = getFilingStatus();
		int taxableIncome = getTaxableIncome();
		
		
		//Call method to get tax 
		int[] taxBrackets2009 = getTaxBracket2009(filingStatus);
		double [] taxRates2009 = {.10, .15, .25, .28, .33, .35};
		
		double tax = getTax(taxBrackets2009, taxRates2009, taxableIncome);
		
		//Output
		
		System.out.println("Income tax is: " + tax);
		in.close();
	}
	
	/*
	 * getFilingStatus Method
	 * asks user to input filing status
	 * checks if valid, then returns int value representing filing status.
	 */
	private static int getFilingStatus() {

		int filingStatus = -1; //Initialize Return Variable
		
		//While loop continues as long as filingStatus value stays same
		while (filingStatus == -1) {
			
			//print instructions
			System.out.println("Single\tMarried Filing Jointly or Qualified Widow(er)\tMarried Filing Separately\tHead of Household");
			System.out.println(" (0)\t\t\t(1)\t\t\t\t\t(2)\t\t\t\t(3)");
			System.out.println("Enter the number that corresponds with your filing status: ");
		
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
			
			//if no int was entered
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
			System.out.println("Enter your total taxable income (no change, decimal points): ");
		
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
				in.nextLine();
				System.err.println("Please enter an integer value only");
			}
		}
		return taxableIncome; //return statement
	}
	
	
	/*
	 * getTaxBrackets Method
	 * Takes int parameter for filing status
	 * Uses switch board to categorize filing status brackets
	 * Returns taxBrackets with cap of each bracket
	 * 
	 */
	private static int[] getTaxBracket2009(int filingStatus) {
		
		int[] taxBrackets = new int[7]; //initialize variable
		
		//Long switch board with conditional statements in order to obtain tax bracket array
		switch (filingStatus) {
		case 0:
			
			taxBrackets[0] = 0;
			taxBrackets[1] = 8350; 
			taxBrackets[2] =  33950;
			taxBrackets[3] = 82250;
			taxBrackets[4] = 171550;
			taxBrackets[5] = 372950;
			taxBrackets[6] = 999999999; 
			break;
			
		case 1:
			
			taxBrackets[0] = 0;
			taxBrackets[1] = 16700; 
			taxBrackets[2] =  67900;
			taxBrackets[3] = 137050;
			taxBrackets[4] = 208850;
			taxBrackets[5] = 372950;
			taxBrackets[6] = 999999999;
			break;
			
		case 2:
			
			taxBrackets[0] = 0;
			taxBrackets[1] = 8350; 
			taxBrackets[2] =  33950;
			taxBrackets[3] = 68525;
			taxBrackets[4] = 104425;
			taxBrackets[5] = 186475;
			taxBrackets[6] = 999999999;
			break;
			
		case 3:
			taxBrackets[0] = 0;
			taxBrackets[1] = 11950; 
			taxBrackets[2] =  45500;
			taxBrackets[3] = 117450;
			taxBrackets[4] = 190200;
			taxBrackets[5] = 372950;
			taxBrackets[6] = 999999999;
			break;
			
		//Error printed if switch board made it this far:
		default:
			System.err.println("Error found in switch board method getTaxBracket2009");
			
		}
		
		return taxBrackets; //return statement
	}
	
	/*
	 * getTax Method
	 * calculates tax based on parameters for tax brackets, tax rates and taxable income entered by user
	 * returns tax amount
	 */
	public static double getTax(int[] taxBrackets, double[] taxRates, int taxableIncome) {
		double accumulator = 0; //Accumulator set to 0
		double tax = -1.0;   //initialize tax value, set to a value noticeably incorrect until re-assigned 
		
		//for loop for the cap of each tax bracket, lowest bracket to highest
		for(int i = 1 ; i < taxBrackets.length ; i++){

			/* if taxable income falls within tax bracket, calculate tax owed for that bracket
			 * any taxes owed from any lower tax brackets, then return tax value
			 */
			if(taxableIncome < taxBrackets[i]) {
				tax = ((taxableIncome - taxBrackets[i-1]) * taxRates[i-1]) + accumulator;
				return tax;  //Return statement for succesful method call
			
			//else taxable income is higher than bracket, so taxes owed from that bracket are accumulated.
			}else{
				accumulator += ((taxBrackets[i] - taxBrackets[i-1]) * taxRates[i-1]); 
			}
		}
			//error message with return if for loop is completed before method returns
			System.err.println("Error calculating tax in getTax method");
			return tax; //Return statement for logic error method call
	}	
}