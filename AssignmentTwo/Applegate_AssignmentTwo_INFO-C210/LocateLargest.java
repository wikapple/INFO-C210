import java.util.Scanner;

/*LocateLargestClass
 * Asks for int 2D array input
 * Checks for the largest element value within array
 * outputs first location/index of the largest value.
 * William Applegate
 * INFO-C210
*/
public class LocateLargest{

    /*input2DArray Method
     *Asks user to input array length, sublength, and assign element values
     *Checked if input valid, then returns 2D Array
    */
    private static double[][] input2DArray(){
        Scanner in = new Scanner(System.in);  // Scanner created 
        
        System.out.println("Enter the number of rows and number of columns: "); //Instruction
        
        //Initialize rows and columns, set to -1 to end program unless value changed below:
        int rows = -1; int columns = -1; 
        
        //If valid input received, assign values to rows, columns and array indecies
        //If invalid input received, output error message before program crash
        if(in.hasNextInt()){
            rows = in.nextInt();
        }else{
            String badInput = in.next();
            System.err.println(badInput + " is an invalid input for rows variable");
        }
        if(in.hasNextInt()){
            columns = in.nextInt();
        }else{
            String badInput2 = in.next();
            System.err.println(badInput2 + " is an invalid input for columns variable");
        }
        
        //Create myArray (program will crash here if rows and columns values remain unchanged at -1)
        double[][] myNewArray = new double[rows][columns];
        
        //Instructions for assigning indecy values:
        System.out.println("Enter the elements for a 2D double array with " + rows + " rows and " + columns + " columns: ");
        
        //Traverse myArray
        for (int m = 0; m < myNewArray.length; m++){
            for (int n = 0; n<myNewArray[m].length; n++){
                
                //Instruction per index (Commented out to avoid clutter when using a txt file instead of user input)
                //System.out.println("Enter a value to array index: " + m + "," + n + "." );

                //If valid input recieved:
                if(in.hasNextDouble()){ 
                    myNewArray[m][n] = in.nextDouble();
                //If invalid input recieved:
                }else{
                    String badInput3 = in.next();
                    System.err.println("\"" + badInput3 + "\"" + " is an invalid input for element of two dimensional array");
                }
            }
        }    
        in.close();
        return myNewArray; //Return statement
    }

    /* locateLargest Method
     * Takes double 2D array
     * checks for largest element value and returns the index value in the form of an int array
    */
    public static int[] locateLargest(double[][] a){
        int[] indexOfLargest = new int[2];
        //Initialize the highestDouble value at first index and assign index values to indexOfLargest array. Gotta start somewhere.
        double highestDouble = a[0][0];
        indexOfLargest[0] = 0; indexOfLargest[1] = 0;
        
        //Traverse "a" double array:
        for (int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                //If a larger element value is found, change highest double to it, and update indexOfLargest values to current index. 
                if(highestDouble < a[i][j]){
                    highestDouble = a[i][j];
                    indexOfLargest[0] = i;
                    indexOfLargest[1] = j;
                }
            }            
        }
        return indexOfLargest; //Return statement
    }


    /*main method
     *Get 2D double array, get index of highest element within 2D array, output index values.
    */
    public static void main(String[] args){
        //Get 2D array
        double[][] myArray = input2DArray();
        //Get index of largest value of 2D array
        int[] indexOfHighestValue = locateLargest(myArray);
        //Out index of largest value of 2D array
        System.out.println("The location of the largest element is at (" + indexOfHighestValue[0] + ", " + indexOfHighestValue[1] + ")");
    }
}