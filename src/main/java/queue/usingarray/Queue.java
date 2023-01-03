package queue.usingarray;

/**
 * Created By: Shivam Kale
 * Queue implementation using arrays
 * - we will maintain two pointers FRONT & REAR
 * - insertion always performs from REAR
 * - deletion always performs from FRONT
 */
public class Queue {
    public int[] queue;
    public int FRONT;
    public int REAR;

    /**
     * Creation of queue takes O(n) time complexity
     * @param size
     */
    public Queue(int size){
        this.queue = new int[size];
        this.FRONT = 0;
        this.REAR = 0;
        System.out.println("Queue has been created with size " + size);
    }

    public static void main(String[] args){
        Queue queue = new Queue(5);

        //Insert element in Queue
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);

        //Delete element from Queue | TC-O(n)
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        //first element on Queue | TC-O(1)
        int elementAtFirst = queue.firstInQueue();
        System.out.println("Element at front: " + elementAtFirst);

        //end element no Queue | TC-O(1)
        int elementAtEnd = queue.lastInQueue();
        System.out.println("Element at end: " + elementAtEnd);

        //delete whole queue | TC-O(1)
        queue.deleteQueue();

    }

    private void deleteQueue() {
        queue = null;
        System.out.println("Queue has been deleted!!");
    }

    /**
     * This will return who is at last in queue
     * @return lastInQueue
     */
    private int lastInQueue() {
        if(FRONT == 0 && REAR == 0){
            System.out.println("Queue is empty!!");
            return -1;
        }else{
            return queue[REAR];
        }
    }

    /**
     * This will return who is at first in queue
     * @return firstInQueue
     */
    private int firstInQueue() {
        if(FRONT == 0 && REAR == 0){
            System.out.println("Queue is empty!!");
            return -1;
        }else{
           return queue[FRONT];
        }
    }

    /**
     * This method will delete element from Queue | TC-O(1)
     */
    private void deQueue() {
        if(FRONT == 0 && REAR == 0){
            System.out.println("Queue is empty!!");
        }else{
            int deletedElement = queue[FRONT];
            for(int i = (FRONT+1);i<REAR;i++){
                queue[i-1] = queue[i];
            }
            REAR--;
            System.out.println("DeQueue - Deleted element " + deletedElement);
        }
    }

    /**
     * This method will be used to insert element in the Queue | TC-O(1)
     * @param element
     */
    private void enQueue(int element) {
        if(REAR == (queue.length)){
            System.out.println("Queue is full!!");
        }else{
            queue[REAR] = element;
            System.out.println("EnQueue - Inserted " + element + " at location " + REAR);
            REAR++;
        }
    }
}
