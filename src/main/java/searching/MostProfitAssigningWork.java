package searching;

import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssigningWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int result = 0;

        // Create pairs of difficulty and profit and sort by difficulty
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        // Sort workers
        Arrays.sort(worker);

        // Max profit so far
        int[] maxProfit = new int[n];
        maxProfit[0] = jobs[0][1];
        for (int i = 1; i < n; i++) {
            maxProfit[i] = Math.max(maxProfit[i - 1], jobs[i][1]);
        }

        // Allocate jobs to workers
        for (int w : worker) {
            int jobIndex = binarySearch(jobs, w);
            if (jobIndex != -1) {
                result += maxProfit[jobIndex];
            }
        }

        return result;
    }

    // Binary search to find the highest index where difficulty <= worker's ability
    private int binarySearch(int[][] jobs, int target) {
        int low = 0;
        int high = jobs.length - 1;

        if (jobs[high][0] <= target) {
            return high;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid][0] <= target && (mid == jobs.length - 1 || jobs[mid + 1][0] > target)) {
                return mid;
            } else if (jobs[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MostProfitAssigningWork solution = new MostProfitAssigningWork();
        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};

        System.out.println(solution.maxProfitAssignment(difficulty, profit, worker));  // Output
    }
}

