package com.questions.array;

import java.util.Arrays;

public class StartsWithNumber {
    public static void main(String[] args) {
        int[] array = {12, 41, 22, 21, 24, 1, 2, 5};
        Arrays.stream(array).filter(value -> String.valueOf(value).startsWith("2")).forEachOrdered(value -> {
            System.out.println(value);
        });

    }
}
