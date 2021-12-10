package assignmentsix;

import java.util.ArrayList;

import javafx.geometry.Insets;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/*
 * Class extends HBox to create a pane of three ImageView objects by 
 * calling RandomCardSelect's getThreeRandomCards method
 * 
 * Author: William Applegate
 * INFO-C210
 * Assignment Six
 */
class ThreeCardPane extends HBox {

	private ArrayList<ImageView> cards;
	
	ThreeCardPane(){
		super(5);
		cards = RandomCardSelect.getThreeRandomCards();
		this.setPadding(new Insets(5,5,5,5));
	
		this.getChildren().addAll(cards);
	
	}
	

}
