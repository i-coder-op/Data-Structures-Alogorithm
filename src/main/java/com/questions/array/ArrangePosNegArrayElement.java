package com.questions.array;

public class ArrangePosNegArrayElement {
    public static void main(String[] args){
        int[] array = {-12,-11,10,12,-3,-4,-5,6,7,8,-8,-7};

        //Method 1: Using two pointer left and right & temp variable
        array = ArrangePosNegArrayElement.arrangeElements(array);
    }

    /**
     *
     * @param array
     * @return
     */
    private static int[] arrangeElements(int[] array) {
        int left = 0;
        int right = array.length-1;
        int temp = 0;

        while (left<right){
            if(array[left] < 0){
                left++;
            }else{
                if(array[right] > 0){
                    right--;
                }
                if(array[left] > 0 && array[right] < 0){
                    temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                    left++;
                    right--;
                }
            }
        }
        return array;
    }
}
