# DSA Revision Guide

## Binary Trees

**1. Height of BT**

Approach:
   1.	Apply the level order traversal and get the total level and that will be the height of binary tree.

Code:

    class Solution {
    public int maxDepth(TreeNode root) {
            if(null == root){
                return 0;
            }
    
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<List<TreeNode>> levelOrderTraversalList = new ArrayList<>();
    
            while (!queue.isEmpty()) {
                int qSize = queue.size();
                List<TreeNode> levelDataList = new ArrayList<>();
                for (int i = 0; i < qSize; i++) {
                    TreeNode removedNode = queue.poll();
                    levelDataList.add(removedNode);
    
                    if (null != removedNode.left) {
                        queue.add(removedNode.left);
                    }
                    if (null != removedNode.right) {
                        queue.add(removedNode.right);
                    }
                }
                levelOrderTraversalList.add(levelDataList);
            }
            return levelOrderTraversalList.size();
        }
    }

--------------------------------------------------------------------------------------

**2. Check if the Binary tree is height-balanced or not**

_Approach:_

1. Create an isHeightBalanced boolean variable to maintain if tree or subtree is balanced or not
2. Pass the root and check the left subtree and right subtree is balanced or not
3. If while recursively calling found the subtree is not balanced then we will set the flag isHeightBalanced = false

_Code:_

    class Solution {
    private Boolean isHeightBalancedInstance = true;
    
        public boolean isBalanced(TreeNode root) {
            if (null == root) {
                return true;
            }
    
            checkHeightBalanced(root);
            return this.isHeightBalancedInstance;
        }
    
        public int checkHeightBalanced(TreeNode root) {
            if (null == root.left && null == root.right) {
                return 0;
            }
    
            int leftH = 0;
            int rightH = 0;
            if (this.isHeightBalancedInstance != false) {
                if (null != root.left) {
                    leftH = 1 + checkHeightBalanced(root.left);
                }
    
                if (null != root.right) {
                    rightH = 1 + checkHeightBalanced(root.right);
                }
    
                if (leftH - rightH > 1 || leftH - rightH < -1) {
                    this.isHeightBalancedInstance = false;
                }
            }
    
            return Integer.max(leftH, rightH);
        }
    }

--------------------------------------------------------------------------------------

**3. Diameter of Binary Tree**

_Approach:_

    1. Find the height of the left subtree.
    2. Find the height of right subtree.
    3. Now diameter = leftHeight + rightHeight
    4. Create an instance variable to hold the biggest diameter by comparing the local diameter with instance diameter

_Code:_

    class Solution {
        public int diameter = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(null == root){
                return 0;
            }
    
            calculate(root);
            return this.diameter;
        }
    
        public int calculate(TreeNode root){
            //Base Condition
            if(null == root.left && null == root.right){
                return 0;
            }
    
            //Induction
            int leftHeight = 0;
            if(null != root.left){
                leftHeight = 1 + calculate(root.left);
            }
    
            int rightHeight = 0;
            if(null != root.right){
                rightHeight = 1 + calculate(root.right);
            }
    
            int diameter = leftHeight + rightHeight;
            
            if(this.diameter < diameter){
                this.diameter = diameter;
            }
            return Integer.max(leftHeight, rightHeight);
        }
    }

--------------------------------------------------------------------------------------

**4. Maximum path sum**

_Approach:_

    1. Take the sum of left subtree.
    2. Take the sum of right subtree.
    3. Calculate the sum with multiple options like below
        1. leftSubtreeSum = root.val + leftSum
        2. rightSubtreeSum = root.val + rightSum
        3. rootLeftRightSum = root.val + leftSum + rightSum
        4. rootSum = root.val
    4. Check which one is bigger and compare it with global variable and if the if finalSum after comparing Max of step 3's 4 conditions then replace it and return the Max of them.


_Code:_

    class Solution {
        
        int maxSum = -2147483648;
        
        public int maxPathSum(TreeNode root) {
            compute(root);
            return this.maxSum;
        }
    
        public int compute(TreeNode root){
            if(this.maxSum < root.val){
                this.maxSum = root.val;
            }
            //Base condition
            if(null == root.left && null == root.right){
                return root.val;
            }
    
            //Induction condition
            int leftSum = 0;
            if(null != root.left){
                leftSum = compute(root.left);
            }
    
            int rightSum = 0;
            if(null != root.right){
                rightSum = compute(root.right);
            }
    
           int leftRightRootSum = root.val + leftSum + rightSum;
           int leftRootSum = root.val + leftSum;
           int rightRootSum = root.val + rightSum;
    
           int maxLeftRight = Integer.max(leftRootSum, rightRootSum);
           int maxRootLeftRight = Integer.max(maxLeftRight, root.val); 
           int finalLeftRightRootSum = Integer.max(maxRootLeftRight, leftRightRootSum);
    
    
           if(finalLeftRightRootSum > this.maxSum){
            this.maxSum = finalLeftRightRootSum;
           }
           return Integer.max(Integer.max(leftRootSum, rightRootSum), root.val);
        }
    }

--------------------------------------------------------------------------------------

**5. Check if two trees are identical or not**

_Approach:_

    1. take the preOrder traversal of first BT in a list.
    2. take the preOrder traversal of second BT in another list.
    3. check two list with equals method and return the result.

_Code:_

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            List<Integer> firstTreeNodes = new ArrayList<>();
            traverse(p, firstTreeNodes);
    
            List<Integer> secondTreeNodes = new ArrayList<>();
            traverse(q, secondTreeNodes);
            
            return firstTreeNodes.equals(secondTreeNodes);
        }
    
        public void traverse(TreeNode root, List<Integer> treeNodes){
            if(null == root){
                treeNodes.add(null);
                return;
            }
    
            treeNodes.add(root.val);
            traverse(root.left, treeNodes);
            traverse(root.right, treeNodes);
        }
    }

_Another Optimized Code:_

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(null == p && null == q){
                return true;
            }
            
            if((null == p || null == q) || (p.val != q.val)){
                return false;
            }
    
            return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
    }

--------------------------------------------------------------------------------------

**6. Zig Zag Traversal of Binary Tree**

_Approach:_ It's a level order traversal just with a slight modification.

    1. Create queue and insert root node in it.
    2. Create a level variable to identify in which order we need to store the nodes in the list
        1. if level % 2 == 0
            then first right followed by left
        2. if level % 2 != 0
            then first left followed by right   



_Code:_

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
    
            List<List<Integer>> traversals = new ArrayList<>();
    
            int level = 2;
    
            if (null != root) {
                while (!queue.isEmpty()) {
                    List<TreeNode> treeNodes = new ArrayList<>();
                    List<Integer> nodeDataList = new ArrayList<>();
                    while (!queue.isEmpty()) {
                        TreeNode latestNode = queue.poll();
                        nodeDataList.add(latestNode.val);
                        treeNodes.add(latestNode);
                    }
    
                    traversals.add(nodeDataList);
    
                    Collections.reverse(treeNodes);
                    for (TreeNode node : treeNodes) {
                        if(level % 2 == 0){
                            if (null != node.right) {
                                queue.add(node.right);
                            }
                            if (null != node.left) {
                                queue.add(node.left);
                            }
                        }else{
                            if (null != node.left) {
                                queue.add(node.left);
                            }
                            if (null != node.right) {
                                queue.add(node.right);
                            }
                        }
                    }
                    level++;
                }
            }
    
            return traversals;
        }
    }
     
------------------------------------------------------------------------------------------------------------------

**7. Boundary Traversal of Binary Tree**

_Approach:_ I was good on my approach but was stuck on some test cases. since I was trying to solve it using recursion, but it can be solved iteratively.

    1. Find the leftBoundary (If current is not leaf then go to left and if left is null then go to right)
        
        -> Create a current pointer and initially assigned it to root.left
        -> Run thru the while loop until current is null.
        -> Check in loop if current node is the leaf node or not by using condition
            if(null == current.left && null == current.right) then break the loop.
        -> If above condition is not satisfied then current might have left/right subtree.
        -> If null != current.left then add the current.data into the leftBoundaryList assign current = current.left and
            continue the loop.
        -> If null == current.left then add the current.data into the leftBoundaryList assign current = current.right and
            continue the loop.

    2. Find the leaf nodes using preOrder traversal.
    3. Find the rightBoundary just like leftBoundary computation [If current is not leaf then go to right and if right is null then go to left]
        -> Once the rightBounday computation is done then reverse the list which has all the rightBoundary traversed nodes.

