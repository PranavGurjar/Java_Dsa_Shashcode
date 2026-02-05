package Top20InterviewJavaProblem.BasicLogicProblems;

public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 1221;
        boolean palindrome = isPalindrome(n);
        System.out.println(n+" is Palindrome : "+palindrome);
    }
    static boolean isPalindrome(int n) {
        int temp = n, rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return temp == rev;
    }
}
