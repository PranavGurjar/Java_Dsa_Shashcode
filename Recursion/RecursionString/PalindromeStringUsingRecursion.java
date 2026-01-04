package Recursion.RecursionString;

public class PalindromeStringUsingRecursion {
    public static void main(String[] args) {
        String str = "NAMAN";
        boolean checkPalindrome = checkPalindrome(str, 0, str.length() - 1);
        System.out.println(str+" is palindrome : "+checkPalindrome);
    }
    public static boolean checkPalindrome(String str, int i, int j){
        if (i>=j) return true;
        if (str.charAt(i) != str.charAt(j)) return false;
        return checkPalindrome(str, i+1, j-1);
    }
}
