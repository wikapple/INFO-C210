package bankmanagementsystem;

class RegularAccount extends Account{
	//data fields
	private double interestRate;
	private double monthlyFee;
	
	//constructor
	RegularAccount(int accountNumber, double initialDeposit, int customerID, String customerName){
		super(accountNumber, initialDeposit, customerID, customerName);
		this.interestRate = 0.06;
		this.monthlyFee = 10;
	}
	
	//Accessor
	public double getInterestRate() {
		return this.interestRate;
	}
	public double getMonthlyFee() {
		return this.monthlyFee;
	}
	
	@Override
	public void monthReset() {
		double monthlyInterestRate = this.interestRate / 12;
		double interestEarned = this.getBalance() * monthlyInterestRate;
		this.depositFunds(interestEarned);
		
		if(!(this.withdrawFunds(this.monthlyFee))){
			this.setBalance(0.0);
		}
	}
	@Override
	public String toString() {
		String value = "\t\tRegular Account\nInterest Rate: " + this.interestRate + "\tMonthly Fee: " + this.monthlyFee + "\n";
		value += super.toString();
		return value;
	}
}