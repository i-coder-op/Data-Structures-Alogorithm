package twopointers;


import java.util.*;

public class FirstStringOccurance {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(7);
        pq.add(1);
            System.out.println(pq);
//        strStr("hello", "ll");
        }
        public static int strStr (String haystack, String needle){
            int i = 0;
            int j = 0;
            String temp = "";

            if (needle.length() > haystack.length()) {
                return -1;
            }

            while (i < haystack.length() && j < haystack.length()) {
                temp = temp.concat(String.valueOf(haystack.charAt(j)));
                if (temp.length() == needle.length()) {
                    if (temp.equals(needle)) {
                        return i;
                    } else {
                        temp = temp.substring(1);
                        i++;
                        j++;
                    }
                } else {
                    j++;
                }

            }

            return -1;
        }
    }
