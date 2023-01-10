package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * This pattern will be used to solve any subsequences problem using recursion and will be very useful in the dynamic programming as well.
 * Pattern:
 * 1. Take
 * add element to list
 * call method with index+1 recursively
 * 2. Not take
 * remove the (size-1) element from list
 * call method with index+1 recursively
 */
public class ArraySubsequencesUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        List<Integer> list = new ArrayList<>();
        arraySubsequence(0, arr, list, arr.length);
    }

    /**
     * This method will be responsible to print the subsequences using recursion
     * @param index
     * @param arr
     * @param list
     * @param n
     */
    private static void arraySubsequence(int index, int[] arr, List<Integer> list, int n) {
        if(index == n){
            //It prints the subsequences once the index reaches the size of the array
            System.out.println("");
            list.stream().forEach(integer -> System.out.print(integer + " "));
            return;
        }
        //Take element into consideration - add it to the list and call the function for next index
        list.add(arr[index]);
        arraySubsequence(index+1, arr, list, n);

        //Do not Take element into consideration - remove it from the list and call the function for next index
        list.remove(list.size()-1);
        arraySubsequence(index+1, arr, list, n);
    }
}
