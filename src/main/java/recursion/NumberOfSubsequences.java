package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Print how many number of subsequences can be possible using recursion
 * Use take/not take pattern
 */
public class NumberOfSubsequences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        int sequenceCount = printCountOfSubsequences(0, arr, list);
        System.out.println("No of subsequences count: " + sequenceCount);
    }

    /**
     * This method will print count of sequences possible using take/not-take patter
     * @param index
     * @param arr
     * @param list
     */
    private static int printCountOfSubsequences(int index, int[] arr, List<Integer> list) {
        if(index == arr.length){
            System.out.println(" ");
            list.stream().forEach(integer -> System.out.print(integer + " " ));
            return 1;
        }
        list.add(arr[index]);
        int take = printCountOfSubsequences(index+1, arr, list);
        list.remove(list.size()-1);
        int notTake = printCountOfSubsequences(index+1, arr, list);
        return take + notTake;
    }
}
