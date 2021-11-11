package comparables;

import java.util.Date;

abstract class GeometricObject1 implements Comparable<GeometricObject1>{
    //instance variables
	private String color = "white";
    private boolean filled;
    private Date dateCreated;
    
    /**Default construct*/
    protected GeometricObject1() {
    	this.dateCreated = java.util.Calendar.getInstance().getTime();
    }
    
    /**Construct a geometric object*/
    protected GeometricObject1(String color, boolean filled) {
      this.color = color;
      this.filled = filled;
      this.dateCreated = java.util.Calendar.getInstance().getTime();
    }
    
    /**Getter method for color*/
    public String getColor() {
      return color;
    }
    
    /**Setter method for color*/
    public void setColor(String color) {
      this.color = color;
    }
    
    /**Getter method for filled. Since filled is boolean,
       so, the get method name is isFilled*/
    public boolean isFilled() {
      return filled;
    }
    
    /**Setter method for filled*/
    public void setFilled(boolean filled) {
      this.filled = filled;
    }
    
    public Date getDateCreated() {
    	return this.dateCreated;
    }
    
    public String toString() {
    	return "Object Color: " + this.color + " ; filled: " + this.filled + " ; Date Created: " + dateCreated;
    }
    
    //Abstract methods
    abstract public double getArea();
    
    abstract public double getPerimeter();
    
    //Compare
    @Override
    public int compareTo(GeometricObject1 newObject) {
    	double differenceOfAreas = this.getArea() - newObject.getArea();
    	
    	if(differenceOfAreas > 0.0) {
    		return 1;
    	}else if(differenceOfAreas < 0.0) {
    		return -1;
    	}else {
    		return 0;
    	}
    }
    
    //Max method
    public static GeometricObject1 max(GeometricObject1 obj1, GeometricObject1 obj2) {
    	int comparison = obj1.compareTo(obj2);
    	
    	if(comparison > 0) {
    		return obj1;
    	}else if(comparison < 0){
    		return obj2;
    	}else {
    		return null;
    	}
    }
}