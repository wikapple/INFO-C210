
public class Triangle {
	//Instance Variables
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private Angle angleA;
	private Angle angleB;
	private Angle angleC;
	
	private Line lineA;
	private Line lineB;
	private Line lineC;
	
	private double area;
	private double height;
	
	//Constructor
	public Triangle(Point pointA, Point pointB, Point pointC) {
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		
		this.lineA = new Line(pointB, pointC);
		this.lineB = new Line(pointA, pointC);
		this.lineC = new Line(pointA, pointB);
		
		this.angleA = new Angle(lineA, lineB, lineC);
		this.angleB = new Angle(lineB, lineA, lineC);
		this.angleC = new Angle(lineC, lineB, lineA);
		
		this.height = 2 * (this.lineA.getDistance()/lineB.getDistance());
		
		this.area = (lineB.getDistance() * this.height) / 2;

	}
	
	//Getters and setters
	
	public double getArea() {
		return this.area;
	}

	public void printAllInfo() {
		System.out.println("Triangle Information Printout:\n");
		System.out.println("pointA: (" + pointA.getX() + ", " + pointA.getY() + ").");
		System.out.println("pointB: (" + pointB.getX() + ", " + pointB.getY() + ").");
		System.out.println("pointC: (" + pointC.getX() + ", " + pointC.getY() + ").");
		System.out.println();
		System.out.println("angleA: " + angleA.getDegrees() + " degrees.");
		System.out.println("angleB: " + angleB.getDegrees() + " degrees.");
		System.out.println("angleC: " + angleC.getDegrees() + " degrees.");
		System.out.println();
		System.out.println("lineA: " + lineA.getDistance() + ".");
		System.out.println("lineB: " + lineB.getDistance() + ".");
		System.out.println("lineC: " + lineC.getDistance() + ".");
		System.out.println();
		System.out.println("Triangle height: " + this.height);
		System.out.println();
		System.out.println("Triangle area: " + area);

	}
}
