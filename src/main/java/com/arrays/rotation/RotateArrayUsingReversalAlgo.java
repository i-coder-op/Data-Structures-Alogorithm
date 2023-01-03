package com.arrays.rotation;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArrayUsingReversalAlgo {
    public static void main(String[] args){
        // array declaration & initialization
        int[] array = {1,2,3,4,5,6,7,8,9,10};

        System.out.print("Enter the number by how many elements array should be rotated: ");
        // Take the input from user by how many elements they want to rotate
        Scanner sc = new Scanner(System.in);
        int rotateBy = Integer.parseInt(sc.next());

        array = RotateArrayUsingReversalAlgo.rotateArray(array, rotateBy);
    }

    /**
     * This method will break the arrays into the sets and then reverse each set combine them again reverse it, TM-O(n), SC-O(1)
     * @param array
     * @param rotateBy
     * @return
     */
    private static int[] rotateArray(int[] array, int rotateBy) {
        array = reverse(array, 0, (rotateBy-1));
        System.out.println("First Part Reversal: ");
        Arrays.stream(array).forEach(value -> {
            System.out.print(value);
        });

        System.out.println("");

        array = reverse(array, rotateBy, (array.length-1));
        System.out.println("Second Part Reversal: ");
        Arrays.stream(array).forEach(value -> {
            System.out.print(value);
        });

        System.out.println("");

        array = reverse(array, 0, (array.length-1));
        System.out.println("Whole Array Reversal: ");
        Arrays.stream(array).forEach(value -> {
            System.out.print(value);
        });

        return array;
    }

    private static int[] reverse(int[] array, int firstIndex, int lastIndex) {
        for(int i = lastIndex;i>firstIndex;i--){
            int temp = array[firstIndex];
            array[firstIndex] = array[i];
            array[i] = temp;
            firstIndex++;
        }
        return array;
    }
}