_Code:_

    public class Solution {
        public static List<Integer> traverseBoundary(TreeNode root){
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
    
        public static void computeLeafNodes(TreeNode root, List<Integer> leafNodes){
            if(null == root){
                return;
            }
    
            if(null == root.left && null == root.right){
                leafNodes.add(root.data);
            }
    
            computeLeafNodes(root.left, leafNodes);
            computeLeafNodes(root.right, leafNodes);
        }
    
        public static void computeLeftBoundary(TreeNode root, List<Integer> leftBoundaryNodes){
            TreeNode current = root;
            
            while(null != current){
                if(null == current.left && null == current.right){
                    break;
                }
                if(null != current.left){
                    leftBoundaryNodes.add(current.data);
                    current = current.left;
                    continue;
                }else{
                    leftBoundaryNodes.add(current.data);
                    current = current.right;
                }
            }
        }
    
        public static void computeRightBoundary(TreeNode root, List<Integer> rightBoundaryNodes){
            TreeNode current = root;
            
            while(null != current){
                if(null == current.left && null == current.right){
                    break;
                }
                if(null != current.right){
                    rightBoundaryNodes.add(current.data);
                    current = current.right;
                    continue;
                }else{
                    rightBoundaryNodes.add(current.data);
                    current = current.left;
                }
            }
        }
    }

_Easy Optimized Approach:_ Finally solved it using recursion!!!!

    1. Compute the left subtree nodes of the tree except leaf nodes.
        
        -> Start with root.left
        -> Add to the list
        -> if left is not null then go to left other wise go to right subtree.
        -> once leaf node condition is hit then return.

    2. Compute the right subtree nodes of the tree except leaf nodes.
        
        -> Start with root.right
        -> Add to the list
        -> if right is not null then go to right other wise go to left subtree.
        -> once leaf node condition is hit then return.
        -> finally reverse the list.
    
    3. Compute all the leaf nodes
    
    4. Add the root node followed by left nodes list followed by leaf nodes list then at the end add right nodes reversed list.


_Code:_

    public class Solution {
        public static List<Integer> traverseBoundary(TreeNode root){
            // Write your code here.
            //Get the left nodes
            List<Integer> left = new ArrayList<>(); 
            List<Integer> leaf = new ArrayList<>();           
            List<Integer> right = new ArrayList<>();
            List<Integer> ls = new ArrayList<>();
    
            computeL(root.left, left);
            computeLeaf(root, leaf);
            computeR(root.right, right);
            Collections.reverse(right);
    
            ls.add(root.data);
            ls.addAll(left);
            ls.addAll(leaf);
            ls.addAll(right);
            return ls;
        }
    
    
        static void computeL(TreeNode root, List<Integer> left){
            if(null == root){
                return;
            }
            if(null == root.left && null == root.right){
                return;
            }
    
            left.add(root.data);
            if(null == root.left){
                computeL(root.right, left);
            }else{
                computeL(root.left, left);
            }
        }
    
        static void computeR(TreeNode root, List<Integer> right){
            if(null == root){
                return;
            }
            
            if(null == root.left && null == root.right){
                return;
            }
    
            right.add(root.data);
            if(null == root.right){
                computeR(root.left, right);
            }else{
                computeR(root.right, right);
            }
        }
    
        static void computeLeaf(TreeNode root, List<Integer> leaf){
            if(null == root.left && null == root.right){
                leaf.add(root.data);
                return;
            }
            
            if(null != root.left){
                computeLeaf(root.left, leaf);
            }
    
            if(null != root.right){
                computeLeaf(root.right, leaf);
            }
        }
    }

------------------------------------------------------------------------------------------------------------------

**8. Vertical Order Traversal of Binary Tree**

_Approach:_ I solved this problem using recursion with all the test cases passing, but this problem statement can be solved using normal level order traversal using queue with slight modifications.

Note: Data Structure in which I have stored the information while traversing the nodes level wise.

Map<Map<Integer (Column), Integer (Row)>, List<Integer>> verticalLevelOrderTraversals = new HashMap<>();

    1. Initially, insert the root node in the verticalLevelOrderTraversals with column = 0 & row = 0.
    2. Now we will pass the root node initial column & row value to the compute method and this method will be called recursively.
    3. From root node if we are calling left node then column size will be decreased by 1
        example: if root column = 0 then left column = -1
    4. Now before calling for the root's left node insert the left node data in the verticalLevelOrderTraversals with appropriate column and row number.
    5. NOTE>>>> If two nodes with same coordinates like column = 0 & row = 2 then in that case we will check if already we have entry in map or not if it is there then we will insert the current value and sort the list.
    6. Same thing we will do it for right node as well.
    7. Once recursive method call is over then we will loop thru the MAP (verticalLevelOrderTraversals) and insert the values level wise in the List<List<Integer>> and return back.


_Code:_

    class Solution {
        int startColumn = 0;
        int totalRow = 0;

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> verticalTraversals = new ArrayList<>();
            Map<Map<Integer, Integer>, List<Integer>> verticalTraversalsMap = new HashMap<>();
    
            if (null != root) {
                List<Integer> zerothColumnList = new ArrayList<>();
                zerothColumnList.add(root.val);
                Map<Integer, Integer> key = new HashMap<>();
                key.put(this.startColumn, this.totalRow);
                verticalTraversalsMap.put(key, zerothColumnList);
            } else {
                return verticalTraversals;
            }
    
            compute(root, verticalTraversalsMap, startColumn, totalRow);
    
            while (!verticalTraversalsMap.isEmpty()) {
    
                List<Integer> list = new ArrayList<>();
                
                for(int i=0;i<=this.totalRow;i++){
                    Map<Integer, Integer> key = new HashMap<>();
                    key.put(this.startColumn, i);
    
                    List<Integer> tempList = verticalTraversalsMap.get(key);
                    if(null != tempList){
                        list.addAll(tempList);
                        verticalTraversalsMap.remove(key);
                    }
    
                }
                if(!list.isEmpty())
                    verticalTraversals.add(list);
                this.startColumn = this.startColumn + 1;
            }
            return verticalTraversals;
        }
    
        public void compute(TreeNode root, Map<Map<Integer, Integer>, List<Integer>> verticalTraversalsMap, Integer column, Integer row) {
            if (null == root.left && null == root.right) {
                return;
            }
    
            // Induction
            Integer newLeftColumn = column - 1;
            Integer newRightColumn = column + 1;
            Integer newRow = row + 1;
    
            if (null != root.left) {
                Map<Integer, Integer> key = new HashMap<>();
                key.put(newLeftColumn, newRow);
    
                if (!verticalTraversalsMap.containsKey(key)) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(root.left.val);
    
                    verticalTraversalsMap.put(key, newList);
                } else {
                    List<Integer> newList = verticalTraversalsMap.get(key);
                    newList.add(root.left.val);
                    Collections.sort(newList);
    
                    verticalTraversalsMap.put(key, newList);
                }
    
                compute(root.left, verticalTraversalsMap, newLeftColumn, newRow);
            }
    
            if (null != root.right) {
                Map<Integer, Integer> key = new HashMap<>();
                key.put(newRightColumn, newRow);
    
                if (!verticalTraversalsMap.containsKey(key)) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(root.right.val);
    
                    verticalTraversalsMap.put(key, newList);
                } else {
                    List<Integer> newList = verticalTraversalsMap.get(key);
                    newList.add(root.right.val);
                    Collections.sort(newList);
    
                    verticalTraversalsMap.put(key, newList);
                }
    
                compute(root.right, verticalTraversalsMap, newRightColumn, newRow);
            }
    
            if (newLeftColumn < this.startColumn) {
                this.startColumn = newLeftColumn;
            }
    
            if (newRow > this.totalRow) {
                this.totalRow = newRow;
            }
        }
    }

------------------------------------------------------------------------------------------------------------------

**9. Top View of Binary Tree**

_Approach:_ There may be a chance that you will get multiple nodes on the same column but for top view we need to take only the very first node of that column.

_Code:_

    class QueueData {
        Node node;
        Integer column;
        Integer row;
        
        QueueData(Node node, Integer column, Integer row){
            this.node = node;
            this.column = column;
            this.row = row;
        }
    }

    class Solution
    {
        //Function to return a list of nodes visible from the top view
        //from left to right in Binary Tree.
        static ArrayList<Integer> topView(Node root)
        {
        // add your code
        ArrayList<Integer> topVList = new ArrayList<>();
        Queue<QueueData> queue = new LinkedList<>();
        Map<Map<Integer, Integer>, Integer> map = new HashMap();
    
            Integer column = 0;
            Integer lastColumn = 0;
            Integer row = 0;
            
            if(null != root){
                QueueData data = new QueueData(root, column, row);
                queue.add(data);
            } else{
                return topVList;
            }
            
            while(!queue.isEmpty()){
                QueueData polledData = queue.poll();
                
                if(!map.containsKey(Map.of(polledData.column, polledData.row))){
                    map.put(Map.of(polledData.column, polledData.row), polledData.node.data);
                }
                
                if(null != polledData.node.left){
                    Integer leftColumnIndex = polledData.column - 1;
                    Integer newRow = polledData.row + 1;
                    
                    queue.add(new QueueData(polledData.node.left, leftColumnIndex, newRow));
                    
                    if(column > leftColumnIndex){
                        column = leftColumnIndex;
                    }
                
                    if(row < newRow){
                        row = newRow;
                    }
                }
                
                if(null != polledData.node.right){
                    Integer rightColumnIndex = polledData.column + 1;
                    Integer newRow = polledData.row + 1;
                    
                    if(lastColumn < rightColumnIndex){
                        lastColumn = rightColumnIndex;
                    }
                    
                    if(row < newRow){
                        row = newRow;
                    }
                    
                    queue.add(new QueueData(polledData.node.right, rightColumnIndex, newRow));
                }
            }

            while(column <= lastColumn){
                
                for(int i=0;i<=row;i++){
                    if(map.containsKey(Map.of(column, i))){
                        topVList.add(map.get(Map.of(column, i)));
                        break;
                    }
                }
                
                column++;
            }
            return topVList;
        }
    }

