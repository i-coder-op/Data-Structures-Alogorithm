package recursion;

import java.util.*;

public class CombinationSumII {

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 2));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        findCombinationSum2(candidates, 0, 0, target, ans, finalAns);
        return finalAns;
    }

    public static void findCombinationSum2(int[] candidates, int index, int sum, int target, List<Integer> ans, List<List<Integer>> finalAns){
        //Base Condition
        if(index >= candidates.length){
            Collections.sort(ans);
            if(sum == target && !finalAns.contains(ans)){
                finalAns.add(ans);
            }
            return;
        }

        //Induction step
        List<Integer> newAns = new ArrayList<>();
        newAns.add(candidates[index]);
        newAns.addAll(ans);
        findCombinationSum2(candidates, index+1, sum+candidates[index], target, newAns, finalAns);

        //Do not pick the element
        findCombinationSum2(candidates, index+1, sum, target, ans, finalAns);
    }
}
