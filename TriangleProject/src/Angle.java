
public class Angle {
	private double angleDegrees;
	
	public Angle(Line line1, Line line2, Line line3) {
		double distance1 = line1.getDistance();
		double distance2 = line2.getDistance();
		double distance3 = line3.getDistance();
		
		double distanceFormula = (distance1 * distance1 - distance2 * distance2 - distance3 * distance3) / (-2 * distance2 * distance3);
		
		angleDegrees = Math.toDegrees(Math.acos(distanceFormula));
	}
	
	
	public double getDegrees() {
		return this.angleDegrees;
	}

}
