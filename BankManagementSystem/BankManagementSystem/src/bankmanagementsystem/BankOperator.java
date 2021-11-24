package bankmanagementsystem;

import java.math.BigDecimal;
import java.util.ArrayList;


/*
 * Bank Operator Class
 * Provides user interface to a bank operator
 * uses UserInput class to get user input, calls on instance of AccountLedger class to manipulate bank data
 * 
 * Author: William Applegate
 * Class: INFO-C210
 */
class BankOperator {
	
	
	/*Data Fields*/
	AccountLedger bankLedger;
	
	
	/*Constructor*/
	BankOperator(AccountLedger bankLedger){
		this.bankLedger = bankLedger;
	}
	
	
	/* main menu */
	public void runMenu() {
		boolean menuLoop = true; /*Do while loop until menu closed by user*/
		
		do {
			System.out.println("Press enter to continue to main menu..."); /*User must press enter to continue, output gets cluttered without a divider*/
			UserInput.divider();
			printMainMenu(); /*Print the menu*/
			int response = UserInput.enterNumber("Enter a number for a corresponding menu option", 0, 9); /*Get menu selection from user, run it through switch board*/
			switch(response) {
				case 1:
					createCheckingAccount();
					break;
				case 2:
					createGoldAccount();
					break;
				case 3:
					createRegularAccount();
					break;
				case 4:
					depositFunds();
					break;
				case 5:
					withdrawFunds();
					break;
				case 6:
					displayAccountInfo();
					break;
				case 7:
					removeAccount();
					break;
				case 8:
					applyEndOfMonth();
					break;
				case 9:
					displayBankStats();
					break;
				case 0:
					System.out.println("Closing menu...");
					menuLoop = false;
					break;
				default:
					System.out.println("Invalid entry");
					break;
			}
		}while(menuLoop);
		
		System.out.println("Menu closed");
	}
	/*End Main Menu*/
	
	
	
