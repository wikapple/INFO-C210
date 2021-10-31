/*
 * Triangle Class extended from Geometric Object
 * INFO-C210 Assignment 4
 * Author: William Applegate
 */
class Triangle extends GeometricObject {
	
	//data fields:
	private double side1;
	private double side2;
	private double side3;
	
	//Constructors:
	Triangle(){
		this(1.0, 1.0, 1.0);
	}
	
	Triangle(double side1, double side2, double side3){
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	//Accessor methods:
	public double getSide1() {
		return this.side1;
	}
	public double getSide2() {
		return this.side2;
	}
	public double getSide3() {
		return this.side3;
	}
	
	//Get area method referenced from assignment file:
	public double getArea() {
		double s = (this.side1 + this.side2 + this.side3) / 2;
		return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
	}
	
	//getPrimiter method returns sum of all sides
	public double getPerimeter() {
		return this.side1 + this.side2 + this.side3;
	}
	
	//toString override method:
	@Override
	public String toString() {
		return "Triangle : side1 = " + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3;
	}
	
}
