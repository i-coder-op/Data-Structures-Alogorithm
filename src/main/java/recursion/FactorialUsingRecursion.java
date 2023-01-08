package recursion;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        int N = 5;
        int result = factorial(N);
        System.out.println("Factorial of " + N +" is " + result);
    }

    /**
     * This method will be used to find the factorial of a number n using recursion
     * @param n
     * @return
     */
    private static int factorial(int n) {
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}
