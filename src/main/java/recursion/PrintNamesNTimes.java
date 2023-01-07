package recursion;

public class PrintNamesNTimes {
    public static void main(String[] args) {
        int n = 5;
        int count = 1;
        printName(n, count);
    }

    /**
     * This method will print N times
     * @param n
     * @param count
     */
    private static void printName(int n, int count) {
        if(count > n){
            return;
        }
        System.out.println("Shivam");
        count++;
        printName(n, count);
    }
}