------------------------------------------------------------------------------------------------------------------

**10. Bottom View of Binary Tree**

_Approach:_ It's very easy approach using normal level order traversal. [Insertion in the map based on column]

_DS Used_:

    1. Map<Integer(column), Integer(node-data)> : To store the nodes data for each column.
    2. Queue<Pair(column, Node)> : To insert the column based nodes in the queue.
    3. ArrayList<Integer(node)> : used to store the final bottom node of the BT.

_Steps_:

    1. Create a Pair class with column and node information.
    2. Initialize the Map to hold column, node information.
    3. Initialize the queue of type pair and insert the root node as column = 0.
    4. Run thru the while loop and remove the node from the queue and add in the map with its column value.
    5. If map already contains the any value for the column then it will replace with the new value.
    6. Finally, once the queue is empty then we will have a map which will have the values based on column
    7. we will do the while loop again and retrieve each column with its value insert it in the array list and once addded to list then we will remove the column from the map and this loop will run till the map is not empty.
    8. Done.


_Code:_

    class Pair {
        public Integer column;
        public Node node;
        
        public Pair(Integer column, Node node){
            this.column = column;
            this.node = node;
        }
    }

    class Solution
    {
        //Function to return a list containing the bottom view of the given tree.
        public ArrayList <Integer> bottomView(Node root)
        {
            // Code here
            Map<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> bottomViewList = new ArrayList<>();
            Queue<Pair> queue = new LinkedList<>();
    
            Integer startColumn = 0;
            
            //Insert the root node in the queue
            queue.add(new Pair(0, root));
            
            while(!queue.isEmpty()){
                Pair polledPair = queue.poll();
                
                map.put(polledPair.column, polledPair.node.data);
                
                if(null != polledPair.node.left){
                    Integer newColumn = polledPair.column - 1;
                    queue.add(new Pair(newColumn, polledPair.node.left));
                    
                    if(startColumn > newColumn){
                        startColumn = newColumn;
                    }
                }
                
                if(null != polledPair.node.right){
                    Integer newColumn = polledPair.column + 1;
                    queue.add(new Pair(newColumn, polledPair.node.right));
                }
            }
            
            
            while(!map.isEmpty()){
                if(map.containsKey(startColumn)){
                    bottomViewList.add(map.get(startColumn));
                    map.remove(startColumn);
                }
                startColumn = startColumn + 1;
            }
            
            return bottomViewList;
        }
    }

------------------------------------------------------------------------------------------------------------------

**11. Right/Left View of Binary Tree**

_Approach:_ I have solved this question using two approaches.

_Different Approaches_:

    1. Using level order traversal iteratively [Takes 2 ms]
    2. Using Recursion [Takes 1 ms] [Optimal]

_Code (Approach 1 Using level order traversals)_:

    class Pair{
        Integer row;
        TreeNode node;
        
        Pair(Integer row, TreeNode node){
            this.row = row;
            this.node = node;
        }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> rightSideView = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            Queue<Pair> queue = new LinkedList<>();
            Integer rowCount = 0;
    
            if(null != root){
                queue.add(new Pair(rowCount, root));
            }else{
                return rightSideView;
            }
    
            while(!queue.isEmpty()){
                Pair polledPair = queue.poll();
                int row = polledPair.row;
    
                map.put(row, polledPair.node.val);
    
                boolean incRequired = false;
    
                if(null != polledPair.node.left){
                    queue.add(new Pair(row+1, polledPair.node.left));
                    incRequired = true;
                }
    
                if(null != polledPair.node.right){
                    queue.add(new Pair(row+1, polledPair.node.right));
                    incRequired = true;
                }
    
                if(incRequired)
                    rowCount = rowCount+1;
            }
    
            for(int i=0;i<=rowCount;i++){
                if(map.containsKey(i)){
                   rightSideView.add(map.get(i));
                   map.remove(i); 
                }
            }
    
            return rightSideView;
        }
    }

_Code (Approach 1 Using recursion)_:

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> rightSideView = new ArrayList<>();
            if (null != root) {
                rightSideView.add(root.val);
            } else {
                return rightSideView;
            }
    
            compute(root, 0, rightSideView);
            return rightSideView;
        }
    
        public List<Integer> compute(TreeNode root, Integer row, List<Integer> rightSideView) {
            // Base case
            if (null == root.left && null == root.right) {
    
                if (row < rightSideView.size()) {
                    rightSideView.set(row, root.val);
                }else{
                    rightSideView.add(root.val);
                }
                return rightSideView;
            }
    
            if (row < rightSideView.size()) {
                rightSideView.set(row, root.val);
            }else{
                rightSideView.add(root.val);
            }
    
            if (null != root.left) {
                compute(root.left, row+1, rightSideView);
            }
    
            if(null != root.right){
                compute(root.right, row+1, rightSideView);
            }
    
            return rightSideView;
        }
    }

------------------------------------------------------------------------------------------------------------------

**12. Symmetric Binary Tree**

_Approach:_ There are many approach to solve this question.

_Different Approaches_:

    1. Brute force which i have follwed by using level order traversal.
    2. Optimal recursive approach by identifying pattern
        -> Root's left is equal to Root's right
        -> Root's right is equal to Root's left
        If these above two conditions are satisfied then BT is symmetric binary tree.

_Code (Approach 1 Brute Force)_:

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (null == root) {
                return true;
            }
    
            List<List<Integer>> leftList = new ArrayList<>();
            List<List<Integer>> rightList = new ArrayList<>();
    
            if (null != root.left) {
                compute(root.left, leftList, false);
            }
            if (null != root.right) {
                compute(root.right, rightList, true);
            }
    
            if (leftList.equals(rightList)) {
                return true;
            }
    
            return false;
        }
        public void compute(TreeNode root, List<List<Integer>> traversals, boolean isRight) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            traversals.add(List.of(root.val));
    
            while (!queue.isEmpty()) {
                List<TreeNode> list = new ArrayList<>();
                List<Integer> nodeDataList = new ArrayList<>();
    
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    list.add(node);
                }
    
                for (TreeNode node : list) {
                    if (null != node.left) {
                        nodeDataList.add(node.left.val);
                        queue.add(node.left);
                    } else {
                        nodeDataList.add(1);
                    }
    
                    if (null != node.right) {
                        nodeDataList.add(node.right.val);
                        queue.add(node.right);
                    } else {
                        nodeDataList.add(1);
                    }
                }
    
                if (isRight) {
                    Collections.reverse(nodeDataList);
                    traversals.add(nodeDataList);
                } else {
                    traversals.add(nodeDataList);
                }
            }
        }
    }

_Code (Approach 2 - Optimal Using recursion)_:

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return compute(root, root);
        }
    
        public boolean compute(TreeNode root1, TreeNode root2){
            //Base Condition
            if(null == root1 && null == root2){
                return true;
            }
    
            if(null == root1 || null == root2){
                return false;
            }
    
            if(root1.val != root2.val){
                return false;
            }
    
            //Induction step
            return compute(root1.left, root2.right) && compute(root1.right, root2.left);
        }
    }

------------------------------------------------------------------------------------------------------------------

**13. LCA in Binary Tree**

_Approach:_ I have tried solving this problem using brute force approach where I am holding details in the map as

    node -> list of ancestors
    which is actually not optimised solution.
    Brute force approach failed at time limit exceed by me

