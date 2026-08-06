
public class TwoDArray
{
/**
 * Given a 2D array String[][] words = {{"a", "b", "c"},
 *                                      {"d", "e", "f"}}
 */

    public static void words()
    {
        String[][] words = {{"a", "b", "c"},
                           {"d", "e", "f"}};

        // for (int i = 0; i < words.length; i++)
        // {
        //     for (int j = 0; j < words[i].length; j++)
        //     {
        //         System.out.println(words[i][j]); // Prints a b c d e f
        //     }
        // }

        //print one column at a time
        for (int i = 0; i < words[0].length; i++)
        {
            for (int j = 0; j < words.length; j++)
            {                
                System.out.print(words[j][i] + " ");
                
            }
        }
    }

    /**
     * Print the following output
     * Col:    0   1   1
     * Row 0:  a   b   c
     * Row 1:  e   f   g
     */

    public static void printTable()
    {
        String[][] table = {{"a", "b", "c",},
                            {"d", "e", "f"},
                            {"g", "h", "i"}};
                            
        System.out.print("Cols: \t");
        for (int k = 0; k < table[0].length; k++)
        {
            System.out.print(k + "\t");
        }

        System.out.print("\n");

        for (int i = 0; i < table.length; i++)
        {
            System.out.print("Row " + i + ":\t");

            for (int j = 0; j < table[i].length; j++)
            {
                System.out.print(table[i][j] + "\t");
            }

            System.out.println();
        }
    }

    public static void arrayOrder()
    {
        double[][] doubleValues = {{1.5, 2.6, 3.7}, {7.5, 6.4, 5.3}, {9.8,  8.7, 7.6}, {3.6, 5.7, 7.8}};

        //Row major order: Prints out the rows underneath or next to each other
        for (int i = 0; i < doubleValues.length; i++)
        {
            for (int j = 0; j < doubleValues[i].length; j++)
            {
                System.out.print(doubleValues[i][j] + "\t");
            }

            System.out.println();
        }

        // //Column major order: Prints out the columns underneath or next to each other
        for (int i = 0; i < doubleValues[0].length; i++)
        {
            for (int j = 0; j < doubleValues.length; j++)
            {
                System.out.print(doubleValues[j][i] + "\t");
            }

            System.out.println();
        }
    }

    /**
     * Write an int method countPositives that takes an int parameter 2D array
     * and returns number of positive integers 
     * 
     */
    public static int countPositives(int[][] array)
    {
        int count = 0;
    
        //loop through array
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[0].length; j++)
            {
                if (array[i][j] > 0 )
                {
                    count++;
                }
            }
        }
        //return count of positive integers
        return count;
    }

    /*
     * print avg of each row at the end
     */
    public static void avgArray(int[][] array)
    {
        //Column heading
        System.out.print("Cols: \t");
        for (int k = 0; k < array[0].length; k++)
        {
            System.out.print(k + "\t");
        }

        System.out.print("AVERAGE\n");

        for (int i = 0; i < array.length; i++)
        {
            System.out.print("Row " + i + ":\t");
            double sum = 0;
            for (int j = 0; j < array[0].length; j++)
            {
                System.out.print(array[i][j] + "\t");
                sum += array[i][j]; //get sum
            }

            double avg = sum / array[i].length;
            System.out.println(avg);

        }
    }

    /**
     * 
     * write an int method that takes a 2d array of double and returns the index of row
     * with largest sum
     */
    public static int findLargestRow(double[][] array)
    {
        int index = 0;
        double largestSum = Double.MIN_VALUE; //stores smallest double


        for (int i = 0; i < array.length; i++)
        {
            double sum = 0; //temporary value to hold sum 
            for (int j = 0; j < array[i].length; j++)
            {
                sum += array[i][j];
                
            }

            if (sum > largestSum)
            {
                index = i; //i is the row
                largestSum = sum;
            }
        }

        return index;
    }

    /**
        Write an int method which has a square 2d array of ints as a parameter and returns
        the product of the main diagonal. The main diagonal is the entry where row == column    
    */
    public static int productDiagonal(int[][] array)
    {
        int product = 1; 
         
        for (int i = 0; i < array.length; i++)
        {
            product *= array[i][i];
        }

        return product;
    }

    /**
     * 
     * 
     */
    public static int countIsolatedZeros(int[][] array)
    {
        int count = 0;

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                if (array[i][j] == 0)
                {
                    boolean hasNeighbour = false;
                    //up
                    if (isValid(array, i-1, j) && array[i - 1][j] == 0)
                    {
                        hasNeighbour = true;
                    }
                    //down 
                    if (array[i + 1][j] == 0)
                    {
                        hasNeighbour = true;
                    }

                    //left
                    if (array[i][j - 1] == 0)
                    {
                        hasNeighbour = true;
                    }

                    //right
                    if (array[i][j + 1] == 0)
                    {
                        hasNeighbour = true;
                    }

                }
            }
        }

        return count;
    }

    private static boolean isValid(int[][] array, int row, int col)
    {
        return row >= 0 && row < array.length 
            && col >= 0 && col < array[row].length;
    }

    public static double[] findRowAverage(double[][] arr)
    { 
        double[] rowAvg = new double[arr.length];

        for (int i = 0; i < arr.length; i++)
        {
            double rowSum = 0;
            for (int j = 0; j < arr[i].length; j++)
            {
                rowSum += arr[i][j];
            }

            rowAvg[i] = rowSum / arr[i].length;
        }

        return rowAvg;
    }

    public static void main(String[] args) {
        //printTable();
        //arrayOrder();
        double[][] arr = {{1.1, 2.2, 3.3},{4.4, 5.5, 6.6, 7.7},{8.8, 9.9}};
        double[] averages = findRowAverage(arr);

        for (double avg : averages) 
        {
            System.out.println(avg);
        }
     }

     public static void rollRight(int[] arr)
     {
        int temp = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--)
        {
            arr[i] = arr[i - 1];
        }

        arr[0] = temp;
     }
 
}