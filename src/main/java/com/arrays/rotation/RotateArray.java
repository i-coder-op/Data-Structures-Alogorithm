package com.arrays.rotation;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args){
        //array declaration & initialization
        int[] array = {1,2,3,4,5,6,7};

        System.out.print("Enter the number to rotate array by that number: ");
        // Taking the inputs from cmd
        Scanner scanner = new Scanner(System.in);
        int rotateBy = Integer.parseInt(scanner.next());

        System.out.println("Array before rotation");
        Arrays.stream(array).forEach(value -> {
            System.out.print(value);
        });

        System.out.println("");

        // This is method-1 using temp array with single for loop and TC-O(n) SC-O(rotateBy)
        //array = RotateArray.rotateArrayByInputPassed(array, rotateBy);

        array = RotateArray.rotateArrayByInputPassedUsingSingleArray(array, rotateBy);

        System.out.println("Array after rotation");
        Arrays.stream(array).forEach(value -> {
            System.out.print(value);
        });
    }

    /**
     * This method will rotate the array using single array and a localStorage using nested loop TC-O(n*rotateBy) & SC-O(1)
     * @param array
     * @param rotateBy
     * @return array
     */
    private static int[] rotateArrayByInputPassedUsingSingleArray(int[] array, int rotateBy) {
        int localStorage = 0;

        for(int i=0;i<rotateBy;i++){
            for(int j=0;j<array.length;j++){
                if(i<rotateBy && j == 0)
                    localStorage = array[j];
                else{
                    array[j-1] = array[j];
                    if(j == (array.length-1))
                        array[j] = localStorage;
                }

            }
        }

        return array;
    }

    /**
     * This is method-1 using temp array with single for loop and TC-O(n) SC-O(rotateBy)
     * @param array
     * @param rotateBy
     * @return array
     */
    private static int[] rotateArrayByInputPassed(int[] array, int rotateBy) {
        int[] tempArray = new int[array.length];
        int count = 0;

        for(int i=0;i<array.length;i++){
           if(i < rotateBy) {
               tempArray[i] = array[i];
               array[i] = 0;
           } else{
               array[i-rotateBy] = array[i];
               array[i] = 0;
               if((array.length - i) <= rotateBy){
                   array[i] = tempArray[count];
                   count++;
               }
           }
        }
        return array;
    }

}
