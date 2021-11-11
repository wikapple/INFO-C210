package comparables;

class Circle1 extends GeometricObject1{
	//instance variables
	private double radius;
	
	//Constructors
	public Circle1() {
		this(1.0);
	}
	
	public Circle1(double radius) {
		this.radius = radius;
	}
	
	public Circle1 (double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}
	
	//End constructors
	
	//get radius
	public double getRadius() {
		return this.radius;
	}
	
	//set radius
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	//diameter
	public double getDiameter() {
		double diameter = this.radius  * 2;
		return diameter;
	}
	
	//overrides
	
	@Override
	public double getArea() {
		double area = Math.PI * Math.pow(radius, 2);
		return area;
	}
	
	@Override
	public double getPerimeter() {
		double perimeter = this.getDiameter() * Math.PI;
		return perimeter;
	}

}
