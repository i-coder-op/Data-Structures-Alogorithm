package queue.usinglinkedlist;

/**
 * Created By- Shivam Kale
 * Queue implementation using linked list
 * - why?
 * - it is space efficient
 */
public class Queue {
    public Node FRONT;
    public Node REAR;
    public int queueSize;

    public Queue(){
        this.FRONT = null;
        this.REAR = null;
        this.queueSize = 0;
        System.out.println("Queue has been created!!");
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        //Check if queue is empty or not | TC-O(1)
        boolean isQueueEmpty = queue.isEmpty();

        //Insert element in the queue | TC-O(1)
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        //Delete element in the queue | TC-O(1)
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        int frontElement = queue.firstQElement();
        System.out.println("Front element: " + (frontElement == -1 ? "Not Found" : frontElement));

        int lastElement = queue.lastQElement();
        System.out.println("Last element: " + (lastElement == -1 ? "Not Found" : lastElement));
    }

    private int lastQElement() {
        if(isEmpty()){
            return -1;
        }else{
            return REAR.element;
        }
    }

    private int firstQElement() {
        if(isEmpty()){
            return -1;
        }else{
            return FRONT.element;
        }
    }

    /**
     * This method will delete element from the queue
     */
    private void deQueue() {
        if(isEmpty()){
            System.out.println("Queue is empty!!");
        }else if(queueSize == 1){
            int deletedElement = FRONT.element;
            FRONT = null;
            REAR = null;
            queueSize--;
            System.out.println("Deleted element: " + deletedElement);
        }else{
            int deletedElement = FRONT.element;
            FRONT = FRONT.next;
            queueSize--;
            System.out.println("Deleted element: " + deletedElement);
        }
    }

    /**
     * This method will insert element in the queue
     * @param element
     */
    private void enQueue(int element) {
        Node node = new Node();
        node.element = element;

        if(isEmpty()){
            FRONT = node;
            REAR = node;
            node.next = null;
        }else{
            REAR.next = node;
            node.next = null;
            REAR = node;
        }
        queueSize++;
        System.out.println("Inserted element: " + node.element);
    }

    /**
     * This method will return if Queue is empty or not
     * @return true/false
     */
    private boolean isEmpty() {
        if(FRONT == null && REAR==null){
            return true;
        }else{
            return false;
        }
    }
}
