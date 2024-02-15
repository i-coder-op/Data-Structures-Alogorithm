package recursion;

import java.util.Arrays;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(7, 7, -3, 0, -1));
        stack.stream().forEach(integer -> System.out.println(integer));
        //1. Hypothesis 2. Base Condition 3. Induction
        if(!stack.isEmpty()){
            sortStack(stack); // I/P -> {7, 7, -3, 0, -1} ..... O/P -> {-3, -1, 0, 7, 7}
            stack.stream().forEach(integer -> System.out.println(integer));
            return;
        }
        System.out.println("Stack is empty!");
    }

    private static void sortStack(Stack<Integer> stack) {
        //Base Condition -> if stack has size == 1 then it is already sorted
        if(stack.size() == 1){
            return;
        }

        //Induction -> make input smaller
        Integer tempElement = stack.peek(); // temp -> -1
        stack.pop(); // {7, 7, -3, 0}
        sortStack(stack); // {-3, 0, 7, 7}
        insertElementInSortedStack(stack, tempElement); // I/P -> {-3, 0, 7, 7} , temp -> {-1} ..... O/P -> {-3, -1, 0, 7, 7}
    }

    private static void insertElementInSortedStack(Stack<Integer> stack, Integer element) {
        if(stack.isEmpty() || stack.peek() < element){
            stack.push(element);
            return;
        }

        //Induction -> make input smaller
        Integer tempElement = stack.peek();
        stack.pop();
        insertElementInSortedStack(stack, element);
        stack.push(tempElement);
    }
}
