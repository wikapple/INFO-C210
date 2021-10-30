import javafx.geometry.Point2D;

/* Circle2D class
 *  Creates a Circle2D object with circle values as data fields, methods compare circle with other Circle2D or Point2D object
 *  Author: William Applegate
 *  INFO-C210
 */
public class Circle2D {
	//data fields
	private double x, y;
	private double radius;
	private Point2D circleCenterPoint;
	
	//constructors
	Circle2D(){
		this(0,0,1);
	}
	Circle2D(double xInput, double yInput, double radiusInput){
		this.x = xInput;
		this.y = yInput;
		this.radius = Math.abs(radiusInput);
		this.circleCenterPoint = new Point2D(this.x, this.y);
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
	
	public Point2D getCircleCenterPoint() {
		return this.circleCenterPoint;
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
	
	/*contains method determines if point at parameter x and y is within circle
	 * Return true if the distance from this circle's center to the point parameter is less than (or equal to?) this circles radius
	 */
	public boolean contains(double x, double y) {
		
		Point2D newPoint = new Point2D(x, y);

		if(circleCenterPoint.distance(newPoint) <= this.radius) {
			return true;
		}else {
			return false;
		}
	}
	
	/*contains method determines if circle contains the new circle parameter.
	 * calculates distance from circle center point to the farthest point on another circle
	 * if total distance is less than or equal to this circle's radius, then this circle contains the other circle
	 */
	public boolean contains(Circle2D circle){
		
		double distance = circleCenterPoint.distance(circle.getCircleCenterPoint()) + circle.radius;
		
		if(distance <= this.radius){
			return true;
		}else{
			return false;
		}
	}
	
	/*overlaps method determines if this circle and another circle overlap
	 * Calculates distance between this circle center and another circle's center
	 * if the sum of both their radiuses is greater than the distance, and if one circle does NOT contain the other, then they overlap.
	 */
	public boolean overlaps(Circle2D circle) {
		
		double distance = circleCenterPoint.distance(circle.getCircleCenterPoint());
		
		if(this.radius + circle.radius > distance && !contains(circle) && !circle.contains(this)) {
			return true;
		}else {
			return false;
		}
	}
}