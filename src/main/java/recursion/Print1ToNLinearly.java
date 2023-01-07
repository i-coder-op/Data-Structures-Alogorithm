package recursion;

public class Print1ToNLinearly {
    public static void main(String[] args){
        int N = 10;
        printNumbers(1, N);
    }

    private static void printNumbers(int i, int n) {
        if(i>n){
            return;
        }
        System.out.println(i);
        printNumbers(i+1, n);
    }
}
