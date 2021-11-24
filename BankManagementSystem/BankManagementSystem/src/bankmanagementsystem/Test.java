package bankmanagementsystem;


/* Test Class
 * Instantiates a new AccountLedger Class
 * Instantiates a new BankOperator Class with the AccountLedger as a parameter   
 * Calls on the bank operators menu
 * 
 * Author: William Applegate
 * Class: INFO-C210
 */
public class Test {

	public static void main(String[] args) {
		AccountLedger myBank = new AccountLedger();
		BankOperator newTeller = new BankOperator(myBank);
		newTeller.runMenu();
	}

}
