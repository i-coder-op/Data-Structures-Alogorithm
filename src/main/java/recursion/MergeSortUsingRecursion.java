package recursion;

import java.util.ArrayList;
import java.util.List;

public class MergeSortUsingRecursion {
    public static void main (String[] args) {
        int[] arr = {20,1,4,2,45,0};
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println("\nAfter Sorting");
        mergeSort(arr, 0, arr.length-1);
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low == high){
            return;
        }

        int mid = (low+high)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, mid+1, high);
    }

    public static void merge(int[] arr, int low1, int high1, int low2, int high2){
        List<Integer> tempList = new ArrayList<>();
        int p1 = low1;
        int p2 = low2;

        while(p1<=high1 && p2<=high2){
            if(arr[p1] < arr[p2]){
                tempList.add(arr[p1]);
                p1++;
            }else{
                tempList.add(arr[p2]);
                p2++;
            }
        }

        //Now we need to copy the remaining elements in the array

        if(p2>high2){
            while(p1<=high1){
                tempList.add(arr[p1]);
                p1++;
            }
        }else{
            while(p2<=high2){
                tempList.add(arr[p2]);
                p2++;
            }
        }

        for (Integer i : tempList){
            arr[low1] = i;
            low1++;
        }
    }
}
