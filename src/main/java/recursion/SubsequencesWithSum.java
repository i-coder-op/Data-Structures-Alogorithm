package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesWithSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int expectedSum = 2;
        int actualSum = 0;
        List<Integer> list = new ArrayList<>();
        printSubsequencesWithSum(0, arr, list, actualSum, expectedSum);
    }

    /**
     * This method will be used to print the subsequences with expected sum
     * @param index
     * @param arr
     * @param actualSum
     * @param expectedSum
     */
    private static void printSubsequencesWithSum(int index, int[] arr, List<Integer> list, int actualSum, int expectedSum) {

        if(index == arr.length){
            if(expectedSum == actualSum){
                System.out.println("");
                list.stream().forEach(integer -> System.out.print(integer + " "));
                return;
            }
            return;
        }

        //Take condition - take element into the consideration
        list.add(arr[index]);
        actualSum += arr[index];
        printSubsequencesWithSum(index+1, arr, list, actualSum, expectedSum);

        //Not take condition - do not take the element into consideration
        list.remove(list.size()-1);
        actualSum -= arr[index];
        printSubsequencesWithSum(index+1, arr, list, actualSum, expectedSum);
    }
}