_Code (Approach 1 Brute Force)_:

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (null == root) {
                return null;
            }
    
            Map<Integer, List<TreeNode>> map = new HashMap<>();
            map.put(root.val, List.of(root));
            compute(root, p.val, q.val, map, new ArrayList<>());
            List<TreeNode> pAncestors = map.get(p.val);
            Collections.reverse(pAncestors);
            List<TreeNode> qAncestors = map.get(q.val);
            Collections.reverse(qAncestors);
    
            if(pAncestors.size() > qAncestors.size()){
                for(TreeNode element : qAncestors){
                    if(pAncestors.contains(element)){
                        return element;
                    }
                }
            }else{
                for(TreeNode element : pAncestors){
                    if(qAncestors.contains(element)){
                        return element;
                    }
                }
            }
            return root;
        }
    
        public void compute(TreeNode root, Integer p, Integer q, Map<Integer, List<TreeNode>> map, List<TreeNode> list) {
            //Base condition
            if(null == root.left && null == root.right){
                return;
            }
    
            if(null != root.left && (!map.containsKey(p) || !map.containsKey(q))){
                List<TreeNode> newLs = new ArrayList<>();
                newLs.addAll(list);
                newLs.add(root);
                compute(root.left, p, q, map, newLs);
                newLs.add(root.left);
                if(root.left.val == p || root.left.val == q){
                    map.put(root.left.val, newLs);
                }
            }
    
            if(null != root.right && (!map.containsKey(p) || !map.containsKey(q))){
                List<TreeNode> newLs = new ArrayList<>();
                newLs.addAll(list);
                newLs.add(root);
                compute(root.right, p, q, map, newLs);
                newLs.add(root.right);
                if(root.right.val == p || root.right.val == q){
                    map.put(root.right.val, newLs);
                }
            }
        }
    }


_Optimal Approach_:

    1. Pass the root node and call recursively for left and right.
    2. as a base condition if current root has P or Q or Current root is null then return the same.
    3. If p or q is present on left or right then return the same.
    4. If p or q present in both subtree like in left or right then return the root.
    5. Done.

    NOTE: Ya toh p or q left me hoga ya toh right me hoga agar left me hoga toh left return kro right me hue toh right return
    asa bhi ho skhta he ki ek left me ho dusra right me then in that case return root.

_Code (Approach 2 - Optimal Approach)_:

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return compute(root, p, q);
        }
    
        public TreeNode compute(TreeNode root, TreeNode p, TreeNode q){
            //Base Condition
            if(null == root || root.val == p.val || root.val == q.val){
                return root;
            }
    
            TreeNode left = compute(root.left, p, q);
            TreeNode right = compute(root.right, p, q);
    
            if(null != left && null != right){
                return root;
            }
    
            if(null == left){
                return right;
            }
    
            if(null == right){
                return left;
            }
            return root;
        }
    }

------------------------------------------------------------------------------------------------------------------

**14. Maximum width of a Binary Tree**

_Approach:_ We need to use level order traversal using indexing of each node.

    1. if parent = 2 then 
          left = parent * 2 
          right = parent * 2+1

    2. So, while adding the node into queue make sure to insert index of that particular node.
    
    3. I have used Map<Integer, TreeNode>
        where,
            Integer = index of current node
            TreeNode = current node

_Code (Approach 1 Brute Force)_:

    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if(null == root){
                return 0;
            }
    
            int max = 1;
    
            Queue<Map<Integer, TreeNode>> q = new LinkedList<>();
            q.add(Map.of(1, root));
            
            int start = 0;
            int end = 0;
    
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    Map<Integer, TreeNode> polledNode = q.poll();
                    Map.Entry<Integer,TreeNode> entry = polledNode.entrySet().iterator().next();
                    int currentIndex = entry.getKey();
                    if(i==0){
                        start = currentIndex;
                    }
                    if(i == (size-1)){
                        end = currentIndex;
                    }
    
                    if(null != entry.getValue().left){
                        q.add(Map.of(currentIndex * 2, entry.getValue().left));
                    }
    
                    if(null != entry.getValue().right){
                        q.add(Map.of(currentIndex*2 + 1, entry.getValue().right));
                    }
                }
    
                max = Integer.max(max, (end-start) + 1);
            }
    
            return max;
        }
    }

------------------------------------------------------------------------------------------------------------------

**15. Count total Nodes in a COMPLETE Binary Tree**

_Approach:_

    1. Declare an instance variable count which will be responsible to count number of nodes in tree.
    2. traverse each node using any of the traversal and increment the count++ for each node.
    3. Done

_Code_:

    class Solution {
        Integer count = 0;
        public int countNodes(TreeNode root) {
            if(null == root){
                return this.count;
            }
            compute(root);
            return this.count;
        }
        public void compute(TreeNode root){
            //Base Condition
            if(null == root.left && null == root.right){
                this.count = this.count + 1;
                return;
            }
            //Induction
            this.count = this.count+1;
            
            if(null != root.left){
                compute(root.left);
            }
    
            if(null != root.right){
                compute(root.right);
            }
        }
    }

------------------------------------------------------------------------------------------------------------------

**16. Flatten Binary Tree to LinkedList**

_Approach:_

    1. It's very easy just do preorder traversal and add each node while traversing to a list.
    2. Then in the same tree if left node of current root node is present then remove it and add new node on the right and move the current pointer to next inserted node.

_Code_:

    class Solution {
        public void flatten(TreeNode root) {
            TreeNode newRoot = null;
            List<Integer> nodes = new ArrayList<>();
            compute(root, nodes);
    
            if(!nodes.isEmpty()){
                root.left = null;
                root.right = null;
                TreeNode temp = root;
                for(int i=1;i<nodes.size();i++){
                    temp.right = new TreeNode(nodes.get(i));
                    temp = temp.right;
                }
            }
        }
    
        public void compute(TreeNode root, List<Integer> nodes) {
            if (null == root) {
                return;
            }
            nodes.add(root.val);
            compute(root.left, nodes);
            compute(root.right, nodes);
        }
    }

------------------------------------------------------------------------------------------------------------------

**17. Construct Binary Tree from inorder and preorder**

_Approach:_ By using inorder we can basically create a unique binary tree. It can be with combination of preorder or postorder.

    Note:
    -----
    
    1. Preorder always gives the first node as root of the binary tree
    2. Inorder always gives left root right combination.
    3. Prepare a map with all the nodes of inorder array with value as its index to basically perform seaching an index very fast.
    
    Conditions to remember:
    -----------------------

    1. when building left subtree
        
        -> inorder
        i1 = 0;
        i2 = index-1;       
        
        -> preorder
        p1 = p1+1;
        p2 = p1 + (index-i1);

    2. When building right subtree
        
        -> inorder
        i1 = index+1;
        i2 = length-1;
        
        -> preorder
        p1 = p1+(index-i1)+1
        p2 = length-1


_Code_:

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
        return root;
    }

    TreeNode construct(int[] preorder, int p1, int p2, int[] inorder, int i1, int i2,
            Map<Integer, Integer> inorderMap) {
        // Base Condition
        if(p1>p2 || i1>i2){
            return null;
        }

        TreeNode root = new TreeNode(preorder[p1]);
        int index = inorderMap.get(preorder[p1]);
        root.left = construct(preorder, p1+1, p1+(index-i1), inorder, i1, index-1, inorderMap);
        root.right = construct(preorder, p1+(index-i1)+1, p2, inorder, index+1, i2, inorderMap);

        return root;
    }

------------------------------------------------------------------------------------------------------------------

**18. Construct the Binary Tree from Postorder and Inorder Traversal**

_Approach:_ By using inorder we can basically create a unique binary tree. It can be with combination of preorder or postorder.

    Note:
    -----
    
    1. Postorder always gives the lastnode as root of the binary tree.
    2. Inorder always gives left root right combination.
    3. Prepare a map with all the nodes of inorder array with value as its index to basically perform seaching an index very fast.
    
    Conditions to remember:
    -----------------------

    1. when building left subtree
        
        -> inorder
            q1 = 0;
            q2 = index-1;
            
        -> preorder
            p1 = p1
            p2 = p1 + (index-q1)-1;

    2. When building right subtree
        
        -> inorder
            q1 = index+1;
            q2 = length-1;
            
        -> preorder
            p1 = p1+(index-q1)
            p2 = p2-1


_Code_:

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<inorder.length;i++){
                map.put(inorder[i], i);
            }
    
            return construct(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
        }
    
        TreeNode construct(int[] inorder, int q1, int q2, int[] postorder, int p1, int p2, HashMap<Integer, Integer> map){
            //Base Condition
            if(p1>p2 || q1>q2){
                return null;
            }
    
            //Induction
            TreeNode root = new TreeNode(postorder[p2]);
            int index = map.get(postorder[p2]);
    
            root.left = construct(inorder, q1, index-1, postorder, p1, p1+index-q1-1, map);
            root.right = construct(inorder, index+1, q2, postorder, p1+index-q1, p2-1, map);
            return root;
        }
    }

------------------------------------------------------------------------------------------------------------------

**18. Construct the Binary Tree from Postorder and Inorder Traversal**

