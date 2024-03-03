package recursion;

public class SortArray {

    public static void main (String[] args) {
        int[] array = {7, 7, -3, 0, -1};

        System.out.println("After Sort: ");

        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }

        sort(array, array.length);
        System.out.println("\nAfter Sort: ");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void sort(int[] array, int length){
        if(length == 1){
            return;
        }

        int temp = array[length-1];
        sort(array, length-1);
        insert(array, temp, length-1);
    }

    public static void insert(int[] array, int element, int length){
        if(length == 0 || array[length-1] < element){
            array[length] = element;
            return;
        }

        int temp = array[length-1];
        insert(array, element, length-1);
        array[length] = temp;
    }

}
