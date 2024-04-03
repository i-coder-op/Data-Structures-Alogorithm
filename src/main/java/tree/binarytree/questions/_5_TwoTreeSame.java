package tree.binarytree.questions;

import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Leet Code 100: Check if two trees are same or not
 *
 * Algorithm:
 * 1. do the preorder traversal of both the trees.
 * 2. Instead of printing it on screen just add those nodes to the list
 * 3. Once traversal is completed for both the trees then compare both the list using equals method.
 */
public class _5_TwoTreeSame {
    public static void main(String[] args) {
        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.createRootNode(1);
        binaryTree1.insertNodeBT(binaryTree1.root, 2);
        binaryTree1.insertNodeBT(binaryTree1.root, 3);

        BinaryTree binaryTree2 = new BinaryTree();
        binaryTree2.createRootNode(1);
        binaryTree2.insertNodeBT(binaryTree2.root, 2);
        binaryTree2.insertNodeBT(binaryTree2.root, 4);

        List<Integer> firstTreeNodes = new ArrayList<>();
        compute(binaryTree1.root, firstTreeNodes);

        List<Integer> secondTreeNodes = new ArrayList<>();
        compute(binaryTree2.root, secondTreeNodes);

        if(firstTreeNodes.equals(secondTreeNodes)){
            System.out.println("Both trees are same");
            return;
        }
        System.out.println("Both trees are not same");
    }

    private static void compute(BinaryNode root, List<Integer> nodes) {
        //Base Condition
        if(null == root){
            nodes.add(null);
            return;
        }

        //Induction
        nodes.add(root.data);
        compute(root.left, nodes);
        compute(root.right, nodes);
    }
}
