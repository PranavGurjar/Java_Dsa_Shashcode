package Top20InterviewJavaProblem.BasicLogicProblems;

public class PalindromeNumber {
    static boolean isPalindrome(int n) {
        int temp = n, rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return temp == rev;
    }
}
