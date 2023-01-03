package com.demo;

import java.util.Scanner;

class Node{
    int data;
    Node next;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

public class SinglyLinkedList {

    public static void main(String[] args){
        //Initialize root node
        Node root = new Node(0, null);

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        //Insert new node
        root.next = SinglyLinkedList.createNewNode(1, null);
        System.out.println("Singly Linked List: " + root);
    }

    private static Node createNewNode(int data, Node next) {
        Node node = new Node(data, next);
        return node;
    }

}
