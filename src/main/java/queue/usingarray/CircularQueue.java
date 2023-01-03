package queue.usingarray;

import java.util.Arrays;

/**
 * Created By - Shivam Kale
 * Circular Queue implementation using arrays
 * - why circular queue is required?
 * Ans-> to improve the space efficiency
 */
public class CircularQueue {
    public int[] circularQueue;
    public int FRONT;
    public int REAR;
    public int circularQueueSize;

    /**
     * This constructor will create the circular queue | TC-O(n)
     * @param size
     */
    public CircularQueue(int size){
        this.circularQueue = new int[size];
        this.circularQueueSize = this.circularQueue.length;
        this.FRONT = -1;
        this.REAR = -1;
        System.out.println("Circular Queue is created with size " + this.circularQueueSize);
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        //check if circular queue is empty or not | TC-O(1)
        boolean isEmpty = circularQueue.isEmpty();
        System.out.println("CQ is empty? - " + (isEmpty ? "Yes" : "No"));

        //check if circular queue is full or not | TC-O(1)
        boolean isFull = circularQueue.isFull();
        System.out.println("CQ is full? - " + (isFull ? "Yes" : "No"));

        //Insert new element in the CQ takes O(1) TC
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        circularQueue.enQueue(5);
        circularQueue.enQueue(6);

        //Delete element from the FRONT location of CQ takes O(1) TC
        circularQueue.deQueue();
        circularQueue.enQueue(6);
        circularQueue.deQueue();
        circularQueue.enQueue(7);

        //Printing whole Queue takes O(n) TC
        circularQueue.printCQ();

        int frontCQElement = circularQueue.frontCQElement();
        System.out.println("Front CQ Element: " + frontCQElement);

        int rearCQElement = circularQueue.rearCQElement();
        System.out.println("Rear CQ Element: " + rearCQElement);

    }

    private int rearCQElement() {
        if(isEmpty()){
            System.out.println("CQ is empty!!");
            return -1;
        }else{
            return circularQueue[REAR];
        }
    }

    private int frontCQElement() {
        if(isEmpty()){
            System.out.println("CQ is empty!!");
            return -1;
        }else{
            return circularQueue[FRONT];
        }
    }

    /**
     * This will show what we have CQ currently
     */
    private void printCQ() {
        System.out.println("Current Circular Queue");
        Arrays.stream(circularQueue).forEach(value -> {
            System.out.print(value);
        });
    }

    /**
     * This method will delete element from CQ from FRONT location
     */
    private void deQueue() {
        if(isEmpty()){
            System.out.println("CQ is Empty!!");
        }else{
            int deletedElement = circularQueue[FRONT];
            FRONT++;
            System.out.println("Element delete from CQ: " + deletedElement);
            if(FRONT == (circularQueueSize-1))
                FRONT = 0;
        }
    }

    /**
     * This method will insert new element in the CQ
     * @param element
     */
    private void enQueue(int element) {
        if(isFull()){
            System.out.println("CQ is full");
            return;
        }else{
            if(REAR == (circularQueueSize-1) && FRONT != 0){
                REAR = 0;
            }else if(FRONT == -1 && REAR == -1){
                FRONT++;
                REAR++;
            }else{
                REAR++;
            }
            circularQueue[REAR] = element;
            System.out.println("Element inserted in CQ: " + element);
            return;
        }
    }

    /**
     * This methid will return if CQ is full or not | TC-O(1)
     * @return isFull or not
     */
    private boolean isFull() {
        if(FRONT == 0 && REAR == (circularQueueSize-1)){
            return true;
        }else if(REAR == (FRONT-1)){
            return true;
        }else
            return false;
    }

    /**
     * This method will return if CQ is empty or not
     * @return isEmpty or not
     */
    private boolean isEmpty() {
        if(FRONT == -1 && REAR == -1){
            return true;
        }else{
            return false;
        }
    }
}
