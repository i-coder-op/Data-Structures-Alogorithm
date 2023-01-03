package linkedlist.questions;

import linkedlist.SinglyNode;

public class NthToLast {
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.createSLL(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(5);
        list.traverseSLL();

        findNthToLast(list, 1);
    }

    /**
     * Using one pointer we can achieve it in O(n) time complexity
     * @param list
     * @param locationFromLast
     */
    private static void findNthToLast(SinglyLinkedList list, int locationFromLast) {
        int desiredIndex = list.size - locationFromLast;
        if(desiredIndex >= 0){
            SinglyNode tempNode = list.head;
            for(int i = 1; i<=desiredIndex;i++){
                tempNode = tempNode.next;
            }
            System.out.println("\n Location from last: " + tempNode.data);
        }else{
            throw new IndexOutOfBoundsException("Index does not found");
        }
    }


}
