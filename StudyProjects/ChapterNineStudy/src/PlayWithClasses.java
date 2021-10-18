
public class PlayWithClasses {

	public static void main(String [] args) {
		//int month, day, year;
		//int anniversaryDay, anniversaryMonth;
		Date birthday = new Date(11, 16, 1990);
		Date anniversary = new Date(11, 17, 2018);
		
		//birthday.month = 11;
		//birthday.day = 16;
		//birthday.year = 1990;
		
		birthday.setMonth(11);
		
		System.out.println(birthday);
	}
}
