package linkedlist;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    public static void main(String[] args){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        //Creation of DLL takes O(1)
        linkedList.createDLL(2);

        //Insert node at begin takes O(1) time complexity
        linkedList.insertAtBegin(1);
        linkedList.insertAtBegin(0);

        //Insert node at last takes O(1) as we will use tail pointer to insert node at end
        linkedList.insertAtEnd(3);

        linkedList.traverseList();

        //Insert node at specific location, and it will take O(n) time complexity
        linkedList.insertAtLocation(4,2);
        linkedList.insertAtLocation(6,7);

        //Traversing list will take O(n) time complexity
        linkedList.traverseList();
        //Traversing list from end using will take O(n) time complexity
        //linkedList.traverseListUsingTail();

        //Deleting a node from specified location | TC-O(n)
        linkedList.deleteAtLocation(6);
        linkedList.traverseList();

    }

    /**
     * Deleting a node from specified location takes O(n) time complexity
     * @param location
     */
    private void deleteAtLocation(int location) {
        if(null == head){
            System.out.println("Doubly linked list does not exists!");
            return;
        }else if(location == 1){
            if(size == 1){
                deleteOnlyNode();
            }else{
                head = head.next;
                head.previous = null;
                tail = head;
                size--;
                System.out.println("Node from location " + location + " has been deleted");
            }
        }else if(location >= size){
            if(size == 1){
                deleteOnlyNode();
            }else{
                if(location > size){
                    throw new IndexOutOfBoundsException("Index out of bounds Exception");
                }
                DoublyNode tempNode = tail.previous;
                tail.previous = null;
                tail = tempNode;
                tail.next = null;
                size--;
                System.out.println("Node has been deleted from end");
            }
        }else{
            if(size == 1){
                deleteOnlyNode();
            }else{
                DoublyNode tempPointerNode = head;
                for(int i=2; i<location;i++){
                    tempPointerNode = tempPointerNode.next;
                }

                tempPointerNode.next = tempPointerNode.next.next;
                tempPointerNode.next.previous = tempPointerNode;
                size--;
                System.out.println("Node from location " + location + " has been deleted");
            }
        }
    }

    /**
     * Utility method to delete only present node from the list | TC-O(1)
     */
    private void deleteOnlyNode() {
        head.next = null;
        head = null;
        tail = null;
        size--;
        System.out.println("Only node from the list has been deleted");
    }

    private void traverseListUsingTail() {
        DoublyNode tempPointerNode = tail;
        System.out.print("Reverse List: ");
        while(null != tempPointerNode){
            System.out.print(tempPointerNode.data);
            tempPointerNode = tempPointerNode.previous;
        }
        System.out.println();
    }

    /**
     * This method will insert node at specified passed location | TC-O(n)
     * @param data
     * @param location
     */
    private void insertAtLocation(int data, int location) {
        if(null == head){
            createDLL(data);
            return;
        }else if(location > size){
            insertAtEnd(data);
            return;
        }else if(location == 1){
            insertAtBegin(data);
        }else{
            DoublyNode tempPointerNode = head;
            for(int i=2; i<location;i++){
                tempPointerNode = tempPointerNode.next;
            }
            DoublyNode node = new DoublyNode();
            node.data = data;
            node.next = tempPointerNode.next;
            node.previous = tempPointerNode;
            tempPointerNode.next.previous = node;
            tempPointerNode.next = node;
            System.out.println("Node has been inserted at location " + location);
            size++;
        }
    }

    /**
     * This method will be used to traverse list | TC-O(n)
     */
    private void traverseList() {
        DoublyNode tempPointerNode = head;
        System.out.print("List: ");
        while(null != tempPointerNode){
            System.out.print(tempPointerNode.data);
            tempPointerNode = tempPointerNode.next;
        }
        System.out.println();
    }

    /**
     * Inserting a node at end will take O(1) TC
     * @param data
     */
    private void insertAtEnd(int data) {
        if(null == head){
            createDLL(data);
        }else{
            DoublyNode node = new DoublyNode();
            node.data = data;
            node.next = null;
            node.previous = tail;
            tail.next = node;
            tail = node;
            System.out.println("Node has been inserted at the end of the list");
            size++;
        }
    }

    /**
     * Inserting a node on first location | O(1)
     * @param data
     */
    private void insertAtBegin(int data) {
        if(null == head){
            createDLL(data);
            return;
        }else {
          DoublyNode node = new DoublyNode();
          node.previous = null;
          node.data = data;
          node.next = head;
          head.previous = node;
          head = node;
          System.out.println("Node has been inserted at begin");
          size++;
          return;
        }
    }

    /**
     *
     * @param data
     */
    private void createDLL(int data) {
        if(null == head){
            DoublyNode node = new DoublyNode();
            node.data = data;
            node.previous = null;
            node.next = null;

            head = node;
            tail = node;
            size++;
            System.out.println("DLL created!");
            return;
        }
    }
}
