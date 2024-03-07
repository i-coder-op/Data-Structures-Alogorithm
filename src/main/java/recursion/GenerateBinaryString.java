package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: Generate all binary strings (LeetCode)
 */
public class GenerateBinaryString {
    public static void main(String[] args) {
        int N = 10;
        List<String> binaryStringList = new ArrayList<>();
        generate(N, N, N, "", binaryStringList);
        binaryStringList.forEach(s -> System.out.println(s));
    }

    private static List<String> generate(int n, int zero, int one, String binaryString, List<String> binaryStringList) {
        //Base Condition
        if (binaryString.length() == n) {
            binaryStringList.add(binaryString);
            return binaryStringList;
        }

        //Induction
        if(binaryString.length()>0 && binaryString.charAt(binaryString.length()-1) == '1'){
            //Choose "0"
            String binaryStringNew0 = binaryString.concat("0");
            generate(n, zero - 1, one, binaryStringNew0, binaryStringList);
        }else{
            //Choose "0"
            String binaryStringNew0 = binaryString.concat("0");
            generate(n, zero - 1, one, binaryStringNew0, binaryStringList);

            //Choose "1"
            String binarStringNew1 = binaryString.concat("1");
            generate(n, zero, one - 1, binarStringNew1, binaryStringList);
        }

        return binaryStringList;
    }
}
