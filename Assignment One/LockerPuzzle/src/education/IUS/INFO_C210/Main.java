package education.IUS.INFO_C210;
/*
 * Assignment 1 Problem 5
 * Checks if lockers are open or shut after 100 students opens/shuts 
 * one less locker than the one before them starting with opening 100 lockers.
 * 
 *  INFO-C210
 *  William Applegate
 */
public class Main {

	/*
	 * main Method (Only method)
	 * 
	 */
	public static void main(String[] args) {
		
		//Create boolean array. 
		boolean[] isLockerOpen= new boolean[100];

		//for loop of 100 students
		for(int i = 0 ; i < 100 ; i++) {
			
			//for loop of every locker - the next (i + 1)'th student opens/closes
			for(int j = 0 + i; j < 100; j++) {
				
				//every other student does the opposite (open/close - even/odd)
				if(i % 2 == 0) {
					isLockerOpen[j] = true;
					
				}else {
					isLockerOpen[j] = false;
				}
			}
		}
		
		//Print results:		
		for(int k = 0 ; k < isLockerOpen.length ; k++) {
			String answer;
			
			if(isLockerOpen[k]) {
				answer = "open";
				
			}else {
				answer = "shut";
			}
			
			System.out.println("Locker " + (1 + k) + " is " + answer + ".");
		}
	}
}