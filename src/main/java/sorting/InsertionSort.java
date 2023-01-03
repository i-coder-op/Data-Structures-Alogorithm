package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
        int[] unSortedArray = {10,2,3,14,7,8};

        InsertionSort.sort(unSortedArray);
    }

    /**
     * Insertion Sort Algorithm
     * This method will be responsible to sort array elements using insertion sort algorithm
     * @param unSortedArray
     */
    private static void sort(int[] unSortedArray) {
        for(int i=1;i< unSortedArray.length;i++){
            int pickedElement = unSortedArray[i];
            int j = i-1;
            while(j>=0){
                if(unSortedArray[j] > pickedElement){
                    unSortedArray[j+1] = unSortedArray[j];
                }else{
                    break;
                }
                j--;
            }
            unSortedArray[j+1] = pickedElement;
        }

        Arrays.stream(unSortedArray).forEach(value -> System.out.println(value + " "));
    }
}
