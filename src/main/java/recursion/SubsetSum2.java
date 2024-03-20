package recursion;

import java.util.*;

/**
 * Leet code 90 - Subset sum II
 */
public class SubsetSum2 {
    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        findSubsets(nums, 0, ans, finalAns);
        System.out.println(finalAns);
    }

    private static void findSubsets(int[] nums, int index, List<Integer> ans, List<List<Integer>> finalAns) {
        //Base Condition
        if(index == nums.length){
            Collections.sort(ans);
            if(!finalAns.contains(ans)){
                finalAns.add(ans);
            }
            return;
        }

        //Induction

        //Choose the first number from array
        List<Integer> newAns = new ArrayList<>();
        newAns.add(nums[index]);
        newAns.addAll(ans);
        findSubsets(nums, index+1, newAns, finalAns);

        //Do not choose the first number from array
        findSubsets(nums, index+1, ans, finalAns);
        return;
    }
}
