package assignmentsix;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/*
 * RandomCardSelect Class
 * Method getThreeRandomCards() calls on private methods then returns
 * three ImageViews from cards folder
 * 
 * Author: William Applegate
 * INFO-C210
 * Assignment 6
 */
class RandomCardSelect {

	
	
	/*Static method getThreeRandomCards can be called by main FX class
	 * calls methods below it to assist in collected three card ImageViews before returning them
	 */
	static ArrayList<ImageView> getThreeRandomCards() {
		/*Get random three unique random numbers*/
		int[] randomCardNumbers = randomCardNumbers(3);
		//System.out.println("Random numbers are " + randomCardNumbers[0] + ", " + randomCardNumbers[1] + ", " + randomCardNumbers[2]);
		
		
		/*Create ImageView array and traverse it while placing values in*/
		ArrayList<ImageView> cards = new ArrayList<>();
		
		for (int i = 0; i < randomCardNumbers.length ; i++) {
			cards.add(getCardImageView(randomCardNumbers[i]));
		}
		return cards;
		
	}
	
	/*Take a card number and return associated ImageView from cards folder*/
	private static ImageView getCardImageView(int cardNumber) {
		if(cardNumber < 1 || cardNumber > 52) {
			return null;
		}else {
			Image cardImage = new Image("assignmentsix/cards/" + cardNumber + ".png");
			
			ImageView cardImageView = new ImageView(cardImage);
			
			return cardImageView;
		}
	}
	
	/*Takes total number of cards and returns three random and unique int values between 1 and 52
	 * calls randomNumberGenertor each time it needs a new random number
	 */
	private static int[] randomCardNumbers(int numberOfCards){
		
		int[] cards = new int[numberOfCards];
		
		for (int i = 0; i < numberOfCards; i++) {
			boolean isRandomNumberUnique;
			int randomNumber;
			//do while loop while random number is not unique
			do {
				isRandomNumberUnique = true;
				randomNumber = randomNumberGenerator(1,52);
				for(int j = 0; j < i; j++) {
					if(randomNumber == cards[j]) {
						isRandomNumberUnique = false;
					}
				}
			}while(!isRandomNumberUnique);
			cards[i] = randomNumber;
		}
		
		return cards;
    }
	
	/*Generate a random number between min and max parameter values*/
    private static int randomNumberGenerator(int min, int max){
        int range = max - min +1;
        
        int random = (int)(Math.random() * range) + min;
        return random;
    }
}
