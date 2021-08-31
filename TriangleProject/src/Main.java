import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);

	public static Point askForPointInput(char point) {
		System.out.println("Enter x value for point " + point + ":");
		double xValue = in.nextDouble();  
		System.out.println("Enter y value for point " + point + ":");
		double yValue = in.nextDouble();
		Point newPoint = new Point(xValue, yValue);
		return newPoint;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("Triangle Creator");
		
		System.out.println("Need three points for triangle");
		Point pointA = askForPointInput('A');
		Point pointB = askForPointInput('B');
		Point pointC = askForPointInput('C');
		Triangle myTriangle = new Triangle(pointA, pointB, pointC);
		
		System.out.println("Triangle created. . . \n");
		
		myTriangle.printAllInfo();
		
		
	}

}
