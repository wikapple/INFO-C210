package comparables;

class Test {
	  // Main method
	  public static void main(String[] args) {
	    // Create two comparable circles
	    Circle1 circle1 = new Circle1(5);
	    Circle1 circle2 = new Circle1(4);

	    // Display the max circle
	    Circle1 circle = (Circle1)GeometricObject1.max(circle1, circle2);
	    System.out.println("The max circle's radius is " +
	      circle.getRadius());
	    System.out.println(circle);
	  }
	}

