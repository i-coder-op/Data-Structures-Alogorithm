package recursion;

import java.util.*;

/**
 * Leet Code: 78. Subsets
 */

public class PrintSubsequencesInteger {
    public static void main(String[] args) {
       int nums[] = {1, 2, 3};
       PrintSubsequencesInteger printSubsequencesInteger = new PrintSubsequencesInteger();
       printSubsequencesInteger.subsets(nums).forEach(integers -> {
           System.out.println(integers);
       });

    }

    public List<List<Integer>> subsets(int[] nums) {
        //Convert array to list
        List<List<Integer>> finalOutputSubsequenceList = new ArrayList<>();
        List<Integer> inputList = new ArrayList<>();
        for (int number : nums)
            inputList.add(number);
        getSubsequences(inputList, Collections.emptyList(), finalOutputSubsequenceList);
        return finalOutputSubsequenceList;
    }

    private void getSubsequences(List<Integer> inputList, List<Integer> outputSubsequences, List<List<Integer>> finalOutputSubsequenceList) {
        //Base Condition
        if(inputList.isEmpty()){
            if(!finalOutputSubsequenceList.contains(outputSubsequences)){
                finalOutputSubsequenceList.add(outputSubsequences);
            }
            return;
        }

        //Induction
        //Choose first number & remove from the inputList
        Integer firstNumber = inputList.get(0);
        List<Integer> newInputList = new ArrayList<>();
        newInputList.addAll(inputList);
        newInputList.remove(0);

        List<Integer> newOutputSubsequences = new ArrayList<>();
        newOutputSubsequences.addAll(outputSubsequences);
        newOutputSubsequences.add(firstNumber);
        getSubsequences(newInputList, newOutputSubsequences, finalOutputSubsequenceList);

        //Do not choose the first number but remove from inputList
        List<Integer> newInputList1 = new ArrayList<>();
        newInputList1.addAll(inputList);
        newInputList1.remove(0);
        getSubsequences(newInputList1, outputSubsequences, finalOutputSubsequenceList);
    }
}
