package sorting;

import java.util.Arrays;

/**
 * Two step process
 * 1. Insert the array element in binary heap
 * 2. extract the elements from binary heap
 */
public class HeapSort {
    public int[] array = {4,5,7,1,2,9};
    public int[] binaryHeap;
    public int heapPosition;

    public HeapSort(){
        this.binaryHeap = new int[array.length+1];
        this.heapPosition=0;
    }

    public static void main(String[] args){
        HeapSort heapSort = new HeapSort();
        heapSort.sort();
    }

    /**
     * Heap sort algorithm | TC-O(nlogn) & SC-O(1)
     */
    private void sort() {
        //Step1: insert all the element from array to heap
        for(int i=0;i< array.length;i++){
            insertIntoHeap(array[i]);
        }
        for(int i=0;i< array.length;i++){
            int extractedElement = binaryHeap[1];
            array[i] = extractedElement;
            System.out.println("Extracted element: " + extractedElement);
            binaryHeap[1] = binaryHeap[heapPosition];
            heapPosition--;
            heapifyTop2Bottom(1);
        }
        Arrays.stream(array).forEach(value -> System.out.println(value + " "));
    }

    /**
     * Heapify top to bottom
     * @param root
     */
    private void heapifyTop2Bottom(int root) {
        int leftChild = root*2;
        int rightChild = ((root*2) + 1);
        int swapChild;
        if(heapPosition < leftChild){
            return;
        }else{
            if(heapPosition == leftChild){
                if(binaryHeap[root] < binaryHeap[leftChild]){
                    int temp = binaryHeap[root];
                    binaryHeap[root] = binaryHeap[leftChild];
                    binaryHeap[leftChild] = temp;
                }
                return;
            }else {
                if (binaryHeap[leftChild] < binaryHeap[rightChild]) {
                    swapChild = leftChild;
                } else {
                    swapChild = rightChild;
                }

                if (binaryHeap[root] > binaryHeap[swapChild]) {
                    int temp = binaryHeap[root];
                    binaryHeap[root] = binaryHeap[swapChild];
                    binaryHeap[swapChild] = temp;
                }
            }
        }
        heapifyTop2Bottom(swapChild);
    }

    private void insertIntoHeap(int element) {
        if(heapPosition == (binaryHeap.length-1)){
            System.out.println("Binary Heap is full");
        }else{
            heapPosition++;
            binaryHeap[heapPosition] = element;
            heapifyBottom2Top(heapPosition);
        }
    }

    private void heapifyBottom2Top(int child) {
        int parent = child/2;
        if(child <= 1){
            return;
        }else{
            if(binaryHeap[child] < binaryHeap[parent]){
                int temp = binaryHeap[child];
                binaryHeap[child] = binaryHeap[parent];
                binaryHeap[parent] = temp;
            }
            heapifyBottom2Top(parent);
        }
    }
}