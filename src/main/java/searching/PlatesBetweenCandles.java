package searching;

import java.util.*;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] prefixSumArr = new int[s.length()];
        List<Integer> candles = new ArrayList<>();

        // Identify positions of candles and calculate prefix sums
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                candles.add(i);
            } else {
                prefixSumArr[i] = 1;
            }
        }

        // Calculate prefix sum array
        for (int i = 1; i < prefixSumArr.length; i++) {
            prefixSumArr[i] += prefixSumArr[i - 1];
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            // Find the first candle to the right of start
            int lowerBound = Collections.binarySearch(candles, start);
            if (lowerBound < 0) {
                lowerBound = -lowerBound - 1;
            }
            if (lowerBound >= candles.size()) {
                result[i] = 0;
                continue;
            }
            // Find the last candle to the left of end
            int upperBound = Collections.binarySearch(candles, end);
            if (upperBound < 0) {
                upperBound = -upperBound - 2;
            }
            if (upperBound < 0 || upperBound < lowerBound) {
                result[i] = 0;
                continue;
            }
            // Ensure the upperBound points to the actual candle position
            while (upperBound < candles.size() - 1 && candles.get(upperBound + 1) <= end) {
                upperBound++;
            }
            // Calculate the number of plates between these candles
            result[i] = prefixSumArr[candles.get(upperBound)] - (lowerBound > 0 ? prefixSumArr[candles.get(lowerBound - 1)] : 0);
        }

        return result;
    }

    public static void main(String[] args) {
        PlatesBetweenCandles solution = new PlatesBetweenCandles();
        String s = "|**|*|*";
        int[][] queries = {{1, 6}, {0, 4}};
        int[] result = solution.platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(result));  // Output should be [2, 2]
    }
}

