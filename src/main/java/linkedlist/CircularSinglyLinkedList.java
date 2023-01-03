package linkedlist;

public class CircularSinglyLinkedList {
    public SinglyNode head;
    public SinglyNode tail;
    public int size;

    public static void main(String[] args){
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
        circularSinglyLinkedList.head = null;
        circularSinglyLinkedList.tail = null;
        circularSinglyLinkedList.size = 0;
        // Circular Singly Linked List Operations

        //Insert First node in the list - it will take O(1) time complexity
        circularSinglyLinkedList.createCSLLWithFirstNode(2);
        System.out.println("Circular Linked List Created with first node: " + circularSinglyLinkedList.head.data);

        //Inserting a new node at begin - it will take O(1)
        circularSinglyLinkedList.insertNodeAtBegin(1);
        System.out.println("Node inserted at begin " + circularSinglyLinkedList.head.data);

        //Inserting a new node at end - it will take O(1) TC
        circularSinglyLinkedList.insertNodeAtEnd(3);
        System.out.println("Node inserted at end " + circularSinglyLinkedList.tail.data);

        //Inserting a node at specified location
        circularSinglyLinkedList.insertNodeAtSpecifiedLocation(4, 6);
        circularSinglyLinkedList.insertNodeAtSpecifiedLocation(4, 2);
        circularSinglyLinkedList.insertNodeAtSpecifiedLocation(5, 3);

        //Traversing CSLL - it will take O(n) time complexity
        circularSinglyLinkedList.traverseCSLL();

        //Delete node from the list
        circularSinglyLinkedList.deleteAnyNode(1);
        circularSinglyLinkedList.traverseCSLL();
        circularSinglyLinkedList.deleteAnyNode(7);
        circularSinglyLinkedList.traverseCSLL();
        circularSinglyLinkedList.deleteAnyNode(3);
        circularSinglyLinkedList.traverseCSLL();
        circularSinglyLinkedList.deleteAnyNode(1);
        circularSinglyLinkedList.traverseCSLL();

    }

    /**
     * Delete any node based on location parameter
     * @param location
     */
    private void deleteAnyNode(int location) {
        if(null == head){
            System.out.println("Circular linked list does not exists!");
            return;
        }else if(location == 1){
            if(size == 1){
                deleteOnlyNodeFromList();
            }else{
                head = head.next;
                tail.next = head;
                size--;
                System.out.println("Node has been deleted from location " + location);
            }
            return;
        }else if(location >= size){
            if(size == 1){
                deleteOnlyNodeFromList();
            }else{
                SinglyNode tempPointerNode = head;
                for(int i=2; i<size;i++){
                    tempPointerNode = tempPointerNode.next;
                }
                tempPointerNode.next.next = null;
                tempPointerNode.next = head;
                tail = tempPointerNode;
                System.out.println("Node has been deleted from end");
                size--;
            }
        }else{
            if(size == 1){
                deleteOnlyNodeFromList();
            }else if(size > location){
                SinglyNode tempPointerNode = head;
                for (int i=2; i<location;i++){
                    tempPointerNode = tempPointerNode.next;
                }
                tempPointerNode.next = tempPointerNode.next.next;
                System.out.println("Node has been deleted from location " + location);
                size--;
            }
            return;
        }
    }

    /**
     * This method will delete only node from the list
     */
    private void deleteOnlyNodeFromList() {
        head.next = null;
        head = null;
        tail = null;
        return;
    }

    /**
     * This will traverse the CSLL and it will take O(n)
     */
    private void traverseCSLL() {
        SinglyNode tempPointerNode = new SinglyNode();
        tempPointerNode = head;
        int index = 1;
        while(index <= size){
            System.out.print(tempPointerNode.data);
            index++;
            tempPointerNode = tempPointerNode.next;
        }
        System.out.println("\n");
    }

    private void insertNodeAtSpecifiedLocation(int data, int location) {
        if(null == head){
            createCSLLWithFirstNode(data);
            return;
        }else if(location == 1){
            insertNodeAtBegin(data);
            return;
        }else if(location > size){
            if(location == (size+1))
                insertNodeAtEnd(data);
            else
                System.out.println("There is no position with " + location);
           return;
        }else{
            SinglyNode node = new SinglyNode();
            node.data = data;

            SinglyNode tempPointerNode = head;

            for(int i = 1; i<(location-1);i++){
                tempPointerNode = tempPointerNode.next;
            }

            node.next = tempPointerNode.next;
            tempPointerNode.next = node;
            System.out.println("Node inserted at location " + location);
            size++;
        }
    }

    /**
     * Inserting node at the end of the list | O(1)
     * @param data
     */
    private void insertNodeAtEnd(int data) {
        if(null == head){
            createCSLLWithFirstNode(data);
        }else{
            SinglyNode node = new SinglyNode();
            node.data = data;
            tail.next = node;
            node.next = head;
            tail = node;
            size++;
        }
    }

    /**
     * Insert node at begin | TC - O(1)
     * @param data
     */
    private void insertNodeAtBegin(int data) {
        if(null == head){
          createCSLLWithFirstNode(data);
          return;
        }else {
            SinglyNode node = new SinglyNode();
            node.data = data;
            node.next = head.next;
            head = node;
            tail.next = node;
            size++;
            return;
        }
    }

    /**
     * This method will create CSLL with first node | TC - O(1)
     * @param data
     */
    private void createCSLLWithFirstNode(int data) {
        if(null == head && null == tail){
            SinglyNode firstNode = new SinglyNode();
            firstNode.data = data;
            head = firstNode;
            tail = firstNode;
            firstNode.next = firstNode;
            size++;
        }
    }
}
