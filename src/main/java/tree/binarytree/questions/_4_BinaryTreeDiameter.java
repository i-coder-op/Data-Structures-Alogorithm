package tree.binarytree.questions;

import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

/**
 * Algorithm[Same as finding the Height Balanced Binary tree algo]:
 * 1. find the height of left subtree.
 * 2. find the height of right subtree.
 * 3. calculate diameter using diameter = left height + right height
 * 4. maintain an instance variable to hold the final diameter of binary tree
 * 5. if the new diameter is greater than the previous then we will replace it with the new diameter
 * 6. Done
 */

public class _4_BinaryTreeDiameter {

    public int diameter = 0;

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
        /**
         * Tree Structure
         *                  1
         *             2         3
         *         4      5   6     7
         *      8     9
         */

        _4_BinaryTreeDiameter binaryTreeDiameter = new _4_BinaryTreeDiameter();
        binaryTreeDiameter.calculate(binaryTree.root);
        System.out.println("Diameter of binary tree: " + binaryTreeDiameter.diameter);
    }

    public int calculate(BinaryNode root) {
        if (null == root.left && null == root.right) {
            return 0;
        }

        // Induction
        int leftH = 0;
        int rightH = 0;
        if (null != root.left) {
            leftH = 1 + calculate(root.left);
        }

        if (null != root.right) {
            rightH = 1 + calculate(root.right);
        }

        int diameter = leftH + rightH;
        if(this.diameter < diameter){
            this.diameter = diameter;
        }

        return Integer.max(leftH, rightH);
    }
}
