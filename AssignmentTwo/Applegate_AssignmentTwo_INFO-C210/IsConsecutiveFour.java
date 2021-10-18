import java.util.Scanner;

/*IsConsecutiveFour class
 *Asks user for 2D Array of type int
 *Tells user if 2D Array input includes four consecutive equal values 
 *William Applegate
 *INFO-C210
*/
public class IsConsecutiveFour{

    /*input2DArray Method
     *Asks user to input array length, sublength, and assign element values
     *Checked if input valid, then returns 2D Array
    */
    private static int[][] input2DArray(){
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
        int[][] myArray = new int[rows][columns];
        
        //Instructions for assigning indecy values:
        System.out.println("Enter the elements for a 2D array with " + rows + " rows and " + columns + " columns: ");
        
        //Traverse myArray
        for (int m = 0; m < myArray.length; m++){
            for (int n = 0; n<myArray[m].length; n++){
                
                //Instruction per index:
                //System.out.println("Enter a value to array index: " + m + "," + n + "." );

                //If valid input recieved:
                if(in.hasNextInt()){ 
                    myArray[m][n] = in.nextInt();
                //If invalid input recieved:
                }else{
                    String badInput3 = in.next();
                    System.err.println("\"" + badInput3 + "\"" + " is an invalid input for element of two dimensional array at index: " + m + ", " + n);
                }
            }
        }
        in.close();    
        return myArray; //Return statement
    }
    
    /* isConsecutiveFour class
     * Takes int two dimensional array parameter
     * Checks if there are four consecutive numbers with same value, returns true or false
    */
    private static boolean isConsecutiveFour(int[][] values){

        //Initialize new int array with four indecies
        int[] array = new int[4];

        //Traverse values 2D array
        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < values[i].length; j++){

              /* Check if an array of length 4 is within bounds from current index
               * If so, assign values to array
               * Pass array to allNumbersEqual method to determine if array elements are the same
               */ 

                //Horizontal Array
                if(j < values[i].length - 3){
                    for(int k = 0; k < 4; k++){
                        array[k] = values[i][j+k];
                    }
                    if(allNumbersEqual(array)){
                        return true;
                    }
                }
                //Vertical Array
                if(i < values.length - 3){
                    for(int k = 0; k < 4; k++){
                        array[k] = values[i+k][j];
                    }
                    if(allNumbersEqual(array)){
                        return true;
                    }
                }
                //Diagonal Down Array
                if(i < values.length - 3 && j < values[i].length - 3){
                    for(int k = 0; k < 4; k++){
                        array[k] = values[i+k][j+k];
                    }
                    if(allNumbersEqual(array)){
                        return true;
                    }
                }
                //Diagonal Up Array  
                if(i > 2 && j < values[i].length - 3){
                    for(int k = 0; k < 4; k++){
                        array[k] = values[i-k][j+k];
                    }
                    if(allNumbersEqual(array)){
                        return true;
                    }
                }
            }
        }
        //If no array of 4 consecutive numbers with same value found, return false
        return false;
    }
    
    /* allNumbersEqual Method
     * Takes int array parameter
     * Checks if array has all equal elements or not, returns true of false
    */
    public static boolean allNumbersEqual(int[] inputArray){
        //Traverse array except last index:
        for(int i = 0; i < inputArray.length - 1; i++){
            //If current element is not equal to next element in array, return false
            if(inputArray[i] != inputArray[i+1]){
                return false;
            }
        }
        //If method has not returned yet, elements are equal, return true:
        return true; 
    }



    /*
     * Main Method
     * Get 2D array, check if there are 4 consecutive numbers of same value, output findings.
    */
        public static void main(String[] args){
        //Call method to get a 2D Array
        int[][] myArray = input2DArray();
        
        //Call boolean method to determine if there are four consecutive numbers, 
        //String answer depends on boolean return value:
        String answer = isConsecutiveFour(myArray) ? "True":"False";
        
        //Output per the instructions:
        System.out.println(answer);
    }

}