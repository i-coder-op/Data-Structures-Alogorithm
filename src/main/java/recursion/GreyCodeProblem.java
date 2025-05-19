package recursion;

import java.util.ArrayList;
import java.util.List;

public class GreyCodeProblem {
    public static void main(String[] args) {
        GreyCodeProblem greyCodeProblem = new GreyCodeProblem();
        greyCodeProblem.grayCode(4);
    }

    List<Integer> result;

    public List<Integer> grayCode(int n) {

        result = new ArrayList<>();
        result.add(0);
        result.add(1);

        if (n == 1) {
            return result;
        }

        int low = 2;
        int high = (int) Math.pow(2, n) - 1;
        List<Integer> input = new ArrayList<>();
        while (low <= high) {
            input.add(low);
            low++;
        }

        compute(0, input, result, high+1);
        return result;
    }

    void compute(int index, List<Integer> input, List<Integer> output, int inputSize) {
        // Base case
        if (inputSize == output.size()) {
            System.out.println(output);
            return;
        }

        // Induction step
        while (index < input.size()) {
            int og = input.get(index);
            int res = output.get(output.size() - 1);
            int xor = og^res;
            if (isValidNumbers(xor)) {
                input.remove(index);
                output.add(og);

                compute(0, input, output, inputSize);

                 output.remove(output.size() - 1);
                input.add(index, og);
            }

            index++;
        }
    }

    boolean isValidNumbers(int n) {
        int temp = n & (n-1);
        return (temp==0 && n!=0) ? true : false;
    }
}
