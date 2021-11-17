package bankmanagementsystem;
import java.math.BigDecimal;
import java.util.ArrayList;

class AccountLedger {
	private String ledgerName;
	private ArrayList<Account> Accounts;
	private int numberOfCreatedAccounts;
	
	AccountLedger(){
		this("My Ledger");
	}
	
	AccountLedger(String nameOfLedger){
		Accounts = new ArrayList<>();
		this.ledgerName = nameOfLedger;
		this.numberOfCreatedAccounts = 0;
	}
	
	public String getLedgerName() {
		return this.ledgerName;
	}
	public int getNumberOfAccountsCreated() {
		return this.numberOfCreatedAccounts;
	}
	
	public boolean addCheckingAccount(BigDecimal initialDeposit, int customerID, String customerName){
		int accountNumber = this.numberOfCreatedAccounts +1;		
		CheckingAccount newCheckingAccount = new CheckingAccount(accountNumber, initialDeposit, customerID, customerName);
		Accounts.add(newCheckingAccount);
		this.numberOfCreatedAccounts++;
		return true;
	}
	
	public boolean addGoldAccount(BigDecimal initialDeposit, int customerID, String customerName) {
		int accountNumber = this.numberOfCreatedAccounts +1;		
		GoldAccount newGoldAccount = new GoldAccount(accountNumber, initialDeposit, customerID, customerName);
		Accounts.add(newGoldAccount);
		this.numberOfCreatedAccounts++;
		return true;
	}
	public boolean addRegularAccount(BigDecimal initialDeposit, int customerID, String customerName) {
		int accountNumber = this.numberOfCreatedAccounts +1;		
		RegularAccount newRegularAccount = new RegularAccount(accountNumber, initialDeposit, customerID, customerName);
		Accounts.add(newRegularAccount);
		this.numberOfCreatedAccounts++;
		return true;
	}
	
	public boolean depositFunds(int accountNumber, BigDecimal depositAmount) {
		int index = this.getIndexOfAccount(accountNumber);
		if(index != -1) {
			if(Accounts.get(index).depositFunds(depositAmount)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean withdrawFunds(int accountNumber, BigDecimal withdrawAmount) {
		int index = this.getIndexOfAccount(accountNumber);
		if(index != -1) {
			if(Accounts.get(index).withdrawFunds(withdrawAmount)) {
				return true;
			}
		}
		return false;
	}
	
	public String getAccountInfo(int accountNumber) {
		int index = this.getIndexOfAccount(accountNumber);
		if(index != -1) {
			return Accounts.get(index).toString();
		}else
			return "Account not found";
	}
	
	public boolean removeAccount(int accountNumber) {
		int index = this.getIndexOfAccount(accountNumber);
		if(index != -1) {
			Accounts.remove(index);
			return true;
		}else {
		return false;
		}
	}
	
	public void monthReset() {
		for(Account thisAccount: Accounts) {
			thisAccount.monthReset();
		}
	}
	
	public BigDecimal sumOfAccounts() {
		BigDecimal sum = new BigDecimal(0);
		for (Account thisAccount : Accounts) {
			sum.add(thisAccount.getBalance());
		}
		return sum;
	}
	
	public int getNumberOfAccounts() {
		return Accounts.size();
	}
	
	public BigDecimal getAverageValue() {
		return this.sumOfAccounts().divide(new BigDecimal(this.getNumberOfAccounts()));
	}
	
	public Account getLargestValue() {	
		Account largestAccount;
		
		if(Accounts.size() > 0) {
			largestAccount = Accounts.get(0);
			
			for(int i = 1; i < Accounts.size(); i ++) {
				
				if(largestAccount.getBalance().compareTo(Accounts.get(i).getBalance()) < 1){
					largestAccount = Accounts.get(i);
				}
			}
			return largestAccount;
			
		}else {
			return null;
		}
	}
	
	
	public ArrayList<Account> getAccountsWith0Balance(){
		ArrayList<Account> zeroBalanceAccounts = new ArrayList<>();
		
		for (Account thisAccount : Accounts) {
			
			if(thisAccount.getBalance().compareTo(new BigDecimal(0)) < 1) {
				zeroBalanceAccounts.add(thisAccount);
			}
		}
		
		return zeroBalanceAccounts;
	}
	
	
	
	
	//Searching methods
	
	private int getIndexOfAccount(int accountNumber) {
		int index = -1;
		
		for(int i = 0 ; i < Accounts.size() ; i++) {
			
			if (Accounts.get(i).getAccountNumber() == accountNumber) {
				index = i;
			}
		}
		return index;
	}
	
	public Account searchByAccountNumber(int accountNumber) {
		int index = -1;
		
		for(int i = 0 ; i < Accounts.size() ; i++) {
			if (Accounts.get(i).getAccountNumber() == accountNumber) {
				index = i;
			}
		}
		if(index >-1) {
			return this.Accounts.get(index);
		}else {
			return null;
		}
	}
	
	public ArrayList<Account> searchAccountsByCustomerName(String customerName) {
		ArrayList<Account> results = new ArrayList<>();
		
		for (Account thisAccount : Accounts) {
			if(thisAccount.getCustomerName().equals(customerName)) {
				results.add(thisAccount);
			}
		}
		return results;
	}
	
	public ArrayList<Account> searchAccountsByCustomerID(int customerID) {
		ArrayList<Account> queryList = new ArrayList<>();
		
		for (Account thisAccount : Accounts) {
			if(thisAccount.getCustomerID() == customerID) {
				queryList.add(thisAccount);
			}
		}
		
		return queryList;
	}
	
	@Override
	public String toString() {
		String value = "Bank Ledger Name: " + this.ledgerName + "\tTotal Accounts Created: " + this.numberOfCreatedAccounts + "\n";
		value += Accounts.toString();
		return value;
	}
}
