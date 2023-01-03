package com.questions.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxDuplicates {
    public static void main(String[] args) {
        int[] intArray = new int[] { 1, 2, 2, 2, 1, 2, 4, 4, 1, 1, 1, 1, 2, 2 };
        Map<Integer, Integer> map = new HashMap<>();

        AtomicInteger currentGreater = new AtomicInteger(0);
        Arrays.stream(intArray).forEachOrdered(element -> {
            if(!map.containsKey(element)){
                map.put(element, 1);
            }else{
                map.put(element, map.get(element)+1);
                if((map.get(element)) > currentGreater.get()){
                    currentGreater.set(map.get(element));
                }
            }
        });

        for (Map.Entry entry : map.entrySet()){
            if((Integer)currentGreater.get() == entry.getValue())
                System.out.println(entry.getKey() + "==>" + entry.getValue());
        }
    }
}