_Approach:_ By using inorder we can basically create a unique binary tree. It can be with combination of preorder or postorder.

    Note:
    -----
    
    1. Postorder always gives the lastnode as root of the binary tree.
    2. Inorder always gives left root right combination.
    3. Prepare a map with all the nodes of inorder array with value as its index to basically perform seaching an index very fast.
    
    Conditions to remember:
    -----------------------

    1. when building left subtree
        
        -> inorder
            q1 = 0;
            q2 = index-1;
            
        -> preorder
            p1 = p1
            p2 = p1 + (index-q1)-1;

    2. When building right subtree
        
        -> inorder
            q1 = index+1;
            q2 = length-1;
            
        -> preorder
            p1 = p1+(index-q1)
            p2 = p2-1


_Code_:

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<inorder.length;i++){
                map.put(inorder[i], i);
            }
    
            return construct(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
        }
    
        TreeNode construct(int[] inorder, int q1, int q2, int[] postorder, int p1, int p2, HashMap<Integer, Integer> map){
            //Base Condition
            if(p1>p2 || q1>q2){
                return null;
            }
    
            //Induction
            TreeNode root = new TreeNode(postorder[p2]);
            int index = map.get(postorder[p2]);
    
            root.left = construct(inorder, q1, index-1, postorder, p1, p1+index-q1-1, map);
            root.right = construct(inorder, index+1, q2, postorder, p1+index-q1, p2-1, map);
            return root;
        }
    }

------------------------------------------------------------------------------------------------------------------

**19. Serialize and deserialize Binary Tree**

_Approach:_ There are two approaches.

        1. One is my solution.
        2. Another is solution provided by takeuforward.
        3. Both solutions don't have much difference.
    
       Steps:
       ------

        1. Convert the tree into a string with comma separated.
        2. For any null node insert 1111
        3. Use level order traversal to serialize the tree into string.
        4. At deserialization insert the very first node of the serialized string.
        5. Create a lookup map which finds the left node data and right node data when we dequeue the node from queue.
        6. insert left node to dequeued node if data is not 1111.
        7. Insert right node to dequeued node if data is not 1111.
        8. Insert both nodes into queue if data is not 1111.
        9 Done.


_Code_ (By TakeUForward):

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String serialized = "";
            if (null == root) {
                return serialized;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (null == node) {
                    serialized = serialized.concat(",1111");
                    continue;
                } else {
                    if (index == 1) {
                        serialized = serialized.concat(String.valueOf(node.val));
                        index++;
                    } else {
                        serialized = serialized.concat("," + String.valueOf(node.val));
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            // System.out.println(serialized);
            return serialized;
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) {
                return null;
            }
    
            String[] nodes = data.split(",");
            HashMap<Integer, Integer> lookup = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
    
            for(int i=0;i<nodes.length;i++){
                lookup.put(i+1, Integer.parseInt(nodes[i]));
            }
    
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            queue.add(root);
            
            int index = 1;
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                int leftData = lookup.get(2*index);
                int rightData = lookup.get(2*index+1);
                
                if(leftData != 1111){
                    TreeNode lNode = new TreeNode(leftData);
                    node.left = lNode;
                    queue.add(lNode);
                }
    
                if(rightData != 1111){
                    TreeNode rNode = new TreeNode(rightData);
                    node.right = rNode;
                    queue.add(rNode);
                }
                index++;
            }
            return root;
        }
    }

_Code_ (By Shivam):

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String serialized = "";
            if (null == root) {
                return serialized;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (null == node) {
                    serialized = serialized.concat(",1111");
                    continue;
                } else {
                    if (index == 1) {
                        serialized = serialized.concat(String.valueOf(node.val));
                        index++;
                    } else {
                        serialized = serialized.concat("," + String.valueOf(node.val));
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            // System.out.println(serialized);
            return serialized;
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) {
                return null;
            }
    
            String[] nodes = data.split(",");
            HashMap<TreeNode, Integer> lookup = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
    
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            queue.add(root);
    
            for (int i = 1; i < nodes.length; i++) {
                TreeNode node = queue.peek();
                
                if(Integer.parseInt(nodes[i]) != 1111){
                    TreeNode newNode = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.add(newNode);
    
                    if (null == node.left && !lookup.containsKey(node)) {
                        node.left = newNode;
                    } else {
                        if (null == node.right) {
                            node.right = newNode;
                        }
                    }
                }
    
                if (lookup.containsKey(node)) {
                    lookup.put(node, lookup.get(node) + 1);
                } else {
                    lookup.put(node, 1);
                }
    
                if (lookup.get(node) == 2) {
                    queue.poll();
                }
            }
            return root;
        }
    }

------------------------------------------------------------------------------------------------------------------

## Binary Search Trees

**1. Search in a Binary Search Tree**

_Approach:_ Traverse each node and check if val is at root then set result with that value if not then either that value will be in.

        1. left subtree
            if val < root.val
        2. right subtree
            if val > root.val

_Code_:

    class Solution {
        TreeNode result = null;
        public TreeNode searchBST(TreeNode root, int val) {
            compute(root, val);
            return this.result;
        }
    
        public void compute(TreeNode root, int val){
            //Base Condition
            if(null == root){return;}
            
            //Induction
            if(root.val == val){
                this.result = root;
            } else {
                if(val < root.val){
                    compute(root.left, val);
                }else{
                    compute(root.right, val);
                }
            }
        }
    }

------------------------------------------------------------------------------------------------------------------

**2. Find Min/Max in BST**

_Approach:_

        1.	Apply inorder traversal on binary search tree and store the traversal in the list.
        2.	first element will always be minimum and last element will always be maximum.

_Code_:

    public class Solution
    {
        public static int minValue(Node root) {
            Stack<Node> stack = new Stack<>();
            ArrayList<Integer> inorder = new ArrayList<>();
            Node current = root;
    
            while(true){
                if(null != current){
                    stack.push(current);
                    current = current.left;
                }else{
                    if(stack.isEmpty()){
                        break;
                    }
                    current = stack.pop();
                    inorder.add(current.data);
                    current = current.right;
                }
            }
    
            if(!inorder.isEmpty()){
                return inorder.get(0);
            }
            return -1;
        }
    }

------------------------------------------------------------------------------------------------------------------

**3. Ceil in a Binary Search Tree**

_Approach:_

        1.	Approach is simple, we just need to use BST property.
        2.	Along with that we will be maintaining a global instance variable to store the final results.

_Code_:

    public class Solution {
        int value = Integer.MAX_VALUE;
        public  static int findCeil(TreeNode<Integer> node, int x) {
            Solution s = new Solution();
            s.compute(node, x, s);
            if(s.value == Integer.MAX_VALUE){
                return -1;
            }
            return s.value;
        }
         void compute(TreeNode<Integer> root, int x, Solution s){
            if(null == root){ 
                return; 
            }
            if(root.data == x){
                s.value = root.data;
                return;
            }
    
            if(x < root.data){
                if(s.value > root.data){
                    s.value = root.data;
                }
                compute(root.left, x, s);
            }
    
            if(x > root.data){
                compute(root.right, x, s);
            }
        }
    }

------------------------------------------------------------------------------------------------------------------

**4. Floor in a Binary Search Tree**

_Approach:_

        1.	Approach is simple, we just need to use BST property.
        2.	Along with that we will be maintaining a global instance variable to store the final results.

_Code_:

    public class solution {
        int floor = Integer.MAX_VALUE;
        public static int Floor(BinaryTreeNode<Integer> node, int input) {
            solution s = new solution();
            s.compute(node, input, s);
            return s.floor;
        }

        void compute(BinaryTreeNode<Integer> root, int k, solution s){
            if(null == root){ 
                return; 
            }
            
            if(root.data ==  k){
                s.floor = root.data;
                return;
            }

            if(k < root.data){
                if(s.floor > root.data){
                    s.floor = root.data;
                }

			    compute(root.left, k, s);
		    }

		    if(k > root.data){
                    s.floor = root.data;
                    compute(root.right, k, s);
            }
        }
    }

------------------------------------------------------------------------------------------------------------------

**5. Insert a given Node in Binary Search Tree**

_Approach:_ It’s easy just use BST property like
        
        1. if value is greater than root then
            -> go to right subtree and insert.
        2. else
            -> go to left subtree and insert

_Code_:

    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            //Base Condition
            if(null == root){
                return new TreeNode(val);
            }
    
            //Induction
            if(val < root.val){
                root.left = insertIntoBST(root.left, val);
            }else{
                root.right = insertIntoBST(root.right, val);
            }
    
            return root;
        }
    }

------------------------------------------------------------------------------------------------------------------

**6. Delete a Node in Binary Search Tree**

_Approach:_ Approach is very simple, to delete a node in BST we will have three conditions.

        1. Node to be deleted is a leaf node, in this case we will return null.
        2. Node to be delete have left subtree null so we will return right subtree or have right subtree null so we will return left subtree.
        3. Node to be deleted have both left and right subtree. In this case we need to find the smallest node in the right subtree and replace smallest node value with the node to be deleted. after that we need to delete the smallest node of right subtree.

