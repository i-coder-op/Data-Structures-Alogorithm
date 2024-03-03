package recursion;

import java.util.Arrays;
import java.util.Stack;

public class DeleteMiddleElementStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(1, 2, 3, 4, 5));

        Integer middleElement = (stack.size()/2) + 1;

        //1. Hypothesis 2. Base Condition 3. Induction
        if(stack.size() != 1){
            deleteMiddleElement(stack, middleElement-1); // I/P -> (1, 2, 3, 4, 5, 6) ... O/P -> (1, 2, 3, 5, 6)
            stack.forEach(System.out::println);
        }else {
            System.out.println("Size of stack is: " + stack.size());
        }


    }

    private static void deleteMiddleElement(Stack<Integer> stack, Integer middleElement) {
        if(stack.peek() == stack.get(middleElement)){
            stack.pop();
            return;
        }

        //Induction step
        Integer temp = stack.pop();
        deleteMiddleElement(stack, middleElement);
        stack.push(temp);
    }

}