	/*Prints main menu options for user*/
	private static void printMainMenu() {
		String menu = "\t\tMain Menu\n1: Create a Checking account\n2: Create a Gold account\n3: Create a Regular account\n4: Enter a deposit\n"
				+ "5: Make a withdraw\n6: Display Account Information\n7: Remove an account\n8: Apply end of the month account upates\n"
				+ "9: Display bank statistics\n0: Exit";
		
		System.out.println(menu);
	}

	
	/* Menu Option 1
	 * Creates a Checking Account
	 */
	private void createCheckingAccount() {
		String customerName = UserInput.enterName("Enter customer's name");
		int customerID = UserInput.enterNumber("Enter customer ID", 1, 9999999);
		double initialDepositAsDouble = (double)UserInput.enterNumber("Enter initial deposit value", 0, 9999999);
		BigDecimal initialDeposit = new BigDecimal(initialDepositAsDouble);
		
		if(bankLedger.addCheckingAccount(initialDeposit, customerID, customerName)) {
			System.out.println("Account created");
		}else {
			System.out.println("Error, account not created");
		}
		System.out.println();
		UserInput.divider();
	}
	
	
	/* Menu Option 2
	 * Creates Gold Account
	 */
	private void createGoldAccount() {
		String customerName = UserInput.enterName("Enter customer's name");
		int customerID = UserInput.enterNumber("Enter customer ID", 1, 9999999);
		double initialDepositAsDouble = (double)UserInput.enterNumber("Enter initial deposit value", 0, 9999999);
		BigDecimal initialDeposit = new BigDecimal(initialDepositAsDouble);
		
		if(bankLedger.addGoldAccount(initialDeposit, customerID, customerName)) {
			System.out.println("Account created");
		}else {
			System.out.println("Error, account not created");
		}
		System.out.println();
		UserInput.divider();
	}

	
	/* Menu Option 3
	 * Creates Regular Account
	 */
	private void createRegularAccount() {
		String customerName = UserInput.enterName("Enter customer's name");
		int customerID = UserInput.enterNumber("Enter customer ID", 1, 9999999);
		double initialDepositAsDouble = (double)UserInput.enterNumber("Enter initial deposit value", 0, 9999999);
		BigDecimal initialDeposit = new BigDecimal(initialDepositAsDouble);
		
		if(bankLedger.addRegularAccount(initialDeposit, customerID, customerName)) {
			System.out.println("Account created");
		}else {
			System.out.println("Error, account not created");
		}
		System.out.println();
		UserInput.divider();
	}
	
	
	/* Menu Option 4
	 * Deposit funds if possible
	 */
	private void depositFunds() {
		
		/*find an account to deposit to*/
		Account thisAccount = searchForAnAccount();
		if(thisAccount == null) {
			System.out.println("Deposit cancelled");
			return;
		}
		
		/*Choose deposit amount*/
		double depositAmountAsDouble = (double)UserInput.enterNumber("Enter a deposit amount", 1, 999999);
		BigDecimal depositAmount = new BigDecimal(depositAmountAsDouble);
		
		/*deposit cash*/
		if(bankLedger.depositFunds(thisAccount.getAccountNumber(), depositAmount)) {
			System.out.println("Deposit complete");
		}else {
			System.out.println("Deposit failed");
		}
		System.out.println();
		UserInput.divider();
	}
	
	
	/* Menu Option 5
	 * Withdraw funds if possible
	 */
	private void withdrawFunds() {
		
		/*find an account*/
		Account thisAccount = searchForAnAccount();
		if(thisAccount == null) {
			System.out.println("Deposit cancelled");
			return;
		}
		
		/*Choose withdraw amount*/
		double withdrawAmountAsDouble = (double)UserInput.enterNumber("Enter a withdraw amount", 1, 999999);
		BigDecimal withdrawAmount = new BigDecimal(withdrawAmountAsDouble);
		
		/*withdraw cash*/
		if(bankLedger.withdrawFunds(thisAccount.getAccountNumber(), withdrawAmount)) {
			System.out.println("withdraw complete");
		}else {
			System.out.println("withdraw failed");
		}
		System.out.println();
		UserInput.divider();
	}
	
	
	/* Menu Option 6
	 * Display Account information
	 */
	private void displayAccountInfo() {
		Account thisAccount = searchForAnAccount();
		System.out.println(thisAccount);
	}
	
	
	/* Menu Option 7
	 * Remove an account if it exists
	 */
	private void removeAccount() {
		/*Find account*/
		Account thisAccount = searchForAnAccount();
		
		/*Remove account*/
		if(bankLedger.removeAccount(thisAccount.getAccountNumber())) {
			System.out.println("Account removed");
			System.out.println();
			UserInput.divider();
			return;
			
		}else {
			System.out.println("Removal failed");
		}
		System.out.println("Removal failed");
		System.out.println();
		UserInput.divider();
	}
	
	
	/* Menu Option 8
	 * Run end of the month adjustments to all accounts
	 */
	private void applyEndOfMonth() {
		/*Double check if user is certain they want to apply changes*/
		UserInput.divider();
		
		/*Apply monthly adjustment*/
		if(UserInput.yesOrNoQuestion("Are you sure you want to apply end of month updates? Action cannot be reversed.")) {
			bankLedger.monthReset();
			System.out.println("End of month account updates applied");
		}else {
			System.out.println("End of month updates cancelled");
		}
		System.out.println();
		UserInput.divider();
	}
	
	
	/* Menu Option 9
	 * Display bank statistics if any are available to list
	 */
	private void displayBankStats() {
		String stats = "\t\tBank Statistics:\n";
		if(bankLedger.getNumberOfAccounts() < 1) {
			stats += "Bank has no accounts";
		}else {
			stats += "Sum of all accounts: " + bankLedger.sumOfAccounts() + "\tTotal Accounts: " + bankLedger.getNumberOfAccounts() + "\n";
			stats += "Number of zero balance accounts: " + bankLedger.getAccountsWith0Balance().size() + "\tAverage Balance: " + bankLedger.getAverageValue() + "\n";
			stats += "\t\tAccount with largest balance: \n" + bankLedger.getLargestValue();
		}
		
		System.out.println(stats);
		System.out.println();
		UserInput.divider();
	}
	
	
	/*private method used to search for an account*/
	private Account searchForAnAccount(){
		
		/*Search menu is a do while loop that continues until account is selected or user quits search*/
		boolean searchLoop = true;
		Account thisAccount = null;
		do {
			System.out.println("\t\tSearch Options:");
			int select = UserInput.enterNumber("1: Search by account number\n2: Search by customer name\n3: Search by customer ID\n0: Exit Search", 0, 3);
			
			switch (select){
				
				/*Search by account number*/
				case 1:
					int accountNumber = UserInput.enterNumber("Enter account number", 1, 999999);
					UserInput.divider();
					thisAccount = bankLedger.searchByAccountNumber(accountNumber);
					
					if(thisAccount != null) {
						System.out.println(thisAccount.toString());
						
						if(UserInput.yesOrNoQuestion("Do you want to use this account?")) {
							searchLoop = false;
						}
					}else {
						System.out.println("Account not found");
					}
					break;
				
				/*Search by customer name*/
				case 2:
					String name = UserInput.enterName("Enter customer name");
					UserInput.divider();
					ArrayList<Account> searchResult = bankLedger.searchAccountsByCustomerName(name);
					
					if(searchResult.size() > 0) {
						thisAccount = selectAccountFromList(searchResult);
						
						if(thisAccount != null) {				
							System.out.println(thisAccount.toString());
							
							if(UserInput.yesOrNoQuestion("Do you want to use this account?")) {
								searchLoop = false;
							}
						}else {
							System.out.println("Account not found");
						}
					}
					break;
				
				/*Search by customer ID*/
				case 3:
					int customerID = UserInput.enterNumber("Enter customer ID", 1, 9999999);
					UserInput.divider();
					ArrayList<Account> searchResult2 = bankLedger.searchAccountsByCustomerID(customerID);
					
					if(searchResult2.size() > 0) {
						thisAccount = selectAccountFromList(searchResult2);
						
						if(thisAccount != null) {
							System.out.println(thisAccount.toString());
							
							if(UserInput.yesOrNoQuestion("Do you want to use this account?")) {
								searchLoop = false;
							}
						}else {
							System.out.println("Account not found");
						}
					}
					break;
				
				/*Quit search*/
				case 0:
					System.out.println("Search cancelled");
					return null; /*If search is cancelled, return null since no account was found*/
				
				default:
					break;
			}
		}while(searchLoop);
		
		return thisAccount; /*Finally, return the account that was found*/
	}
	
	
	/*private method used to select from one account from a ArrayList of search results*/
	private Account selectAccountFromList(ArrayList<Account> Accounts) {
		
		/*If only 1 account in ArrayList, return that account*/
		if(Accounts.size() == 1) {
			return Accounts.get(0);
		}
		
		/*Print list of accounts and a corresponding integer (account's index + 1)*/
		for(int i = 0 ; i < Accounts.size(); i++) {
			System.out.println("Account"  + (i + 1) + ":");
			System.out.println(Accounts.get(i));
		}
		
		/*User selects an account*/
		int selection = UserInput.enterNumber("Enter the number that corresponds with the account you want to use (or press 0 to quit)", 1, Accounts.size());
		UserInput.divider();
		if(selection > 0) {
			return Accounts.get(selection-1); /*Return the user selection*/
		}else {
			return null; /*If user selection is cancelled, return null*/
		}
	}
}
