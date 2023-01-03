package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] unSortedArray = {4,2,1,7,8,6};

        BubbleSort.sort(unSortedArray);
    }

    /**
     * Bubble Sort Algorithm
     * This method is responsible to perform bubble | TC-O(n2) & SC-O(1)
     * @param unSortedArray
     */
    private static void sort(int[] unSortedArray) {
        for(int i=0;i<unSortedArray.length;i++){
            for(int j=0;j<(unSortedArray.length - 1 - i);j++){
                if(unSortedArray[j] > unSortedArray[j+1]){
                    //Perform swapping
                    int temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[j+1];
                    unSortedArray[j+1] = temp;
                }
            }
        }

        Arrays.stream(unSortedArray).forEach(value -> System.out.println(value + " "));
    }
}
