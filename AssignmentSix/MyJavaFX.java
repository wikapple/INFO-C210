package JavaFX;
import JavaFX.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.lang.Math;



public class MyJavaFX extends Application {
    @Override
    public void start(Stage primaryStage){
       Pane pane = new HBox(10);
       pane.setPadding(new Insets(5,5,5,5));
       int[] randomCards = randomCardNumbers();
       Image card1 = new Image("JavaFX/Cards/"+ randomCards[0] +".png");
       
       Image card2 = new Image("JavaFX/Cards/"+ randomCards[1]+".png");
       Image card3 = new Image("JavaFX/Cards/"+randomCards[2]+".png");
       pane.getChildren().add(new ImageView(card1));
       pane.getChildren().add(new ImageView(card2));
       pane.getChildren().add(new ImageView(card3));
        
       Scene scene = new Scene(pane, 250, 125);
       primaryStage.setTitle("Assignment 6");
       primaryStage.setScene(scene);
       primaryStage.show();
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }
    
    public static int[] randomCardNumbers(){
        int[] cards = new int[3];
        cards[0] = randomNumberGenerator(1, 52);

        do{
            cards[1] = randomNumberGenerator(1, 52);
        }while (cards[1] == cards[0]);
        
        do{
            cards[2] = randomNumberGenerator(1, 52);
        }while (cards[2] == cards[0] || cards[2] == cards[1]);
        
        return cards;
    }
    
    public static int randomNumberGenerator(int min, int max){
        int range = max - min +1;
        
        int random = (int)(Math.random() * range) + min;
        return random;
    }
    
}
