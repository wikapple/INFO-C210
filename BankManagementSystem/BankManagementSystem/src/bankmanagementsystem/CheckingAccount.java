package bankmanagementsystem;

import java.math.BigDecimal;


/* CheckingAccount Class
 * Extends Account, applies checking account specifications
 * 
 * Author: William Applegate
 * Class: INFO-C210
 */
class CheckingAccount extends Account {
	
	
	/*Data Fields*/
	private int totalMonthlyTransactions;
	private double transactionFee;

	
	/*Constructor*/
	CheckingAccount(int accountNumber, BigDecimal initialDeposit, int customerID, String customerName){
		super(accountNumber, initialDeposit, customerID, customerName);
		this.transactionFee = 3;
		this.totalMonthlyTransactions = 0;
	}

	
	/*Getters*/
	public int getMonthlyTransactionTotal() {
		return this.totalMonthlyTransactions;
	}
	
	public double getTransactionFee() {
		return this.transactionFee;
	}
	
	
	/* Deposit method
	 * Applies transaction fee specification to parent method
	 */
	@Override
	public boolean depositFunds(BigDecimal depositAmount){
		if(totalMonthlyTransactions <3) {
			if(super.depositFunds(depositAmount)){
				this.totalMonthlyTransactions++;
				return true;
			}
		}else if(totalMonthlyTransactions >2) {
			if(super.depositFunds(depositAmount.subtract(new BigDecimal("3.00")))){
				this.totalMonthlyTransactions++;
				return true;
			}
		}
		return false;	
	}
	
	
	/* Withdraw method
	 * Applies transaction fee specification to parent method
	 */
	@Override
	public boolean withdrawFunds(BigDecimal withdrawAmount) {
		if(totalMonthlyTransactions <3) {
			if(super.withdrawFunds(withdrawAmount)){
				this.totalMonthlyTransactions++;
				return true;
			}
		}else if(totalMonthlyTransactions >2) {
			if(super.withdrawFunds(withdrawAmount.add(new BigDecimal(3.00)))) {
				this.totalMonthlyTransactions++;
				return true;
			}
		}
		
		return false;
	}
	
	
	/* Apply monthly adjustments
	 * Overrides parent method to reset monthly transactions to 0
	 */
	@Override
	public void monthReset() {
		this.totalMonthlyTransactions = 0;
	}
	
	
	/*toString method*/
	@Override
	public String toString() {
		String value = "\t\tChecking Account\nFee per transaction: " + this.transactionFee;
		value += "\tTotal Monthly Transactions: " + this.totalMonthlyTransactions + "\n";
		value += super.toString();
		return value;
	}
	
}
