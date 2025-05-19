package recursion;

public class PowerFunction {
    public static void main(String[] args) {
        System.out.println(compute(2.0, -245*(-1)));
    }

    private static double compute(double x, int n) {
        //Base Condition
        if (n == 1) {
            double r = 1/x;
            return r;
        }

        //Induction step
        double c = 1/x;
        double d = 1/compute(x, n-1);
        double result = c/d;
        return result;
    }
}
