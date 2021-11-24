package bankmanagementsystem;
import java.math.BigDecimal;
import java.util.ArrayList;

/*
 * AccountLedger Class
 * Responsible for holding ArrayList of all accounts and manipulating the data
 * BankOperator Class calls on this class, this class calls on Accounts if applicable
 * 
 * Author: William Applegate
 * Class: INFO-C210
 */

class AccountLedger {
	
	/*Data Fields*/
	private String ledgerName;
	private ArrayList<Account> accounts;
	private int numberOfCreatedAccounts;
	
	/*Constructors*/
	AccountLedger(){
		this("My Ledger");
	}
	
	AccountLedger(String nameOfLedger){
		accounts = new ArrayList<>();
		this.ledgerName = nameOfLedger;
		this.numberOfCreatedAccounts = 0;
	}
	
	
	/*Getters*/
	public String getLedgerName() {
		return this.ledgerName;
	}
	public int getNumberOfAccountsCreated() {
		return this.numberOfCreatedAccounts;
	}
	
	
	/* Add Checking Account
	 * Return true if successful, false if failed
	 */
	public boolean addCheckingAccount(BigDecimal initialDeposit, int customerID, String customerName){
		int accountNumber = this.numberOfCreatedAccounts +1;		
		CheckingAccount newCheckingAccount = new CheckingAccount(accountNumber, initialDeposit, customerID, customerName);
		accounts.add(newCheckingAccount);
		this.numberOfCreatedAccounts++;
		return true;
	}
	
	
	/* Add Gold Account 
	 * Return true if successful, false if failed
	 */
	public boolean addGoldAccount(BigDecimal initialDeposit, int customerID, String customerName) {
		int accountNumber = this.numberOfCreatedAccounts +1;		
		GoldAccount newGoldAccount = new GoldAccount(accountNumber, initialDeposit, customerID, customerName);
		accounts.add(newGoldAccount);
		this.numberOfCreatedAccounts++;
		return true;
	}
	
	
	/* Add regular Account
	 * Return true if successful, false if failed
	 */
	public boolean addRegularAccount(BigDecimal initialDeposit, int customerID, String customerName) {
		int accountNumber = this.numberOfCreatedAccounts +1;		
		RegularAccount newRegularAccount = new RegularAccount(accountNumber, initialDeposit, customerID, customerName);
		accounts.add(newRegularAccount);
		this.numberOfCreatedAccounts++;
		return true;
	}
	
	
	/* Deposit funds
	 * Return true if successful, false if failed
	 */
	public boolean depositFunds(int accountNumber, BigDecimal depositAmount) {
		int index = this.getIndexOfAccount(accountNumber);
		if(index != -1) {
			if(accounts.get(index).depositFunds(depositAmount)) {
				return true;
			}
		}
		return false;
	}
	
	
	/* Withdraw funds
	 * Return true if successful, false if failed
	 */
	public boolean withdrawFunds(int accountNumber, BigDecimal withdrawAmount) {
		int index = this.getIndexOfAccount(accountNumber);
		if(index != -1) {
			if(accounts.get(index).withdrawFunds(withdrawAmount)) {
				return true;
			}
		}
		return false;
	}
	
	
	/* Get account information
	 * Take account number to find and print information on account
	 */
	public String getAccountInfo(int accountNumber) {
		int index = this.getIndexOfAccount(accountNumber);
		if(index != -1) {
			return accounts.get(index).toString();
		}else
			return "Account not found";
	}
	
	
	/* Remove Account
	 * Take account number and delete that account
	 */
	public boolean removeAccount(int accountNumber) {
		int index = this.getIndexOfAccount(accountNumber);
		if(index != -1) {
			accounts.remove(index);
			return true;
		}else {
		return false;
		}
	}
	
	
	/* Apply end of month adjustments
	 * Enhanced for loop calls on each Accounts end of month adjustment method
	 */
	public void monthReset() {
		for(Account thisAccount: accounts) {
			thisAccount.monthReset();
		}
	}
	
	
	/*	Methods for bank statistics:	*/
	
	
	/* Get sum of all account balances
	 */
	public BigDecimal sumOfAccounts() {
		BigDecimal sum = new BigDecimal(0);
		for (Account thisAccount : accounts) {
			sum.add(thisAccount.getBalance());
		}
		return sum;
	}
	
	
	/* Get number of Accounts contained in Accounts 
	 */
	public int getNumberOfAccounts() {
		return accounts.size();
	}
	
	
	/* Get average balance value of accounts 
	 */
	public BigDecimal getAverageValue() {
		return this.sumOfAccounts().divide(new BigDecimal(this.getNumberOfAccounts()));
	}
	
	
	/* Get the largest Account balance from accounts
	 */
	public Account getLargestValue() {	
		Account largestAccount;
		
		if(accounts.size() > 0) {
			largestAccount = accounts.get(0);
			
			for(int i = 1; i < accounts.size(); i ++) {
				
				if(largestAccount.getBalance().compareTo(accounts.get(i).getBalance()) < 1){
					largestAccount = accounts.get(i);
				}
			}
			return largestAccount;
			
		}else {
			return null;
		}
	}
	
	
	/* Get an ArrayList of accounts with 0 balance
	 */
	public ArrayList<Account> getAccountsWith0Balance(){
		ArrayList<Account> zeroBalanceAccounts = new ArrayList<>();
		
		for (Account thisAccount : accounts) {
			
			if(thisAccount.getBalance().compareTo(new BigDecimal(0)) < 1) {
				zeroBalanceAccounts.add(thisAccount);
			}
		}
		return zeroBalanceAccounts;
	}
	
	
	
	
	/*Searching methods*/
	
	
	/*  Takes an account number and returns index of corresponding account
	 */
	private int getIndexOfAccount(int accountNumber) {
		int index = -1;
		
		for(int i = 0 ; i < accounts.size() ; i++) {
			
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				index = i;
			}
		}
		return index;
	}
	
	
	/* Takes an account number and gets corresponding Account
	 */
	public Account searchByAccountNumber(int accountNumber) {
		int index = -1;
		
		for(int i = 0 ; i < accounts.size() ; i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				index = i;
			}
		}
		if(index >-1) {
			return this.accounts.get(index);
		}else {
			return null;
		}
	}
	
	
	/* Takes customer name and returns list of corresponding accounts 
	 */
	public ArrayList<Account> searchAccountsByCustomerName(String customerName) {
		ArrayList<Account> results = new ArrayList<>();
		
		for (Account thisAccount : accounts) {
			if(thisAccount.getCustomerName().equals(customerName)) {
				results.add(thisAccount);
			}
		}
		return results;
	}
	
	/* Takes customerID and returns a list of corresponding accounts
	 */
	public ArrayList<Account> searchAccountsByCustomerID(int customerID) {
		ArrayList<Account> queryList = new ArrayList<>();
		
		for (Account thisAccount : accounts) {
			if(thisAccount.getCustomerID() == customerID) {
				queryList.add(thisAccount);
			}
		}
		return queryList;
	}
	
	
	/*Account Ledger toString method*/
	@Override
	public String toString() {
		String value = "Bank Ledger Name: " + this.ledgerName + "\tTotal Accounts Created: " + this.numberOfCreatedAccounts + "\n";
		value += accounts.toString();
		return value;
	}
}
