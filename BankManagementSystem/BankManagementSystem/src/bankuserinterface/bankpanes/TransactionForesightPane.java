package bankuserinterface.bankpanes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import bankmanagementsystem.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class TransactionForesightPane extends VBox{
	BigDecimal transactionAmount;
	boolean isFeeApplied;
	double transactionFee;
	BigDecimal accountValue;
	
	
	BigDecimal transactionSum;
	
	TransactionForesightPane(double lineDistance, Account thisAccount, long transactionAmount){
		super(lineDistance);
		
		this.setPadding(new Insets(10,10,20,10));
		
		if(transactionAmount == 0) {
			Label errorMessage = new Label("Invalid transaction amount entered");
			errorMessage.setStyle("-fx-text-fill: red; -fx-background-color: white; -fx-border-color: red;");
			errorMessage.setFont(new Font("Arial Bold", 12));
			this.getChildren().add(errorMessage);
			
		}else {
		
		
			if(thisAccount instanceof ChargesTransactionFee) {
				isFeeApplied = ((ChargesTransactionFee)thisAccount).isFeeCharged();
				if(isFeeApplied) {
					transactionFee = ((ChargesTransactionFee)thisAccount).getTransactionFee();
				}
			}
		
			this.accountValue = thisAccount.getBalance().setScale(2, RoundingMode.FLOOR);
			
			this.transactionAmount = new BigDecimal(transactionAmount);
			
			this.transactionSum = accountValue.add(this.transactionAmount);
		
		
		
			String startingBalanceString = this.accountValue.toString() + "\tBeginning Balance";
			this.getChildren().add(new Text(startingBalanceString));
			if(isFeeApplied) {
				String feeApplicationString = "" + transactionFee + "\tTransactionfee";
				this.getChildren().add(new Text(feeApplicationString));
			};
			String transactionAmountString;
			if(this.transactionAmount.compareTo(new BigDecimal("0")) > 0){
				transactionAmountString = "+ " + this.transactionAmount.toString() + "\tDeposit"; 
			}else {
				transactionAmountString = "" + this.transactionAmount.toString() + "\tWithdraw";
			}
			this.getChildren().add(new Text(transactionAmountString));
			String barrierLine = "--------------------";
			this.getChildren().add(new Text(barrierLine));
			String sumString;
			boolean isSumNegative = false;
		
			if(this.transactionSum.compareTo(new BigDecimal("0")) < 0) {
				isSumNegative = true;
			}
			sumString = this.transactionSum.toString();
		
			Text sumText = new Text(sumString);
			if(isSumNegative) {
				sumText.setFill(Color.RED);
			}
			this.getChildren().add(sumText);

		}
		
	}
	

}
