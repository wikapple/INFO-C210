package bankuserinterface.bankpanes;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class RadioButtonVBox extends VBox{
	private ArrayList<RadioButton> radioButtons = new ArrayList<>();
	ToggleGroup thisToggle;
	
	RadioButtonVBox(double rbSeparation, String rbOneText, String rbTwoText){
		super(rbSeparation);
		this.setPaneFormat();
		this.setAlignment(Pos.BOTTOM_CENTER);
		
		thisToggle = new ToggleGroup();
		
		RadioButton rbOne = new RadioButton(rbOneText);
		radioButtons.add(rbOne);
		rbOne.setToggleGroup(thisToggle);
		
		RadioButton rbTwo = new RadioButton(rbTwoText);
		radioButtons.add(rbTwo);
		rbTwo.setToggleGroup(thisToggle);
		
		setRadioButtonFormats();
		this.getChildren().addAll(radioButtons);
		
	}
	RadioButtonVBox(double rbSeparation, String rbOneText, String rbTwoText, String rbThreeText){
		this(rbSeparation, rbOneText, rbTwoText);
		RadioButton rbThree = new RadioButton(rbThreeText);
		radioButtons.add(rbThree);
		rbThree.setToggleGroup(thisToggle);
		
		setRadioButtonFormats();
		
		this.getChildren().removeAll(radioButtons);
		this.getChildren().addAll(radioButtons);	
	}
	RadioButtonVBox(double rbSeparation, String rbOneText, String rbTwoText, String rbThreeText, String rbFourText){
		this(rbSeparation, rbOneText, rbTwoText, rbThreeText);
		RadioButton rbFour = new RadioButton(rbFourText);
		radioButtons.add(rbFour);
		rbFour.setToggleGroup(thisToggle);
		
		setRadioButtonFormats();
		
		this.getChildren().removeAll(radioButtons);
		this.getChildren().addAll(radioButtons);
	}
	
	
	private void setRadioButtonFormats() {
		radioButtons.forEach(a->{
			((RadioButton)a).setTextFill(Color.DARKGREEN);
			((RadioButton)a).setFont(new Font("Arial Bold", 16));
			((RadioButton)a).setStyle("-fx-border-color: black; -fx-background-color: white");
			((RadioButton)a).setPrefHeight(this.getPrefHeight());
			((RadioButton)a).setPrefWidth(this.getPrefWidth());
			((RadioButton)a).setTextAlignment(TextAlignment.CENTER);
			((RadioButton)a).setAlignment(Pos.CENTER);
		});
	}
	
	private void setPaneFormat() {
		this.setPrefHeight(35);
		this.setPrefWidth(225);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(10,10,10,10));
	}
	
	public RadioButton getButton(int btnIndex) {
		if(radioButtons.size() <= btnIndex) {
			return null;
		}else {
			return radioButtons.get(btnIndex);
		}
	}
}
