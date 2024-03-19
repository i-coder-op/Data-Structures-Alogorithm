package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum1 {

    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{1,2,3}));
    }

    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        findSum(num, 0, ans, 0);
        Collections.sort(ans);
        return ans;
    }

    public static void findSum(int[] num, int index, List<Integer> ans, int sum){
        //Base Condition
        if(index >=num.length){
            ans.add(sum);
            return;
        }

        //Induction Step
        findSum(num, index+1, ans, sum+num[index]);

        //Do not choose
        findSum(num, index+1, ans, sum);
        return;
    }
}