_Code_:

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(null == root){
                return null;
            }
    
            if(root.val == key){
                if(null == root.left && null == root.right){
                    return null;
                }
    
                if(null != root.left && null != root.right){
                    TreeNode smallestNode = find(root.right);
                    root.val = smallestNode.val;
                    root.right = deleteNode(root.right, smallestNode.val);
                    return root;
                }
    
                if(null == root.left){
                    return root.right;
                }
    
                if(null == root.right){
                    return root.left;
                }
            }
    
            if(key < root.val){
                root.left = deleteNode(root.left, key);
            }
    
            if(key > root.val){
                root.right = deleteNode(root.right, key);
            }
            
            return root;
        }
    
        public TreeNode find(TreeNode root){
            if(null == root.left){
                return root;
            }
    
            return find(root.left);
        }
    }

------------------------------------------------------------------------------------------------------------------

**7. Find K-th smallest/largest element in BST**

_Approach:_

        1. Simply just apply the in-order traversal. 
        2. which will automatically sort the nodes from left to right
        3. keep on adding the nodes to a list.
        4. Once traversal is finished then return list.get(k-1).

_Code_:

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrderList = new ArrayList<>();
        compute(root, inOrderList);
        return inOrderList.get(k-1);
    }

    public void compute(TreeNode root, List<Integer> inOrderList){
        //Base Condition
        if(null == root){
            return;
        }

        //Induction step
        compute(root.left, inOrderList);
        inOrderList.add(root.val);
        compute(root.right, inOrderList);
    }

------------------------------------------------------------------------------------------------------------------

**8. Check if a tree is a BST or BT**

_Approach:_ Approach is very simple, to delete a node in BST we will have three conditions.

    1. Use InOrder traversal in recursive way and store each element rather than printing to a list.
    2. At every call check if left subtree is valid BST
    3. Check if the last inserted value in the list is smaller than the current value.
    4. At every call check if the right subtree is valid BST.
    5. If 2,3,4 are satisfied then return true as result else false.

_Code_:

    class Solution {
        public boolean isValidBST(TreeNode root) {
            Boolean isBST = false;
            if (null == root) {
                return isBST;
            }
            if (null == root.left && null == root.right) {
                isBST = true;
                return isBST;
            }
    
            List<Integer> inOrderTraversals = new ArrayList<>();
            isBST = compute(root, inOrderTraversals);
            return isBST;
        }
    
        public Boolean compute(TreeNode root, List<Integer> inOrderTraversals) {
            // Base condition
            if (null == root.left && null == root.right) {
                if (!inOrderTraversals.isEmpty() && inOrderTraversals.get(inOrderTraversals.size() - 1) >= root.val) {
                    return false;
                } else {
                    inOrderTraversals.add(root.val);
                }
                return true;
            }
    
            if (null != root.left) {
                Boolean leftResult = compute(root.left, inOrderTraversals);
                if (!leftResult) {
                    return false;
                }
            }
    
            Boolean result = false;
    
            if (!inOrderTraversals.isEmpty() && inOrderTraversals.get(inOrderTraversals.size() - 1) >= root.val) {
                return false;
            } else {
                result = true;
                inOrderTraversals.add(root.val);
            }
    
            if (null != root.right) {
                Boolean rightResult = compute(root.right, inOrderTraversals);
                if (!rightResult) {
                    return false;
                }
            }
    
            return result;
        }
    }

_Code_ (By Me - Optimized):

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(null == root){
                return false;
            }
    
            if(null == root.left && null == root.right){
                return true;
            }
    
            List<Integer> ls = new ArrayList<>();
            compute(root, ls);
    
            if(!ls.isEmpty()){
                int p1 = 0;
                int p2 = 1;
                while(p2 < ls.size()){
                    if(ls.get(p1) >= ls.get(p2)){
                        return false;
                    }
                    p1++;
                    p2++;
                }
            }
            return true;
        }
    
        void compute(TreeNode root, List<Integer> ls){
            if(null == root){
                return;
            }
    
            compute(root.left, ls);
            ls.add(root.val);
            compute(root.right, ls);
        }
    }

_Code_ (By Me - More Optimized):

    class Solution {
        boolean isValidBST = true;
        public boolean isValidBST(TreeNode root) {
            if(null == root){
                return false;
            }
    
            if(null == root.left && null == root.right){
                return true;
            }
    
            List<Integer> ls = new ArrayList<>();
            compute(root, ls);
    
            return this.isValidBST;
        }
    
        void compute(TreeNode root, List<Integer> ls){
            if(null == root){
                return;
            }
    
            if(this.isValidBST){
                compute(root.left, ls);
                if(!ls.isEmpty() && ls.get(ls.size()-1) >= root.val){
                    this.isValidBST = false;
                }
                ls.add(root.val);
                compute(root.right, ls);
            }
        }
    }

------------------------------------------------------------------------------------------------------------------

**9. Construct a BST from a preorder traversal**

_Approach:_

    1. Insert the first node from the preorder array as a root node.
    2. It's very simple just run through the loop starting from node 2 in preorder array.
    3. Insert each node in the binary search by keeping BST property in mind.

_Code_:

    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            if(preorder.length == 0){
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);
            for(int i=1;i<preorder.length; i++){
                insertNode(root, preorder[i]);
            }
            return root;
        }
    
        public TreeNode insertNode(TreeNode root, int data){
            //Base Condition
            if(null == root){
                return new TreeNode(data);
            }
            if(data < root.val){
                root.left = insertNode(root.left, data);
            }
    
            if(data > root.val){
                root.right = insertNode(root.right, data);
            }
            return root;
        }
    }

------------------------------------------------------------------------------------------------------------------

**10. Inorder Successor/Predecessor in BST**

_Approach:_ It's very easy, just we need to traverse the BST in inorder traversal to find successor and predecessor for the given node.
            
Question: Why inorder traversal?

Answer: It gives all the nodes in sorted order for a BST.

    1. Apply inorder traversal 
    2. rather than printing each node compare the node with key node which is provided
    3. Maintain two instance variables i.e. successor and predecessor and assign the initial value -1 to both variables.
    4. Check for the below condition rather than printing those nodes.
       if root.data < key
       then predecessor = root.data;
       if root.data > key && successor < 0
       then successor = root.data

_Code_:

    public class Solution {
        int predecessor = -1;
        int successor = -1;
        public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
            // Write your code here.
            Solution solution = new Solution();
    
            List<Integer> results = new ArrayList<>();
            solution.compute(root, key);
    
            results.add(solution.predecessor);
            results.add(solution.successor);
    
            return results;
        }
    
        void compute(TreeNode root, int key){
            //Base Condition
            if(null == root){
                return;
            }
    
            compute(root.left, key);
            if(root.data < key){
                this.predecessor = root.data;
            }
            if(root.data > key && this.successor < 0){
                this.successor = root.data;
            }
            compute(root.right, key);
        }
    }

------------------------------------------------------------------------------------------------------------------

**11. Binary Search Tree Iterator**

_Approach:_ It's very easy.

    1. Create an instance variable to hold all the nodes traversed using in-order traversal.
    2. Do in-order traversal in recursive fashion and store each node in the instance variable inorder.
    3. Create an instance variable index which will be responsible to get the next element and check if it has next element.

_Code_:

    class BSTIterator {
        List<Integer> inorder = new ArrayList<>();
        int index = 0;
    
        public BSTIterator(TreeNode root) {
            compute(root, this.inorder);
        }
    
        void compute(TreeNode root, List<Integer> inorder){
            if(null == root){
                return;
            }
    
            compute(root.left, inorder);
            inorder.add(root.val);
            compute(root.right, inorder);
        }
        
        public int next() {
            int next = this.inorder.get(index);
            this.index++;
            return next;
        }
        
        public boolean hasNext() {
            if(this.inorder.size()-1 >= index){
                return true;
            }
            return false;
        }
    }

------------------------------------------------------------------------------------------------------------------

**12. Two Sum in BST | Check if there exists a pair with Sum K**

_Approach:_ It's very easy.

    1. Using recursion and HashMap
    2. check target - root.val present in the map or not
    3. If present then return true.
    4. if not present then put the value in the map.
    5. base case will be when we hit root node as null then return false.
    6. make conditional recursive call that it might be in left subtree or in right subtree.

_Code_:

    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            return compute(root, map, k);
        }
    
        boolean compute(TreeNode root, HashMap<Integer, Integer> map, int target){
            if(null == root){
                return false;
            }
    
            if(map.containsKey(target - root.val)){
                return true;
            } 
    
            map.put(root.val,1);
            return compute(root.left, map, target) || compute(root.right, map, target);
        }
    }

