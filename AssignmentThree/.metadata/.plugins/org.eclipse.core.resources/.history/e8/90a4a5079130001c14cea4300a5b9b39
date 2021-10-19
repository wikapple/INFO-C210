import javafx.geometry.Point2D;

/* Circle2D class
 *  Creates a Circle2D object with circle values as data fields, methods compare circle with other circle object
 *  Author: William Applegate
 *  INFO-C210
 */
public class Circle2D {
	//data fields
	private double x, y;
	private double radius;
	private Point2D thisCircleCenter;
	
	//constructors
	Circle2D(){
		this(0,0,1);
	}
	Circle2D(double xInput, double yInput, double radiusInput){
		this.x = xInput;
		this.y = yInput;
		this.radius = Math.abs(radiusInput);
		this.thisCircleCenter = new Point2D(this.x, this.y);
	}
	
	//getters
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getRadius() {
		return this.radius;
	}
	
	//getArea method:
	public double getArea() {
		double area = Math.pow(this.radius, 2) * Math.PI;
		return area;
	}
	
	//getPerimeter method:
	public double getPerimeter() {
		double circumference = 2 * Math.PI * this.radius; //circumference formula
		return circumference;
	}
	//contains method determines if point at parameter x and y is within circle
	public boolean contains(double x, double y) {
		Point2D newCircle = new Point2D(x, y);

		if(thisCircleCenter.distance(newCircle) <= this.radius) {
			return true;
		}else {
			return false;
		}
	}
	
	//overloaded contains method determines if circle contains the new circle parameter.
	public boolean contains(Circle2D circle){
		Point2D newCircleCenter = new Point2D(circle.x, circle.y);
		//greatest distance from this.circle to the farthest away point of the new circle parameter
		double distance = thisCircleCenter.distance(newCircleCenter) + circle.radius;
		
		//if the distance is greater than this.radius, this circle does not contain the circle parameter
		//if the distance is less than or equal to this.radius, this circle does contain the circle parameter
		if(distance <= this.radius){
			return true;
		}else{
			return false;
		}
	}
	//overlaps method checks if this circle another circle overlap.
	public boolean overlaps(Circle2D circle) {
		Point2D newCircleCenter = new Point2D(circle.getX(), circle.getY());
		//distance between the center of both circles:
		double distance = thisCircleCenter.distance(newCircleCenter);
		
		//if the sum of both radii is greater than the distance, and this one does not contain the other, then they overlap:
		if(this.radius + circle.radius > distance && !contains(circle) && !circle.contains(this)) {
			return true;
		}else {
			return false;
		}
		
	}
}
