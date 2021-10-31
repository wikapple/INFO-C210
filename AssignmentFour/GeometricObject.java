
/*
 * Geometric Object Class	
 * INFO-C210 Assignment 4
 * Referenced from Assignment 4 instructions
 * 
 */
class GeometricObject {
    private String color = "white";
    private boolean filled;
    
    /**Default construct*/
    protected GeometricObject() {
    }
    
    /**Construct a geometric object*/
    protected GeometricObject(String color, boolean filled) {
      this.color = color;
      this.filled = filled;
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
}
