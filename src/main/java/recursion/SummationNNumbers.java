package recursion;

public class SummationNNumbers {
    public static void main(String[] args) {
        int N = 10;
        int summation = summation(1, N);
        System.out.println(summation);
    }

    /**
     * This method will be useful to find the summation of N numbers using recursion
     * @param i
     * @param N
     * @return summation
     */
    private static int summation(int i, int N) {
        if (i > N){
            return 0;
        }
        return i + summation(i+1, N);
    }
}
