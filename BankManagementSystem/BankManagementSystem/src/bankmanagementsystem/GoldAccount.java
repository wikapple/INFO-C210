package bankmanagementsystem;

import java.math.BigDecimal;


/* GoldAccount Class
 * Extends Account, applies Gold Account specifications 
 * 
 * Author: William Applegate
 * Class: INFO-C210
 * 
 */
class GoldAccount extends Account{
	
	
	/*Data Fields*/
	private double interestRate;
	
	
	/*Constructor*/
	public GoldAccount(int accountNumber, BigDecimal initialDeposit, int customerID, String customerName) {
		super(accountNumber, initialDeposit, customerID, customerName);
		this.interestRate = 0.05;
	}

	
	/*Getter*/
	public double getInterestRate() {
		return this.interestRate;
	}

	
	/* Apply end of month adjustments
	 * Adds monthly interest to gold account balance
	 */
	@Override
	public void monthReset() {
		double monthlyInterest = this.interestRate / 12;
		BigDecimal earnedInterest = this.getBalance().multiply(new BigDecimal(monthlyInterest));
		this.depositFunds(earnedInterest);
	}

	
	/*toString method*/
	@Override
	public String toString() {
		String value = "\t\tGold Account\nInterest Rate: " + this.interestRate + "\n";
		value += super.toString();
		return value;
	}
}
