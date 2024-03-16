package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Sub Array with sum = K
 */
public class SubArraySumK {
    public static void main(String[] args) {
        int a[] = {1,2,3,1,1,1};
        long k = 3;
        List<List<Integer>> list = subarraysWithSumK(a, k);
        for (List<Integer> element : list) {
            System.out.println(element);
        }
    }

    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {
        // Write your code here
        List<List<Integer>> subSequenceList = new ArrayList<>();
        //convert array to list
        List<Integer> inputList = new ArrayList<>();
        for(int element : a){
            inputList.add(element);
        }

        return solve(inputList, new ArrayList<>(), k, subSequenceList);
    }

    private static List<List<Integer>> solve(List<Integer> inputList, List<Integer> outputList, long k, List<List<Integer>> subSequenceList) {
        //Base Condition
        if(inputList.isEmpty()){
            int temp = 0;
            for(int element : outputList){
                temp = temp + element;
            }
            if(temp == k && !subSequenceList.contains(outputList)){
                subSequenceList.add(outputList);
            }
            return subSequenceList;
        }

        //Induction

        //Do not choose the first digit
        List<Integer> newInputList1 = new ArrayList<>();
        newInputList1.addAll(inputList);
        newInputList1.remove(0);
        solve(newInputList1, outputList, k, subSequenceList);

        //Choose first digit
        List<Integer> newOutputList = new ArrayList<>();
        newOutputList.add(inputList.get(0));
        newOutputList.addAll(outputList);

        List<Integer> newInputList = new ArrayList<>();
        newInputList.addAll(inputList);
        newInputList.remove(0);
        solve(newInputList, newOutputList, k, subSequenceList);
        return subSequenceList;
    }
}
