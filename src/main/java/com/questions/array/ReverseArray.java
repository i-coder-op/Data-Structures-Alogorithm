package com.questions.array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        ReverseArray.printArray(array, "before");
        System.out.println("");
        //method to reverse array
        array = ReverseArray.reverseArray(array, 0, (array.length-1));
        ReverseArray.printArray(array, "after");
    }

    private static int[] reverseArray(int[] array, int firstIndex, int lastIndex) {
        int localStorage = 0;
        for(int i = lastIndex; i>firstIndex; i--){
            localStorage = array[firstIndex];
            array[firstIndex] = array[i];
            array[i] = localStorage;
            firstIndex++;
        }
        return array;
    }

    private static void printArray(int[] array, String when) {
        System.out.println("Array " + when + " reverse");
        Arrays.stream(array).forEach(value -> {
            System.out.print(value);
        });
    }
}
