package tree.binarytree.questions;

import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

import java.util.*;

/**
 * Algorithm:
 * 1. Create a stack and push the root node initially.
 * 2. Create a list of type Integer to hold the traversed node.
 * 3. Create a Set of type BinaryNode to hold all the visited nodes.
 * 4. Iterate thru the stack till it is not empty.
 * 5. Inside loop
 *      1. very first step is to get the top node from the stack but do not remove at this moment.
 *      2. check if the that node is already visited or not
 *      3. If that node is not visited then take its right node & then left node and push it to stack respectively.
 *      4. If that node which is top node is already visited then we will pop that node & add into the traversal list.
 */
public class _2_PostOrderTraversalIterative {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createRootNode(1);
        binaryTree.insertNodeBT(binaryTree.root, 2);
        binaryTree.insertNodeBT(binaryTree.root, 3);
        binaryTree.insertNodeBT(binaryTree.root, 5);
        binaryTree.insertNodeBT(binaryTree.root, 6);
        binaryTree.insertNodeBT(binaryTree.root, 4);

        System.out.println("Post Order Traversal: " + postOrderTraversalIterative(binaryTree.root));
    }

    private static List<Integer> postOrderTraversalIterative(BinaryNode root) {
        List<Integer> traversals = new ArrayList<>();
        Stack<BinaryNode> stack = new Stack<>();
        Set<BinaryNode> binaryNodesVisited = new HashSet<>();

        stack.push(root);
        while(!stack.isEmpty()){
            BinaryNode stackTopNode = stack.peek();
            if(!binaryNodesVisited.contains(stackTopNode)){
                binaryNodesVisited.add(stackTopNode);
                if(null != stackTopNode.right){
                    stack.push(stackTopNode.right);
                }

                if(null != stackTopNode.left){
                    stack.push(stackTopNode.left);
                }
            }else{
                BinaryNode poppedNode = stack.pop();

                if(null != poppedNode){
                    traversals.add(poppedNode.data);
                }
            }
        }

        return traversals;
    }
}
