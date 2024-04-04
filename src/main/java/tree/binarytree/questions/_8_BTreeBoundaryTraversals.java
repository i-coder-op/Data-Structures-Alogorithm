package tree.binarytree.questions;

import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Coding Ninja Code Studio : https://www.naukri.com/code360/problems/boundary-traversal-of-binary-tree_790725 [Hard]
 * I was good on my approach but was stuck on some test cases. since i was trying to solve it using recursion but it can be solved iteratively.
 *
 * Algorithm:
 *
 * 1. Find the leftBoundary (If current is not leaf then go to left and if left is null then go to right)
 *           -> Create a current pointer and initially assigned it to root.left
 *           -> Run thru the while loop until current is null.
 *           -> Check in loop if current node is the leaf node or not by using condition
 *                    if(null == current.left && null == current.right) then break the loop.
 *           -> If above condition is not satisfied then current might have left/right subtree.
 *           -> If null != current.left then add the current.data into the leftBoundaryList assign current = current.left and
 *                 continue the loop.
 *           -> If null == current.left then add the current.data into the leftBoundaryList assign current = current.right and
 *                 continue the loop.
 *
 * 2. Find the leaf nodes using preOrder traversal.
 * 3. Find the rightBoundary just like leftBoundary computation [If current is not leaf then go to right and if right is null
 *       then go to left]
 *     -> Once the rightBounday computation is done then reverse the list which has all the rightBoundary traversed nodes.
 */

public class _8_BTreeBoundaryTraversals {
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
        System.out.println("Binary Tree Boundary Traversals: " + traverseBoundary(binaryTree.root));
    }

    public static List<Integer> traverseBoundary(BinaryNode root){
        // Write your code here.
        List<Integer> boundaryNodes = new ArrayList<>();
        List<Integer> leafNodes = new ArrayList<>();

        if(null != root){
            boundaryNodes.add(root.data);
        }else{
            return boundaryNodes;
        }

        //Compute left boundary
        List<Integer> leftBoundaryNodes = new ArrayList<>();
        computeLeftBoundary(root.left, leftBoundaryNodes);

        //Compute right boundary
        List<Integer> rightBoundaryNodes = new ArrayList<>();
        computeRightBoundary(root.right, rightBoundaryNodes);
        Collections.reverse(rightBoundaryNodes);

        //Compute leaf nodes
        computeLeafNodes(root, leafNodes);

        //Populate all leftBoundary, leafNodes & rightBoundary
        populateInlist(boundaryNodes, leftBoundaryNodes);
        populateInlist(boundaryNodes, leafNodes);
        populateInlist(boundaryNodes, rightBoundaryNodes);

        return boundaryNodes;
    }

    public static void populateInlist(List<Integer> boundaryNodes, List<Integer> nodesTobeAdded){
        for(Integer nodeData : nodesTobeAdded){
            if(!boundaryNodes.contains(nodeData)){
                boundaryNodes.add(nodeData);
            }
        }
    }

    public static void computeLeafNodes(BinaryNode root, List<Integer> leafNodes){
        if(null == root){
            return;
        }

        if(null == root.left && null == root.right){
            leafNodes.add(root.data);
        }

        computeLeafNodes(root.left, leafNodes);
        computeLeafNodes(root.right, leafNodes);
    }

    public static void computeLeftBoundary(BinaryNode root, List<Integer> leftBoundaryNodes){
        BinaryNode current = root;

        while(null != current){
            if(null == current.left && null == current.right){
                break;
            }
            if(null != current.left){
                leftBoundaryNodes.add(current.data);
                current = current.left;
            }else{
                leftBoundaryNodes.add(current.data);
                current = current.right;
            }
        }
    }

    public static void computeRightBoundary(BinaryNode root, List<Integer> rightBoundaryNodes){
        BinaryNode current = root;

        while(null != current){
            if(null == current.left && null == current.right){
                break;
            }
            if(null != current.right){
                rightBoundaryNodes.add(current.data);
                current = current.right;
            }else{
                rightBoundaryNodes.add(current.data);
                current = current.left;
            }
        }
    }
}
