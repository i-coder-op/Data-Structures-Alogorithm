package com.questions.array;

import java.util.Arrays;
import java.util.HashSet;

public class UnionAndIntersection {
    public static void main(String[] args){
        int[] array1 = {85, 25, 1, 32, 54, 6};
        int[] array2 = {85, 2, 95};

        int unionCount = 0;

        if(array1.length > array2.length){
            unionCount = array1.length;
        }else{
            unionCount = array2.length;
        }

        //Method 1(Not Optimized): search the small array elements in the big array | TC-O(n^2) | SC-O(1)
        unionCount = UnionAndIntersection.getUnion(array1,array2,unionCount);
        unionCount = 0;
        //Method 2(Optimized): Using Hashset we can achieve the solution | TC-O((n+m)log(n+m)) | SC-O(n+m)
        unionCount = UnionAndIntersection.getUnionUsingSet(array1,array2);
    }

    private static int getUnionUsingSet(int[] array1, int[] array2) {
        HashSet<Integer> unionSet = new HashSet<>();

        Arrays.stream(array1).forEach(value -> {
            unionSet.add(value);
        });

        Arrays.stream(array2).forEach(value -> {
            unionSet.add(value);
        });

        return unionSet.size();
    }

    private static int getUnion(int[] array1, int[] array2, int unionCount) {
        if(unionCount == array1.length){
            unionCount = processArray(array1,array2,unionCount);
        }else{
            unionCount = processArray(array2,array1,unionCount);
        }
        return unionCount;
    }

    private static int processArray(int[] bigArray, int[] smallArray, int unionCount) {
        for(int i=0;i<smallArray.length;i++){
            int count = 0;
            for(int j=0;j< bigArray.length;j++){
                if(smallArray[i] == bigArray[j]){
                    count++;
                }
            }
            if(count == 0)
                unionCount++;
        }
        return unionCount;
    }
}
