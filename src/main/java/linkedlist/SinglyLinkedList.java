package linkedlist;

public class SinglyLinkedList {
    public SinglyNode head;
    public SinglyNode tail;
    public int size;

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                '}';
    }

    public static void main(String[] args){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = null;
        singlyLinkedList.tail = null;
        singlyLinkedList.size = 0;

        //Insertion as first Node
        singlyLinkedList.insertFirstNode(2);
        //Insertion at Begin
        singlyLinkedList.insertNodeAtBegin(1);
        //Insertion at End
        singlyLinkedList.insertNodeAtEnd(3);
        singlyLinkedList.insertNodeAtEnd(4);
        singlyLinkedList.insertNodeAtEnd(5);
        //Insertion at particular location
        singlyLinkedList.insertNodeAtLocation(12, 3);
        singlyLinkedList.insertNodeAtLocation(13, 7);

        System.out.println(singlyLinkedList.toString());

        // Traversal
        singlyLinkedList.traverseSinglyLinkedList();

        // Searching
        singlyLinkedList.searchElement(7);

        //delete node from begin
        singlyLinkedList.deleteNodeFromBegin(1);
        System.out.println(singlyLinkedList.toString());

        //delete node from end
        singlyLinkedList.deleteNodeFromEnd();
        System.out.println(singlyLinkedList.toString());

        //delete node from specific location
        singlyLinkedList.deleteFromLocation(3);
        System.out.println(singlyLinkedList.toString());
    }

    private void deleteFromLocation(int location) {
        if(null == head){
            System.out.println("List is already empty!!");
            return;
        }else if(location == 1){
            deleteNodeFromBegin(location);
            return;
        }else if(location == size){
            deleteNodeFromEnd();
            return;
        }else{
            if(location <= size){
                SinglyNode tempPointerNode = head;
                int loc = 1;
                while(loc != (location-1)){
                    tempPointerNode = tempPointerNode.next;
                    loc++;
                }
                tempPointerNode.next = tempPointerNode.next.next;
                size--;
                System.out.println("Node delete from location " + location);
                return;
            }else{
                System.out.println("Please pass the appropriate location to delete the node");
            }
        }
    }

    /**
     * Deletion of node from end takes O(1) TC if we have only one node in the list
     * Deletion of node from end takes O(n) TC if we have more than one node in the list, then we have to traverse from first node to (size-1) node that means second last node
     */
    private void deleteNodeFromEnd() {
        if(null == head){
            System.out.println("List is already empty!!");
            return;
        }else if(size == 1){
            head = null;
            tail = null;
            System.out.println("The only node from the list is deleted");
            size--;
            return;
        }else{
            SinglyNode tempPointerNode = head;
            int location = 1;
            while(location != (size-1)){
                tempPointerNode = tempPointerNode.next;
                location++;
            }
            tempPointerNode.next = null;
            size--;
            return;
        }
    }

    /**
     * Delete node from begin will take O(1) TC
     * @param location
     */
    private void deleteNodeFromBegin(int location) {
        if(null == head){
            System.out.println("List is already empty!!");
            return;
        }else if(location == 1){
            head = head.next;
            System.out.println("Node from begin deleted from List");
            size--;
            return;
        }
    }

    /**
     * Searching an element takes O(n) TC
     * @param data
     */
    private void searchElement(int data) {
        SinglyNode tempPointerNode = head;
        int location = 1;
        while(location <= size){
            if(data == tempPointerNode.data){
                System.out.println("Data " + data + " found at location " + location);
                return;
            }
            tempPointerNode = tempPointerNode.next;
            location++;
        }
        System.out.println("Data" + data + " not found!");
        return;
    }

    /**
     * Traversing a singly linked list takes O(n) TC
     */
    private void traverseSinglyLinkedList() {
        SinglyNode tempPointerNode = head;
        int location = 1;
        while(location <= size){
            System.out.println("Location: " + location + " | Data: " + tempPointerNode.data);
            tempPointerNode = tempPointerNode.next;
            location++;
        }
    }

    /**
     * Insert at location takes O(n) TC
     * @param data
     */
    private void insertNodeAtLocation(int data, int location) {
        if(null == head && size == 0){
            insertNodeAtBegin(data);
        } else if((size+1) == location){
            insertNodeAtEnd(data);
        } else if(location < size){
            int nodePosition = 1;

            SinglyNode node = new SinglyNode();
            node.data = data;

            SinglyNode tempPointerNode = head;
            while(nodePosition != (location-1)){
                tempPointerNode = tempPointerNode.next;
                nodePosition++;
            }

            node.next = tempPointerNode.next;
            tempPointerNode.next = node;
            size++;
        }
    }

    /**
     * Insert at end takes O(1) TC
     * @param data
     */
    private void insertNodeAtEnd(int data) {
        if(size == 0 && null == head){
            insertNodeAtBegin(data);
        }else{
            SinglyNode nodeAtEnd = new SinglyNode();
            nodeAtEnd.data = data;
            nodeAtEnd.next = null;
            tail.next = nodeAtEnd;
            tail = nodeAtEnd;
            size++;
        }
    }

    /**
     * Insert at begin takes O(1) TC
     * @param data
     */
    private void insertNodeAtBegin(int data) {
        if(head == null){
            insertFirstNode(data);
        }else{
            SinglyNode nodeAtBegin = new SinglyNode();
            nodeAtBegin.data = data;
            nodeAtBegin.next = head;
            head = nodeAtBegin;
            size++;
        }
    }

    /**
     * This will create first node in the list
     * @param data
     */
    private void insertFirstNode(int data) {
        if(null == head){
            SinglyNode firstNode = new SinglyNode();
            firstNode.data = data;
            firstNode.next = null;
            head = firstNode;
            tail = firstNode;
            size++;
        }
    }

}
