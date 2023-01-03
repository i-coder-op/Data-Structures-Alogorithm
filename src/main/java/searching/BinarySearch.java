package searching;

public class BinarySearch {
    public int[] sortedArray = {1,2,4,6,7,9,11};

    public static void main(String[] args){
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.search(2);
    }

    /**
     * Binary search algorithm perform searching in TC - O(logn) & SC-O(1)
     * @param element
     */
    private void search(int element) {
        int low = 0;
        int high = sortedArray.length-1;
        int mid = (low+high)/2;

        while(mid >= 0 && low<high){
            if(sortedArray[mid] == element){
                System.out.println(element + " found in the array at location: " + mid);
                return;
            }else{
                if (element < sortedArray[mid]){
                    high = mid-1;
                    mid = (low+high)/2;
                }else{
                    low = mid+1;
                    mid = (low+high)/2;
                }
            }
        }
        System.out.println(element + " not found in the array");
    }



}
