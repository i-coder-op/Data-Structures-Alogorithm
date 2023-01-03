package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree Implementation using LinkedList
 * Created By: Shivam
 */
public class BinarySearchTree {
    //BST root node declaration
    public Node bstRoot;

    /**
     * Binary Search Tree Creation using constructor
     */
    public BinarySearchTree(){
        this.bstRoot = null;
        //System.out.println("Binary Search Created!!");
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();

        //BST - Root Node Insertion
        bst.insertRootNode(10);

        //BST - Node Insertion
        bst.insertNode(bst.bstRoot, 11);
        bst.insertNode(bst.bstRoot, 8);
        bst.insertNode(bst.bstRoot, 7);
        bst.insertNode(bst.bstRoot, 9);
        bst.insertNode(bst.bstRoot, 12);
        bst.insertNode(bst.bstRoot, 5);

        //Level Order Traversal | TC-O(n) & SC-O(n)
        System.out.println("LevelOrder Traversal");
        bst.levelOrderTraversal(bst.bstRoot);

        //PreOrder Traversal | TC-O(n) & SC-O(n)
        System.out.println("\nPreOrder Traversal");
        bst.preOrderTraversal(bst.bstRoot);

        //PostOrder Traversal | TC-O(n) & SC-O(n)
        System.out.println("\nPostOrder Traversal");
        bst.postOrderTraversal(bst.bstRoot);

        //InOrder Traversal | TC-O(n) & SC-O(n)
        System.out.println("\nInOrder Traversal");
        bst.inOrderTraversal(bst.bstRoot);

        //Search Node in the tree | TC-O(logn) & SC-O(logn)
        searchNode(bst.bstRoot, 7);

        //Delete a node
        deleteNode(bst.bstRoot, 5);

        System.out.println("LevelOrder Traversal After Deletion");
        bst.levelOrderTraversal(bst.bstRoot);
    }

    /**
     * Delete a node from tree
     * @param bstRoot
     * @param data
     */
    private static Node deleteNode(Node bstRoot, int data) {
        if(null == bstRoot){
            System.out.println("Node not found in the tree!!");
            return null;
        }else if(data < bstRoot.data){
            bstRoot.left = deleteNode(bstRoot.left, data);
        }else if(data > bstRoot.data){
            bstRoot.right = deleteNode(bstRoot.right, data);
        }else{
            if(null != bstRoot.left && null != bstRoot.right){
                Node tempNode = bstRoot;
                Node minimumNode = getMinimalNodeFromRightSubtree(tempNode.right);
                bstRoot.data = minimumNode.data;
                bstRoot.right = deleteNode(bstRoot.right, minimumNode.data);
            }else if(null != bstRoot.left){
                bstRoot = bstRoot.left;
            }else if(null != bstRoot.right){
                bstRoot = bstRoot.right;
            }else{
                bstRoot = null;
            }
        }
        return bstRoot;
    }

    /**
     * Delete a node which has two child
     * @param node
     * @return
     */
    private static Node deleteNodeWithTwoChild(Node node) {
        Node minimalNode = getMinimalNodeFromRightSubtree(node.right);
        minimalNode.left = node.left;
        System.out.println(node.data + " with two child has been deleted");
        node = minimalNode;
        return node;
    }


    private static Node getMinimalNodeFromRightSubtree(Node node) {
        if(null == node.left){
            return node;
        }else{
            getMinimalNodeFromRightSubtree(node.left);
        }
        return null;
    }

    /**
     * Delete a node which has only one child
     * @param node
     * @return
     */
    private static Node deleteNodeWithOneChild(Node node) {
        System.out.println(node.data + " with one child has been deleted");
        node = null != node.left ? node.left : node.right;
        return node;
    }

    /**
     * Delete leaf node from the tree
     * @param node
     */
    private static Node deleteLeafNode(Node node) {
        System.out.println(node.data + " leaf node has been deleted");
        node = null;
        return node;
    }

    /**
     * Search a node in the tree using recursion | TC-O(logn) & SC-O(logn)
     * @param bstRoot
     * @param data
     */
    private static void searchNode(Node bstRoot, int data) {
        if(null == bstRoot){
            System.out.println("\nNode not found in the tree!!");
        }else if(data == bstRoot.data){
            System.out.println("\nNode found!");
        }else if(data < bstRoot.data){
            searchNode(bstRoot.left, data);
        }else if(data > bstRoot.data){
            searchNode(bstRoot.right, data);
        }
    }

    /**
     * InOrder Traversal | TC-O(n) & SC-O(n)
     * @param bstRoot
     */
    private void inOrderTraversal(Node bstRoot) {
        if(null == bstRoot){
            return;
        }
        inOrderTraversal(bstRoot.left);
        System.out.print(bstRoot.data + " ");
        inOrderTraversal(bstRoot.right);
    }

    /**
     * PostOrder Traversal | TC-O(n) & SC-O(n)
     * @param bstRoot
     */
    private void postOrderTraversal(Node bstRoot) {
        if(null == bstRoot){
            return;
        }
        postOrderTraversal(bstRoot.left);
        postOrderTraversal(bstRoot.right);
        System.out.print(bstRoot.data + " ");
    }

    /**
     * PreOrder Traversal | TC-O(n) & SC-O(n)
     * @param bstRoot
     */
    private void preOrderTraversal(Node bstRoot) {
        if(null == bstRoot){
            return;
        }
        System.out.print(bstRoot.data + " ");
        preOrderTraversal(bstRoot.left);
        preOrderTraversal(bstRoot.right);
    }

    /**
     * BST - Insert Root Node
     * @param data
     */
    private void insertRootNode(int data) {
        bstRoot = insertNode(bstRoot, data);
    }

    /**
     * BST Insertion
     * @param bstRoot
     * @param data
     */
    private Node insertNode(Node bstRoot, int data) {
        if(null == bstRoot){
            Node node = new Node();
            node.data = data;
            System.out.println("Node Inserted: " + data);
            return node;
        }else if(data <= bstRoot.data){
            bstRoot.left = insertNode(bstRoot.left, data);
            return bstRoot;
        }else if(data > bstRoot.data){
            bstRoot.right = insertNode(bstRoot.right, data);
            return bstRoot;
        }
        return bstRoot;
    }

    /**
     * Level Order Traversal using Queue as LinkedList | TC-O(n) & SC-O(n)
     * @param root
     */
    private void levelOrderTraversal(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        if(null == root){
            System.out.println("Tree is empty!!");
            return;
        }

        System.out.println("");

        while(!nodeQueue.isEmpty()){
            Node currentNode = nodeQueue.remove();
            System.out.print(currentNode.data + " ");

            if(null != currentNode.left){
                nodeQueue.add(currentNode.left);
            }
            if(null != currentNode.right){
                nodeQueue.add(currentNode.right);
            }
        }
    }

}
