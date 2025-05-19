package recursion;

public class DPPrintLCS {
    static int[][] dp;
    static String result;
    public static void main(String[] args) {
        System.out.println(printLCS("ABCDGH", "ACDGHR"));
    }

    private static String printLCS(String s1, String s2) {
        dp = new int[s1.length()+1][s2.length()+1];
        result = "";
        for (int i=0;i<=s1.length();i++) {
            for (int j=0;i<=s2.length();j++) {
                dp[i][j] = -1;
            }
        }

        printIt(s1, s2, s1.length(), s2.length());
        return "";
    }

    private static int printIt(String s1, String s2, int n, int m) {
        //Base Condition
        if(n==0 || m==0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        } else {
            if (s1.charAt(n-1) == s2.charAt(m-1)) {
                dp[n][m] = 1+dp[n-1][m-1];
                result = result.concat(String.valueOf(s1.charAt(n-1)));
            } else {
                dp[n][m] = Integer.max(dp[n-1][m], dp[n][m-1]);
            }
        }

        return dp[n][m];
    }


}
