package com.questions.array;

import java.util.Scanner;

public class KthMaxMinElement {
    public static void main(String[] args){
        int[] array = {100,115,112,7,8,1000,0,1131,1};

        // get the input from user for the kth element
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.next());

        //Method 1: using comparison approach with TC-O(n)
        KthMaxMinElement.getKthMinMaxElement(array, k);
    }

    /**
     *
     * @param array
     * @param k
     */
    private static void getKthMinMaxElement(int[] array, int k) {
        int minElement = 0;
        int maxElement = 0;
        array = KthMaxMinElement.sortArray(array);

    }

    private static int[] sortArray(int[] array) {

        for(int i=0;i< array.length;i++){
            int temp = array[i];
            for(int j=i; j< array.length;j++){
                if(array[i]>array[j]){
                    array[i] = array[j];
                    array[j] = temp;
                    temp = array[i];
                }
            }
        }
        return array;
    }
}
