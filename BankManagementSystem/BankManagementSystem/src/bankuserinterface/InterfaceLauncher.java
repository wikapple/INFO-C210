package bankuserinterface;
import bankmanagementsystem.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * InterfaceLauncher Class contains main method launches Bank GUI
 * 
 * Author: William Applegate
 * INFO-C210
 */
public class InterfaceLauncher extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		BankManagementSystem bankSystem = new BankManagementSystem();
		/*Create a default employee with default password that is already entered into login screen (Save time for testing)*/
		bankSystem.createNewEmployee("Default Login", "Default Password");
		
		/* What's the point of a bank system without some accounts to start with?
		* Directly create a few accounts before launching GUI
		*/
		bankSystem.createAccount(1, 1, "William", 1, 1000000);
		bankSystem.createAccount(2, 2, "Kris", 2, 200000);
		bankSystem.createAccount(3, 3, "Applegate", 3, 300000);
		
		/* Instantiate the Controller*/
		BankFXController myBankFX = new BankFXController(bankSystem, primaryStage);
		
		/*Set the Icon*/
		primaryStage.getIcons().add(new Image("bankuserinterface/Images/MoneyIcon.png"));
		
		/*set scene to the login scene to get the GUI started*/
		primaryStage.setScene(myBankFX.getLoginScene());
		
		/*Show the GUI*/
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
