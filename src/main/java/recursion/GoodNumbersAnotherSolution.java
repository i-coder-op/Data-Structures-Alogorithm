package recursion;

import java.util.ArrayList;
import java.util.List;

public class GoodNumbersAnotherSolution {
    static List<Integer> goodNumbers = new ArrayList<>();

    public static void main(String[] args) {
        int a = 1;
        int b = 40;
        int digit = 9;

        findGoodNumbers(a, b, digit);
        goodNumbers.stream().forEach(integer -> System.out.println(integer));
    }

    private static void findGoodNumbers(int a, int b, int digit) {
        if(a>b){
            return;
        }
        //Induction step
        if(a<10 && a>-1 && a != digit){
            goodNumbers.add(a);
        }else{
            int temp = a;
            int previousNumber = temp%10;
            temp = temp/10;
            boolean flag = false;
            while(temp % 10 != 0){
                int currentNumber = temp%10;
                if(currentNumber > previousNumber && previousNumber != digit && currentNumber != digit){
                    flag = true;
                    previousNumber = currentNumber;
                }else{
                    flag = false;
                    break;
                }
                temp = temp/10;
            }
            if(flag == true){
                goodNumbers.add(a);
            }
        }
        findGoodNumbers(a+1, b, digit);
    }
}
