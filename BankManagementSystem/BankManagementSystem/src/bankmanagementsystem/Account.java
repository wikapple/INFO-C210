package bankmanagementsystem;

abstract class Account {
	//Data Fields
	private int accountNumber;
	private double balance;
	private int customerID;
	private String customerName;
	
	//Constructors
	Account(int accountNumber, double initialDeposit, int customerID, String customerName){
		this.accountNumber = accountNumber;
		this.balance = initialDeposit;
		this.customerID = customerID;
		this.customerName = customerName;
	}
	//Accessors
	public int getAccountNumber(){
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	public int getCustomerID() {
		return this.customerID;
	}
	public String getCustomerName() {
		return this.customerName;
	}
	
	//setters
	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}
	
	public void setCustomerID(int newCustomerID) {
		this.customerID = newCustomerID;
	}
	public void setCustomerName(String newName) {
		this.customerName = newName;
	}
	
	public boolean depositFunds(double depositAmount) {
		if(depositAmount > 0) {
		this.balance += depositAmount;
		return true;
		}else {
			return false;
		}
	}
	
	public boolean withdrawFunds(double withdrawAmount) {
		if(withdrawAmount <= 0) {
			return false;
		}else if(withdrawAmount > this.balance) {
			return false;
		}else {
			this.balance -= withdrawAmount;
			return true;
		}
	}
	
	public void monthReset() {
		
	}
	
	@Override
	public String toString() {
		String value = "Account Number: " + this.accountNumber + "\tAccount Balance: " + this.balance;
		value += "\nCustomer ID: " + this.customerID + "\tCustomer Name: " + this.customerName + "\n";
		return value;
	}
	
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
