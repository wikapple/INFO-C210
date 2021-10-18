
/*
 * Creates a point with x and y values. 
 */

public class Point {
	//instance variables
	private double x;
	private double y;
	
	//constructor
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//getters and setters
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void replaceX(int x) {
		this.x = x;
	}
	
	public void replaceY(int y) {
		this.y = y;
	}
	
}
