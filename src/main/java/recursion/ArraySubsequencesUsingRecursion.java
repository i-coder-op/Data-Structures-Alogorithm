package recursion;

import java.util.ArrayList;
import java.util.List;

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
        if(index >= n){
            System.out.println("");
            list.stream().forEach(integer -> System.out.print(integer + " "));
            return;
        }
        list.add(arr[index]);
        arraySubsequence(index+1, arr, list, n);
        list.remove(arr[index]);
        arraySubsequence(index+1, arr, list, n);
    }
}