------------------------------------------------------------------------------------------------------------------

**13. Closest Nodes Queries in a Binary Search Tree**

_Approach:_ It's very easy, using in-order traversal and binary search

    1.	Find the in-order traversal and store all the nodes in the list - > inorder
    2.	Loop thru the queries
    3.	For each query apply the binary search and set minimum and maximum value.
    4.	If during binary query matches in the inorder list then minimum and maximum will be query only.
    5.	For maintaining minimum and maximum we need to create instance variables.

_Code_:

    class Solution {
        int minimum = -1;
        int maximum = -1;
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            List<Integer> inorder = new ArrayList<>();
            List<List<Integer>> list = new ArrayList<>();
            compute(root, inorder);
    
            for(Integer q : queries){
                
                List<Integer> ls = new ArrayList<>();
                
                int low = 0;
                int high = inorder.size()-1;
                int mid = (low+high)/2;
                binarySearch(inorder, low, high, mid, q);
    
                ls.add(this.minimum);
                ls.add(this.maximum);
                list.add(ls);
                this.minimum = -1;
                this.maximum = -1;
            }
            return list;
        }
    
        void binarySearch(List<Integer> inorder, int low, int high, int mid, int key){
            if(low > high || high < low){
                return;
            }
    
            int element = inorder.get(mid);
    
            if(element == key){
                this.minimum = key;
                this.maximum = key;
                return;
            }
    
            if(key < element){
                this.maximum = element;
                int newLow = low;
                int newHigh = mid - 1;
                int newMid = (newLow+newHigh)/2;
                binarySearch(inorder, newLow, newHigh, newMid, key);
            }
    
            if(key > element){
                this.minimum = element;
                int newLow = mid+1;
                int newHigh = high;
                int newMid = (newLow+newHigh)/2;
                binarySearch(inorder, newLow, newHigh, newMid, key);
            }
            return;
        }
    
        void compute(TreeNode root, List<Integer> inorder){
            if(null == root){
                return;
            }
    
            compute(root.left, inorder);
            inorder.add(root.val);
            compute(root.right, inorder);
        }
    }

------------------------------------------------------------------------------------------------------------------
# Sliding Window

Sliding window algorithm is basically used to optimise the solution which is in O(n^2) to O(n).

There are two types of sliding window:
    
    1. Fixed size sliding window.
    2. Variable size sliding window.

### 1. Fixed size sliding window:

    1. It's basically easy level of sliding window problems where window size will be fixed.
    2. Window size will be fixed till the problem is not solved.

#### Q. How to identify if the problem can be solved using sliding window pattern?
    
    1. Array or String will be given.
    2. we need to find sub-array or sub-string.
    3. we will be given window size as K.
                    
                    OR

    1. Array or String will be given.
    2. we need to find the window of size k.
    3. we will be given some condition.

#### Template to write a fixed size sliding window code.

    i = 0;
    j = 0;
    
    while(j < array.length or string.length()){
        
        //HERE WE WILL DO SOME CALCULATION ON INCREMENTING j
        
        if((j-i+1) < k){
            //Just increment j to achieve the window size
            j++;
        }

        //This case where window size will be achieved
        else if((j-i+1) == k){
            
            //HERE WE WILL AGAIN DO SOME CALCULATION TO FIND OUT RESULT
        
            //Increment i & j to slide the window
            
            i++;
            j++;
        }
    }

    where,

        i = start index of window
        j = end index of window
        k = size of window

### 2. Variable size sliding window:
    
    1. It's basically medium to hard level of sliding window problems where window size will not be fixed and it can vary based on some condition.
    2. Window size will not be fixed till the problem is not solved.

#### Q. How to identify if the problem can be solved using sliding window pattern?

    1. Array or String will be given.
    2. we need to maximize or minimize sub-array or sub-string.
    3. we will be given some condition and based on that our window size will vary.

#### Template to write a variable size sliding window code.

    i = 0;
    j = 0;
    
    while(j < array.length or string.length()){
        
        //HERE WE WILL DO SOME CALCULATION ON INCREMENTING j
        
        if(some condition < k){
            //Just increment j to reach a specific answer
            j++;
        }
        else if (some condition == k){
            //HERE WE WILL AGAIN DO SOME CALCULATION TO FIND OUT RESULT
            
            j++;
        }
        else if (some condition > k){
            while(some condition > k){
                i++;
            }
            j++;
        }
    }

    where,

        i = start index of window
        j = end index of window
        k = condition given in the question

-----------------------------------------------------------------------------------------------------

**1. Max Consecutive Ones III**

_**Leet Code (Medium)**_: https://leetcode.com/problems/max-consecutive-ones-iii/description/

_**Problem Statement**_: Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

_Approach:_ This is a variable sliding window problem

    1. Initialize i, j & result with 0.
    2. Create a hashmap to track number of flipped 0 to 1.
    3. While loop thru all the elements in the array until j < nums.length.
    4. if nums[j] == 1 just increment j as j++.
    5. if nums[j] == 0 then it will have 2 cases
        
        i. if map size is equal to 0(zero) then it means we have not flipped any element from 0 to 1 and it implies
            that k == 0 si given in the question.
        
        ii. if map size is greater than 0 that means we have flipped atleast an element from 0 to 1, so we will increment 
            until we get some index matched in map. If matched then we will flip it back from 1 to 0, remove the entry from 
            map and increment i and increment k.
    
    6. Done

_Code_:

    class Solution {
        public int longestOnes(int[] nums, int k) {
            int i = 0;
            int j = 0;
            int result = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
    
            while(j < nums.length){
                if(nums[j] == 1){
                    j++;
                }else if(nums[j] == 0){
                    if(k > 0){
                        map.put(j, 1);
                        nums[j] = 1;
                        j++;
                        k--;
                    } else {
                        if(map.size() > 0){
                            while(!map.containsKey(i)){
                                i++;
                            }
                            map.remove(i);
                            nums[i] = 0;
                            i++;
                            k++;
                        } else {
                            while(j < nums.length && nums[j] == 0){
                                j++;
                            }
                            i = j;
                        }
                    }
                }
                result = Integer.max(result, j-i);
            }
            return result;
        }
    }

------------------------------------------------------------------------------------------------------------------
# Graphs

**1. BFS of graph**

_**GFG (Easy)**_: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/0

_**Problem Statement**_: Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.

Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the input graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.

**_Approach:_** BFS Graph traversal is a kind of traversal where we traverse the adjacent nodes first then move on to other unvisited nodes.

_Code:_
    
    class Solution {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean[] visited = new boolean[V];
            ArrayList<Integer> bfsList = new ArrayList<>();
        
            compute(0, adj, bfsList, visited);
            
            return bfsList;
        }
        
        public void compute(int vertex, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> bfsList, boolean[] visited){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(vertex);
            visited[vertex] = true;
            
            while(!queue.isEmpty()){
               int removedNode = queue.poll();
               bfsList.add(removedNode);
               
               for(Integer adjNode : adj.get(removedNode)){
                   if(!visited[adjNode]){
                       visited[adjNode] = true;
                       queue.add(adjNode);
                   }
               }
            }
        }
    }
------------------------------------------------------------------------------------------------------------------
**2. DFS of Graph**

_**GFG (Easy)**_: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

_**Problem Statement**_: You are given a connected undirected graph. Perform a Depth First Traversal of the graph.

Note:  Use the recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.

**_Approach:_** BFS Graph traversal is a kind of traversal where we traverse the nodes from start to its depth. And it's a recursive approach.

**_Code:_**

    class Solution {
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            boolean[] visited = new boolean[V];
            ArrayList<Integer> dfsList = new ArrayList<>();
            
            compute(0, adj, dfsList, visited);
            return dfsList;
        }
        
        public void compute(int vertex, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsList, boolean[] visited){
            dfsList.add(vertex);
            visited[vertex] = true;
            
            for(Integer adjNode : adj.get(vertex)){
                if(!visited[adjNode]){
                    compute(adjNode, adj, dfsList, visited);
                }
            }
            return;
        }
    }
------------------------------------------------------------------------------------------------------------------
**3. Number of Provinces**

_**LeetCode (Medium)**_: https://leetcode.com/problems/number-of-provinces/description/

_**Problem Statement**_: There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

**_Approach:_** Number of provinces implies number of disconnected components. So we can use either BFS or DFS both will work in same complexity.

    1. Create an adjacency list using NxN adjacency matrix.
        
        List<List<Integer>> adjList = new ArrayList<>();

    2. Initialize a variable like below to hold the number of provinces/number of disconnected component in graph.
        
        int provinces = 0;

    3. Create a visited boolean array which holds the true value if the particular node is visited.
        
        boolean[] visited = new boolean[adjList.size()];

    4. Apply the BFS/DFS Algorithm and for each disconnected component increment provinces variable by 1.

