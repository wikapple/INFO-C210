
public class Line {
	private double distance;
	
	public Line(Point firstPoint, Point secondPoint) {
		double x1 = firstPoint.getX();
		double y1 = firstPoint.getY();
		double x2 = secondPoint.getX();
		double y2 = secondPoint.getY();
		
		double xValuesSquared = Math.pow((x2 - x1), 2);
		double yValuesSquared = Math.pow((y2 - y1), 2);
		
		double xPlusY = Math.abs(xValuesSquared + yValuesSquared);
		
		this.distance = Math.sqrt(xPlusY);

	}
	
	public double getDistance() {
		return this.distance;
	}
	

}
