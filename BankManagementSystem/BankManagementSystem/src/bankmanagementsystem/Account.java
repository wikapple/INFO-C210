package bankmanagementsystem;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* Account Class
 * Abstract class with common account methods and data fields
 * 
 * Author: William Applegate
 * Class: INFO-C210
 */
abstract class Account {
	
	/*Data Fields*/
	private int accountNumber;
	private BigDecimal balance;
	private int customerID;
	private String customerName;
	
	
	/*Constructors*/
	Account(int accountNumber, BigDecimal initialDeposit, int customerID, String customerName){
		this.accountNumber = accountNumber;
		this.balance = new BigDecimal(initialDeposit.toString());
		this.customerID = customerID;
		this.customerName = customerName;
	}
	
	
	/*Getters*/
	public int getAccountNumber(){
		return this.accountNumber;
	}
	
	public BigDecimal getBalance() {
		return this.balance.setScale(2, RoundingMode.HALF_UP);
	}
	public int getCustomerID() {
		return this.customerID;
	}
	public String getCustomerName() {
		return this.customerName;
	}
	
	
	/*setters*/
	public void setBalance(BigDecimal newBalance) {
		this.balance = new BigDecimal(newBalance.toString());
	}
	
	public void setBalance(int newBalance) {
		this.balance = new BigDecimal(newBalance);
	}
	
	public void setBalance(double newBalance) {
		this.balance = new BigDecimal(newBalance);
	}
	
	public void setCustomerID(int newCustomerID) {
		this.customerID = newCustomerID;
	}
	public void setCustomerName(String newName) {
		this.customerName = newName;
	}
	
	
	/* Deposit method
	 * Returns true if successful, false if failed
	 */
	public boolean depositFunds(BigDecimal depositAmount) {
		if(depositAmount.compareTo(new BigDecimal(0)) > 0) {
		this.balance = this.balance.add(depositAmount);
		return true;
		}else {
			return false;
		}
	}
	
	
	/* Withdraw method
	 * Returns true if successful, false if failed
	 */
	public boolean withdrawFunds(BigDecimal withdrawAmount) {
		
		/*if able to complete withdraw*/
		if(withdrawAmount.compareTo(this.balance) <= 0) {
			this.balance = this.balance.subtract(withdrawAmount);
			return true;
		
		/*If able to partially complete withdraw less than amount requested*/
		}else if(this.balance.compareTo(new BigDecimal("0")) > 0){
			System.out.println("Withdraw amount greater than balance");
			System.out.println("Withdrawing balance of $" + this.balance.setScale(2, RoundingMode.HALF_UP));
			this.setBalance(new BigDecimal("0.00"));
			return true;
		
		/*If no withdraw is possible*/
		}else {
			return false;
		}
	}
	
	
	/*Month Reset method*/
	public void monthReset() {
		
	}
	
	
	/*toString method*/
	@Override
	public String toString() {
		String value = "Account Number: " + this.accountNumber + "\tAccount Balance: " + this.balance.setScale(2, RoundingMode.HALF_UP);
		value += "\nCustomer ID: " + this.customerID + "\tCustomer Name: " + this.customerName + "\n";
		return value;
	}
	
	
	/*equals method*/
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Account)) {
			return false;
		}
		if(this.accountNumber == ((Account)obj).getAccountNumber()) {
			return true;
			
		}else {
			return false;
		}
	}

}
