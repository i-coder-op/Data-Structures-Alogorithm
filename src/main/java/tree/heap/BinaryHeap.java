package tree.heap;

/**
 * Implementing heap using array
 * By: Shivam Kale
 */
public class BinaryHeap {
    int[] heapArray;
    int heapSize;

    public BinaryHeap(int size){
        heapArray = new int[size+1]; // we are incrementing size by 1 coz, 0th index will be ignored.
        this.heapSize = 0;
        System.out.println("Heap has been created with size: " + size--);
    }

    public static void main(String[] args){
        //1. Create Binary Heap | TC-O(1) & SC-O(n)
        BinaryHeap binaryHeap = new BinaryHeap(5);

        //2. Peak of the Binary Heap is the root node | TC-O(1) & SC-O(1)
        int peakOfBH = binaryHeap.peak(binaryHeap);
        System.out.println("Peak of Binary Heap: " + peakOfBH);

        //3. Size of binary heap is total elements present in the BH | TC-O(1) & SC-O(1)
        int sizeOfBH = binaryHeap.getBHSize(binaryHeap);
        System.out.println("Size of Binary Heap: " + sizeOfBH);

        //5. Insert a node in binary tree | TC-O(1) & SC-O(1)
        binaryHeap.insertNode(binaryHeap, 3);
        binaryHeap.insertNode(binaryHeap, 5);
        binaryHeap.insertNode(binaryHeap, 7);
        binaryHeap.insertNode(binaryHeap, 1);
        binaryHeap.insertNode(binaryHeap, 2);
        binaryHeap.insertNode(binaryHeap, 0);

        //4. We will be using level order traversal for the Binary Heap always | TC-O(n) & SC-O(1)
        binaryHeap.levelOrder(binaryHeap);

        //6. Extract a node from binary heap - we will always extract the root node from binary heap and perform heapify either max or min

        binaryHeap.extractNode(binaryHeap);
        binaryHeap.levelOrder(binaryHeap);

    }

    private void extractNode(BinaryHeap binaryHeap) {
        System.out.println("Node Extraction Started...");
        System.out.println("Node Extracted: " + binaryHeap.heapArray[1]);
        binaryHeap.heapArray[1] = binaryHeap.heapArray[binaryHeap.heapSize];
        binaryHeap.heapSize--;

        System.out.println("Starting heapify from top to bottom...");
        heapifyTopToBottom(1, "Min");
    }

    private void heapifyTopToBottom(int index, String heapType) {
        int leftSubtree = index * 2;
        int rightSubtree = (index * 2 + 1);
        int swapChild = 0;
        if(heapSize < leftSubtree){
            return;
        }else{
            if(heapType.equalsIgnoreCase("Min")){
                    if(heapSize == leftSubtree){
                        if(heapArray[index] < heapArray[leftSubtree]){
                            int temp = heapArray[index];
                            heapArray[index] = heapArray[leftSubtree];
                            heapArray[leftSubtree] = temp;
                        }
                        return;
                    }else{
                        if(heapArray[leftSubtree] > heapArray[rightSubtree]){
                            swapChild = leftSubtree;
                        }else{
                            swapChild = rightSubtree;
                        }
                        if(heapArray[index] < heapArray[swapChild]){
                            int temp = heapArray[index];
                            heapArray[index] = heapArray[swapChild];
                            heapArray[swapChild] = temp;
                        }
                    }
            } else if(heapType.equalsIgnoreCase("Max")){
                    if(heapSize == leftSubtree){
                        if(heapArray[index] > heapArray[leftSubtree]){
                            int temp = heapArray[index];
                            heapArray[index] = heapArray[leftSubtree];
                            heapArray[leftSubtree] = temp;
                        }
                        return;
                    }else{
                        if(heapArray[leftSubtree] < heapArray[rightSubtree]){
                            swapChild = leftSubtree;
                        }else{
                            swapChild = rightSubtree;
                        }
                        if(heapArray[index] > heapArray[swapChild]){
                            int temp = heapArray[index];
                            heapArray[index] = heapArray[swapChild];
                            heapArray[swapChild] = temp;
                        }
                    }
            }
        }
        heapifyTopToBottom(swapChild, heapType);
    }

    /**
     * Insert a node in binary tree | TC-O(1) & SC-O(1)
     * @param binaryHeap
     * @param node
     */
    private void insertNode(BinaryHeap binaryHeap, int node) {
        if(binaryHeap.heapSize >= (binaryHeap.heapArray.length-1)){
            System.out.println("Heap is full!!");
            return;
        }else{
            binaryHeap.heapArray[binaryHeap.heapSize+1] = node;
            binaryHeap.heapSize++;
            System.out.println(node + " has been inserted, now doing heapify");
            heapifyFromBottomToTop(binaryHeap.heapSize, "MinHeap");
        }
    }

    /**
     *
     * @param child
     * @param heapType
     */
    private void heapifyFromBottomToTop(int child, String heapType) {
        //To get the parent of any node we usually divide the index position by 2
        int parent = child/2;
        if(child <= 1){
            return;
        }
        if("MinHeap".equalsIgnoreCase(heapType)){
            if(heapArray[child] < heapArray[parent]){
                int tempValue = heapArray[parent];
                heapArray[parent] = heapArray[child];
                heapArray[child] = tempValue;
                System.out.println("Min Heapify Done");
            }
        }else if("MaxHeap".equalsIgnoreCase(heapType)){
            if(heapArray[child] > heapArray[parent]){
                int tempValue = heapArray[parent];
                heapArray[parent] = heapArray[child];
                heapArray[child] = tempValue;
                System.out.println("Max Heapify Done");
            }
        }
        heapifyFromBottomToTop(parent, heapType);
    }

    /**
     * We will be using level order traversal for the Binary Heap always | TC-O(n) & SC-O(1)
     * @param binaryHeap
     */
    private void levelOrder(BinaryHeap binaryHeap) {
        System.out.println("Nodes in the BH");
        for (int i=1;i<=binaryHeap.heapSize;i++)
            System.out.print(binaryHeap.heapArray[i]);
        System.out.println("\n");
    }

    /**
     * Size of binary heap is total elements present in the BH | TC-O(1) & SC-O(1)
     * @param binaryHeap
     * @return
     */
    private int getBHSize(BinaryHeap binaryHeap) {
        return binaryHeap.heapSize;
    }

    /**
     * Peak of the Binary Heap is the root node | TC-O(1) & SC-O(1)
     * @param binaryHeap
     * @return
     */
    private int peak(BinaryHeap binaryHeap) {
        return binaryHeap.heapArray[1];
    }
}
