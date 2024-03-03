package recursion;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4 , 6, 8, 12};
        int searchNumber = 12;
        int mid = (0+ arr.length-1)/2;
        System.out.println(binarySearch(arr, searchNumber, mid, 0, arr.length-1));
    }

    private static boolean binarySearch(int[] arr, int searchNumber, int mid, int low, int high) {
        if (arr[mid] == searchNumber) {
            return true;
        }
        if(low == mid || high == mid){
            return false;
        }

        if (searchNumber > arr[mid]) {
            low = mid + 1;
        } else if (searchNumber < arr[mid]) {
            high = mid - 1;
        }

        mid = (low + high) / 2;
        return binarySearch(arr, searchNumber, mid, low, high);
    }
}
