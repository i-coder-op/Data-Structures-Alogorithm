package stack.questions;

public class StackMinimum {
    public int[] stack;
    public int TOP;
    public int stackSize;
    public int minValue;

    public StackMinimum(int stackSize){
        this.stack = new int[stackSize];
        this.TOP = -1;
        this.stackSize = stackSize;
        minValue = -1;
    }

    public static void main(String[] args){
        StackMinimum stackMinimum = new StackMinimum(6);
        stackMinimum.push(4);
        stackMinimum.push(10);
        stackMinimum.push(40);
        stackMinimum.push(2);
        stackMinimum.push(8);
        stackMinimum.push(3);
        stackMinimum.push(1);
        stackMinimum.getMinValueFromStack();
    }

    private void getMinValueFromStack() {
        System.out.println("Minimum Value in Stack: " + stack[minValue]);
    }

    private void push(int value) {
        if(TOP == (stackSize-1)){
            System.out.println("Stack is full");
            return;
        }else{
            TOP++;
            stack[TOP] = value;
            System.out.println(value + " inserted at " + TOP);
            if(TOP == 0){
                minValue = 0;
            }else if(stack[TOP] < stack[minValue]){
                minValue = TOP;
            }
        }
    }
}
