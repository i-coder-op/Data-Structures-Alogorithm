package tree.binarytree.questions;

import tree.binarytree.linkedlist.BinaryNode;
import tree.binarytree.linkedlist.BinaryTree;

import java.util.*;

/**
 * [HARD] Leet Code 987. Vertical Order Traversal of a Binary Tree:
 * ==============================
 *
 * My Approach:
 * -------------
 * I solved this problem using recursion with all the test cases passing, but this problem statement can be solved using normal level order traversal using queue with slight modifications.
 *
 * Note:
 * ------
 * 1. Data Structure in which I have stored the information while traversing the nodes level wise.
 *
 * Map<Map<Integer (Column), Integer (Row)>, List<Integer>> verticalLevelOrderTraversals = new HashMap<>();
 *
 * Steps:
 * -------
 * 1. Initially, insert the root node in the verticalLevelOrderTraversals with column = 0 & row = 0.
 * 2. Now we will pass the root node initial column & row value to the compute method and this method will be called recursively.
 * 3. From root node if we are calling left node then column size will be decreased by 1
 *                example: if root column = 0 then left column = -1
 * 4. Now before calling for the root's left node insert the left node data in the verticalLevelOrderTraversals with appropriate column and row number.
 * 5. NOTE>>>> If two nodes with same coordinates like column = 0 & row = 2 then in that case we will check if already we have entry in map or not if it is there then we will insert the current value and sort the list.
 * 6. Same thing we will do it for right node as well.
 * 7. Once recursive method call is over then we will loop thru the MAP (verticalLevelOrderTraversals) and insert the values level wise in the List<List<Integer>> and return back.
 * 8. Done
 */
public class _8_BTreeVerticalLevelOrderTraversals {
    Integer columnValue = 0;
    Integer rowValue = 0;

    public static void main(String[] args) {
        _8_BTreeVerticalLevelOrderTraversals bTreeVerticalLevelOrderTraversals = new _8_BTreeVerticalLevelOrderTraversals();
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

        bTreeVerticalLevelOrderTraversals.verticalTraversals(binaryTree.root);

    }

    private void verticalTraversals(BinaryNode root) {
        Map<Map<Integer, Integer>, List<Integer>> verticalTraversalsMap = new HashMap<>();
        List<List<Integer>> verticalTraversalsList = new ArrayList<>();

        //Insert root node data at (0,0)
        if (null != root) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);

            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            verticalTraversalsMap.put(map, list);
        }

        //Insert left and right subtree nodes at appropriate level
        compute(root, verticalTraversalsMap, 0, 0);

        while(!verticalTraversalsMap.isEmpty()){
            for(int i=0;i<=this.rowValue;i++){
                List<Integer> nodeDataList = verticalTraversalsMap.get(Map.of(this.columnValue, i));
                if(null != nodeDataList){
                    verticalTraversalsList.add(nodeDataList);
                    verticalTraversalsMap.remove(Map.of(this.columnValue, i));
                }
            }
            this.columnValue++;
        }

        System.out.println("Vertical Level Order Traversals: " + verticalTraversalsList);
    }

    private void compute(BinaryNode root, Map<Map<Integer, Integer>, List<Integer>> verticalTraversalsMap, Integer columnValue, Integer rowValue) {
        //Base Condition
        if (null == root.left && null == root.right) {
            return;
        }

        //Induction
        Integer newLeftColumnValue = columnValue - 1;
        Integer newRightColumnValue = rowValue + 1;
        Integer newRowValue = rowValue + 1;

        if (null != root.left) {
            Map<Integer, Integer> key = new HashMap<>();
            key.put(newLeftColumnValue, newRowValue);
            if (!verticalTraversalsMap.containsKey(key)) {
                List<Integer> nodeDataList = new ArrayList<>();
                nodeDataList.add(root.left.data);
                verticalTraversalsMap.put(key, nodeDataList);
            } else {
                List<Integer> existingDataList = verticalTraversalsMap.get(key);
                existingDataList.add(root.left.data);
                Collections.sort(existingDataList);
                verticalTraversalsMap.put(key, existingDataList);
            }
            compute(root.left, verticalTraversalsMap, newLeftColumnValue, newRowValue);
        }

        if (null != root.right) {
            Map<Integer, Integer> key = new HashMap<>();
            key.put(newRightColumnValue, newRowValue);
            if (!verticalTraversalsMap.containsKey(key)) {
                List<Integer> nodeDataList = new ArrayList<>();
                nodeDataList.add(root.right.data);
                verticalTraversalsMap.put(key, nodeDataList);
            } else {
                List<Integer> existingDataList = verticalTraversalsMap.get(key);
                existingDataList.add(root.right.data);
                Collections.sort(existingDataList);
                verticalTraversalsMap.put(key, existingDataList);
            }
            compute(root.right, verticalTraversalsMap, newRightColumnValue, newRowValue);
        }

        if (this.columnValue > newLeftColumnValue) {
            this.columnValue = newLeftColumnValue;
        }

        if (this.rowValue < newRowValue) {
            this.rowValue = newRowValue;
        }
    }


}
