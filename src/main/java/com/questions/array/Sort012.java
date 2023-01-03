package com.questions.array;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Sort012 {
    public static void main(String[] args){
        //int[] array = {1,0,2,0,1,0,2,2};
        int[] array = {1,2,0,0,1,2,2,1,1,0,0};

        //Method 1 (Not Optimized): Search for 0,1,2 in the same order and store it in the temp array | TC-O(n^2) & SC-O(n)
       //array = Sort012.sort012Elements(array);

        //Method 2: Optimized way is to sort the 0's first then 1's and we do not required to sort 2's as it will be automatically gets sorted | TC-O(n) & SC-O(1)
        array = Sort012.sort012ElementsOptimized(array);
    }

    /**
     * Optimized solution
     * Method 2: Optimized way is to sort the 0's first then 1's and we do not required to sort 2's as it will be automatically gets sorted | TC-O(n) & SC-O(1)
     * @param array
     * @return
     */
    private static int[] sort012ElementsOptimized(int[] array) {
        int pos = 0;
        int temp = 0;
        // sort 0's first
        for(int i=pos;i<(array.length);i++){
            if(array[pos] == 0){
                pos++;
            }else{
                if(array[i] == 0){
                    temp = array[pos];
                    array[pos] = array[i];
                    array[i] = temp;
                    pos++;
                }
            }
        }

        //sort 1's then
        for(int i=pos;i<(array.length);i++){
            if(array[pos] == 1){
                pos++;
            }else{
                if(array[i] == 1){
                    temp = array[pos];
                    array[pos] = array[i];
                    array[i] = temp;
                    pos++;
                }
            }
        }

        //sort 2's then
        for(int i=pos;i<(array.length);i++){
            if(array[pos] == 2){
                pos++;
            }else{
                if(array[i] == 2){
                    temp = array[pos];
                    array[pos] = array[i];
                    array[i] = temp;
                    pos++;
                }
            }
        }

        return array;
    }

    private static int[] sort012Elements(int[] array) {
        int[] tempArray = new int[array.length];
        AtomicInteger count = new AtomicInteger();

        Arrays.stream(array).forEach(value -> {
            if(value == 0){
                tempArray[count.get()] = value;
                count.getAndIncrement();
            }
        });

        Arrays.stream(array).forEach(value -> {
            if(value == 1){
                tempArray[count.get()] = value;
                count.getAndIncrement();
            }
        });

        Arrays.stream(array).forEach(value -> {
            if(value == 2){
                tempArray[count.get()] = value;
                count.getAndIncrement();
            }
        });

        return tempArray;
    }



}
