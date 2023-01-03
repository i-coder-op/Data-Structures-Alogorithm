package com.questions.array;

import java.util.Arrays;

public class MinMaxElement {
    public static void main(String[] args){
        int[] array = {100,115,112,7,8,1000,0,1131,1};

        //Method 1: Using inbuilt sort(Internally Quick Sort) method of Arrays class
        MinMaxElement.getMinMaxUsingArraysSort(array);

        System.out.println("-------------------------------------------");

        //Method 2: Using comparison by iterating array element two times which make TC-O(n^2) & SC-O(n)
        MinMaxElement.getMinMaxElement(array);

        System.out.println("-------------------------------------------");

        //Method 3: Using single array and in one iteration to get min and max element | TC-O(n) & SC-O(1)
        MinMaxElement.getMinMaxElementOptimized(array);
    }

    /**
     * Method 3: Using single array and in one iteration to get min and max element | TC-O(n), SC-O(1)
     * @param array
     */
    private static void getMinMaxElementOptimized(int[] array) {
        int minElement = 0;
        int maxElement = 0;
        for(int i=0;i< array.length-1;i++){
            int tempMinElement = 0;
            int tempMaxElement = 0;
            if(array[i] > array[i+1]){
                tempMaxElement = array[i];
                tempMinElement = array[i+1];
            }else{
                tempMaxElement = array[i+1];
                tempMinElement = array[i];
            }
            if(i==0){
                minElement = tempMinElement;
                maxElement = tempMaxElement;
            }else{
                if(tempMaxElement > maxElement){
                    maxElement = tempMaxElement;
                }
                if(tempMinElement < minElement){
                    minElement = tempMinElement;
                }
            }
        }
        System.out.println("Max Element: " + maxElement);
        System.out.println("Min Element: " + minElement);
    }

    /**
     * Method 2: Using elements comparison
     * @param array
     */
    private static void getMinMaxElement(int[] array) {
        int minElement = 0;
        int maxElement = 0;

        maxElement = array[0];
        for(int i = 1;i< array.length;i++){
            if(maxElement > array[i])
                maxElement = maxElement;
            else
                maxElement = array[i];

        }
        System.out.println("Max Element: " + maxElement);

        minElement = array[0];
        for(int i = 1;i< array.length;i++){
            if(minElement < array[i])
                minElement = minElement;
            else
                minElement = array[i];
        }
        System.out.println("Min Element: " + minElement);
    }

    /**
     * //Method 1: Using inbuilt sort(Internally Quick Sort) method of Arrays class
     * @param array
     */
    private static void getMinMaxUsingArraysSort(int[] array) {
        Arrays.sort(array);
        System.out.println("Minimum Element: " + array[0]);
        System.out.println("Maximum Element: " + array[array.length-1]);
    }
}
