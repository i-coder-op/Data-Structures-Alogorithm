package recursion;

public class StringPalindromeUsingRecursion {
    public static void main(String[] args) {
        String s = "MADAM";
        isStringPalindrome(s, 0, s.length()-1);
    }

    /**
     * This method will check if string is palindrome or not palindrome
     * @param s
     * @param left
     * @param right
     */
    private static void isStringPalindrome(String s, int left, int right) {
        if(left >= right){
            System.out.println("String is palindrome");
            return;
        }
        if(String.valueOf(s.charAt(left)).equalsIgnoreCase(String.valueOf(s.charAt(right)))){
            isStringPalindrome(s, left+1, right-1);
        }else{
            System.out.println("String is not palindrome");
            return;
        }
    }
}
