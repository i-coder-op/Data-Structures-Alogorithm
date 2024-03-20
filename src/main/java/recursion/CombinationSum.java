package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination sum with subset
 */
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        return solve(candidates, new ArrayList<>(), target, 0, 0, list);
    }

    private static List<List<Integer>> solve(int[] candidates, List<Integer> output, int target, int index, int sum, List<List<Integer>> list) {
        //Base Condition
        if (sum == target) {
            if (!list.contains(output)) {
                list.add(output);
            }
            return list;
        } else if (sum > target || index >= candidates.length) {
            return list;
        }

        //Induction
        if (output.isEmpty()) {
            List<Integer> newOutput = new ArrayList<>();
            newOutput.addAll(output);
            newOutput.add(candidates[index]);
            solve(candidates, newOutput, target, index + 1, sum + candidates[index], list);
            solve(candidates, output, target, index + 1, sum, list);
        } else {

            List<Integer> newOutput = new ArrayList<>();
            newOutput.addAll(output);
            newOutput.add(candidates[index - 1]);
            solve(candidates, newOutput, target, index, sum + candidates[index - 1], list);

            List<Integer> newOutput1 = new ArrayList<>();
            newOutput1.addAll(output);
            newOutput1.add(candidates[index]);
            solve(candidates, newOutput1, target, index + 1, sum + candidates[index], list);
            solve(candidates, output, target, index+1, sum, list);
        }
        return list;
    }
}
