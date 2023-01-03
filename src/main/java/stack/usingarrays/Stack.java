package stack.usingarrays;

/**
 * Created by - Shivam Kale
 * Stack implementation using arrays
 * - easy to implement
 * - fixed in size
 */
public class Stack {
    public int[] stack;
    public int TOP;

    /**
     * Constructor to create stack based on the size passed | TC-O(n)
     * @param size
     */
    public Stack(int size){
        this.stack = new int[size];
        this.TOP = -1;
        System.out.println("Stack has been created with size: " + size);
    }

    public static void main(String[] args){
        // stack creation
        Stack stack = new Stack(5);

        // check if stack is empty
        boolean isEmpty = stack.isEmpty();
        if(isEmpty)
            System.out.println("Stack is empty!!");
        else
            System.out.println("Stack is not empty!!");

        // check if stack is full
        boolean isFull = stack.isFull();
        if(isFull)
            System.out.println("Stack is full!!");
        else
            System.out.println("Stack is still having some space to perform push operation!!");

        // PUSH Operation | TC-O(1)
        stack.pushElement(1);
        stack.pushElement(2);
        stack.pushElement(3);
        stack.pushElement(4);
        stack.pushElement(5);
        stack.pushElement(6);

        //POP Operation | TC-O(1)
        stack.popElement();

        //PEEK Operation | TC-O(1)
        int peekElement = stack.peeKElement();
        if(peekElement != -1)
            System.out.println("Peek Element of stack is " + peekElement);
        else
            System.out.println("Stack is empty!!");

        //DELETE stack Operation | TC-O(1)
        stack.deleteStack();

    }

    /**
     * This method will delete the stack
     */
    private void deleteStack() {
        stack = null;
        System.out.println("Stack has been deleted completely");
    }

    /**
     * This method will return the peek element of the stack | TC-O(1)
     */
    private int peeKElement() {
        if(isEmpty())
            return -1;
        else
            return stack[TOP];
    }

    /**
     * This method will pop the TOP element from the stack | TC-O(1)
     */
    private void popElement() {
        if(isEmpty())
            System.out.println("Stack is empty!!");
        else{
            int poppedElement = stack[TOP];
            stack[TOP] = 0;
            TOP--;
            System.out.println("POP OPERATION: " + poppedElement);
        }

    }

    /**
     * This method will insert/push the element in the stack | TC-O(1)
     * @param element
     */
    private void pushElement(int element) {
        if(isFull()) {
            System.out.println("Stack is full!!");
        }else{
            stack[TOP+1] = element;
            TOP++;
            System.out.println("PUSH OPERATION: " + element);
        }
    }

    /**
     * This method will check whether the stack is full or not | TC-O(1)
     * @return result
     */
    private boolean isFull() {
        if(TOP == (stack.length-1))
            return true;
        else
            return false;
    }

    /**
     * This method will check whether the stack is empty or non-empty | TC-O(1)
     * @return result
     */
    private boolean isEmpty() {
        if(TOP == -1)
            return true;
        else
            return false;
    }
}
