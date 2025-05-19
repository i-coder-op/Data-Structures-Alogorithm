package stack.questions;

import java.util.*;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    static final int mod = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] nse = new int[n];
        int[] pse = new int[n];

        Arrays.fill(nse, n);
        Arrays.fill(pse, -1);

        Stack<Integer> stack = new Stack<>();

        // Next Smaller Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack = new Stack<>();

        // Previous Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                pse[stack.pop()] = i;
            }
            stack.push(i);
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            long leftCount = (i - pse[i]);
            long rightCount = (nse[i] - i);
            System.out.println("left count: " + leftCount);
            System.out.println("right count: " + rightCount);
            long contribution = (leftCount * rightCount % mod) * arr[i] % mod;
            result = (result + contribution) % mod;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {11,81, 94, 43,3};
        System.out.println(sol.sumSubarrayMins(arr)); // Correctly expected output: 126
    }
}
