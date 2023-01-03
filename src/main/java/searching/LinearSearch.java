package searching;

public class LinearSearch {
    public static int[] array = {1,6,8,3,2,9};

    public static void main(String[] args){
        linearSearch(2);
    }

    /**
     * Method used to perform linear searching | TC-O(n) & SC-O(1)
     * @param element
     */
    private static void linearSearch(int element) {
        for (int i=0;i< array.length;i++){
            if(array[i] == element){
                System.out.println(element + " found at location: " + i);
                return;
            }
        }
        System.out.println(element + " not found in the array");
    }
}
