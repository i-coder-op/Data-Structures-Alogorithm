package recursion;

import java.util.Stack;

public class ReverseStackFullRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for(int i=5;i>=1;i--)
            stack.push(i);

        reverseStack(stack);

        stack.stream().forEach(element -> System.out.println(element));
    }

    private static void reverseStack(Stack<Integer> stack) {
        //Base Condition
        if(stack.size() == 1){
            return;
        }

        //Induction step
        int tempElement = stack.pop();
        reverseStack(stack);
        insertPoppedElement(stack, tempElement);
    }

    private static void insertPoppedElement(Stack<Integer> stack, int element) {
        //Base Condition
        if(stack.isEmpty()){
            stack.push(element);
            return;
        }

        //Induction Step
        int tempElement = stack.pop();
        insertPoppedElement(stack, element);
        stack.push(tempElement);
    }
}
