package tree.binarytree.array;

/**
 * Binary Tree implementation using Arrays
 * Created By: Shivam Kale
 */
public class BinaryTree {
    int[] binaryTree;
    int lastVisitedIndex;

    /**
     * Create binary tree | TC-O(1), SC-O(n)
     * @param size
     */
    public BinaryTree(int size){
        this.binaryTree = new int[size+1]; // everytime we will create an array with size+1 because we are going to ignore 0th index
        this.lastVisitedIndex = 0;
        /*System.out.println("Binary tree has been created with size: " + size);*/
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree(6);

        //Insert node in the binary tree | TC-O(1)
        tree.insertNode(tree, 6);
        tree.insertNode(tree, 5);
        tree.insertNode(tree, 4);
        tree.insertNode(tree, 3);
        tree.insertNode(tree, 2);
        tree.insertNode(tree, 1);

        //PreOrder Traversal (R00T->LEFT->RIGHT) | TC-O(n)
        System.out.println("\nPreOrder Traversal");
        tree.preOrder(1);

        //InOrder Traversal (LEFT->ROOT->RIGHT) | TC-O(n)
        System.out.println("\nInOrder Traversal");
        tree.inOrder(1);

        //InOrder Traversal (LEFT->RIGHT->ROOT) | TC-O(n)
        System.out.println("\nPostOrder Traversal");
        tree.postOrder(1);


        //search node in the tree using level order traversal | TC-O(n)
        tree.searchNode(2);

        //Delete node from the tree using level order traversal | TC-O(n)
        tree.deleteNode(5);

        //LevelOrder Traversal | TC-O(n)
        System.out.println("\nLevelOrder Traversal");
        tree.levelOrder();
    }

    private void deleteNode(int node) {
        int deepestNode = binaryTree[lastVisitedIndex];
        for(int index = 1;index<=lastVisitedIndex;index++){
            if(node == binaryTree[index]){
                binaryTree[index] = deepestNode;
                lastVisitedIndex--;
                System.out.println("Node has been deleted: " + node);
                return;
            }
        }
        System.out.println("Node not found to be deleted!!");
    }

    private void searchNode(int node) {
        for(int index = 1;index<=lastVisitedIndex;index++){
            if(node == binaryTree[index]){
                System.out.println("\nFound!!");
                return;
            }
        }
        System.out.println("\nNot Found!!");
    }

    private void levelOrder() {
        for(int index = 1;index<=lastVisitedIndex;index++){
            System.out.print(binaryTree[index] + " ");
        }
    }

    private void postOrder(int index) {
        if(index > (binaryTree.length-1)){
            return;
        }
        postOrder(2*index); // Left Subtree
        postOrder((2*index)+1); // Right Subtree
        System.out.print(binaryTree[index] + " ");
    }

    private void inOrder(int index) {
        if(index > binaryTree.length-1){
            return;
        }
        inOrder(2*index); // Left Subtree
        System.out.print(binaryTree[index] + " ");
        inOrder((2*index)+1); // Right Subtree
    }

    private void preOrder(int index) {
        if(index > (binaryTree.length-1)){
            return;
        }
        System.out.print(binaryTree[index] + " ");
        preOrder(2*index); // left subtree
        preOrder((2*index)+1); // right subtree
    }

    /**
     * Inserting a node in the binary tree | TC-O(1)
     * @param tree
     * @param data
     */
    private void insertNode(BinaryTree tree, int data) {
        if (tree.lastVisitedIndex == 0){
            tree.binaryTree[1] = data;
            tree.lastVisitedIndex++;
            System.out.println("Node has been inserted as root node");
        }else{
            if(tree.lastVisitedIndex == (tree.binaryTree.length-1)){
                System.out.println("Tree is full!!");
                return;
            }
            tree.lastVisitedIndex++;
            tree.binaryTree[lastVisitedIndex] = data;
            System.out.println("Node inserted: " + data);
        }
    }
}


