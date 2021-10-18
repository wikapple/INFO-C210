/*
 * DeckofCards
 * Picks four cards randomly out of deck of 52
 * Outputs them to user
 */
public class DeckofCards {

	public static void main(String[] args) {
		int[] deck = new int[52];
		
		for (int i = 0 ; i < deck.length ; i++) {
			deck[i] = i;
		}
		
		deck = shuffle(deck);
		
		int[] pickFour = drawRandom(deck, 4);
		
		System.out.println("Your four cards are: ");
		for (int k = 0 ; k < pickFour.length ; k++) {
			System.out.println("Card " + k + ": " + pickFour[k]);
		}
	}
	
	private static int[] shuffle(int[] unshuffledDeck) {
		
		for (int i = 0 ; i < unshuffledDeck.length ; i++) {
			int j = (int) (Math.random() * unshuffledDeck.length);
			int temp = unshuffledDeck[i];
			unshuffledDeck[i] = unshuffledDeck[j];
			unshuffledDeck[j] = temp; 
		}
		
		int[] shuffledDeck = unshuffledDeck;
		
		return shuffledDeck;
	}
	
	private static int[] drawRandom(int[] deckInput, int numberDrawn) {
		int[] drawnElements = new int[numberDrawn];
		
		for (int i = 0; i < numberDrawn ; i++) {
			int j = (int)(Math.random() * deckInput.length);
			if(deckInput[j] >= 0) {
			drawnElements[i] = deckInput[j];
			deckInput[j] = -1;
			}else {
				i--;
			}
		}
		return drawnElements;
	}
}
