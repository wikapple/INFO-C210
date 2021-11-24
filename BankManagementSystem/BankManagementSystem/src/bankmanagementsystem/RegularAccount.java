package bankmanagementsystem;

import java.math.BigDecimal;


/* RegularAccount Class
 * Extends Account, applies Regular Account specifications
 * 
 * Author: William Applegate
 * Class: INFO-C210
 */
class RegularAccount extends Account{
	
	
	/*data fields*/
	private double interestRate;
	private BigDecimal monthlyFee;
	
	
	/*constructor*/
	RegularAccount(int accountNumber, BigDecimal initialDeposit, int customerID, String customerName){
		super(accountNumber, initialDeposit, customerID, customerName);
		this.interestRate = 0.06;
		this.monthlyFee = new BigDecimal("10.00");
	}
	
	
	/*Getters*/
	public double getInterestRate() {
		return this.interestRate;
	}
	public BigDecimal getMonthlyFee() {
		return this.monthlyFee;
	}
	
	
	/* Apply end of month adjustments
	 * Add monthly interest and withdraw monthly fee
	 */
	@Override
	public void monthReset() {
		double monthlyInterestRate = this.interestRate / 12;
		BigDecimal interestEarned = this.getBalance().multiply(BigDecimal.valueOf(monthlyInterestRate));
		this.depositFunds(interestEarned);
		
		if(!(this.withdrawFunds(monthlyFee))){
			this.setBalance(0);
		}
	}
	
	
	/*toString method*/
	@Override
	public String toString() {
		String value = "\t\tRegular Account\nInterest Rate: " + this.interestRate + "\tMonthly Fee: " + this.monthlyFee + "\n";
		value += super.toString();
		return value;
	}
}
