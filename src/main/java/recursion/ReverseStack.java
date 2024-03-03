package recursion;
import java.util.*;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<=2;i++){
            stack.push(i);
        }

        System.out.println("Stack before reverse");
        stack.stream().forEach(integer -> System.out.println(integer));

        System.out.println("\n");

        System.out.println("Stack after reverse");
        reverseStack(stack);
        stack.stream().forEach(integer -> System.out.println(integer));
    }

    private static void reverseStack(Stack<Integer> stack) {
        //Base Condition
        if(stack.size() == 1){
            return;
        }

        int temp = stack.pop();

        reverseStack(stack);

        stack.push(temp);

        for(int i=stack.size()-1;i>0;i--){
            //swap n with n-1
            int temp1 = stack.get(i-1);
            stack.set(i-1, stack.get(i));
            stack.set(i, temp1);
        }
    }
}
