package assignmentsix;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/*
 * Main pane for this assignment. Extends VBox and adds the three random 
 * cards HBox and a button to reset the random card HBox.
 * 
 * Author: William Applegate
 * INFO-C210
 * Assignment Six
 */
class MainCardPane extends VBox{
	
private ThreeCardPane threeCardPane;
	MainCardPane(){
		super(10);
		this.setStyle("-fx-background-color: SLATEGRAY; -fx-border-color: black;");
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(5,5,5,5));
		threeCardPane = new ThreeCardPane();
		
		Button cardResetBTN = new Button("Reset Cards");
		cardResetBTN.setStyle("-fx-background-color: lightgray; -fx-border-color: orange;");
		cardResetBTN.setFont(new Font("Arial Bold", 12));
		this.getChildren().addAll(cardResetBTN, threeCardPane);
		
		cardResetBTN.setOnAction(t ->{
			ThreeCardPane newThreeCardPane = new ThreeCardPane();
			this.getChildren().remove(this.threeCardPane);
			this.getChildren().add(newThreeCardPane);
			this.threeCardPane = newThreeCardPane;
		});
		
	}
}
