package assignmentsix;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;

/*
 * Main method and start method launch application
 * 
 * Author: William Applegate
 * INFO-C210
 * Assignment Six
 */
public class RandomCardsFX extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Assignment 6 - Random card generator");
		primaryStage.getIcons().add(new Image("assignmentsix/cards/1.png"));
		MainCardPane myCardPane = new MainCardPane();
		
		Scene cardScene = new Scene(myCardPane);

		
		primaryStage.setScene(cardScene);
		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
