package tree.binarytree.questions;

import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

import java.util.*;

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
