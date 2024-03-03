package recursion;

public class PowXNUsingRecursion {
    public static void main(String[] args) {
        double x = 10;
        int n = 4;

        System.out.println(myPow(x, n));
    }

    private static double myPow(double x, int n) {
        //Base Condition
        if(n == 1){
            return x;
        }

        double temp = x;
        return myPow(x, n-1) * temp;
    }
}
