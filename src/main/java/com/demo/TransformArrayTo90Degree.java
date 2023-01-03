package com.demo;

import java.util.Arrays;

public class TransformArrayTo90Degree {
    public static void main(String[] args){
        int demoArray[][] = {{1,2,3}, {4,5,6}, {7,8}};
        Arrays.stream(demoArray).forEach(ints -> {
            Arrays.stream(ints).forEach(value -> {
                System.out.print(value);
            });
        });
        demoArray = TransformArrayTo90Degree.transform(demoArray);
        System.out.println("-------");
        Arrays.stream(demoArray).forEach(ints -> {
            Arrays.stream(ints).forEach(value -> {
                System.out.print(value);
            });
        });
    }

    /**
     * This method will transform the 2D array into 90 degree
     * @param demoArray
     * @return
     */
    private static int[][] transform(int[][] demoArray) {
        int demoArraySize = demoArray.length;
        int transformedArray[][] = new int[demoArraySize][demoArraySize];
        for(int i = (demoArraySize-1), k=0; i>=0; i--){
            for (int j = 0; j<demoArray[i].length; j++){ // j=0,k=1
                transformedArray[j][k] = demoArray[i][j];
            }
            k++;
        }
        return transformedArray;
    }
}
