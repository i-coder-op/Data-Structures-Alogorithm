package recursion;

public class FibonacciUsingRecursion {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibonacci(n));
    }

    /**
     * This method will find the fibonacci of a number
     * @param n
     * @return
     */
    private static int fibonacci(int n) {
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
