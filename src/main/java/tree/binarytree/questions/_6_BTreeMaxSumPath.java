package tree.binarytree.questions;

import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

/**
 * Leet Code 124: Binary Tree Maximum Path Sum
 * -------------------------------------------
 *
 * Algorithm
 * --------
 * 1. Create a instance variable to hold the maxSum for the entire tree.
 * 2. Insert root.data initially since it can be also a max sum across the tree.
 * 3. Get the left subtree sum recursively.
 * 4. Get the right subtree sum recursively.
 * 5. Now, once we get the left & right subtree sum then we need perform certain comparisons
 *      1. Check which is having maximum sum between root, root+left, root+right & root+left+right
 *      2. From step 1 we will get the maximum sum for the particular subtree.
 *      3. We will compare if the already holding maxSum is greater or smaller, if it is smaller then we will replace with new maximum sum computed on step 1 & 2.
 * 6. Then we will return which is bigger between root+left, root.right & root.
 * 7. Done
 */
public class _6_BTreeMaxSumPath {

    public static int maxSum = -2147483648;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createRootNode(1);
        binaryTree.insertNodeBT(binaryTree.root, 2);
        binaryTree.insertNodeBT(binaryTree.root, -3);

        compute(binaryTree.root);
        System.out.println("Binary Tree Max Sum Path: " + maxSum);
    }

    private static int compute(BinaryNode root) {
        if(null != root){
            maxSum = root.data;
        }
        //Base Case
        if(null == root.left && null == root.right){
            return root.data;
        }

        //Induction Step
        int leftHeight = 0;
        if(null != root.left){
            leftHeight = compute(root.left);
        }

        int rightHeight = 0;
        if(null != root.right){
            rightHeight = compute(root.right);
        }

        int rootLeftRightSum = root.data + leftHeight + rightHeight;
        int rootLeftSum = root.data + leftHeight;
        int rootRightSum = root.data + rightHeight;

        int leftRightMax = Integer.max(rootLeftSum, rootRightSum);
        int rootLeftRightMax = Integer.max(leftRightMax, root.data);
        int finalRootLeftRightMaxSum = Integer.max(rootLeftRightMax, rootLeftRightSum);

        if(maxSum < finalRootLeftRightMaxSum){
            maxSum = finalRootLeftRightMaxSum;
        }

        return Integer.max(root.data, Integer.max(rootLeftSum, rootRightSum));
    }
}
