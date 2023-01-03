package linkedlist.questions;

import linkedlist.SinglyNode;

public class SinglyLinkedList {
    public SinglyNode head;
    public SinglyNode tail;
    public int size;

    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.createSLL(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(5);
        list.traverseSLL();
    }

    public void traverseSLL() {
        if(null != head){
            SinglyNode tempPointerNode = head;
            for(int i=0;i<size;i++){
                System.out.print(tempPointerNode.data);
                if(i<(size-1)){
                    System.out.print("->");
                }
                tempPointerNode = tempPointerNode.next;
            }
        }else{
            System.out.println("Linked list does not exists!!");
        }
    }

    public void insertNode(int data) {
        if(null == head){
            createSLL(data);
        }else{
            SinglyNode node = new SinglyNode();
            node.data = data;
            node.next = null;
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void createSLL(int data) {
        if(null == head){
            SinglyNode node = new SinglyNode();
            node.data = data;
            node.next = null;
            head = node;
            tail = node;
            size++;
        }
    }
}
