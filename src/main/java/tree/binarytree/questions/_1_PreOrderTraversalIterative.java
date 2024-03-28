package tree.binarytree.questions;


import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

import java.util.*;

/**
 * Iterative Algorithm :
 * 1. insert root into stack
 * 2. loop thru stack until it becomes empty
 * 3. pop the node from stack and insert right then left
 * 4. continue until stack is empty.
 */
public class _1_PreOrderTraversalIterative {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createRootNode(1);
        binaryTree.insertNodeBT(binaryTree.root, 2);
        binaryTree.insertNodeBT(binaryTree.root, 3);
        binaryTree.insertNodeBT(binaryTree.root, 5);
        binaryTree.insertNodeBT(binaryTree.root, 6);
        binaryTree.insertNodeBT(binaryTree.root, 4);

        preOrderIterative(binaryTree.root);
    }

    private static void preOrderIterative(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();
        List<Integer> traversedNodeList = new ArrayList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryNode poppedNode = stack.pop();
            traversedNodeList.add(poppedNode.data);

            if(null != poppedNode.right){
                stack.push(poppedNode.right);
            }
            if(null != poppedNode.left){
                stack.push(poppedNode.left);
            }
        }

        for (Integer e : traversedNodeList){
            System.out.print(e);
        }
    }
}
