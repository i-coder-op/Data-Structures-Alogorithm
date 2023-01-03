package tree.binarytree.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public BinaryNode root;

    public BinaryTree(){
        this.root = null;
    }

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();

        // creating root node | TC - O(1)
        binaryTree.createRootNode(10);

        // inserting node | TC - O(n) | This algorithm will be used in Binary search trees
        /*binaryTree.insertNodeBST(binaryTree.root, 7);
        binaryTree.insertNodeBST(binaryTree.root, 3);
        binaryTree.insertNodeBST(binaryTree.root, 11);
        binaryTree.insertNodeBST(binaryTree.root, 12);
        binaryTree.insertNodeBST(binaryTree.root, 8);*/

        binaryTree.insertNodeBT(binaryTree.root, 7);
        binaryTree.insertNodeBT(binaryTree.root, 3);
        binaryTree.insertNodeBT(binaryTree.root, 11);
        binaryTree.insertNodeBT(binaryTree.root, 12);
        binaryTree.insertNodeBT(binaryTree.root, 8);

        //preOrder traversal | TC - O(n)
        System.out.println("PreOrder Traversal:");
        binaryTree.preOrderTraversal(binaryTree.root);

        //inOrder traversal | TC - O(n)
        System.out.println("\nInOrder Traversal:");
        binaryTree.inOrderTraversal(binaryTree.root);

        //postOrder traversal | TC - O(n)
        System.out.println("\nPostOrder Traversal:");
        binaryTree.postOrderTraversal(binaryTree.root);

        //levelOrder traversal | TC - O(n) & SC - O(n)
        System.out.println("\nLevelOrder Traversal:");
        binaryTree.levelOrderTraversal(binaryTree.root);

        int numberToBeSearched = 7;
        System.out.println("\nSearching : " + numberToBeSearched);
        binaryTree.searchInTree(numberToBeSearched);

        /*//get the deepest node from the tree | TC-O(n)
        BinaryNode deepestBinaryNode = getDeepestNode(binaryTree.root);
        System.out.println("Deepest node in the tree" + deepestBinaryNode.data);

        //deleting deepest node from the tree will take | TC-O(n)
        deleteDeepestNode(binaryTree.root);*/

        // deleting a specific node from the tree | TC-O(n)
        deleteNode(binaryTree.root,7);

        System.out.println("\nLevelOrder Traversal After Deleting node from the tree:");
        binaryTree.levelOrderTraversal(binaryTree.root);

    }

    /**
     * Deleting a specific node from the tree | TC-O(n)
     * @param root
     * @param data
     */
    private static void deleteNode(BinaryNode root, int data) {
        if(null == root){
            System.out.println("Tree is empty!!");
            return;
        }else{
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(root);
            BinaryNode currentNode = null;
            while(!queue.isEmpty()){
                currentNode = queue.remove();
                if(currentNode.data == data){
                    currentNode.data = getDeepestNode(root).data;
                    deleteDeepestNode(root);
                    System.out.println("Node has been deleted from the tree");
                    return;
                }else{
                    if(null != currentNode.left){
                        queue.add(currentNode.left);
                    }
                    if(null != currentNode.right){
                        queue.add(currentNode.right);
                    }
                }
            }
        }
    }

    /**
     * Deleting the deepest node from the tree will take | TC-O(n)
     * We will use levelOrder traversals to delete the deepest node from the tree
     * @param root
     */
    private static void deleteDeepestNode(BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode deepestNode = getDeepestNode(root);

        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();

            if (deepestNode == presentNode.left){
                presentNode.left = null;
                System.out.println("Deepest node deleted");
                return;
            }else if(deepestNode == presentNode.right){
                presentNode.right = null;
                System.out.println("Deepest node deleted");
                return;
            }else{
                if(null != presentNode.left){
                    queue.add(presentNode.left);
                }
                if(null != presentNode.right){
                   queue.add(presentNode.right);
                }
            }
        }

    }

    /**
     * This method will be used to get the deepest node from the tree | TC-O(n)
     * we know that the last inserted node will the deepest node of the tree and using levelOrder traversal we can get that node
     * @param root
     * @return
     */
    private static BinaryNode getDeepestNode(BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryNode presentNode = null;
        while(!queue.isEmpty()){
            presentNode = queue.remove();
            if(null != presentNode.left){
                queue.add(presentNode.left);
            }
            if(null != presentNode.right){
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }

    /**
     * This method will insert node in the binary tree using level order traversal
     * @param root
     * @param data
     */
    private void insertNodeBT(BinaryNode root, int data) {
        if(null == root){
            root = new BinaryNode();
            root.data = data;
            root.left = null;
            root.right = null;
            System.out.println("Node inserted in BT as root node");
        }else{
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                BinaryNode currentNode = queue.remove();
                if(null == currentNode.left) {
                    BinaryNode node = new BinaryNode();
                    node.data = data;
                    node.left = null;
                    node.right = null;

                    currentNode.left = node;
                    System.out.println("Node inserted: " + data);
                    break;
                }else if(null == currentNode.right){
                    BinaryNode node = new BinaryNode();
                    node.data = data;
                    node.left = null;
                    node.right = null;

                    currentNode.right = node;
                    System.out.println("Node inserted: " + data);
                    break;
                }else{
                    if(null != currentNode.left){
                        queue.add(currentNode.left);
                    }
                    if(null != currentNode.right){
                        queue.add(currentNode.right);
                    }
                }
            }
        }

    }

    /**
     * This method will search the number in the entire tree using level order traversal | TC-O(n)
     * @param numberToBeSearched
     */
    private void searchInTree(int numberToBeSearched) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isNumberFound = false;

        while(!queue.isEmpty()){
            BinaryNode currentNode = queue.remove();
            if(currentNode.data == numberToBeSearched){
                isNumberFound = true;
                break;
            }else{
                if(null != currentNode.left){
                    queue.add(currentNode.left);
                }
                if(null != currentNode.right){
                    queue.add(currentNode.right);
                }
            }
        }

        if(isNumberFound)
            System.out.println("Number found");
        else
            System.out.println("Number not found");
    }

    /**
     * Level Order Traversal | using Queue as linked list
     * @param root
     */
    private void levelOrderTraversal(BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<>();
        //Initially insert root node in the queue
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode currentNode = queue.remove();
            System.out.print(currentNode.data + " ");
            if(null != currentNode.left){
                queue.add(currentNode.left);
            }
            if(null != currentNode.right){
                queue.add(currentNode.right);
            }
        }
    }

    /**
     * PostOrder Traversal | leftSubtree -> rightSubtree -> root
     * @param root
     */
    private void postOrderTraversal(BinaryNode root) {
        if(null == root){
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * InOrder Traversal | leftSubtree -> root -> rightSubtree
     * @param root
     */
    private void inOrderTraversal(BinaryNode root) {
        if(null == root) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    /**
     * PreOrder Traversal | root -> leftSubtree -> rightSubtree
     * @param root
     */
    private void preOrderTraversal(BinaryNode root) {
        if(null == root){
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * Recursive method to insert node in the tree | BST insertions
     * @param root
     * @param data
     */
    private void insertNodeBST(BinaryNode root, int data) {
        if(data < root.data){
            if(null == root.left){
                root.left = new BinaryNode();
                root.left.data = data;
                root.left.left = null;
                root.left.right = null;
                System.out.println("Node inserted in left subtree: " + data);
            }else
                insertNodeBST(root.left, data);
        }else if(data > root.data){
            if(null == root.right){
                root.right = new BinaryNode();
                root.right.data = data;
                root.right.left = null;
                root.right.right = null;
                System.out.println("Node inserted in right subtree: " + data);
            }else
                insertNodeBST(root.right, data);
        }
    }

    /**
     * Creating root node in the tree
     * @param data
     */
    private void createRootNode(int data) {
        if(null == root){
            root = new BinaryNode();
            root.data = data;
            root.left = null;
            root.right = null;
            System.out.println("Element inserted at as a root node " + data);
        }else{
            System.out.println("Root node is already present");
        }
    }

}
