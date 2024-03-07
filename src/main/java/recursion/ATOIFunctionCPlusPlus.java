package recursion;

import java.util.Stack;

public class ATOIFunctionCPlusPlus {
    public static void main(String[] args) {
        String s1 = "-ban23";
        Stack<String> stack = new Stack<>();
        Stack<String> result = new Stack<>();

        s1 = s1.trim();

        String str[] = s1.split("");
        for (int i=str.length-1;i>= 0;i--)
            stack.push(str[i]);

        String sign = stack.pop();
        if(sign.equals("-")){
            result.push(sign);
        }

        //Hypothesis
        result = atoi(stack, result);
        String resultString = "";
        for(String element : result){
            resultString = resultString.concat(element);
        }

        if((result.size() == 1 && result.peek().equals("-")) || resultString.isBlank()){
            System.out.println("0");
        }else
            System.out.println(Integer.parseInt(resultString));
    }

    private static Stack<String> atoi(Stack<String> stack, Stack<String> result) {
        //Base Condition
        if(stack.isEmpty() || !Character.isDigit(stack.peek().charAt(0))){
            return result;
        }

        //Induction Step
        String tempElement = stack.pop();
        result.push(tempElement);
        atoi(stack, result);
        return result;
    }


}
