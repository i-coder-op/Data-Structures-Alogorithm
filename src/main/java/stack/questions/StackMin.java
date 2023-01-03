package stack.questions;

import java.util.Arrays;

public class StackMin {
    public int[] stack;
    public int TOP;
    public int stackSize;

    public StackMin(int size){
        this.stack = new int[size];
        this.TOP = -1;
        this.stackSize = size;
    }

    public static void main(String[] args){
        StackMin stack = new StackMin(5);

        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println(stack.min());
        Arrays.stream(stack.stack).forEach(value -> {
            System.out.print(value);
        });
    }

    private int min() {
        return stack[TOP];
    }

    private void push(int element) {
        if(TOP == (stackSize-1)){
            System.out.println("Stack is full!!");
            return;
        }else{
            if(TOP == -1){
                TOP++;
                stack[TOP] = element;
            }else{
                int topElement = stack[TOP];
                if(topElement < element){
                    stack[TOP] = element;
                    TOP++;
                    stack[TOP] = topElement;
                }else{
                    TOP++;
                    stack[TOP] = element;
                }
            }
            System.out.println("Inserted element: " + element);
        }
    }
}
