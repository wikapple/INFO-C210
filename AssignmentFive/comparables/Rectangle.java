package comparables;

class Rectangle extends GeometricObject1{
	//instance variables:
	private double width;
	private double height;
	

	//constructors
	public Rectangle() {
		this(1.0,1.0);
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		}
	
	public Rectangle(double width, double height, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.height = height;
	}
	
	//end constructors
	
	//width
	public double getWidth() {
		return this.width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	//height
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double getArea() {
		double area = this.width * this.height;
		return area;
	}
	
	@Override
	public double getPerimeter() {
		double perimeter = (this.width * 2) + (this.height * 2);
		return perimeter;
	}
	}
