package bankmanagementsystem;

class CheckingAccount extends Account {
	//data Fields
	private int totalMonthlyTransactions;
	private double transactionFee;

	//Constructor
	CheckingAccount(int accountNumber, double initialDeposit, int customerID, String customerName){
		super(accountNumber, initialDeposit, customerID, customerName);
		this.transactionFee = 3;
		this.totalMonthlyTransactions = 0;
	}
	
	//Accessor
	public int getMonthlyTransactionTotal() {
		return this.totalMonthlyTransactions;
	}
	
	public double getTransactionFee() {
		return this.transactionFee;
	}
	
	public boolean depositFunds(double depositAmount){
		if(totalMonthlyTransactions <3) {
			if(super.depositFunds(depositAmount)){
				this.totalMonthlyTransactions++;
				return true;
			}
		}else if(totalMonthlyTransactions >2) {
			if(super.depositFunds(depositAmount -3)) {
				this.totalMonthlyTransactions++;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean withdrawFunds(double withdrawAmount) {
		if(totalMonthlyTransactions <3) {
			if(super.withdrawFunds(withdrawAmount)){
				this.totalMonthlyTransactions++;
				return true;
			}
		}else if(totalMonthlyTransactions >2) {
			if(super.withdrawFunds(withdrawAmount +3)) {
				this.totalMonthlyTransactions++;
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void monthReset() {
		this.totalMonthlyTransactions = 0;
	}
	
	@Override
	public String toString() {
		String value = "\t\tChecking Account\nFee per transaction: " + this.transactionFee;
		value += "\tTotal Monthly Transactions: " + this.totalMonthlyTransactions + "\n";
		value += super.toString();
		return value;
	}
	
}