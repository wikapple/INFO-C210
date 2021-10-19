
import java.util.Date;
/* Assignment Three, Problem 1
 * The Account Class
 * Creates Account object 
 * Author: William Applegate
 * INFO-C210
 */
public class Account {
	//Data Fields
	private int id;
	private double balance;
	//interest is static - Assume all accounts have same rate.
	private static double annualInterestRate = 0.0;
	private Date dateCreated;
	
	//Constructors
	Account(){
		this(0, 0.0);
	}
	Account(int idInput, double balanceInput){
		this.id = idInput;
		this.balance = balanceInput;
		this.dateCreated = java.util.Calendar.getInstance().getTime();
	}
	//End constructors
	
	//getters
	public int getID() {
		return this.id;
	}
	public double getBalance() {
		return this.balance;
	}
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	//setters
	public void setID(int newID) {
		this.id = newID;
	}
	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}
	public static void setAnnualInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}
	
	//getMonthlyInterestRate method
	public static double getMonthlyInterestRate() {
		double monthlyInterestRate = annualInterestRate/12;
		return monthlyInterestRate;
	}
	
	/* getMonthlyInterest method
	 * Uses getMonthlyInterestRate() and this.balance to
	 * calculate and return interest amount. 
	 */
	public double getMonthlyInterest() {
		double monthlyInterestPercent = getMonthlyInterestRate() / 100;
		double monthlyInterest = this.balance * monthlyInterestPercent;
		return monthlyInterest;
	}
	
	/*withdraw method decreases balance if applicable
	 *returns boolean value if withdraw successful or not
	 */
	public boolean withdraw(double withdrawAmount){
		if(withdrawAmount <= 0) {
			System.out.println("Invalid withdraw amount entered");
			return false;
		}
		
		if(withdrawAmount <= this.balance) {
			balance -= withdrawAmount;
			return true;
		}else {
			System.out.println("Insufficient funds");
			return false;
		}
	}
	
	/*deposit method increases this.balance if applicable
	//returns boolean value if deposit successful or not.
	*/
	public boolean deposit(double depositAmount) {
		if(depositAmount <= 0) {
			System.out.println("Invalid deposit amount entered");
			return false;
		}else {
			this.balance += depositAmount;
			return true;
		}
	}
	
	
	
	
	
	
}
