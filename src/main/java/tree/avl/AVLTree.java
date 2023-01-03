package tree.avl;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

/**
 * AVL Tree Implementation
 * Created By: Shivam Kale
 * Description: AVL tree is also a type of BST with extra balancing property
 */
public class AVLTree {
    public AVLNode root;

    public AVLTree(){
        this.root = null;
        //System.out.println("AVL Tree Created");
    }

    public static void main(String[] args){
        AVLTree avlTree = new AVLTree();

        //Pre-Order Traversal - it is same as BST
        //avlTree.preOrder(avlTree.root);

        //In-Order Traversal - it is same as BST
        //avlTree.InOrder(avlTree.root);

        //Post-Order Traversal - it is same as BST
        //avlTree.postOrder(avlTree.root);

        //Level-Order Traversal - it is same as BST
        //avlTree.levelOrder(avlTree.root);

        avlTree.insert(50);
        avlTree.insert(40);
        avlTree.insert(30);
        avlTree.insert(60);
        avlTree.insert(65);
        avlTree.insert(55);
        avlTree.insert(59);

        avlTree.levelOrder(avlTree.root);

        avlTree.insert(25);

        avlTree.levelOrder(avlTree.root);

        avlTree.deleteNode(avlTree.root, 65);
        avlTree.levelOrder(avlTree.root);
    }

    /**
     * This method will return the height of the node
     * @param node
     * @return nodeHeight
     */
    public int getNodeHeight(AVLNode node){
        if(null == node)
            return 0;
        return node.height;
    }

    /**
     * Get the balance of node
     * @param node
     * @return nodeBalance
     */
    public int getNodeBalance(AVLNode node){
        if(null == node)
            return 0;
        return (getNodeHeight(node.left) - getNodeHeight(node.right));
    }

    /**
     * Delete a node from the AVL tree
     * @param root
     * @param data
     */
    private AVLNode deleteNode(AVLNode root, int data) {
        if(null == root){
            System.out.println("Node not found!!");
        }else if(data < root.data){
            root.left = deleteNode(root.left, data);
        }else if(data > root.data){
            root.right = deleteNode(root.right, data);
        }else{
            if(null == root.left && null == root.right){
                return null;
            }else if(null == root.left){
                return root.right;
            }else if(null == root.right){
                return root.left;
            }else if(null != root.left && null != root.right){
                AVLNode tempNode = root;
                AVLNode minNodeFromRightSubtree = getMinimalNode(tempNode.right);
                root.data = minNodeFromRightSubtree.data;
                root.right = deleteNode(root.right, minNodeFromRightSubtree.data);
            }
        }

        root.height = 1 + Math.max(getNodeHeight(root.left), getNodeHeight(root.right));
        int nodeBalance = getNodeBalance(root);

        //Right Rotation for Left-Left condition
        if (nodeBalance > 1 && getNodeBalance(root.left) >= 0){
            return rotateRight(root);
        }
        //Left & Right Rotation for Left-Right condition
        if (nodeBalance > 1 && getNodeBalance(root.left) < 0){
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        //Left Rotation for Right-Right condition
        if (nodeBalance < -1 && getNodeBalance(root.right) <= 0){
            return rotateLeft(root);
        }
        //Right & Left Rotation for Right-Left condition
        if (nodeBalance < -1 && getNodeBalance(root.right) > 0){
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    /**
     * Method to get the minimal node from the right subtree
     * @param node
     * @return minimalNode
     */
    private AVLNode getMinimalNode(AVLNode node) {
        if(null == node.left){
            return node;
        }
        return getMinimalNode(node.left);
    }

    /**
     * Right rotation
     * @param disbalancedNode
     * @return newRoot
     */
    public AVLNode rotateRight(AVLNode disbalancedNode){
        AVLNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getNodeHeight(disbalancedNode.left), getNodeHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getNodeHeight(newRoot.left), getNodeHeight(newRoot.right));
        return newRoot;
    }

    /**
     * Left Rotation
     * @param disbalancedNode
     * @return
     */
    public AVLNode rotateLeft(AVLNode disbalancedNode){
        AVLNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getNodeHeight(disbalancedNode.left), getNodeHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getNodeHeight(newRoot.left), getNodeHeight(newRoot.right));
        return newRoot;
    }

   /* *//**
     * Master method to insert a node in the AVL tree
     * @param root
     * @param data
     *//*
    private AVLNode insert(AVLNode root, int data) {
        if(null == root){
            this.root = insertNode(root, data);
            return this.root;
        }else{
            root = insertNode(root, data);
            return root;
        }
    }*/

    /**
     * Master method to insert a node in the AVL tree
     * @param data
     */
    private void insert(int data) {
        root = insertNode(root, data);
    }

    /**
     * Insert Node in the AVL tree
     * @param root
     * @param data
     * @return
     */
    private AVLNode insertNode(AVLNode root, int data) {
        if(null == root){
            AVLNode node = new AVLNode();
            node.data = data;
            node.height = 1;
            node.left = node.right = null;
            return node;
        }else if (data <= root.data){
            root.left = insertNode(root.left, data);
        }else if(data > root.data){
            root.right = insertNode(root.right, data);
        }

        root.height = 1 + Math.max(getNodeHeight(root.left), getNodeHeight(root.right));
        int nodeBalance = getNodeBalance(root);

        if(nodeBalance > 1 && data < root.left.data){
            return rotateRight(root);
        }

        if(nodeBalance > 1 && data > root.left.data){
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        if(nodeBalance < -1 && data > root.right.data){
            return rotateLeft(root);
        }

        if(nodeBalance < -1 && data < root.right.data){
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    /**
     * Level-Order Traversal - it is same as BST
     * @param root
     */
    private void levelOrder(AVLNode root) {
        Queue<AVLNode> queue = new LinkedList<>();
        if(null != root){
            queue.add(root);
        }else{
            return;
        }
        System.out.println("\nLevel Order Traversal");
        while(!queue.isEmpty()){
            AVLNode avlNode = queue.remove();
            System.out.print(avlNode.data + " ");
            if(null != avlNode.left){
                queue.add(avlNode.left);
            }
            if(null != avlNode.right){
                queue.add(avlNode.right);
            }
        }
    }

    /**
     * Post-Order Traversal - it is same as BST
     * @param root
     */
    private void postOrder(AVLNode root) {
        if(null == root){
            return;
        }
        InOrder(root.left);
        InOrder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * In-Order Traversal - it is same as BST
     * @param root
     */
    private void InOrder(AVLNode root) {
        if(null == root){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    /**
     * Pre-Order Traversal [Root->Left->Right]
     * @param root
     */
    private void preOrder(AVLNode root) {
        if(null == root)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
