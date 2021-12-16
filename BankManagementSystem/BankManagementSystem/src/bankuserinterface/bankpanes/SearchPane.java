package bankuserinterface.bankpanes;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import bankmanagementsystem.*;
import bankuserinterface.BankFXController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class SearchPane extends BankBasePane{
	
	private ArrayList<Account> wholeList;	
	private ArrayList<Account> filteredList;
	private AccountSearchFieldsPane leftPane;
	private Account selectedAccount;
	private int accountNumberInput;
	private String customerNameInput;
	private int customerIDInput;
	private BigDecimal minValueInput;
	private BigDecimal maxValueInput;
	private StackPane rightPane;
	private Button returnToMenuBtn;
	

	public SearchPane(ArrayList<Account> wholeList){
		super("Account Search", "Select from list or enter search criteria");

		this.wholeList = wholeList;
		rightPane = new StackPane();

		this.filterList();
		
		
		leftPane = new AccountSearchFieldsPane();
		
		this.mainBorderPane.setLeft(leftPane);
		
		leftPane.getAccountNumberBox().getTextField().setOnKeyTyped(a->{
			this.accountNumberInput = leftPane.getAccountNumberBox().getIntValue();
			this.filterList();
		});
		
		leftPane.getCustomerNameBox().getTextField().setOnKeyTyped(b->{
			this.customerNameInput = leftPane.getCustomerNameBox().getTextField().getText();
			this.filterList();
		});
		
		leftPane.getCustomerIDBox().getTextField().setOnKeyTyped(c->{
			this.customerIDInput = leftPane.getCustomerIDBox().getIntValue();
			this.filterList();
		});
		
		leftPane.getMinValueBox().getTextField().setOnKeyTyped(d->{
			long inputLong = leftPane.getMinValueBox().getLongValue();
			this.minValueInput = new BigDecimal(inputLong);
			this.filterList();
		});
		
		leftPane.getMaxValueBox().getTextField().setOnKeyTyped(e->{
			long inputLong = leftPane.getMaxValueBox().getLongValue();
			this.maxValueInput = new BigDecimal(inputLong);
			this.filterList();
		});
		
		
		this.rightPane.setAlignment(Pos.TOP_LEFT);
		
		this.mainBorderPane.setRight(rightPane);
		
		this.returnToMenuBtn = BankFXController.createButton("Return To Menu", "darkblue", 18);
		this.returnToMenuBtn.setAlignment(Pos.CENTER);
		this.returnToMenuBtn.setTextAlignment(TextAlignment.CENTER);
		
		StackPane bottomPane = new StackPane();
		bottomPane.getChildren().add(returnToMenuBtn);
		bottomPane.setAlignment(Pos.TOP_CENTER);
		bottomPane.setPadding(new Insets(10,10,40,10));
		
		this.mainBorderPane.setBottom(bottomPane);
	}
	
	public Button getReturnButton() {
		return this.returnToMenuBtn;
	}
	
	private AccountListPane getScrollList() {
	
		rightPane.getChildren().clear();
		
		Label accountInfo = new Label("Account info will show here");
		accountInfo.setTextAlignment(TextAlignment.LEFT);
		accountInfo.setAlignment(Pos.TOP_LEFT);
		accountInfo.setFont(new Font("Arial Bold", 18));
		accountInfo.setPrefWidth(300);
		rightPane.setPadding(new Insets(10,20,10,10));
		
		rightPane.getChildren().add(accountInfo);
		
		
		AccountListPane filteredListPane = new AccountListPane(this.filteredList, "Filtered List");
		filteredListPane.setAlignment(Pos.TOP_CENTER);
		
		filteredListPane.getLV().getSelectionModel().selectedItemProperty().addListener(a->{
			int index = filteredListPane.getLV().getSelectionModel().getSelectedIndex();
			this.selectedAccount = filteredList.get(index);
			
			
			rightPane.getChildren().remove(accountInfo);
			accountInfo.setText(this.selectedAccount.toString());
			rightPane.getChildren().add(accountInfo);
		});
		
		
		return filteredListPane;
		
	}
	
	private void filterList() {
		this.filteredList = new ArrayList<Account>();
		for (Account thisAccount : wholeList){
			//boolean doesAccountMatch = true;
			
			if(this.accountNumberInput > 0) {
				if(!BankManagementSystem.doesIntContainInt(accountNumberInput, thisAccount.getAccountNumber()))
					//doesAccountMatch = false;
					continue;
			}
			
			if(this.customerNameInput != null && this.customerNameInput.length() > 0) {
				if(!thisAccount.getCustomerName().contains(customerNameInput)) {
					continue;
				}
					
			}
		
			if(this.customerIDInput > 0) {
				if(!BankManagementSystem.doesIntContainInt(this.customerIDInput, thisAccount.getCustomerID())) {
					continue;
				}
			}
		
			if(this.minValueInput != null && this.minValueInput.compareTo(new BigDecimal("0")) > 0) {
				if(minValueInput.compareTo(thisAccount.getBalance()) > 0) {
					continue;
				}
			}
		
			if(this.maxValueInput != null && this.maxValueInput.compareTo(new BigDecimal("0")) > 0) {
				if(maxValueInput.compareTo(thisAccount.getBalance()) < 1) {
					continue;
				}
			}
			filteredList.add(thisAccount);
		}
		
		Collections.sort(this.filteredList);
		
		this.mainBorderPane.setCenter(getScrollList());
	}

}
