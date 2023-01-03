package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] array = {10,4,7,2,12,1,9};
        mergeSort(array, 0,array.length-1);
        Arrays.stream(array).forEach(value -> System.out.println(value + " "));
    }

    /**
     * Merge Sort Algorithm
     * @param array
     * @param left
     * @param right
     */
    private static void mergeSort(int[] array, int left, int right) {
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge2SortedArray(array, left, mid, right);
        }
    }

    /**
     * This method will merge two sorted arrays
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    private static void merge2SortedArray(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = left;
        int[] tempArray = new int[right+1];

        while(i<=mid && j<=right){
            if(array[i] < array[j]){
                tempArray[k] = array[i];
                i++;
            }else{
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }
        if(i > mid){
            while(j<=right){
                tempArray[k] = array[j];
                j++;
                k++;
            }
        }else{
            while(i<=mid){
                tempArray[k] = array[i];
                i++;
                k++;
            }
        }

        for(k=left;k<=right;k++){
            array[k] = tempArray[k];
        }
    }
}
