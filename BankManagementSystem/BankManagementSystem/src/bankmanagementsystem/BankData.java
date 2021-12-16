package bankmanagementsystem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BankData {
	private BigDecimal sumOfAllAccounts;
	private int numberOfAccounts;
	private  BigDecimal averageValue;
	private Account largestValueAccount;
	private ArrayList<Account> accountsWith0Balance;
	
		BankData(BigDecimal sumOfAllAccounts, int numberOfAccounts, BigDecimal averageValue, Account largestValueAccount, ArrayList<Account> accountsWith0Balance){
			this.sumOfAllAccounts = sumOfAllAccounts;
			this.numberOfAccounts = numberOfAccounts;
			this.averageValue = averageValue;
			this.largestValueAccount = largestValueAccount;
			this.accountsWith0Balance = accountsWith0Balance;
		}

		public BigDecimal getSumOfAllAccounts() {
			return sumOfAllAccounts.setScale(2, RoundingMode.FLOOR);
		}
		
		public String getSumOfAccountsString() {
			return sumOfAllAccounts.setScale(2, RoundingMode.FLOOR).toString();
		}

		public int getNumberOfAccounts() {
			return numberOfAccounts;
		}

		public BigDecimal getAverageValue() {
			return averageValue.setScale(2, RoundingMode.FLOOR);
		}

		public Account getLargestValueAccount() {
			return largestValueAccount;
		}

		public ArrayList<Account> getAccountsWith0Balance() {
			return accountsWith0Balance;
		}
		
		
	
}
