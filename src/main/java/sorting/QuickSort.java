package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int[] unsortedArray = {10,3,7,2,1,0,4};
        int low = 0;
        int high = unsortedArray.length-1;
        quickSort(unsortedArray, low, high);
        Arrays.stream(unsortedArray).forEach(value -> System.out.println(value + " "));
    }

    /**
     * Quick sort algorithm | TC - O(nlogn)[Best] & O(n2)[Worst], SC - O(n)
     * @param low
     * @param high
     */
    private static void quickSort(int[] unsortedArray, int low, int high) {
        if(low < high){
            int pivot = partitioning(unsortedArray, low, high);
            quickSort(unsortedArray, low, pivot-1);
            quickSort(unsortedArray, pivot+1, high);
        }
    }

    /**
     * This method is responsible to perform partitioning and return pivot element
     * @param low
     * @param high
     * @return
     */
    private static int partitioning(int[] unsortedArray, int low, int high) {
        int pivot = unsortedArray[low];
        int i = low;
        int j = high;
        while(i<j){
            // ye loop chalega jab tk i pivot se bada ni hota
            while(i<unsortedArray.length && unsortedArray[i]<=pivot){
                i++;
            }
            // ye loop chalega jab tk j pivot se chota ni hota
            while(j>=0 && unsortedArray[j]>pivot){
                j--;
            }
            if(i<j){
               //perform swapping
                int temp = unsortedArray[i];
                unsortedArray[i] = unsortedArray[j];
                unsortedArray[j] = temp;
            }
        }
        //perform swapping jab bhi j ki value i se choti ho (j<i)
        int temp = unsortedArray[j];
        unsortedArray[j] = pivot;
        unsortedArray[low] = temp;
        return j;
    }
}

