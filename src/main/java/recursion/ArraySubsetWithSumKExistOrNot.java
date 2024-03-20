package recursion;

import java.util.*;

public class ArraySubsetWithSumKExistOrNot {

    public static void main(String[] args) {
        int n = 94;
        int k = 84;
        int[] a = {22, 17, 19, 46, 48, 27, 22, 39, 20, 13, 18, 50, 36, 45, 4, 12, 23, 34, 24, 15, 42, 12, 4, 19, 48, 45, 13, 8, 38, 10, 24, 42, 30, 29, 17, 36, 41, 43, 39, 7, 41, 43, 15, 49, 47, 6, 41, 30, 21, 1, 7, 2, 44, 49, 30, 24, 35, 5, 7, 41, 17, 27, 32, 9, 45, 40, 27, 24, 38, 39, 19, 33, 30, 42, 34, 16, 40, 9, 5, 31, 28, 7, 24, 37, 22, 46, 25, 23, 21, 30, 28, 24, 48, 13};
        System.out.println(isSubsetPresent(n, k, a));
    }

    public static boolean isSubsetPresent(int n, int k, int[] a) {
        // Write your code here
        boolean isPresent = checkIsPresent(0, k, a, 0);
        return isPresent;
    }

    private static boolean checkIsPresent(int sum, int k, int[] a, int i) {
        if (k == sum) {
            return true;
        } else if (sum > k || i >= a.length) {
            return false;
        }
        return checkIsPresent(sum + a[i], k, a, i + 1) || checkIsPresent(sum, k, a, i + 1);
    }
}
