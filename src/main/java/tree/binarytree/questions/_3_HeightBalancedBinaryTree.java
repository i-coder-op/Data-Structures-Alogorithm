package tree.binarytree.questions;

import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

/**
 * Algorithm (Using Recursion)
 * 1. create a isHeightBalanced boolean variable to maintain if tree or subtree is balanced or not
 * 2. Pass the root and check the left subtree and right subtree is balanced or not
 * 3. If while recursively calling found the subtree is not balanced then we will set the flag isHeightBalanced = false
 * 4. Done
 */
public class _3_HeightBalancedBinaryTree {

    private Boolean isHeightBalanced = true;

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

        _3_HeightBalancedBinaryTree heightBalancedBinaryTree = new _3_HeightBalancedBinaryTree();
        heightBalancedBinaryTree.checkHeightBalanced(binaryTree.root);
        System.out.println("Is binary tree a height balanced: " + heightBalancedBinaryTree.isHeightBalanced);
    }

    public int checkHeightBalanced(BinaryNode root) {
        if (null == root.left && null == root.right) {
            return 0;
        }

        // Induction
        int leftH = 0;
        int rightH = 0;
        if (this.isHeightBalanced != false) {
            if (null != root.left) {
                leftH = 1 + checkHeightBalanced(root.left);
            }

            if (null != root.right) {
                rightH = 1 + checkHeightBalanced(root.right);
            }

            if (leftH - rightH > 1 || leftH - rightH < -1) {
                this.isHeightBalanced = false;
            }
        }

        return Integer.max(leftH, rightH);
    }
}
