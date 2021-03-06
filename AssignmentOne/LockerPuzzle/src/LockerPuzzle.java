/* Locker Puzzle
 * Assignment 1 Problem 5
 * Creates 100 boolean values for whether a locker is open or shut
 * Iterates through 100 students who open or shut lockers whose numbers (1 to 100) are divisible by their student number (1 to 100).
 * Upon completion, outputs all open lockers.
 * 
 *  William Applegate
 *  INFO-C210
 */
public class LockerPuzzle {

	/*
	 * main Method (Only method)
	 */
	public static void main(String[] args) {
		
		//Create boolean array. 
		boolean[] isLockerOpen= new boolean[100];

		//for loop of 100 students
		for(int i = 1 ; i < 101 ; i++) {

			//Every locker divisible by i'th student
			for (int j = i - 1 ; j < 100 ; j += i) {
				
				// Open or close locker (reverse current value)
				if(isLockerOpen[j]) {
					isLockerOpen[j] = false;
				}
				else {
					isLockerOpen[j] = true;
				}
			}
		}
		
		//Print results:		
		for(int k = 0 ; k < isLockerOpen.length ; k++) {
			
			if(isLockerOpen[k]) {
				System.out.println("Locker " + (k + 1) + " is open.");
			}
		}
	}
}
