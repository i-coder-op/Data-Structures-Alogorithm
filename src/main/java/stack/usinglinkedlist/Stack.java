package stack.usinglinkedlist;

/**
 * Created By: Shivam Kale
 * Stack implementation using Linked List
 * - easy to implement
 * - variable size
 * - Insertion/Deletion will happen from the beginning of the list
 */
public class Stack {
    public Node TOP;
    public int size;

    public static void main(String[] args){
        Stack stackUsingLL = new Stack();

        //Creating stack will take O(1) TC
        stackUsingLL.createStack();

        //PUSH Operation - O(1)
        System.out.println("\n-----------PUSH OPERATION--------------\n");
        stackUsingLL.pushElement(1);
        stackUsingLL.pushElement(2);
        stackUsingLL.pushElement(3);
        stackUsingLL.pushElement(4);
        stackUsingLL.pushElement(5);
        System.out.println("Stack size after PUSH operation: " + stackUsingLL.size);
        System.out.println("Peek element: " + stackUsingLL.peekElement());

        //POP operation
        System.out.println("\n-----------POP OPERATION--------------\n");
        stackUsingLL.popElement();
        stackUsingLL.popElement();
        stackUsingLL.popElement();
        stackUsingLL.popElement();
        System.out.println("Stack size after POP operation: " + stackUsingLL.size);
        System.out.println("Peek element: " + stackUsingLL.peekElement());

    }

    private int peekElement() {
        if(TOP == null)
            return -1;
        else
            return TOP.data;
    }

    /**
     * This method will pop/delete element from the stack | TC-O(1)
     */
    private void popElement() {
        if(TOP == null){
            System.out.println("Deletion cannot be performed as stack is empty!!");
        }else{
            int poppedElement = TOP.data;
            TOP = TOP.next;
            size--;
            System.out.println("Deleted element: " + poppedElement);
        }
    }

    /**
     * This method will insert the element in the stack | TC-O(1)
     * @param element
     */
    private void pushElement(int element) {
        Node node = new Node();
        node.data = element;

        if(TOP == null){
            TOP = node;
            node.next = null;
        }else{
            node.next = TOP;
            TOP = node;
        }
        size++;
        System.out.println("Inserted element: " + TOP.data);
    }

    /**
     * This will create stack with zero elements
     */
    private void createStack() {
        TOP = null;
        size = 0;
        System.out.println("Stack has been created");
    }
}
