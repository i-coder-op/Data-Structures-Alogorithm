package recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class UniquePermutation {

    static HashSet<ArrayList<Integer>> finalRes = new HashSet<>();

    public static void main(String[] args) {
        UniquePermutation uniquePermutation = new UniquePermutation();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        uniquePermutation.permute(list);
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        finalRes = new HashSet<>();
        ArrayList<Integer> permutation = new ArrayList<>();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        compute(0, A, permutation, A.size());
        for(ArrayList<Integer> list : finalRes) {
            resultList.add(list);

        }
        return resultList;
    }

    void compute(int index, ArrayList<Integer> input, ArrayList<Integer> permutation, int inputSize) {
        //Base Condition
        if (inputSize == permutation.size()) {
            ArrayList<Integer> ls = new ArrayList<>(permutation);
            finalRes.add(ls);
            return;
        }

        if(!input.isEmpty()){
            while (index < input.size()) {
                int og = input.get(index);
                permutation.add(og);
                input.remove(index);
                compute(0, input, permutation, inputSize);
                input.add(index, og);
                permutation.remove(permutation.size()-1);
                index++;
            }
        }
    }
}


