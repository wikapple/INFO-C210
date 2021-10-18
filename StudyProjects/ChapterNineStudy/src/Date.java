
public class Date { //class names always start with a capital letter
	
	private int month; //instance variables
	private int day;
	private int year;
	
	public Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
	}
	
	public int getMonth() {   //accessor method (getters)
		return month;
	}
	    
	public int getDay() {
		return day;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setMonth(int m) {    //mutator (setter)
		if(m > 0 && m < 13) {
			month = m;
		}
	}
	
	public void setDay(int d) {
		if(d > 0 && d < 32){
			day = d;
		}
	}
	
	public void setYear(int y) {
		if(y > 1900 && y < 9999){
			year = y;
		}
	}
	
	public String toString() {  //Java classes are expected to have a toString method with all instance variables of class within String.
		String result;
		result = month + "/" + day + "/" + year;
		return result;
	}
	
}
