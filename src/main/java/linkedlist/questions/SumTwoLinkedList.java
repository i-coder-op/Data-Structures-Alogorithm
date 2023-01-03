package linkedlist.questions;

import linkedlist.SinglyNode;

public class SumTwoLinkedList {
    public static void main(String[] args){
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.createSLL(7);
        list1.insertNode(1);
        list1.insertNode(6);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.createSLL(5);
        list2.insertNode(9);
        list2.insertNode(2);

        SumTwoLinkedList.performOperation(list1, list2);
    }

    private static void performOperation(SinglyLinkedList list1, SinglyLinkedList list2) {
        String firstNumber = "";
        String secondNumber = "";
        String result = "";

        //iterate through list and store number as a string in variable
        firstNumber = storeInString(list1, firstNumber);
        secondNumber = storeInString(list2, secondNumber);

        result = String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));

        String[] tempResult = result.split("");

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for(int i = (tempResult.length-1); i>=0;i--){
            singlyLinkedList.insertNode(Integer.parseInt(tempResult[i]));
        }

        singlyLinkedList.traverseSLL();

    }

    private static String storeInString(SinglyLinkedList list, String number) {
        SinglyNode tempPointerNode = list.head;

        for(int i=0;i<list.size;i++){
            number = String.valueOf(tempPointerNode.data) + number;
            tempPointerNode = tempPointerNode.next;
        }

        return number;
    }
}
