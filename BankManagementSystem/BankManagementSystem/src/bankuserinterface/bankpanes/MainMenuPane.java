package bankuserinterface.bankpanes;
import java.util.ArrayList;

import bankmanagementsystem.*;
import bankuserinterface.BankFXController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainMenuPane extends BankBasePane{

	private Button createNewAccount;
	private Button transactionButton;
	private Button accountSearch;
	private Button removeAccount;
	private Button monthReset;
	private Button bankDataButton;
	private Button logoutButton;
	
	
	public MainMenuPane(BankOperator thisEmployee){
		super("Main Menu", thisEmployee.getEmployeeName());
		
		VBox menuButtons = new VBox(15);
		menuButtons.setPrefWidth(300);
		ArrayList<Button> buttonArray = new ArrayList<Button>();
		this.createNewAccount = BankFXController.createButton(" Create new bank account ", "blue", 16);
		buttonArray.add(createNewAccount);
		this.transactionButton = BankFXController.createButton(" New Transaction ", "blue", 16);
		buttonArray.add(transactionButton);
		this.accountSearch = BankFXController.createButton(" Account Search ", "blue", 16);
		buttonArray.add(accountSearch);
		this.removeAccount = BankFXController.createButton(" Remove Account ", "blue", 16);
		buttonArray.add(removeAccount);
		this.monthReset = BankFXController.createButton(" Apply end of month adjustments ", "blue", 16);
		buttonArray.add(monthReset);
		this.bankDataButton = BankFXController.createButton(" Get bank financial statistics ", "blue", 16);
		buttonArray.add(bankDataButton);
		
		buttonArray.forEach(a -> {
			((Button)a).setStyle(" -fx-background-radius: 15px; -fx-border-color: blue; -fx-background-color: white; -fx-text-fill: darkblue;");
			((Button)a).setFont(new Font("Arial", 16));
			((Button)a).setPrefWidth(menuButtons.getPrefWidth());
			((Button)a).setAlignment(Pos.CENTER);
				
			
		});
		
		menuButtons.getChildren().addAll(buttonArray);
		menuButtons.setAlignment(Pos.BASELINE_CENTER);
		menuButtons.setPadding(new Insets(10,10,10, 300));
		this.mainBorderPane.setCenter(menuButtons);
		
		
		AnchorPane rightLogoutPane = new AnchorPane();
		logoutButton = BankFXController.createButton(" Logout ", "red", 20);
		logoutButton.setAlignment(Pos.CENTER);
		//logoutButton.setLayoutX(100);
		//logoutButton.setPadding(new Insets(10,10,10,10));
		logoutButton.setPrefWidth(200);
		rightLogoutPane.getChildren().add(logoutButton);
		rightLogoutPane.setLayoutX(0);
		rightLogoutPane.setLayoutY(100);
		rightLogoutPane.setPadding(new Insets(10,100,10,10));
		
		this.mainBorderPane.setRight(rightLogoutPane);
		
	}
	public Button getCreateNewAccount() {
		return createNewAccount;
	}


	public Button getTransactionButton() {
		return transactionButton;
	}


	public Button getAccountSearch() {
		return accountSearch;
	}


	public Button getRemoveAccount() {
		return removeAccount;
	}


	public Button getMonthReset() {
		return monthReset;
	}


	public Button getBankDataButton() {
		return bankDataButton;
	}


	public Button getLogoutButton() {
		return logoutButton;
	}


}
