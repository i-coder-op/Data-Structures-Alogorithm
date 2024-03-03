package recursion;

import java.util.ArrayList;
import java.util.List;

public class GoodNumbers {
    public static void main(String[] args) {
        int a = 840;
        int b= 850;
        int digit = 6;
        List<Integer> goodNumbers = new ArrayList<>();
        goodNumbers = findGoodNumbers(a, b, digit, goodNumbers);
        goodNumbers.stream().forEach(integer -> System.out.println(integer));
    }

    private static List<Integer> findGoodNumbers(int a, int b, int digit, List<Integer> goodNumbers) {
        if(a > b){
            return goodNumbers;
        }
        //Induction
        boolean flag = false;
        String tDigits = String.valueOf(a);
        for (int i=0;i<tDigits.length()-1;i++){
            int digit1 = Integer.parseInt(String.valueOf(tDigits.charAt(i)));
            int digit2 = Integer.parseInt(String.valueOf(tDigits.charAt(i+1)));
            if(digit1 == digit || digit2 == digit){
                flag = false;
                break;
            }
            if(digit1 > digit2){
                flag = true;
            }else {
                flag = false;
            }
        }
        if (flag == true)
            goodNumbers.add(a);
        findGoodNumbers(a+1, b, digit, goodNumbers);
        return goodNumbers;
    }
}