**_Code:_**

    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int provinces = 0;
    
            //Adjacency List
            List<List<Integer>> adjList = new ArrayList<>();
    
            //Preparing adjacency list
            for(int i=0;i<isConnected.length;i++){
                List<Integer> adj = new ArrayList<>();
                
                for(int j=0;j<isConnected[i].length;j++){
                    if(i != j && isConnected[i][j] == 1){
                        adj.add(j);
                    }
                }
    
                adjList.add(adj);
            }
    
            boolean[] visited = new boolean[adjList.size()];
    
            for(int i=0;i<adjList.size();i++){
                if(!visited[i]){
                    provinces++;
                    //computeBFS(i, adjList, visited);
                    computeDFS(i, adjList, visited);
                }
            }
    
            return provinces;
        }
    
        public void computeDFS(int vertex, List<List<Integer>> adjList, boolean[] visited){
            visited[vertex] = true;
    
            for(Integer adjNode : adjList.get(vertex)){
                if(!visited[adjNode]){
                    computeDFS(adjNode, adjList, visited);
                }
            }
    
            return;
        }
    
        public void computeBFS(int vertex, List<List<Integer>> adjList, boolean[] visited){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(vertex);
            visited[vertex] = true;
    
            while(!queue.isEmpty()){    
                int removedNode = queue.poll();
    
                for(Integer adjNode : adjList.get(removedNode)){
                    if(!visited[adjNode]){
                        queue.add(adjNode);
                        visited[adjNode] = true;
                    }
                }
            }
        }
    }
------------------------------------------------------------------------------------------------------------------
**4. Rotting Oranges**

_**LeetCode (Medium):**_ https://leetcode.com/problems/rotting-oranges/description/

_**Problem Statement:**_ You are given an m x n grid where each cell can have one of three values:

- 0 representing an empty cell,
- 1 representing a fresh orange, or
- 2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

_**Approach:**_ Cycle detection can be done in  an undirected graph using BFS or DFS algorithm.

    1. Create a data structure to basically hold node and previous node value;
        
        class Data {
            int node;
            int previous;
        }

    2. We will loop thru all the disconnected component and make a call to BFS/DFS for any un visited node.

    3. While traversing we will check if any of adjacent node which is visited and not the previous node, then in 
        that case we will return true else false;

    4. If return value is true then there will a cycle in the graph.  

**_Code:_**

    class Data {
        int node;
        int previous;
        
        public Data(int node, int previous){
            this.node = node;
            this.previous = previous;
        }
    }

    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean[] visited = new boolean[V];

            for(int i=0;i<V;i++){
                if(!visited[i]){
                    //This is BFS
                    if(computeCycleDetectionBFS(i, adj, visited)){
                        return true;
                    }
                    
                    //This is DFS
                    if(computeCycleDetectionDFS(i, -1, adj, visited)){
                        return true;
                    }
                }
            }
            
            return false;
        }
    
        public boolean computeCycleDetectionDFS(int current, int previous, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
            visited[current] = true;
            
            for(int adjNode : adj.get(current)){
                if(visited[adjNode]){
                    if(adjNode != previous){
                        return true;
                    }
                } else {
                        if(computeCycleDetectionDFS(adjNode, current, adj, visited)){
                            return true;
                        }
                }
            }
            
            return false;
        }
    
        public boolean computeCycleDetectionBFS(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
            Queue<Data> queue = new LinkedList<>();
            queue.add(new Data(vertex, -1));
            visited[vertex] = true;
            
            
            while(!queue.isEmpty()){
                Data current = queue.poll();
                
                int currentNode = current.node;
                int previous = current.previous;
                
                for(int adjNode : adj.get(currentNode)){
                    if(visited[adjNode]){
                        if(adjNode != previous){
                            return true;
                        }
                    }else{
                        queue.add(new Data(adjNode, currentNode));
                        visited[adjNode] = true;
                    }
                }
            }
            
            return false;
        }
    }
------------------------------------------------------------------------------------------------------------------
**5. Flood Fill**

_**LeetCode (Medium)**_: https://leetcode.com/problems/flood-fill/description/

_**Problem Statement**_: An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

**_Approach:_** We need to apply BFS algorithm and adjacent node of current node will be located at up, down, right, left.

    1. Create a data structure to basically hold row index and column index;
        
        class Data {
            int rIdx;
            int cIdx;
        }

    2. As a first step we will check if input pixels color in the image[][] matrix is same as input color.

        Example: 
            
            image[sr][sc] = 1
            color = 1;

        then in this case we will just return the same matrix with no change.

    3. If Step 2 is not satisfied then in this case we will perform BFS travsersal and color the 4-directionally located
        adjacent nodes.

    4. We will color only those 4 - directional adjacent nodes which has same color as current node and not visited adjacent node.

    5. Once the adjacent node is eligible for coloring then in that case we will color that adjacent node and mark it as visited. 

**_Code:_**

    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color) {
                return image;
            } else {
                computeBFS(image, sr, sc, color);
            }
    
            return image;
        }
    
        public void computeBFS(int[][] image, int sr, int sc, int color){
            boolean[][] visited = new boolean[image.length][image[0].length];
            Queue<Data> queue = new LinkedList<>();
            queue.add(new Data(sr, sc));
            visited[sr][sc] = true;
    
            while(!queue.isEmpty()){
                Data data = queue.poll();
    
                int i = data.rIdx;
                int j = data.cIdx;
    
                int currentPixel = image[i][j];
                //Left
                if(j-1 >= 0 && image[i][j-1] == currentPixel && !visited[i][j-1]){
                    queue.add(new Data(i, j-1));
                    visited[i][j-1] = true;
                }
    
                //Right
                if(j+1 < image[0].length && image[i][j+1] == currentPixel && !visited[i][j+1]){
                    queue.add(new Data(i, j+1));
                    visited[i][j+1] = true;
                }
    
                //Up
                if(i-1 >= 0 && image[i-1][j] == currentPixel && !visited[i-1][j]){
                    queue.add(new Data(i-1, j));
                    visited[i-1][j] = true;
                }
    
                //Down
                if(i+1 < image.length && image[i+1][j] == currentPixel && !visited[i+1][j]){
                    queue.add(new Data(i+1, j));
                    visited[i+1][j] = true;
                }
    
                image[i][j] = color;
            }
        }
    }

    class Data {
        int rIdx;
        int cIdx;
    
        public Data(int rIdx, int cIdx) {
            this.rIdx = rIdx;
            this.cIdx = cIdx;
        }
    }Cycle Detection in unirected Graph (bfs)
------------------------------------------------------------------------------------------------------------------
**6. Cycle Detection in undirected Graph (bfs/dfs)**

_**GFG (Medium):**_ https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph

_**Problem Statement:**_ Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

_**Approach:**_ Cycle detection can be done in  an undirected graph using BFS or DFS algorithm.

    1. Create a data structure to basically hold node and previous node value;
        
        class Data {
            int node;
            int previous;
        }

    2. We will loop thru all the disconnected component and make a call to BFS/DFS for any un visited node.

    3. While traversing we will check if any of adjacent node which is visited and not the previous node, then in 
        that case we will return true else false;

    4. If return value is true then there will a cycle in the graph.  

**_Code:_**

    class Data {
        int node;
        int previous;
        
        public Data(int node, int previous){
            this.node = node;
            this.previous = previous;
        }
    }

    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean[] visited = new boolean[V];

            for(int i=0;i<V;i++){
                if(!visited[i]){
                    //This is BFS
                    if(computeCycleDetectionBFS(i, adj, visited)){
                        return true;
                    }
                    
                    //This is DFS
                    if(computeCycleDetectionDFS(i, -1, adj, visited)){
                        return true;
                    }
                }
            }
            
            return false;
        }
    
        public boolean computeCycleDetectionDFS(int current, int previous, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
            visited[current] = true;
            
            for(int adjNode : adj.get(current)){
                if(visited[adjNode]){
                    if(adjNode != previous){
                        return true;
                    }
                } else {
                        if(computeCycleDetectionDFS(adjNode, current, adj, visited)){
                            return true;
                        }
                }
            }
            
            return false;
        }
    
        public boolean computeCycleDetectionBFS(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
            Queue<Data> queue = new LinkedList<>();
            queue.add(new Data(vertex, -1));
            visited[vertex] = true;
            
            
            while(!queue.isEmpty()){
                Data current = queue.poll();
                
                int currentNode = current.node;
                int previous = current.previous;
                
                for(int adjNode : adj.get(currentNode)){
                    if(visited[adjNode]){
                        if(adjNode != previous){
                            return true;
                        }
                    }else{
                        queue.add(new Data(adjNode, currentNode));
                        visited[adjNode] = true;
                    }
                }
            }
            
            return false;
        }
    }
------------------------------------------------------------------------------------------------------------------