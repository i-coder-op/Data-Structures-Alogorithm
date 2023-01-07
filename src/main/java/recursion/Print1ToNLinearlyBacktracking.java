package recursion;

public class Print1ToNLinearlyBacktracking {
    public static void main(String[] args) {
        int n = 10;
        printUsingBacktrack(n, n);
    }

    private static void printUsingBacktrack(int i, int n) {
        if(i<1){
            return;
        }
        printUsingBacktrack(i-1, n);
        System.out.println(i);
    }
}
