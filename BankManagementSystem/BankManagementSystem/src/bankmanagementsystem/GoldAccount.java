package bankmanagementsystem;

import java.math.BigDecimal;

class GoldAccount extends Account{
	//Data Fields
	private double interestRate;
	
	public GoldAccount(int accountNumber, BigDecimal initialDeposit, int customerID, String customerName) {
		super(accountNumber, initialDeposit, customerID, customerName);
		this.interestRate = 0.05;
	}
	
	//Accessor
	public double getInterestRate() {
		return this.interestRate;
	}
	
	@Override
	public void monthReset() {
		double monthlyInterest = this.interestRate / 12;
		BigDecimal earnedInterest = this.getBalance().multiply(new BigDecimal(monthlyInterest));
		this.depositFunds(earnedInterest);
	}

	@Override
	public String toString() {
		String value = "\t\tGold Account\nInterest Rate: " + this.interestRate + "\n";
		value += super.toString();
		return value;
	}
}
