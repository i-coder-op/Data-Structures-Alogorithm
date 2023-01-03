package com.questions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateArrayByOne {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6};
        int size = array.length;
        //Method 1: Using reversal algorithm
        RotateArrayByOne.rotate(array, size);

    }

    public static void rotate(int array[], int size)
    {
        int rotateBy = 1;

        //using reversal algorithm

        //reverse the first part of the array
        array = RotateArrayByOne.reverse(array, size-2);

        //reverse whole array
        array = RotateArrayByOne.reverse(array, size-1);

        for(int element : array)
            System.out.print(element);
    }

    public static int[] reverse(int[] array, int size){
        int left = 0;
        int right = size;
        int temp = 0;

        while(left < right){
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return array;
    }
}







