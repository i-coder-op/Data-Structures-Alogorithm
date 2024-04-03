package tree.binarytree.questions;

import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

import java.util.*;

/**
 * Leet Code 103. Binary Tree Zigzag Level Order Traversal [Medium]
 * ---------------------------------------------------------------
 *
 * Algorithm [This is similar to level order traversal with slight modification based on levels]
 * ---------
 *
 * 1. Create a queue.
 * 2. Add root node to the queue initially.
 * 3. Run the while loop until the queue is empty.
 * 4. Run inner while until the queue is empty, this while loop is required to remove all the elements for that level.
 * 5. Maintain a level variable to for each level to identify in which order we are going to push the element in queue.
 *      1. If next level is even then in that case we will store in this order Right --> Left
 *      2. If next level is odd then in that case we will store in this order Left --> Right
 * 6. This will run until the queue is empty.
 */

public class _7_BTreeZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createRootNode(1);
        binaryTree.insertNodeBT(binaryTree.root, 2);
        binaryTree.insertNodeBT(binaryTree.root, 3);
        binaryTree.insertNodeBT(binaryTree.root, 4);
        binaryTree.insertNodeBT(binaryTree.root, 5);
        binaryTree.insertNodeBT(binaryTree.root, 6);
        binaryTree.insertNodeBT(binaryTree.root, 7);
        binaryTree.insertNodeBT(binaryTree.root, 8);
        binaryTree.insertNodeBT(binaryTree.root, 9);

        List<List<Integer>> zigZagLevelOrderTraversals = new ArrayList<>();
        compute(binaryTree.root, zigZagLevelOrderTraversals);
        System.out.println("Zig-Zag Level Order Traversal: " + zigZagLevelOrderTraversals);
    }

    private static void compute(BinaryNode root, List<List<Integer>> zigZagLevelOrderTraversals) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 2;
        while(!queue.isEmpty()){

            List<Integer> nodes = new ArrayList<>();
            List<BinaryNode> binaryNodesRequiredToPushInQueue = new ArrayList<>();

            while(!queue.isEmpty()){
                BinaryNode removedNode = queue.poll();
                nodes.add(removedNode.data);
                binaryNodesRequiredToPushInQueue.add(removedNode);
            }

            zigZagLevelOrderTraversals.add(nodes);

            Collections.reverse(binaryNodesRequiredToPushInQueue);
            for(BinaryNode nodeToPushInQueue : binaryNodesRequiredToPushInQueue){
                if(level % 2 == 0){
                    if(null != nodeToPushInQueue.right){
                        queue.add(nodeToPushInQueue.right);
                    }
                    if(null != nodeToPushInQueue.left){
                        queue.add(nodeToPushInQueue.left);
                    }
                }else{
                    if(null != nodeToPushInQueue.left){
                        queue.add(nodeToPushInQueue.left);
                    }
                    if(null != nodeToPushInQueue.right){
                        queue.add(nodeToPushInQueue.right);
                    }
                }
            }

            level++;
        }
    }
}
