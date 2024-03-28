package tree.binarytree.questions;

import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Algorithm:
 * 1. Create a stack
 * 2. Assign root to new variable current to basically traverse
 * 3. Run infinite while loop
 * 4. check if current variable is not null then push the node to the stack and move current -> current.left.
 * 5. if current becomes null then in else case check if stack is empty then break the loop.
 * 6. Else remove the top node from stack and add its data into traversals list then move the current -> current.right
 * 7. Done.
 */

public class _3_InOrderTraversalIterative {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createRootNode(1);
        binaryTree.insertNodeBT(binaryTree.root, 2);
        binaryTree.insertNodeBT(binaryTree.root, 3);
        binaryTree.insertNodeBT(binaryTree.root, 5);
        binaryTree.insertNodeBT(binaryTree.root, 6);
        binaryTree.insertNodeBT(binaryTree.root, 4);
        System.out.println("\nInOrder Iterative Traversal: " + inOrderTraversalIterative(binaryTree.root));
    }

    private static List<Integer> inOrderTraversalIterative(BinaryNode root) {
        List<Integer> traversals = new ArrayList<>();
        Stack<BinaryNode> stack = new Stack<>();

        BinaryNode current = root;

        while (true) {
            if (null != current) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                current = stack.peek();
                traversals.add(current.data);
                stack.pop();
                current = current.right;
            }
        }
        return traversals;
    }
}
