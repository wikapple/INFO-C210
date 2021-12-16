package bankuserinterface.bankpanes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class InputFieldHBox extends HBox{
private Label descriptionLabel; 
private TextField textField;
	
	public InputFieldHBox(double padBetweenNodes, String labelText, int fontSize){
		super(padBetweenNodes);
		descriptionLabel = new Label(labelText);
		descriptionLabel.setFont(new Font("Arial Bold", fontSize));
		
		textField = new TextField(); 
		
		this.getChildren().addAll(descriptionLabel, textField);	
	}
	
	TextField getTextField() {
		return this.textField;
	}
	Label getLabel() {
		return descriptionLabel;
	}
	
	int getIntValue() {
		int fieldAsInt;
		try {
			fieldAsInt = Integer.parseInt(textField.getText());
		}catch(NumberFormatException e) {
			fieldAsInt = 0;
		}
			return fieldAsInt;
	}
	
	long getLongValue() {
		long fieldAsInt;
		try {
			fieldAsInt = Long.parseLong(textField.getText());
		}catch(NumberFormatException e) {
			fieldAsInt = 0l;
		}
			return fieldAsInt;
	}
	
	
	public void setChildPrefHeight(double prefHeight){
		setLabelPrefHeight(prefHeight);
		setTextFieldPrefHeight(prefHeight);
	}
	
	void setLabelPrefWidth(double prefWidth) {
		descriptionLabel.setPrefWidth(prefWidth);
	}
	void setLabelPrefHeight(double prefHeight) {
		descriptionLabel.setPrefHeight(prefHeight);
	}
	
	void setTextFieldPrefWidth(double prefWidth) {
		textField.setPrefWidth(prefWidth);
	}
	
	void setTextFieldPrefHeight(double prefHeight) {
		textField.setPrefHeight(prefHeight);
	}
	
	void setFont(Font newFont) {
		this.descriptionLabel.setFont(newFont);
	}
	
	void setLabelStyle(String fxStyle) {
		this.descriptionLabel.setStyle(fxStyle);
	}
	void setTextFieldStyle(String fxStyle) {
		this.textField.setStyle(fxStyle);
	}
}
