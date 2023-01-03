package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        int[] unSortedArray = {4,2,1,7,8,6,0,3,5};
        SelectionSort.sort(unSortedArray);
    }

    /**
     * Selection Sort Algorithm | TC-O(n2) | SC-O(1)
     * This method will be responsible to sort array element using selection sort
     * @param unSortedArray
     */
    private static void sort(int[] unSortedArray) {
        for(int i=0;i< unSortedArray.length;i++){
            int minIndex = i;
            for(int j=i+1;j<unSortedArray.length;j++){
                if(unSortedArray[j] < unSortedArray[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex > i){
                int temp = unSortedArray[i];
                unSortedArray[i] = unSortedArray[minIndex];
                unSortedArray[minIndex] = temp;
            }
        }

        Arrays.stream(unSortedArray).forEach(value -> System.out.println(value + " "));
    }
}
