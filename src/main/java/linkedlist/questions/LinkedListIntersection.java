package linkedlist.questions;

import linkedlist.SinglyNode;

import java.sql.SQLOutput;

public class LinkedListIntersection {
    public static void main(String[] args){
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.createSLL(7);
        list1.insertNode(1);
        list1.insertNode(6);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.createSLL(5);
        list2.insertNode(9);
        list2.insertNode(2);
        list2.insertNode(3);

        addCommonNodeInBothList(list1, list2);

        checkIfIntersecting(list1, list2);
    }

    private static void addCommonNodeInBothList(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyNode node = new SinglyNode();
        node.data = 7;
        node.next = null;
        list1.tail.next = node;
        list1.tail = node;
        list2.tail.next = node;
        list2.tail = node;
        list1.size++;
        list2.size++;
    }

    private static void checkIfIntersecting(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyNode firstListPointer = list1.head;
        SinglyNode secondListPointer = list2.head;

        if(list1.size == list2.size){
            while(null != firstListPointer || null != secondListPointer){
                if(firstListPointer.next == secondListPointer.next){
                    System.out.println("Intersecting at node: " + firstListPointer.next.data + " | " + secondListPointer.next.data);
                    return;
                }
                firstListPointer = firstListPointer.next;
                secondListPointer = secondListPointer.next;
            }
        }else if(list1.size > list2.size){

        }
    }
}
