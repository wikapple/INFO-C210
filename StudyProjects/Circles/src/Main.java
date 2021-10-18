import java.util.Scanner;

public class Main {

	  public static void main(String[] args) {
		    int[][] values = {{3, 4, 5, 1}, {33, 6, 1, 2}};

		    for (int row = 0; row < values.length; row++) {
		      System.out.print(m(values[row]) + " ");
		    }
		  }

		  public static int m(int[] list) {
		    int v = list[0];
		    for (int i = 1; i < list.length; i++)
		      if (v < list[i])
		        v = list[i];
		    return v;
		  }
}
