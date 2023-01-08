package recursion;

import java.util.Arrays;

public class ReverseArrayUsingRecursion {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int i = 0;
        int j = array.length-1;
        reverseArray(i, j, array);
    }

    /**
     * This method will reverse an array using recursion
     * @param i
     * @param j
     * @param array
     */
    private static void reverseArray(int i, int j, int[] array) {
        if(i > j || i == j){
            //Print the values
            Arrays.stream(array).forEach(value -> System.out.print(value + " "));
        }else{
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            reverseArray(i+1, j-1, array);
        }
    }
}
